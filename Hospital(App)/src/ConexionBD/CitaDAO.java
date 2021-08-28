package ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import Vista.frmMedicos_Mes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Cristhian Sierra
 */
public class CitaDAO {

    Cita objCM;

    /**
     * Constructor parametrico que inicializa las variables de la clae CitaDAO
     *
     * @param objCM
     */
    public CitaDAO(Cita objCM) {
        this.objCM = objCM;
    }

    /**
     * Constructor basico que instancia la variables de tipo objeto en la clase
     * PacienteDAO
     */
    public CitaDAO() {
        this.objCM = new Cita();
    }

    /**
     * Retorna el valor del parametro objCM
     *
     * @return Object
     */
    public Cita getObjCM() {
        return objCM;
    }

    /**
     * Modifica el valor del parametro objCM
     *
     * @param objCM
     */
    public void setObjCM(Cita objCM) {
        this.objCM = objCM;
    }

    /**
     * Metodo que se encarga de hacer la consulta del programa, conectado a la
     * base de datos mediante comandos SQL
     *
     * @return DefaultTableModel
     */
    public DefaultTableModel consulta() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objCon = new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();//SQL Permite crear un contenedor, bloque de consulta a travez de la conexion con BD
            ResultSet datos = consulta.executeQuery("select * from cita_medica");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
            ResultSetMetaData campos = datos.getMetaData();//Transforma los datos en metadatas

            for (int i = 1; i <= campos.getColumnCount(); i++) {//Agrega a la plantilla las columnas
                plantilla.addColumn(campos.getColumnName(i));
            }
            while (datos.next()) {
                Object[] fila = new Object[campos.getColumnCount()];//coloque los campos de la fila
                for (int i = 0; i < campos.getColumnCount(); i++) {//Recorrer cada fila
                    fila[i] = datos.getObject(i + 1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            objCon.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return plantilla;
    }

    /**
     * Metodo que se encarga de hacer la insercion de datos del programa para la
     * clase Persona, conectado a la base de datos mediante comandos SQL
     *
     * @return String
     */
    public String insertar() {
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando = "insert into cita_medica values(?,?,?,?,?,?,?,?)";//Formato de comando de consultas
            consulta = conexion.getConexion().prepareStatement(comando);//Agregar informacion
            consulta.setString(1, (String.valueOf(objCM.getCodigo())));
            consulta.setString(2, String.valueOf(objCM.getObjE().getCodigo()));
            consulta.setString(3, String.valueOf(objCM.getObjS().getCodigo()));
            consulta.setString(4, String.valueOf(objCM.getObjP().getId()));
            consulta.setString(5, String.valueOf(objCM.getObjM().getId()));
            consulta.setString(6, String.valueOf(objCM.getHora_c()));
            consulta.setString(7, objCM.getFecha_r());
            consulta.setString(8, String.valueOf(objCM.getObjEsp().getCodigo()));
            consulta.execute();//Ejecuta la isercion
            mensaje = "Registro BD exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar insertar en BD...\n" + ex;
        }
        return mensaje;
    }

    public int Autoincrement() {
        int cod = 1;
        try {
            ConexionBD conexion = new ConexionBD();
            conexion.conectar();
            PreparedStatement consulta = null;
            ResultSet RSQL = null;
            consulta = conexion.getConexion().prepareStatement("SELECT max(cod) FROM Cita_medica");
            RSQL = consulta.executeQuery();
            while (RSQL.next()) {
                cod = RSQL.getInt(1) + 1;
            }
            consulta.close();
            conexion.getConexion().close();
            RSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en \n" + ex);
        }

        return cod;
    }

    public boolean Consultacitames(int id_paciente) {
        int cont = 0;
        ResultSet RSQL = null;//Contenedor de una consulta, mediante un apuntador
        try {
            ConexionBD conexion = new ConexionBD();
            Medico objM = new Medico();
            Especialidad objEsp = new Especialidad();
            Estado objEst = new Estado();
            conexion.conectar();//Conexiona BD
            Date fecha = new Date();
            String sentencia = "SELECT * FROM cita_medica "
                    + "WHERE MONTH(fecha_r) = MONTH(CURRENT_DATE())"
                    + " AND YEAR(fecha_r) = YEAR(CURRENT_DATE()) AND id_paciente = "+ id_paciente                     
                    + " AND cod_especialidad != 8";
            PreparedStatement consulta;
            consulta = conexion.getConexion().prepareStatement(sentencia);
            
            System.out.println(consulta.toString());
            
            RSQL = consulta.executeQuery(sentencia);//Ejecuta consulta
            while(RSQL.next()){
                cont++;
            }
            consulta.close();
            conexion.getConexion().close();
            RSQL.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error\n" + ex);
        }

        if(cont>=2){
         return true;    
        }
           
        else{
          return false;   
        }
           
    }
   public ResultSet citaspacientemes(int idpaciente) throws SQLException{
        ConexionBD conexion = new ConexionBD();
         ResultSet RSQL = null;
            Medico objM = new Medico();
            Especialidad objEsp = new Especialidad();
            Estado objEst = new Estado();
            conexion.conectar();//Conexiona BD
            Date fecha = new Date();
            String sentencia = "CREATE OR REPLACE VIEW Citas_Mes_Paciente (id_paciente,Nombre_Paciente,Codigo_Cita,Especialidad_Cita,Estado_Cita,Fecha_Cita)"
                    + " AS SELECT p.num_id, p.nombre, cm.cod, esp.nombre, est.tipo,cm.fecha_r FROM Paciente AS p,Cita_medica AS cm, Especialidad AS esp, Estado AS est "
                    + "WHERE MONTH(fecha_r) = ? AND (YEAR(fecha_r) =?) AND (p.num_id =?) AND (esp.cod = cm.cod_especialidad) AND (est.cod = cm.cod_estado) AND (cm.id_paciente = "+idpaciente+")";
            PreparedStatement consulta;
            consulta = conexion.getConexion().prepareStatement(sentencia);
            consulta.executeQuery(sentencia);
            sentencia = "SELECT * FROM Citas_Mes_Paciente";
              RSQL = consulta.executeQuery(sentencia);
             
            System.out.println(consulta.toString());
           return RSQL; 
           
   }
       public ResultSet CM_Mes_Medico(){
        ResultSet RSQL = null;//Contenedor de una consulta, mediante un apuntador
        try{
            ConexionBD conexion=new ConexionBD();
            Medico objM= new Medico();
            Especialidad objEsp = new Especialidad();
            Estado objEst = new Estado();
            conexion.conectar();//Conexiona BD
            PreparedStatement consulta=null;// Tendra la consulta almacenada de SQL
            
            String sentencia = "SELECT cm.id_medico, cm.cod, cm.cod_espcialidad, cm.cod_estado, cm.fecha_r "
                    + "from Cita_medica AS cm  WHERE MONTH(cm.fecha_r)=' AND YEAR(cm.fecha_r)=' AND cm.id_medico ='"+objCM.getFecha_r()+"'"+objCM.getObjM().getId()+"";
            consulta= conexion.getConexion().prepareStatement(sentencia);
            consulta.setString(1, String.valueOf(objCM.getObjM().getId()));
        
            consulta.setString(2, String.valueOf(objCM.getCodigo()));
            consulta.setString(3, String.valueOf(objCM.getObjEsp().getCodigo()));
            consulta.setString(4, String.valueOf(objCM.getObjE().getCodigo()));
            consulta.setString(5, objCM.getFecha_r());
            //consulta.execute();
            RSQL= consulta.executeQuery(sentencia);//Ejecuta consulta
            
            consulta.close();
            conexion.getConexion().close();
            RSQL.close();
        } catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error\n"+ex);
        } 
       
        return RSQL;
    } 
    public DefaultTableModel Consulta_CM_Medico() {
        frmMedicos_Mes frmMMes = new frmMedicos_Mes();
        DefaultTableModel plantilla = new DefaultTableModel();
        ResultSet RSQL = CM_Mes_Medico();
        try {
            
            
            frmMMes.getTblMed_Mes().setModel(plantilla);

            while (RSQL.next()) {
                plantilla.addRow(new Object[]{RSQL.getInt("m.num_id"), RSQL.getString("m.nombre"), RSQL.getInt("cm.cod"), RSQL.getString("esp.nombre"), RSQL.getString("est.tipo"), RSQL.getInt("cm.fecha_r")});

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en " + ex);
        }

        return plantilla;
    }
    /*Metodo que se encarga de hacer la actualizacion de datos  del programa para la clase Cita, conectado a la base de datos mediante comandos SQL
     * @return String
     */

    public String actualizar() {
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;//Clase de java.sql que permite enviar los campos uno a uno
            conexion.conectar();
            JOptionPane.showMessageDialog(null, "Estos datos se actualizarán " + objCM.toString());
            String instruccion = "update Cita_medica set cod=?,cod_estado=?,cod_sede=?,id_paciente=?,id_medico=?,hora_c=?,fecha_r=?,cod_especialidad=? where cod='" + objCM.getCodigo() + "'";
            consulta = conexion.getConexion().prepareStatement(instruccion);
            consulta.setString(1, (String.valueOf(objCM.getCodigo())));
            consulta.setString(2, String.valueOf(objCM.getObjE().getCodigo()));
            consulta.setString(3, String.valueOf(objCM.getObjS().getCodigo()));
            consulta.setString(4, String.valueOf(objCM.getObjP().getId()));
            consulta.setString(5, String.valueOf(objCM.getObjM().getId()));
            consulta.setString(6, String.valueOf(objCM.getHora_c()));
            consulta.setString(7, String.valueOf(objCM.getFecha_r()));
            consulta.setString(8, String.valueOf(objCM.getObjEsp().getCodigo()));
            consulta.execute();
            mensaje = "Actualización exitosa";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar actualizar..." + ex;
        }
        return mensaje;
    }

    /**
     * Metodo que se encarga de eliminar de datos del programa para la clase
     * Persona, conectado a la base de datos mediante comandos SQL
     *
     * @return String
     */
    public String eliminar() {
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            JOptionPane.showMessageDialog(null, "Lo datos a eliminar son: " + objCM.toString());
            String comando = "delete from cita_medica where cod='" + objCM.getCodigo() + "'";
            consulta = conexion.getConexion().prepareStatement(comando);
            consulta.execute();
            mensaje = "Se ha eliminado registro...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar eliminar..\n" + ex;
        }
        return mensaje;
    }

}

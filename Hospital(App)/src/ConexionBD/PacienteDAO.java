
package ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import java.sql.Date;

/**
 *
 * @author Cristhian Sierra
 */
public class PacienteDAO {
    Paciente objP;

    /**
     *Constructor parametrico que inicializa las variables de la clae PacienteDAO
     * @param objP
     */
    public PacienteDAO(Paciente objP) {
        this.objP = objP;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase PacienteDAO
     */
    public PacienteDAO() {
        this.objP = new Paciente();
    }

    /**
     *Retorna el valor del parametro objP
     * @return Object
     */
    public Paciente getObjP() {
        return objP;
    }

    /**
     *Modifica  el valor del parametro objP
     * @param objP
     */
    public void setObjP(Paciente objP) {
        this.objP = objP;
    }

    /**
     *Metodo que se encarga de hacer la consulta del programa, conectado a la base de datos mediante comandos SQL
     * @return DefaultTableModel
     */
    public DefaultTableModel consulta(){
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objCon= new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();//SQL Permite crear un contenedor, bloque de consulta a travez de la conexion con BD
            ResultSet datos= consulta.executeQuery("select * from paciente");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
            ResultSetMetaData campos= datos.getMetaData();//Transforma los datos en metadatas
            
           
            for (int i = 1; i <= campos.getColumnCount(); i++){//Agrega a la plantilla las columnas
              plantilla.addColumn(campos.getColumnName(i));           
            }
           while (datos.next()){
            Object[] fila = new Object[campos.getColumnCount()];//coloque los campos de la fila
            for (int i=0; i < campos.getColumnCount(); i++){//Recorrer cada fila
              fila[i]=datos.getObject(i+1);
             }
             plantilla.addRow(fila);
            }
            datos.close();
            objCon.getConexion().close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
      return plantilla;
    }

    /**
     *Metodo que se encarga de hacer la insercion de datos  del programa para la clase Paciente, conectado a la base de datos mediante comandos SQL
     * @return String
     */
    public String insertar(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into paciente values(?,?,?,?,?)";//Formato de comando de consultas
            consulta=conexion.getConexion().prepareStatement(comando);//Agregar informacion
            consulta.setString(1,(String.valueOf(objP.getId())));
            consulta.setString(2,objP.getNombre());
            consulta.setString(3,objP.getFecha_nac());
            consulta.setString(4,String.valueOf(objP.getObjTipoID().getCodigo()));
            consulta.setString(5,String.valueOf(objP.getObjM().getCodigo()));
            consulta.execute();//Ejecuta la isercion
            mensaje="Registro BD exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar en BD...\n"+ex;
        }
      return mensaje;  
    }
   
    /**
     *Metodo que se encarga de hacer la actualizacion de datos  del programa para la clase Paciente, conectado a la base de datos mediante comandos SQL
     * @return String
     */
    public String actualizar()
   {
       String mensaje ="";
       try
       {
           ConexionBD conexion = new ConexionBD();
           PreparedStatement consulta=null;//Clase de java.sql que permite enviar los campos uno a uno
           conexion.conectar();
           JOptionPane.showMessageDialog(null, "Estos datos se actualizarán "+ objP.toString());
           String instruccion="update paciente set num_id=?,nombre=?,fecha_nac=?,cod_tipo_id=?,cod_municipio=? where num_id='" +objP.getId()+"'";
           consulta=conexion.getConexion().prepareStatement(instruccion);
           consulta.setString(1,(String.valueOf(objP.getId())));
           consulta.setString(2,objP.getNombre());
           consulta.setString(3,objP.getFecha_nac());
           consulta.setString(4,String.valueOf(objP.getObjTipoID().getCodigo()));
           consulta.setString(5,String.valueOf(objP.getObjM().getCodigo()));
           consulta.execute();
           mensaje ="Actualización exitosa";
           consulta.close();
           conexion.getConexion().close();
       }catch(SQLException ex){
       mensaje = "Error al intentar actualizar..."+ex;
       }
       return mensaje;
   }

    /**
     *Metodo que se encarga de eliminar de datos del programa para la clase Persona, conectado a la base de datos mediante comandos SQL
     * @return String
     */
    public String eliminar()
   {
   String mensaje="";
   try
   {
   ConexionBD conexion = new ConexionBD();
   PreparedStatement consulta = null;
   conexion.conectar();
   JOptionPane.showMessageDialog(null,"Lo datos a eliminar son: "+ objP.toString());
   String comando = "delete from paciente where num_id='"+objP.getId()+"'";
   consulta=conexion.getConexion().prepareStatement(comando);
   consulta.execute();
   mensaje="Se ha eliminado registro...";
   consulta.close();
   conexion.getConexion().close();
   }catch(SQLException ex){
   mensaje = "Error al intentar eliminar..\n"+ex;
   }
   return mensaje;
   }
   
}

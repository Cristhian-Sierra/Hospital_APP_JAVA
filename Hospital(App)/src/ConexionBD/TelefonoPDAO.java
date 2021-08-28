package ConexionBD;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import Vista.frmTblPaciente;
import java.sql.PreparedStatement;
/**
 *
 * @author Cristhian Sierra
 */
public class TelefonoPDAO {
    TelefonosP objTelP;

    /**
     *Constructor parametrico que inicializa las variables de la clase TelefonoPDAO
     * @param objTelP
     */
    public TelefonoPDAO(TelefonosP objTelP) {
        this.objTelP= objTelP;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase TelefonoMDAO
     */
    public TelefonoPDAO() {
        this.objTelP= new TelefonosP();
    }


    /**
     *Retorna el valor del parametro objTelP
     * @return Object
     */
    public TelefonosP getObjTelP() {    
        return objTelP;
    }

    /**
     *Modifica  el valor del parametro objTelP
     * @param objTelP
     */
    public void setObjTelP(TelefonosP objTelP) {    
        this.objTelP = objTelP;
    }

    /**
     *Metodo que se encarga de hacer la consulta del programa, conectado a la base de datos mediante comandos SQL
     * @return DefaultTableModel
     */
    public DefaultTableModel consulta() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD objCon= new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();//SQL Permite crear un contenedor, bloque de consulta a travez de la conexion con BD
            ResultSet datos= consulta.executeQuery("select * from telefono_paciente");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
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
    
    public String insertar(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into telefono_paciente values(?,?)";//Formato de comando de consultas
            consulta=conexion.getConexion().prepareStatement(comando);//Agregar informacion
            consulta.setString(1,(String.valueOf(objTelP.getObjP().getId())));
            consulta.setString(2,objTelP.getTelefono1());
           // consulta.setString(3,objTelP.getTelefono2());
            consulta.execute();//Ejecuta la isercion
            mensaje="Registro BD exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar en BD...\n"+ex;
        }
      return mensaje;  
    }
    
    public String actualizar(){
       String mensaje ="";
       try{
           ConexionBD conexion = new ConexionBD();
           PreparedStatement consulta=null;//Clase de java.sql que permite enviar los campos uno a uno
           conexion.conectar();
           JOptionPane.showMessageDialog(null, "Estos datos se actualizarán "+ objTelP.toString());
           String instruccion="update Telefono_paciente set id_paciente=?,telefono=? where id_paciente='" +objTelP.getObjP().getId()+"'";
           consulta=conexion.getConexion().prepareStatement(instruccion);
           consulta.setString(1,(String.valueOf(objTelP.getObjP().getId())));
           consulta.setString(2,objTelP.getTelefono1());
           consulta.execute();
           mensaje ="Actualización exitosa";
           consulta.close();
           conexion.getConexion().close();
       }catch(SQLException ex){
       mensaje = "Error al intentar actualizar..."+ex;
       }
       return mensaje;
   }

   public String eliminar(){
   String mensaje="";
   try{
    ConexionBD conexion = new ConexionBD();
    PreparedStatement consulta = null;
    conexion.conectar();
    JOptionPane.showMessageDialog(null,"Lo datos a eliminar son: "+ objTelP.toString());
    String comando = "delete from Telefono_paciente where id_paciente='"+objTelP.getObjP().getId()+"'";
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


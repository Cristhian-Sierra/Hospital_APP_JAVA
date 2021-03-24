
package ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
/**
 *
 * @author Cristhian Sierra
 */
public class MedicoDAO {
    Medico objM;

    /**
     *Constructor parametrico que inicializa las variables de la clae MedicoDAO
     * @param objM
     */
    public MedicoDAO(Medico objM) {
        this.objM = objM;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase MedicoDAO
     */
    public MedicoDAO() {
        this.objM = new Medico();
    }

    /**
     *Retorna el valor del parametro objM
     * @return Object
     */
    public Medico getObjM() {
        return objM;
    }

    /**
     *Modifica  el valor del parametro objM
     * @param objM
     */
    public void setObjM(Medico objM) {
        this.objM = objM;
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
            ResultSet datos= consulta.executeQuery("select * from medico");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
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
     *Metodo que se encarga de hacer la insercion de datos  del programa para la clase Persona, conectado a la base de datos mediante comandos SQL
     * @return String
     */
    public String insertar()
   {
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into medico values(?,?,?,?,?,?,?,?)";//Formato de comando de consultas
            consulta=conexion.getConexion().prepareStatement(comando);//Agregar informacion
            consulta.setString(1,(String.valueOf(objM.getId())));
            consulta.setString(2,objM.getNombre());
            consulta.setString(3,objM.getDireccion());
            consulta.setString(4,String.valueOf(objM.getObjTipoID().getCodigo()));
            consulta.setString(5,String.valueOf(objM.getObjE().getCodigo()));
            consulta.setString(6,String.valueOf(objM.getHora_i()));
            consulta.setString(7,String.valueOf(objM.getHora_f()));
            consulta.setString(8,String.valueOf(objM.getObjm().getCodigo()));
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
     *Metodo que se encarga de hacer la actualizacion de datos  del programa para la clase Persona, conectado a la base de datos mediante comandos SQL
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
           JOptionPane.showMessageDialog(null, "Estos datos se actualizarán "+ objM.toString());
           String instruccion="update medico set num_id=?,nombre=?,direccion=?,cod_tipo=?,cod_especialidad=?,hora_i=?,hora_f=?,cod_municipio=? where num_id='" +objM.getId()+"'";
            consulta=conexion.getConexion().prepareStatement(instruccion);
            consulta.setString(1,(String.valueOf(objM.getId())));
            consulta.setString(2,objM.getNombre());
            consulta.setString(3,objM.getDireccion());
            consulta.setString(4,String.valueOf(objM.getObjTipoID().getCodigo()));
            consulta.setString(5,String.valueOf(objM.getObjE().getCodigo()));
            consulta.setString(6,String.valueOf(objM.getHora_i()));
            consulta.setString(7,String.valueOf(objM.getHora_f()));
            consulta.setString(8,String.valueOf(objM.getObjm().getCodigo()));
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
   JOptionPane.showMessageDialog(null,"Lo datos a eliminar son: "+ objM.toString());
   String comando = "delete from medico where num_id='"+objM.getId()+"'";
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

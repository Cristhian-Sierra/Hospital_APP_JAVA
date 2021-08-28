/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import Modelo.Cita;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Sierra
 */
public class ConexionBD {
    //Variable privada de tipo Connection que almacenará el atributo conexion
    private Connection conexion;
    //Variable privada de tipo String que almacenará el atributo bd
    private String bd;
    //Variable privada de tipo String que almacenará el atributo ususario
    private String usuario; 
   //Variable privada de tipo String que almacenará el atributo clave
    private String clave;
    //Variable privada de tipo String que almacenará el atributo mensaje
    private String mensaje;

    /**
     *Constructor parametrico de la clase ConexionBD que se encargará de instanciar las variables  
     * @param conexion
     * @param bd
     * @param usuario
     * @param clave
     * @param mensaje
     */
    public ConexionBD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }
    
    /**
     *Constructor basico de la clase ConexionBD que se encarga de inicializar las variables
     */
    public ConexionBD() {
        this.conexion = null;
        this.bd = "hospital";
        this.usuario = "root";
        this.clave = "Herlinda#197016";
        this.mensaje = "";
    }
     
    /**
     *Metodo cuta función es la de conectar a la base de datos previamente creada con la clase java.mysql
     */
    public void conectar(){
       try {
            Class.forName("com.mysql.jdbc.Driver");//Definir el conector
            String ruta= "jdbc:mysql://localhost:3306/"+bd;
            conexion=DriverManager.getConnection(ruta,usuario,clave);//Crea la conexion con la ruta 
            mensaje= "Conexión exitosa a Base de datos " + bd;
       } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver no encontrado...");
       }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar conectar BD: "+ bd +"\n"+ex);
       }
    }   
    
    
     public ArrayList<Cita> consultarcitas(){
        ArrayList<Cita> citas=new ArrayList<>();
          ConexionBD objCon= new ConexionBD();
        try {
            objCon.conectar();
            Statement consulta = objCon.getConexion().createStatement();
            ResultSet registros = consulta.executeQuery("select * from Cita_medica");
            while(registros.next()){
            Cita cita = new Cita();
            cita.setCodigo(Integer.parseInt(registros.getString("cod")));
            cita.getObjP().setId(Integer.parseInt(registros.getString("id_paciente")));
            cita.getObjEsp().setCodigo(Integer.parseInt(registros.getString("cod_especialidad")));;
           
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return citas;    
        
        
    }
     /**
     *Retorna el valor de parametro conexion
     * en la clase ConexionBD
     * @return Connection
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
      *Modifica el valor de parametro conexion
     * en la clase ConexionBD
     * @param conexion
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
      *Retorna el valor de parametro mensaje
     * en la clase ConexionBD
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     *Modifica el valor de parametro mensaje
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }    
    
    
}

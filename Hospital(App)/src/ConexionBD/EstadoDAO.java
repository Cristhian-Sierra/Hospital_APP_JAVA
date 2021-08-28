package ConexionBD;

import ConexionBD.ConexionBD;
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
public class EstadoDAO {
    Estado objEstado;

    /**
     *Constructor parametrico que inicializa las variables de la clase EstadoDAO
     * @param objEstado 
     */
    public EstadoDAO(Estado objEstado) {
        this.objEstado= objEstado;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase EstadodDAO
     */
    public EstadoDAO() {
        this.objEstado= new Estado();
    }
    /**
     *Retorna el valor del parametro objEstado
     * @return Object
     */
    public Estado getObjEstado() {    
        return objEstado;
    }

    /**
     *Modifica  el valor del parametro objEstado
     * @param objEstado
     */
    public void setObjEstado(Estado objEstado) {   
        this.objEstado = objEstado;
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
            ResultSet datos= consulta.executeQuery("select * from estado");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
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
}
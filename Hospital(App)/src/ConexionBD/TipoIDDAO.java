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
public class TipoIDDAO {
    Tipo_ID objTipoID;

    /**
     *Constructor parametrico que inicializa las variables de la clae TipoIDDAO
     * @param objTipoID
     */
    public TipoIDDAO(Tipo_ID objTipoID) {
        this.objTipoID =objTipoID;;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase TipoIDDAO
     */
    public TipoIDDAO() {
        this.objTipoID= new Tipo_ID();
    }

    /**
     *Retorna el valor del parametro objTipoID
     * @return Object
     */
    public Tipo_ID getObjTipoID() {   
        return objTipoID;
    }

    /**
     *Modifica  el valor del parametro objTipoID
     * @param objTipoID
     */
    public void setObjTipoID(Tipo_ID objTipoID){    
        this.objTipoID = objTipoID;
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
            ResultSet datos= consulta.executeQuery("select * from cod_tipo_id");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
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
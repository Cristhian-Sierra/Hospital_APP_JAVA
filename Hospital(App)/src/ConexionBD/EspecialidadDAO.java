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
public class EspecialidadDAO {
    Especialidad objEspe;

    /**
     *Constructor parametrico que inicializa las variables de la clase EspecialidadDAO
     * @param objEspe
     */
    public EspecialidadDAO(Especialidad objEspe) {
        this.objEspe= objEspe;
    }

    /**
     *Constructor basico que instancia la variables de tipo objeto en la clase EspecialidadDAO
     */
    public EspecialidadDAO() {
        this.objEspe= new Especialidad();
    }


    /**
     *Retorna el valor del parametro objEspe
     * @return Object
     */
    public Especialidad getObjEspe() {
        return objEspe;
    }    

    /**
     *Modifica  el valor del parametro objEspe
     * @param objEspe
     */
    public void setObjEspe(Especialidad objEspe) {    
        this.objEspe = objEspe;
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
            ResultSet datos= consulta.executeQuery("select * from especialidad");//Conjunto de datos, retorna los campos de los datos de Cliente con tabla
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
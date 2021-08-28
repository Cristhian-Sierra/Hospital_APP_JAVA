/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Camilo
 */

public class Paciente {
    
   private String nombre;
   private int id;
   private Tipo_ID objTipoID;
   private String fecha_nac;
   private Municipio objM;

    public Paciente(String nombre, int id,Tipo_ID objTipoID, String fecha_nac,Municipio objM) {
        this.nombre = nombre;
        this.id = id;
        this.objTipoID = objTipoID;
        this.fecha_nac = fecha_nac;
        this.objM = objM;
    }
   
   
    public Paciente() {
        this.nombre = "";
        this.id = 0;
        this.objTipoID= new Tipo_ID();
        this.fecha_nac="";
        this.objM= new Municipio();
    }

    public Municipio getObjM() {
        return objM;
    }

    public void setObjM(Municipio objM) {
        this.objM = objM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo_ID getObjTipoID() {
        return objTipoID;
    }

    public void setObjTipoID(Tipo_ID objTipoID) {
        this.objTipoID = objTipoID;
    }
    

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "\nDatos Registrados del paciente:\n" + "ID= " + id + "\nNombre= " + nombre + "\nFecha= " + fecha_nac 
                + "\nCodigo tipo de ID= " + objTipoID.getCodigo() +"\nCodigo de Municipio = " + objM.getCodigo();
    }

 
}

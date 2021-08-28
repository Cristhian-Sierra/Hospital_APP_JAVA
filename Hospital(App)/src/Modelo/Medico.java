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
public class Medico {
   private String nombre;
   private Tipo_ID objTipoID;
   private int id;
   private String direccion;
   private String hora_i;
   private String hora_f;
   private Municipio objm;
   private Especialidad objE;
   
  public Medico(String nombre,int id,Tipo_ID objTipo_ID,String direccion,String hora_i,String hora_f,Municipio objm,Especialidad objE){
       this.nombre=nombre;
       this.id=id;
       this.objTipoID=objTipo_ID;
       this.direccion=direccion;
       this.hora_i=hora_i;
       this.hora_f=hora_f;
       this.objm=objm;
       this.objE=objE;
   }
  
    public Medico(){
       this.nombre="";
       this.objTipoID=new Tipo_ID();
       this.id=0;
       this.direccion="";
       this.hora_i="";
       this.hora_f="";
       this.objm = new Municipio();
       this.objE = new Especialidad();
   }
  
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_ID getObjTipoID() {
        return objTipoID;
    }

    public void setObjTipoID(Tipo_ID objTipoID) {
        this.objTipoID = objTipoID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHora_i() {
        return hora_i;
    }

    public void setHora_i(String hora_i) {
        this.hora_i = hora_i;
    }

    public String getHora_f() {
        return hora_f;
    }

    public void setHora_f(String hora_f) {
        this.hora_f = hora_f;
    }

    public Municipio getObjm() {
        return objm;
    }

    public void setObjm(Municipio objm) {
        this.objm = objm;
    }

    public Especialidad getObjE() {
        return objE;
    }

    public void setObjE(Especialidad objE) {
        this.objE = objE;
    }

  

    @Override
    public String toString() {
        return "\nDatos registrados del medico\n" + "Nombre= " + nombre + "\nId= " + id+ "\nCodigo tipo de Id= " + objTipoID.getCodigo()+ "\nDirección= " + direccion 
                + "\nHora de entrada= " + hora_i + "\nHora de salida= " + hora_f +"\nCodigo Municipio= " + objm.getCodigo()
                +"\nCodigo de Especialidad= "+objE.getCodigo();
    }
  
}


package Modelo;

public class TelefonosP{
   private  String telefono1;
   private Paciente objP;
   
   public TelefonosP(String telefono1,Paciente objP) {
        this.telefono1 = telefono1;
        this.objP = objP;
    }
   
    public TelefonosP() {
        this.telefono1 = "";
        this.objP = new Paciente();
    }   

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public Paciente getObjP() {
        return objP;
    }

    public void setObjP(Paciente objP) {
        this.objP = objP;
    }

    @Override
    public String toString() {
        return "\nTelefonos de Paciente: " +"\nId del paciente "+objP.getId()+ "\nTelefono 1=" + telefono1 ;
    }
   
   
   
   
   
   
   
   
   
   
   
   
}

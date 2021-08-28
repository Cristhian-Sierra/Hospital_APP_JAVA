
package Modelo;

public class TelefonosM {
   private String telefono1;
   private Medico objM;
   
   public TelefonosM(String telefono1,Medico objM) {
        this.telefono1 = telefono1;
        this.objM = objM;
    }
   
    public TelefonosM() {
        this.telefono1 = "";
        this.objM = new Medico();
    }   

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
    
    public Medico getObjM() {
        return objM;
    }

    public void setObjM(Medico objM) {
        this.objM = objM;
    }

    @Override
    public String toString() {
        return "\nTelefonos de Medico: " +"\nId del Medico "+objM.getId()+ "\nTelefono 1=" + telefono1;
    }
   
   
   
   
   
   
   
   
   
   
   
   
}

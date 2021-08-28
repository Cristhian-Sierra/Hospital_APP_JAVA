
package Modelo;

/**
 *
 * @author Camilo
 */
public class Cita {
    private int codigo;
    private String fecha_r;
    private Sede objS;
    private Paciente objP;
    private Medico objM;
    private String hora_c;
    private Estado objE;
    private Especialidad objEsp;

    public Cita(int codigo, String fecha_r, Sede objS, Paciente objP, Medico objM, String hora_c, Estado objE,Especialidad objEsp) {
        this.codigo = codigo;
        this.fecha_r = fecha_r;
        this.objS = objS;
        this.objP = objP;
        this.objM = objM;
        this.hora_c =hora_c;
        this.objE = objE;
        this.objEsp= objEsp;
    }

        public Cita() {
        this.codigo = 0;
        this.fecha_r = "";
        this.objS = new Sede();
        this.objP = new Paciente();
        this.objM = new Medico();
        this.hora_c="";
        this.objE = new Estado();
        this.objEsp = new Especialidad();
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecha_r() {
        return fecha_r;
    }

    public void setFecha_r(String fecha_r) {
        this.fecha_r = fecha_r;
    }

    public Sede getObjS() {
        return objS;
    }

    public void setObjS(Sede objS) {
        this.objS = objS;
    }

    public Paciente getObjP() {
        return objP;
    }

    public void setObjP(Paciente objP) {
        this.objP = objP;
    }

    public Medico getObjM() {
        return objM;
    }

    public void setObjM(Medico objM) {
        this.objM = objM;
    }

    public String getHora_c() {
        return hora_c;
    }

    public void setHora_c(String hora_c) {
        this.hora_c = hora_c;
    }


    public Estado getObjE() {
        return objE;
    }

    public void setObjE(Estado objE) {
        this.objE = objE;
    }

    public Especialidad getObjEsp() {
        return objEsp;
    }

    public void setObjEsp(Especialidad objEsp) {
        this.objEsp = objEsp;
    }
    
    @Override
    public String toString() {
        return "\nDatos registrados de la cita" 
                + "\nCodigo de cita= " + codigo + "\nFecha de cita= " + fecha_r +"\nCodigo de estado de la cita "+objE.getCodigo()
                + "\nCodigo de sede= " + objS.getCodigo()+ "\nId del paciente a atender= " + objP.getId()
                + "\nId del medico= " + objM.getId() +"\nHora de cita= "+hora_c+"\nCodigo de especialidad= "+objEsp.getCodigo();
                
    }


}
    
    

    


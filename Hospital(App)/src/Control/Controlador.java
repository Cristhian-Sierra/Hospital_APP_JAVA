
package Control;

import Modelo.*;
import ConexionBD.*;
import Vista.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;




public class Controlador implements ActionListener,Runnable{
    
    Hora objH;
    Fecha objF;
    Thread hilo;
    frmPrincipal frmP;
    frmRegMedico frmM;
    frmRegPaciente frmPa;
    frmReg_Cita frmCM;
    frmRegSede frmS;
    frmRegMunicipio frmMu;
    frmRegEspecialidad frmEspM;
    frmRegTelMed frmTelMed;
    frmRegTelPac frmTelPac;
    frmRegEstadoC frmEstCita;
    frmRegTipoID frmTipoID;
    frmTblCitasMedicas frmTblCM;
    frmTblMedico frmTblM;
    frmTblPaciente frmTblP;
    
    //Objetos de clases DAO
    PacienteDAO objPacDAO;
    MedicoDAO objMedDAO;
    CitaDAO objCitaDAO;
    MunicipioDAO objMunDAO;
    TipoIDDAO objTipoIDDAO;
    EspecialidadDAO objEspDAO;
    EstadoDAO objEstDAO;
    SedeDAO objSedeDAO;
    TelefonoMDAO objTelMDAO;
    TelefonoPDAO objTelPDAO;
    
    //Consultas
     frmMedicos_Mes frmMMes;
    
    public Controlador() {
        hilo = new Thread((Runnable)this);
        objH = new Hora();
        objF = new Fecha();
        frmP = new frmPrincipal();
        frmM= new frmRegMedico();
        frmPa= new frmRegPaciente();
        frmCM= new frmReg_Cita();
        frmS= new frmRegSede();
        frmMu= new frmRegMunicipio();
        frmEspM= new frmRegEspecialidad();
        frmTelMed = new frmRegTelMed();
        frmTelPac= new frmRegTelPac();
        frmEstCita = new frmRegEstadoC();
        frmTipoID = new frmRegTipoID();
        frmTblP = new frmTblPaciente();
        frmTblM = new frmTblMedico();
        frmTblCM= new frmTblCitasMedicas();
        
       
        objPacDAO = new PacienteDAO();
        objMedDAO= new MedicoDAO();
        objCitaDAO= new CitaDAO();
        objMunDAO = new MunicipioDAO();
        objTipoIDDAO= new TipoIDDAO();
        objEspDAO = new EspecialidadDAO();
        objEstDAO = new EstadoDAO();
        objSedeDAO= new SedeDAO();
        objTelMDAO= new TelefonoMDAO();
        objTelPDAO = new TelefonoPDAO();
                
        frmMMes = new frmMedicos_Mes();
        
        frmP.getEscritorio().add(frmCM);
        frmP.getEscritorio().add(frmPa);
        frmP.getEscritorio().add(frmM);
        frmP.getEscritorio().add(frmTblCM);
        frmP.getEscritorio().add(frmTblM);
        frmP.getEscritorio().add(frmTblP);
        frmP.getEscritorio().add(frmS);
        frmP.getEscritorio().add(frmMu);
        frmP.getEscritorio().add(frmEspM);
        frmP.getEscritorio().add(frmTelMed);
        frmP.getEscritorio().add(frmTelPac);
        frmP.getEscritorio().add(frmEstCita);
        frmP.getEscritorio().add(frmTipoID);
        frmP.getEscritorio().add(frmMMes);
       
        frmP.getMnuRegMedico().addActionListener(this);
        frmP.getMnuRegCita().addActionListener(this);
        frmP.getMnuRegPaciente().addActionListener(this);
        frmP.getMnuSalir().addActionListener(this);
        frmP.getMnuConCitas().addActionListener(this);
        frmP.getMnuConMedico().addActionListener(this);
        frmP.getMnuConPacientes().addActionListener(this);
        
        frmCM.getBtnMed_Esp().addActionListener(this);
        frmCM.getBtnPaciente().addActionListener(this);
        frmCM.getBtnSSede().addActionListener(this);
        frmCM.getBtnRegistroC().addActionListener(this);
        frmCM.getBtnSelEstadoC().addActionListener(this);
        frmCM.getBtnEspecialidad().addActionListener(this);
   
   
       
        frmPa.getBtnRegistrarP().addActionListener(this);
        frmPa.getBtnMunicipio().addActionListener(this);
        frmPa.getBtnTipoID().addActionListener(this);
        frmPa.getBtnAsigTelPac().addActionListener(this);
        
        frmM.getBtnRegistrarM().addActionListener(this);
        frmM.getBtnEspecial().addActionListener(this);
        frmM.getBtnMunicipio().addActionListener(this);
        frmM.getBtnTipoID().addActionListener(this);
        frmM.getBtnAsigTelMed().addActionListener(this);
        
        frmMu.getBtnRegistroMMed().addActionListener(this);
        frmMu.getBtnRegistroMPac().addActionListener(this);
        
        frmEspM.getBtnRegistroE().addActionListener(this);
        frmEspM.getBtnRegistroECita().addActionListener(this);
        
        frmS.getBtnRegistroS().addActionListener(this);
        
        frmTelMed.getBtnBuscMed().addActionListener(this);
        frmTelMed.getBtnRegTelM().addActionListener(this);
        
        frmTelPac.getBtnBuscPac().addActionListener(this);
        frmTelPac.getBtnRegTelP().addActionListener(this);
        
        frmEstCita.getBtnRegistroEstado().addActionListener(this);
        
        frmTipoID.getBtnRegistroTipoIDM().addActionListener(this);
        frmTipoID.getBtnRegistroTipoIDP().addActionListener(this);
        
        frmTblM.getBtnRegMedicos().addActionListener(this);
        frmTblM.getBtnRegMedicosT().addActionListener(this);
        
        frmTblP.getBtnRegPacientes().addActionListener(this);   
        frmTblP.getBtnRegPacientesT().addActionListener(this);
        
        //Botones CRUD Tabla Pacientes y Telefonos de Paciente
        frmTblP.getBtnElimTelPac().addActionListener(this);
        frmTblP.getBtnModTelP().addActionListener(this);
        frmTblP.getBtnModPac().addActionListener(this);
        frmTblP.getBtnElimPac().addActionListener(this);
        frmTelPac.getBtnActTP().addActionListener(this);
        frmPa.getBtnActPac().addActionListener(this);
        
         //Botones CRUD Tabla Medicos y Telefonos de Medico
        frmTblM.getBtnElimTM().addActionListener(this);
        frmTblM.getBtnModTM().addActionListener(this);
        frmTblM.getBtnModMed().addActionListener(this);
        frmTblM.getBtnElimMed().addActionListener(this);
        frmTelMed.getBtnActTM().addActionListener(this);
        frmM.getBtnActMed().addActionListener(this);
        
        //Botones CRUD Cita Medica
        frmTblCM.getBtnElimCita().addActionListener(this);
        frmTblCM.getBtnModCita().addActionListener(this);
        frmCM.getBtnActCita().addActionListener(this);
       
      //Boton Consultas
      frmTblCM.getBtnCM_Med().addActionListener(this);
        
    }
    
    
    @Override
    public void run() {
      while(true){
      frmP.getLblHora().setText(objH.toString());
      objH.incSS();
        try {
            hilo.sleep(1000);
        }
        catch(InterruptedException e){
          JOptionPane.showMessageDialog(frmP, "Error al intentar interrumpir");
        }
      } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(frmP.getMnuSalir())){//Menu para salir
            int resp=JOptionPane.showConfirmDialog(frmP,"¿Desea salir?","salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (resp==JOptionPane.YES_OPTION ){
            System.exit(0);
            }
        }  
//////////////////////////FORMULARIOS DE REGISTRO////////////////////////////////////////////////////////////////////////////////////////////////////   

        if(frmP.getMnuRegPaciente().equals(e.getSource())){
            frmPa.setVisible(true);
            frmPa.getBtnActPac().setEnabled(false);
            frmPa.getBtnRegistrarP().setEnabled(true);
        }
           
        if(frmP.getMnuRegMedico().equals(e.getSource())){
            frmM.setVisible(true);
            frmM.getBtnActMed().setEnabled(false);
            frmM.getBtnRegistrarM().setEnabled(true);
        }           
        if(frmP.getMnuConPacientes().equals(e.getSource())){
                frmTblP.setVisible(true);
                frmTblP.getTblPacientes().setModel(objPacDAO.consulta());
                frmTblP.getBtnRegPacientes().setEnabled(false);
                frmTblP.getBtnRegPacientesT().setEnabled(false);
                frmTblP.getTblTelefonosP().setModel(objTelPDAO.consulta());
                               
        }
        if(frmP.getMnuRegCita().equals(e.getSource())){
           frmCM.setVisible(true);
           frmCM.getBtnActCita().setEnabled(false);
           frmCM.getBtnRegistroC().setEnabled(true);
        }
             
        if(frmP.getMnuConMedico().equals(e.getSource())){
            frmTblM.setVisible(true);
            frmTblM.getTblMedicos().setModel(objMedDAO.consulta());
            frmTblM.getTblTelefonosM().setModel(objTelMDAO.consulta());
            frmTblM.getBtnRegMedicos().setEnabled(false);
            frmTblM.getBtnRegMedicosT().setEnabled(false);
        }
 
        if(frmP.getMnuConCitas().equals(e.getSource())){
            frmTblCM.setVisible(true);
           frmTblCM.getTblCitas().setModel(objCitaDAO.consulta());
        }
       
        if(frmPa.getBtnRegistrarP().equals(e.getSource())){ //condicional registro de paciente
            int dd= frmPa.getDataFecha().getCalendar().get(Calendar.DAY_OF_MONTH);
            int mm= (frmPa.getDataFecha().getCalendar().get(Calendar.MONTH))+1;
            int aa= frmPa.getDataFecha().getCalendar().get(Calendar.YEAR);
            String formatof= (aa+"/"+mm+"/"+dd);
            if( Validarfecha(formatof)==true && Validarstring(frmPa.getTxtNombreP().getText())==true && Validarnum(frmPa.getTxtTipoID().getText())==true && Validarnum(frmPa.getTxtMunicipioP().getText())==true ){
           
                Paciente objPa= new Paciente();
                objPa.setFecha_nac(formatof);
                objPa.setNombre(frmPa.getTxtNombreP().getText());  
                objPa.setId(Integer.parseInt(frmPa.getTxtIdP().getText()));
                objPa.getObjTipoID().setCodigo(Integer.parseInt(frmPa.getTxtTipoID().getText()));
                objPa.getObjM().setCodigo(Integer.parseInt(frmPa.getTxtMunicipioP().getText()));
                objPacDAO.setObjP(objPa);
                JOptionPane.showMessageDialog(frmP, objPa.toString());
                //LlenarTablaPa(objPa, frmTblP.getTblPacientes());
                JOptionPane.showMessageDialog(frmP, objPacDAO.insertar());  
                
                     
            }else{
                 JOptionPane.showMessageDialog(frmP, "Error,existe una inconsistencia en la informacion digitada,revise su informacion."); 
            }
           
        }            
        if(frmM.getBtnRegistrarM().equals(e.getSource())){//Condicional para boton de registro de Medico
            Medico objM= new Medico();
            objM.setNombre(frmM.getTxtNomM().getText());
            if(Validarnum(frmM.getTxtIdM().getText())==true && Validarhoramedico(frmM.getJcomboHI().getSelectedItem().toString(),frmM.getJcomboHS().getSelectedItem().toString())==true){
                objM.setId(Integer.parseInt(frmM.getTxtIdM().getText()));
                objM.getObjTipoID().setCodigo(Integer.parseInt(frmM.getTxtTipoID().getText()));
                objM.setDireccion(frmM.getTxtDir().getText());
                objM.getObjm().setCodigo(Integer.parseInt(frmM.getTxtMunicipioM().getText()));
                objM.getObjE().setCodigo(Integer.parseInt(frmM.getTxtEspecialidad().getText()));
                objM.setHora_i(String.valueOf(frmM.getJcomboHI().getSelectedItem()));
                objM.setHora_f(String.valueOf(frmM.getJcomboHS().getSelectedItem()));
                //objM.getObjm().setCodigo(Integer.parseInt(frmMu.getTxtCodigoM().getText()));
                objMedDAO.setObjM(objM);
                JOptionPane.showMessageDialog(frmP, objM.toString());
                JOptionPane.showMessageDialog(frmP, objMedDAO.insertar());
                //LlenarTablaMed(objM, frmTblM.getTblMedicos());  
            }
            else{
                JOptionPane.showMessageDialog(frmP, "Error,existe una inconsistencia en la informacion digitada,revise su informacion.");
                }
           }

        if(frmCM.getBtnRegistroC().equals(e.getSource())){//Condicional para boton de registro de cita medica
            Cita objCM= new Cita();
            int dd= frmCM.getDatatxtFechaC().getCalendar().get(Calendar.DAY_OF_MONTH);
            int mm= frmCM.getDatatxtFechaC().getCalendar().get((Calendar.MONTH))+1;
            int aa= frmCM.getDatatxtFechaC().getCalendar().get(Calendar.YEAR);
            String formatof= (aa+"/"+mm+"/"+dd);
       
             
           if( Evaluarcita(Integer.parseInt(frmCM.getTxtSPacienteID().getText()))==true){
               //
                objCM.setFecha_r(formatof);
            frmCM.getTxtCodigo().setText(String.valueOf(objCitaDAO.Autoincrement()));
            objCM.setCodigo(Integer.parseInt(frmCM.getTxtCodigo().getText()));
            objCM.getObjM().setId(Integer.parseInt(frmCM.getTxtSMedicoID().getText()));
            CitaDAO cita= new CitaDAO(); 
            if(cita.Consultacitames(Integer.parseInt(frmCM.getTxtSPacienteID().getText()))==false){
                objCM.getObjP().setId(Integer.parseInt(frmCM.getTxtSPacienteID().getText()));
            
            objCM.getObjS().setCodigo(Integer.parseInt(frmCM.getTxtCodigoS().getText()));
            objCM.setHora_c(frmCM.getJcomboHC().getSelectedItem().toString());
            objCM.getObjE().setCodigo(Integer.parseInt(frmCM.getTxtSEstadoC().getText()));
            objCM.getObjEsp().setCodigo(Integer.parseInt(frmCM.getTxtSEspecialidad().getText())); 
            objCitaDAO.setObjCM(objCM);
            JOptionPane.showMessageDialog(frmP, objCM.toString());
            JOptionPane.showMessageDialog(frmP, objCitaDAO.insertar()); 
            }
           
            //LlenarTablaCita(objCM, frmTblCM.getTblCitas());
           }else{
                JOptionPane.showMessageDialog(frmP, "Error,no se puede registrar .");
           }
             
            

           
            
        }
        
/////////////////////////////CONDICONALES PARA MODIFICAR FORMULARIOS//////////////////////////////////////////////////////////////////////////////////////////
        if(frmCM.getBtnMed_Esp().equals(e.getSource())){
            frmTblM.setVisible(true);
            frmTblM.getBtnRegMedicos().setEnabled(true);
            frmTblM.getBtnRegMedicosT().setEnabled(false);
            frmTblM.getTblMedicos().setModel(objMedDAO.consulta()); 
        }
           
        if(frmCM.getBtnPaciente().equals(e.getSource())){
            frmTblP.setVisible(true);
            frmTblP.getBtnRegPacientes().setEnabled(true);
            frmTblP.getBtnRegPacientesT().setEnabled(false);
            frmTblP.getTblPacientes().setModel(objPacDAO.consulta());
        }
        
        if(frmCM.getBtnSSede().equals(e.getSource())){//Condicional para invocar al formulario de Sede
            frmS.setVisible(true);
            frmS.getTblSedes().setModel(objSedeDAO.consulta());
            
        }

        if(frmCM.getBtnSelEstadoC().equals(e.getSource())){
            frmEstCita.setVisible(true);
            frmEstCita.getTblEstados().setModel(objEstDAO.consulta());
        }
        if(frmCM.getBtnEspecialidad().equals(e.getSource())){//Condicional para invocar al formulario de Especialidad
            frmEspM.setVisible(true);
            frmEspM.getBtnRegistroE().setEnabled(false);
            frmEspM.getBtnRegistroECita().setEnabled(true);
            frmEspM.getTblEspecialidades().setModel(objEspDAO.consulta());
        }
     
        if(frmPa.getBtnMunicipio().equals(e.getSource())){//Condicional para invocar al formulario de Municipio 
            frmMu.setVisible(true);
            frmMu.getBtnRegistroMMed().setEnabled(false);
            frmMu.getBtnRegistroMPac().setEnabled(true);
            frmMu.getTblMunicpios().setModel(objMunDAO.consulta());
        }
        if(frmPa.getBtnAsigTelPac().equals(e.getSource())){//Condicional para invocar al formulario de TelefonosPaciente
            frmTelPac.setVisible(true);
            frmTelPac.getBtnActTP().setEnabled(false);
            frmTelPac.getBtnRegTelP().setEnabled(true);
        }
        if(frmPa.getBtnTipoID().equals(e.getSource())){//Condicional para invocar al formulario de tipoID
            frmTipoID.setVisible(true);
            frmTipoID.getBtnRegistroTipoIDM().setEnabled(false);
            frmTipoID.getBtnRegistroTipoIDP().setEnabled(true);
            frmTipoID.getTblTiposID().setModel(objTipoIDDAO.consulta());
        }
        if(frmM.getBtnMunicipio().equals(e.getSource())){//Condicional para invocar al formulario de Municipio
            frmMu.setVisible(true);
            frmMu.getBtnRegistroMMed().setEnabled(true);
            frmMu.getBtnRegistroMPac().setEnabled(false);
            frmMu.getTblMunicpios().setModel(objMunDAO.consulta());
        }
        if(frmM.getBtnTipoID().equals(e.getSource())){//Condicional para invocar al formulario de TelefonosPaciente
            frmTipoID.setVisible(true);
            frmTipoID.getBtnRegistroTipoIDM().setEnabled(true);
            frmTipoID.getBtnRegistroTipoIDP().setEnabled(false);
            frmTipoID.getTblTiposID().setModel(objTipoIDDAO.consulta());
        }
        if(frmM.getBtnEspecial().equals(e.getSource())){//Condicional para invocar al formulario de Especialidad
            frmEspM.setVisible(true);
            frmEspM.getBtnRegistroE().setEnabled(true);
            frmEspM.getBtnRegistroECita().setEnabled(false);
            frmEspM.getTblEspecialidades().setModel(objEspDAO.consulta());
        }
        
        if(frmM.getBtnAsigTelMed().equals(e.getSource())){//Condicional para invocar al formulario de TelefonosPaciente
            frmTelMed.setVisible(true);
            frmTelMed.getBtnActTM().setEnabled(false);
            frmTelMed.getBtnRegTelM().setEnabled(true);
            
        }
  
        if(frmMu.getBtnRegistroMPac().equals(e.getSource())){
            JTable tabla;
            tabla = frmMu.getTblMunicpios();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                frmPa.getTxtMunicipioP().setText(String.valueOf(tabla.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Municipio seleccionado ");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun municipio");
                }           
        } 

        if(frmMu.getBtnRegistroMMed().equals(e.getSource())){
            JTable tabla;
            tabla = frmMu.getTblMunicpios();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                frmM.getTxtMunicipioM().setText(String.valueOf(tabla.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Municipio seleccionado ");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun municipio");
            }           
        }         

        if(frmTipoID.getBtnRegistroTipoIDP().equals(e.getSource())){
            JTable tabla;
            tabla = frmTipoID.getTblTiposID();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                frmPa.getTxtTipoID().setText(String.valueOf(tabla.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Tipo de ID seleccionado ");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun tipo ID");
                }           
        }
        
        if(frmTipoID.getBtnRegistroTipoIDM().equals(e.getSource())){
            JTable tabla;
            tabla = frmTipoID.getTblTiposID();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                frmM.getTxtTipoID().setText(String.valueOf(tabla.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Tipo de ID seleccionado ");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun tipo ID");
                }           
        }         

        if(frmEspM.getBtnRegistroE().equals(e.getSource())){
            JTable tabla;
            tabla = frmEspM.getTblEspecialidades();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmM.getTxtEspecialidad().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Especialidad seleccionada");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna especialidad");
            }
        }
        if(frmEspM.getBtnRegistroECita().equals(e.getSource())){
            JTable tabla;
            tabla = frmEspM.getTblEspecialidades();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmCM.getTxtSEspecialidad().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Especialidad seleccionada");
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna especialidad");
            }
        }

        
        
        if(frmTelPac.getBtnBuscPac().equals(e.getSource())){//Condicional para mostrar la lista de pacientes 
            frmTblP.setVisible(true);
            frmTblP.getBtnRegPacientes().setEnabled(false);
            frmTblP.getBtnRegPacientesT().setEnabled(true);
            frmTblP.getTblPacientes().setModel(objPacDAO.consulta());
            frmTblP.getTblTelefonosP().setModel(objTelPDAO.consulta());

        }
        if(frmTelPac.getBtnRegTelP().equals(e.getSource())){//Condicional para registro de telefonos de paciente
            TelefonosP objTelP= new TelefonosP();
            objTelP.getObjP().setId(Integer.parseInt(frmTelPac.getTxtSelIDPac().getText()));
            objTelP.setTelefono1(frmTelPac.getTxtPacTel1().getText());
            objTelPDAO.setObjTelP(objTelP);
            JOptionPane.showMessageDialog(frmP, objTelPDAO.insertar());
        }
        if(frmTelMed.getBtnRegTelM().equals(e.getSource())){//Condicional para  mostrar la lista de medicos
            TelefonosM objTelM= new TelefonosM();
            objTelM.getObjM().setId(Integer.parseInt(frmTelMed.getTxtSelIDMed().getText()));
            objTelM.setTelefono1(frmTelMed.getTxtMedTel1().getText());
            objTelMDAO.setObjTelM(objTelM);
            JOptionPane.showMessageDialog(frmP, objTelMDAO.insertar());

        }
        if(frmTelMed.getBtnBuscMed().equals(e.getSource())){//Condicional para mostrar la lista de pacientes 
            frmTblM.setVisible(true);
            frmTblM.getBtnRegMedicos().setEnabled(false);
            frmTblM.getBtnRegMedicosT().setEnabled(true);
            frmTblP.getTblTelefonosP().setModel(objTelPDAO.consulta());
            frmTblCM.getTblCitas().setModel(objCitaDAO.consulta());
        }
            
        if(frmEstCita.getBtnRegistroEstado().equals(e.getSource())){//Condiconal para registrar la sede
            JTable tabla;
            tabla = frmEstCita.getTblEstados();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmCM.getTxtSEstadoC().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Estado seleccionado");
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun estado");
            }   
        }        
        if(frmS.getBtnRegistroS().equals(e.getSource())){//Condiconal para registrar la sede
            JTable tabla;
            tabla = frmS.getTblSedes();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmCM.getTxtCodigoS().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Sede seleccionada");
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado sede");
            }    
        }
       
        
        if(frmTblP.getBtnRegPacientesT().equals(e.getSource())){//Registrar paciente a telefono
            JTable tabla;
            tabla = frmTblP.getTblPacientes();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmTelPac.getTxtSelIDPac().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Paciente seleccionado");
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado paciente");
            }
        }
           
        if(frmTblP.getBtnRegPacientes().equals(e.getSource())){//Condicional para añadir un paciente de la tabla a una cita      
            JTable tabla = frmTblP.getTblPacientes();
            int fila = tabla.getSelectedRow();   // Se trae la fila que está seleccionada 
            if(fila>=0) //Condicional para validar si hay una fila seleccionada
            { 
            frmCM.getTxtSPacienteID().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Paciente seleccionado "+Integer.toString(fila));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun paciente "+Integer.toString(fila));
            }
        }

        if(frmTblM.getBtnRegMedicosT().equals(e.getSource())){//Condicional para registro de telefonos de medico
            JTable tabla;
            tabla = frmTblM.getTblMedicos();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
            frmTelMed.getTxtSelIDMed().setText(String.valueOf(tabla.getValueAt(fila, 0)));
            JOptionPane.showMessageDialog(null, "Medico seleccionado");
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado medico");
            }   
        }        
          
        if(frmTblM.getBtnRegMedicos().equals(e.getSource())){//Condicional para llevar un medico de la tabla a una cita
            JTable tabla = frmTblM.getTblMedicos();
            int fila = tabla.getSelectedRow();   // Se trae la fila que está seleccionada 
            if(fila>=0){
                frmCM.getTxtSMedicoID().setText(String.valueOf(tabla.getValueAt(fila, 0)));
                JOptionPane.showMessageDialog(null, "Medico seleccionado "+Integer.toString(fila));
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun medico "+Integer.toString(fila));
            }
        }

    /////////////////////////////BOTONES DEL CRUD TELEFONO PACIENTE//////////////////////////////////////////////////////////////////////////////////////////////////////
        if(frmTblP.getBtnElimTelPac().equals(e.getSource())){//Eliminar Telefono de Paciente
            TelefonosP objTP = new TelefonosP();
            JTable tabla = frmTblP.getTblTelefonosP();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                objTP.getObjP().setId((int) tabla.getValueAt(fila, 0));
                objTP.setTelefono1((String) tabla.getValueAt(fila, 1));
                objTelPDAO.setObjTelP(objTP);
                JOptionPane.showMessageDialog(frmP,objTelPDAO.eliminar());
                modelo.removeRow(fila);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna ila de telefonos");
            }
            
        }
        if(frmTblP.getBtnModTelP().equals(e.getSource())){
            frmTelPac.setVisible(true);
            frmTelPac.getBtnActTP().setEnabled(true);
            frmTelPac.getBtnRegTelP().setEnabled(false);
            JTable tabla = frmTblP.getTblTelefonosP();
            //DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
              frmTelPac.getTxtSelIDPac().setText(String.valueOf(tabla.getValueAt(fila, 0)));
              frmTelPac.getTxtPacTel1().setText(String.valueOf(tabla.getValueAt(fila, 1)));
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de telefonos");
            }
        
        }
        if(frmTelPac.getBtnActTP().equals(e.getSource())){
            TelefonosP objTP = new TelefonosP();
            objTP.getObjP().setId(Integer.parseInt(frmTelPac.getTxtSelIDPac().getText()));
            objTP.setTelefono1(frmTelPac.getTxtPacTel1().getText());
            objTelPDAO.setObjTelP(objTP);
            JOptionPane.showMessageDialog(frmP, objTelPDAO.actualizar()); 
        }
/////////////////////////////////////////////Botones CRUD TELEFONO MEDICO////////////////////////////////////////////////////////////////        
        if(frmTblM.getBtnElimTM().equals(e.getSource())){//Eliminar Telefono de Medico
            TelefonosM objTM = new TelefonosM();
            JTable tabla = frmTblM.getTblTelefonosM();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                objTM.getObjM().setId((int) tabla.getValueAt(fila, 0));
                objTM.setTelefono1((String) tabla.getValueAt(fila, 1));
                objTelMDAO.setObjTelM(objTM);
                JOptionPane.showMessageDialog(frmP,objTelMDAO.eliminar());
                modelo.removeRow(fila);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de telefonos");
            }
        }
        
        if(frmTblM.getBtnModTM().equals(e.getSource())){
            frmTelMed.setVisible(true);
            frmTelMed.getBtnActTM().setEnabled(true);
            frmTelMed.getBtnRegTelM().setEnabled(false);
            JTable tabla = frmTblM.getTblTelefonosM();
            //DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
              frmTelMed.getTxtSelIDMed().setText(String.valueOf(tabla.getValueAt(fila, 0)));
              frmTelMed.getTxtMedTel1().setText(String.valueOf(tabla.getValueAt(fila, 1)));
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de telefonos");
            }
        
        }
        if(frmTelMed.getBtnActTM().equals(e.getSource())){
            TelefonosM objTM = new TelefonosM();
            objTM.getObjM().setId(Integer.parseInt(frmTelMed.getTxtSelIDMed().getText()));
            objTM.setTelefono1(frmTelMed.getTxtMedTel1().getText());
            objTelMDAO.setObjTelM(objTM);
            JOptionPane.showMessageDialog(frmP, objTelMDAO.actualizar()); 
        }
            
 ///////////////////////////CONDICIONES CRUD CITA MEDICA(VA PRIMERO YA QUE EN ESTA AL MOMENTO DE ELIMINAR, NO PRESENTARA ERRORES DE INTEGRIDAD, CREO XD    
        if(frmTblCM.getBtnElimCita().equals(e.getSource())){//Eliminar Telefono de Medico
            Cita objCM = new Cita();
            JTable tabla = frmTblCM.getTblCitas();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                objCM.setCodigo((int) tabla.getValueAt(fila, 0));
                objCM.getObjE().setCodigo((int) tabla.getValueAt(fila, 1));
                objCM.getObjS().setCodigo((int) tabla.getValueAt(fila, 2));
                objCM.getObjP().setId((int) tabla.getValueAt(fila, 3));
                objCM.getObjM().setId((int) tabla.getValueAt(fila, 4));
                objCM.setHora_c(( tabla.getValueAt(fila, 5)).toString());
                objCM.setFecha_r( tabla.getValueAt(fila, 6).toString());
                objCM.getObjEsp().setCodigo((int) tabla.getValueAt(fila, 7));                
                objCitaDAO.setObjCM(objCM);
                JOptionPane.showMessageDialog(frmP,objCitaDAO.eliminar());
                modelo.removeRow(fila);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de citas");
            }
        }
        
        if(frmTblCM.getBtnModCita().equals(e.getSource())){
           frmCM.setVisible(true);
           frmCM.getBtnActCita().setEnabled(true);
           frmCM.getBtnRegistroC().setEnabled(false);
           JTable tabla = frmTblCM.getTblCitas();
           //DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
           int fila = tabla.getSelectedRow();
           if(fila>=0){
               frmCM.getTxtCodigo().setText(String.valueOf(tabla.getValueAt(fila, 0)));
               frmCM.getTxtSEstadoC().setText(String.valueOf(tabla.getValueAt(fila, 1)));
               frmCM.getTxtCodigoS().setText(String.valueOf(tabla.getValueAt(fila, 2)));
               frmCM.getTxtSPacienteID().setText(String.valueOf(tabla.getValueAt(fila, 3)));
               frmCM.getTxtSMedicoID().setText(String.valueOf(tabla.getValueAt(fila, 4)));
               frmCM.getJcomboHC().setSelectedItem(tabla.getValueAt(fila, 5).toString());
               frmCM.getDatatxtFechaC().setDate((Date) tabla.getValueAt(fila, 6));
               frmCM.getTxtSEspecialidad().setText(String.valueOf(tabla.getValueAt(fila, 7)));
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de telefonos");
            }
        }
        if(frmCM.getBtnActCita().equals(e.getSource())){
            Cita objCM = new Cita();
            int dd= frmCM.getDatatxtFechaC().getCalendar().get(Calendar.DAY_OF_MONTH);
            int mm= frmCM.getDatatxtFechaC().getCalendar().get((Calendar.MONTH))+1;
            int aa= frmCM.getDatatxtFechaC().getCalendar().get(Calendar.YEAR);
            String formatof= (aa+"/"+mm+"/"+dd);
            objCM.setFecha_r(formatof);
            //frmCM.getTxtCodigo().setText(String.valueOf(objCitaDAO.Autoincrement()));
            objCM.setCodigo(Integer.parseInt(frmCM.getTxtCodigo().getText()));
            objCM.getObjM().setId(Integer.parseInt(frmCM.getTxtSMedicoID().getText()));
            objCM.getObjP().setId(Integer.parseInt(frmCM.getTxtSPacienteID().getText()));
            objCM.getObjS().setCodigo(Integer.parseInt(frmCM.getTxtCodigoS().getText()));
            objCM.setHora_c(frmCM.getJcomboHC().getSelectedItem().toString());
            objCM.getObjE().setCodigo(Integer.parseInt(frmCM.getTxtSEstadoC().getText()));
            objCM.getObjEsp().setCodigo(Integer.parseInt(frmCM.getTxtSEspecialidad().getText()));
            objCitaDAO.setObjCM(objCM);
            JOptionPane.showMessageDialog(frmP, objCitaDAO.actualizar()); 
        }    
 ////////////////////////////////////////CONDICIONES CRUD PACIENTE//////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        if(frmTblP.getBtnElimPac().equals(e.getSource())){//Eliminar Paciente
            Paciente objP = new Paciente();
            JTable tabla = frmTblP.getTblPacientes();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                objP.setId((int) tabla.getValueAt(fila, 0));
                objP.setNombre((String) tabla.getValueAt(fila, 1));
                objP.setFecha_nac(( tabla.getValueAt(fila, 2)).toString());
                objP.getObjTipoID().setCodigo((int) tabla.getValueAt(fila, 3));
                objP.getObjM().setCodigo((int) tabla.getValueAt(fila, 4));                   
                objPacDAO.setObjP(objP);
                JOptionPane.showMessageDialog(frmP,objPacDAO.eliminar());
                modelo.removeRow(fila);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de pacientes");
            }
        }
        
        if(frmTblP.getBtnModPac()==e.getSource()){
           frmPa.setVisible(true);
           frmPa.getBtnActPac().setEnabled(true);
           frmPa.getBtnRegistrarP().setEnabled(false);
           JTable tabla = frmTblP.getTblPacientes();
           //DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
           int fila = tabla.getSelectedRow();
           if(fila>=0){
               frmPa.getTxtIdP().setText(String.valueOf(tabla.getValueAt(fila, 0)));
               frmPa.getTxtNombreP().setText(String.valueOf(tabla.getValueAt(fila, 1)));
               frmPa.getDataFecha().setDate((Date)tabla.getValueAt(fila, 2));
               frmPa.getTxtTipoID().setText(String.valueOf(tabla.getValueAt(fila, 3)));
               frmPa.getTxtMunicipioP().setText(String.valueOf(tabla.getValueAt(fila, 4)));
 
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de pacientes");
            }
        }
        if(frmPa.getBtnActPac().equals(e.getSource())){
            Paciente objPa = new Paciente();
            int dd= frmPa.getDataFecha().getCalendar().get(Calendar.DAY_OF_MONTH);
            int mm= (frmPa.getDataFecha().getCalendar().get(Calendar.MONTH))+1;
            int aa= frmPa.getDataFecha().getCalendar().get(Calendar.YEAR);
            String formatof= (aa+"/"+mm+"/"+dd);
            if( Validarfecha(formatof)==true){
                objPa.setFecha_nac(formatof);
                objPa.setNombre(frmPa.getTxtNombreP().getText());
                objPa.setId(Integer.parseInt(frmPa.getTxtIdP().getText()));
                objPa.getObjTipoID().setCodigo(Integer.parseInt(frmPa.getTxtTipoID().getText()));
                objPa.getObjM().setCodigo(Integer.parseInt(frmPa.getTxtMunicipioP().getText()));
                objPacDAO.setObjP(objPa);
                JOptionPane.showMessageDialog(frmP, objPacDAO.actualizar()); 
            }            
            else{
                JOptionPane.showMessageDialog(frmP, "Error, usted no puede nacer en el futuro");
            }
        }      
//////////////////////////////////////////CONDICIONES CRUD MEDICO///////////////////////////////////////////////////////////////////////////////////////////////////////////////   
        if(frmTblM.getBtnElimMed().equals(e.getSource())){//Eliminar Paciente
            Medico objM = new Medico();
            JTable tabla = frmTblM.getTblMedicos();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                objM.setId((int) tabla.getValueAt(fila, 0));
                objM.setNombre((String) tabla.getValueAt(fila, 1));
                objM.setDireccion(((String) tabla.getValueAt(fila, 2)));
                objM.getObjTipoID().setCodigo((int) tabla.getValueAt(fila, 3));
                objM.getObjE().setCodigo((int) tabla.getValueAt(fila, 4));
                objM.setHora_i(( tabla.getValueAt(fila, 5)).toString());
                objM.setHora_f(( tabla.getValueAt(fila, 6).toString()));
                objM.getObjm().setCodigo((int) tabla.getValueAt(fila, 7));
                
                objMedDAO.setObjM(objM);
                JOptionPane.showMessageDialog(frmP,objMedDAO.eliminar());
                modelo.removeRow(fila);
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de medicos");
            }
        }
        
        if(frmTblM.getBtnModMed()==e.getSource()){
           frmM.setVisible(true);
           frmM.getBtnActMed().setEnabled(true);
           frmM.getBtnRegistrarM().setEnabled(false);
           JTable tabla = frmTblM.getTblMedicos();
           //DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
           int fila = tabla.getSelectedRow();
           if(fila>=0){
               frmM.getTxtIdM().setText(String.valueOf(tabla.getValueAt(fila, 0)));
               frmM.getTxtNomM().setText(String.valueOf(tabla.getValueAt(fila, 1)));
               frmM.getTxtDir().setText((String) tabla.getValueAt(fila, 2));
               frmM.getTxtTipoID().setText(String.valueOf(tabla.getValueAt(fila, 3)));
               frmM.getTxtEspecialidad().setText(String.valueOf(tabla.getValueAt(fila, 4)));
               frmM.getJcomboHI().setSelectedItem(String.valueOf(tabla.getValueAt(fila, 5)));
               frmM.getJcomboHS().setSelectedItem(String.valueOf(tabla.getValueAt(fila, 6)));
               frmM.getTxtMunicipioM().setText(String.valueOf(tabla.getValueAt(fila, 7)));
            }
            else{
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila de medicos");
            }
        }
        if(frmM.getBtnActMed().equals(e.getSource())){
            Medico objM = new Medico();
            
            if(Validarnum(frmM.getTxtIdM().getText())==true){
                objM.setNombre(frmM.getTxtNomM().getText());
                objM.setId(Integer.parseInt(frmM.getTxtIdM().getText()));
                objM.getObjTipoID().setCodigo(Integer.parseInt(frmM.getTxtTipoID().getText()));
                objM.setDireccion(frmM.getTxtDir().getText());
                objM.getObjm().setCodigo(Integer.parseInt(frmM.getTxtMunicipioM().getText()));
                objM.getObjE().setCodigo(Integer.parseInt(frmM.getTxtEspecialidad().getText()));
                objM.setHora_i(String.valueOf(frmM.getJcomboHI().getSelectedItem()));
                objM.setHora_f(String.valueOf(frmM.getJcomboHS().getSelectedItem()));
                objMedDAO.setObjM(objM);
                JOptionPane.showMessageDialog(frmP, objMedDAO.actualizar());
                //LlenarTablaMed(objM, frmTblM.getTblMedicos());  
            }
            else{
                JOptionPane.showMessageDialog(frmP, "Error,solo debe introducir numeros en el espacio de id.");
                }   
            
        }
        
///////////////////////////////////////////////CONSULTAS///////////////////////////////////////////////////////////////////////////////////////
        if(frmTblCM.getBtnCM_Med().equals(e.getSource())){
            JTable tabla = frmTblCM.getTblCitas();
            ;
            int fila = tabla.getSelectedRow();
            if(fila>=0){
                //tabla.getValueAt(fila, 0);
                
                frmMMes.setVisible(true);
               JOptionPane.showMessageDialog(frmP, objCitaDAO.Consulta_CM_Medico());
            
            }
            else{
                JOptionPane.showMessageDialog(frmP, "No ha seleccionado ninguna fila");
            }
        
        }
    }    
        
        
    
/////////////////////////////////////////////////METODOS DE VALIDACION/////////////////////////////////////////////////////////////////////////////////////////////////////////
  
        
    public boolean Validarnum(String n){
        try{
           Double.parseDouble(n);
            }catch(NumberFormatException e){
            return false;
           }
            return true;
        }
    
   public boolean Validarstring(String st){
        for(int i=0;i< st.length();i++){
            int c =  (int) st.charAt(i);
            if(c >= 1 && c<=64 || c>= 91 && c<=96 || c>=123 && c<=127 || st.charAt(i)==' '){
                return true;
            }                   
        }
        return false;
    }
    
    public boolean Validarfecha(String f){
        java.util.Date factual = new Date(); 
        SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd"); 
        Date fnac = null;
        try {
            fnac = formato.parse(f);
            if(factual.compareTo(fnac) <=0){
                return false;
            }else{
                return true;
            }
    
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return true;
    } 
     public boolean Validarespecialidadcita(String f){
         Calendar fechaact=Calendar.getInstance();
        int dd = fechaact.get(Calendar.DAY_OF_MONTH);
        int mm = fechaact.get(Calendar.MONTH)+1;
        int aa = fechaact.get(Calendar.YEAR);
        String formatof=(aa+"/"+mm+"/"+dd); 
        SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd"); 
        Date fcita = null;
   
        try{
            fcita= formato.parse(f);
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        return true;
     }
      public boolean Validarfechacita(String f){
        Calendar fechaact=Calendar.getInstance();
        int dd = fechaact.get(Calendar.DAY_OF_MONTH);
        int mm = fechaact.get(Calendar.MONTH)+1;
        int aa = fechaact.get(Calendar.YEAR);
        String formatof=(aa+"/"+mm+"/"+dd);
        
        SimpleDateFormat formato=new SimpleDateFormat("yyyy/MM/dd"); 
        Date fcita = null;
        Date factual =null;
        try {
            fcita = formato.parse(f);
            factual = formato.parse(formatof);
            if(factual.compareTo(fcita) <=0){
                return false;
            }else{
                return true;
            }
    
        }catch (ParseException ex){
            ex.printStackTrace();
        }
        return true;
    } 
 
     public boolean Validarhoramedico(String hi,String hf){
        String[] hia= hi.split(":");
          String[] hfa= hf.split(":");
          int ni= Integer.parseInt(hia[0]);
          int nf= Integer.parseInt(hfa[0]);
          if(ni<nf){
              return true;
          }
        return false;
    }
     public boolean Evaluarcita(int idpac){
         
             ConexionBD con=new ConexionBD();
         ArrayList<Cita>ListaCitas= con.consultarcitas();
         int cont=0;
       for (int i=0 ; i< ListaCitas.size();i++){
           ListaCitas.get(i).getCodigo();
            ListaCitas.get(i).getObjEsp().getCodigo();
            if(ListaCitas.get(i).getObjEsp().getCodigo()!=8&& idpac== ListaCitas.get(i).getObjP().getId()){
               cont++; 
            }
           
       } 
       if(cont>2){
           return false;
       }else{
           return true;
       }
          
     }
    public void Iniciar(){
        frmP.setTitle("Gestión de Hospital");
        frmP.setVisible(true);
        frmP.getLblFecha().setText(objF.toString());
        frmTblP.getTblPacientes().setModel(objPacDAO.consulta());
        frmTblM.getTblMedicos().setModel(objMedDAO.consulta());
        frmTblCM.getTblCitas().setModel(objCitaDAO.consulta());
        frmMu.getTblMunicpios().setModel(objMunDAO.consulta());
        frmTipoID.getTblTiposID().setModel(objTipoIDDAO.consulta());
        frmEspM.getTblEspecialidades().setModel(objEspDAO.consulta());
        frmEstCita.getTblEstados().setModel(objEstDAO.consulta());
        frmS.getTblSedes().setModel(objSedeDAO.consulta());
        frmTblP.getTblTelefonosP().setModel(objTelPDAO.consulta());
        frmTblM.getTblTelefonosM().setModel(objTelMDAO.consulta());
     //frmMu.getTblMunicpios().setModel(objMunDAO.consulta());
     
    }    
    
}

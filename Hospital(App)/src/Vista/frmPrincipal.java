package Vista;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

public class frmPrincipal extends javax.swing.JFrame 
{

    public frmPrincipal() 
    {
        initComponents();
        Escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
    }

    public JDesktopPane getEscritorio() {
        return Escritorio;
    }

    public void setEscritorio(JDesktopPane Escritorio) {
        this.Escritorio = Escritorio;
    }

    public JMenuItem getMnuConCitas() {
        return MnuConCitas;
    }

    public void setMnuConCitas(JMenuItem MnuConCitas) {
        this.MnuConCitas = MnuConCitas;
    }

    public JMenuItem getMnuConMedico() {
        return MnuConMedico;
    }

    public void setMnuConMedico(JMenuItem MnuConMedico) {
        this.MnuConMedico = MnuConMedico;
    }

    public JMenuItem getMnuConPacientes() {
        return MnuConPacientes;
    }

    public void setMnuConPacientes(JMenuItem MnuConPacientes) {
        this.MnuConPacientes = MnuConPacientes;
    }

    public JMenuItem getMnuRegCita() {
        return MnuRegCita;
    }

    public void setMnuRegCita(JMenuItem MnuRegCita) {
        this.MnuRegCita = MnuRegCita;
    }

    public JMenuItem getMnuRegMedico() {
        return MnuRegMedico;
    }

    public void setMnuRegMedico(JMenuItem MnuRegMedico) {
        this.MnuRegMedico = MnuRegMedico;
    }

    public JMenuItem getMnuRegPaciente() {
        return MnuRegPaciente;
    }

    public JMenuItem getMnuSalir() {
        return mnuSalir;
    }

    public void setMnuSalir(JMenuItem mnuSalir) {
        this.mnuSalir = mnuSalir;
    }

    public void setMnuRegPaciente(JMenuItem MnuRegPaciente) {
        this.MnuRegPaciente = MnuRegPaciente;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JLabel getLblHora() {
        return lblHora;
    }

    public void setLblHora(JLabel lblHora) {
        this.lblHora = lblHora;
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        Escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnuRegPaciente = new javax.swing.JMenuItem();
        MnuRegMedico = new javax.swing.JMenuItem();
        MnuRegCita = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MnuConCitas = new javax.swing.JMenuItem();
        MnuConPacientes = new javax.swing.JMenuItem();
        MnuConMedico = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 66, 121));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        lblFecha.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("Fecha");

        lblHora.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(439, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFecha))
        );

        jMenu1.setText("Registrar");

        MnuRegPaciente.setText("Registrar Paciente");
        MnuRegPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuRegPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(MnuRegPaciente);

        MnuRegMedico.setText("Registrar Medico");
        jMenu1.add(MnuRegMedico);

        MnuRegCita.setText("Registrar Cita medica");
        jMenu1.add(MnuRegCita);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultar");

        MnuConCitas.setText("Citas");
        jMenu2.add(MnuConCitas);

        MnuConPacientes.setText("Pacientes");
        MnuConPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuConPacientesActionPerformed(evt);
            }
        });
        jMenu2.add(MnuConPacientes);

        MnuConMedico.setText("Medicos");
        MnuConMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuConMedicoActionPerformed(evt);
            }
        });
        jMenu2.add(MnuConMedico);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salir");

        mnuSalir.setText("¿Desea salir?");
        jMenu3.add(mnuSalir);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnuRegPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuRegPacienteActionPerformed

    }//GEN-LAST:event_MnuRegPacienteActionPerformed

    private void MnuConMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuConMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnuConMedicoActionPerformed

    private void MnuConPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuConPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MnuConPacientesActionPerformed



 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem MnuConCitas;
    private javax.swing.JMenuItem MnuConMedico;
    private javax.swing.JMenuItem MnuConPacientes;
    private javax.swing.JMenuItem MnuRegCita;
    private javax.swing.JMenuItem MnuRegMedico;
    private javax.swing.JMenuItem MnuRegPaciente;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables
}

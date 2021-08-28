/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author CRISTHIAN. S
 */
public class frmTblPaciente extends javax.swing.JInternalFrame {
    
        public frmTblPaciente() {
        initComponents();
    }

    public JButton getBtnRegPacientesT() {
        return btnRegPacientesT;
    }

    public void setBtnRegPacientesT(JButton btnRegPacientesT) {
        this.btnRegPacientesT = btnRegPacientesT;
    }

    public JTable getTblPacientes() {
        return TblPacientes;
    }

    public void setTblPacientes(JTable TblPacientes) {
        this.TblPacientes = TblPacientes;
    }

    public JButton getBtnRegPacientes() {
        return btnRegPacientes;
    }

    public void setBtnRegPacientes(JButton btnRegPacientes) {
        this.btnRegPacientes = btnRegPacientes;
    }

    public JTable getTblTelefonosP() {
        return tblTelefonosP;
    }

    public void setTblTelefonosP(JTable tblTelefonosP) {
        this.tblTelefonosP = tblTelefonosP;
    }

    public JButton getBtnElimPac() {
        return BtnElimPac;
    }

    public void setBtnElimPac(JButton BtnElimPac) {
        this.BtnElimPac = BtnElimPac;
    }

    public JButton getBtnModPac() {
        return BtnModPac;
    }

    public void setBtnModPac(JButton BtnModPac) {
        this.BtnModPac = BtnModPac;
    }

    public JButton getBtnElimTelPac() {
        return BtnElimTelPac;
    }

    public void setBtnElimTelPac(JButton BtnElimTelPac) {
        this.BtnElimTelPac = BtnElimTelPac;
    }

    public JButton getBtnModTelP() {
        return BtnModTelP;
    }

    public void setBtnModTelP(JButton BtnModTelP) {
        this.BtnModTelP = BtnModTelP;
    }

   
    
   

    @SuppressWarnings("unchecked")
                           
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefonosP = new javax.swing.JTable();
        BtnModTelP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BtnElimTelPac = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRegPacientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPacientes = new javax.swing.JTable();
        BtnModPac = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnElimPac = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRegPacientesT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Lista de Pacientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblTelefonosP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Paciente", "Telefono 1", "Telefono 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTelefonosP);
        if (tblTelefonosP.getColumnModel().getColumnCount() > 0) {
            tblTelefonosP.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnModTelP.setBackground(new java.awt.Color(255, 255, 255));
        BtnModTelP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/modificar.png"))); // NOI18N
        BtnModTelP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnModTelP.setFocusable(false);
        BtnModTelP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModTelP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel5.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 166, 198));
        jLabel5.setText("Modificar");

        BtnElimTelPac.setBackground(new java.awt.Color(255, 255, 255));
        BtnElimTelPac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/eliminar.png"))); // NOI18N
        BtnElimTelPac.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnElimTelPac.setFocusable(false);
        BtnElimTelPac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnElimTelPac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 166, 198));
        jLabel6.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnModTelP, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(BtnElimTelPac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(BtnModTelP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnElimTelPac, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRegPacientes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegPacientes.setText("Registrar paciente a cita");
        btnRegPacientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num ID", "Nombre", "Fecha nacimiento", "Cod.Tipo ID", "Cod. Municpio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblPacientes);
        if (TblPacientes.getColumnModel().getColumnCount() > 0) {
            TblPacientes.getColumnModel().getColumn(0).setResizable(false);
            TblPacientes.getColumnModel().getColumn(1).setResizable(false);
            TblPacientes.getColumnModel().getColumn(2).setResizable(false);
            TblPacientes.getColumnModel().getColumn(3).setResizable(false);
            TblPacientes.getColumnModel().getColumn(4).setResizable(false);
        }

        BtnModPac.setBackground(new java.awt.Color(255, 255, 255));
        BtnModPac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/modificar.png"))); // NOI18N
        BtnModPac.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnModPac.setFocusable(false);
        BtnModPac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModPac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Modificar");

        BtnElimPac.setBackground(new java.awt.Color(255, 255, 255));
        BtnElimPac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/eliminar.png"))); // NOI18N
        BtnElimPac.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnElimPac.setFocusable(false);
        BtnElimPac.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnElimPac.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Eliminar");

        btnRegPacientesT.setBackground(new java.awt.Color(255, 255, 255));
        btnRegPacientesT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/phone_7135.png"))); // NOI18N
        btnRegPacientesT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegPacientesT.setFocusable(false);
        btnRegPacientesT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegPacientesT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jLabel2.setText("Agregar paciente  a telefono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(btnRegPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegPacientesT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(BtnElimPac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnModPac, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnModPac, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnElimPac, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegPacientesT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnElimPac;
    private javax.swing.JButton BtnElimTelPac;
    private javax.swing.JButton BtnModPac;
    private javax.swing.JButton BtnModTelP;
    private javax.swing.JTable TblPacientes;
    private javax.swing.JButton btnRegPacientes;
    private javax.swing.JButton btnRegPacientesT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTelefonosP;
    // End of variables declaration//GEN-END:variables
}

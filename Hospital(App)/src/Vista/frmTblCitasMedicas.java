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
public class frmTblCitasMedicas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTblCitasMedicas
     */
    public frmTblCitasMedicas() {
        initComponents();
    }

    public JTable getTblCitas() {
        return TblCitas;
    }

    public void setTblCitas(JTable TblCitas) {
        this.TblCitas = TblCitas;
    }

    public JButton getBtnElimCita() {
        return BtnElimCita;
    }

    public void setBtnElimCita(JButton BtnElimCita) {
        this.BtnElimCita = BtnElimCita;
    }

    public JButton getBtnModCita() {
        return BtnModCita;
    }

    public void setBtnModCita(JButton BtnModCita) {
        this.BtnModCita = BtnModCita;
    }

    public JButton getBtnCM_Med() {
        return BtnCM_Med;
    }

    public void setBtnCM_Med(JButton BtnCM_Med) {
        this.BtnCM_Med = BtnCM_Med;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblCitas = new javax.swing.JTable();
        BtnModCita = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnElimCita = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnCM_Med = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Lista de Citas");

        TblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod de cita", "Cod de Estado", "Cod de Sede", "ID Paciente", "ID Medico", "Hora Cita", "Fecha Cita", "Cod de Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblCitas);
        if (TblCitas.getColumnModel().getColumnCount() > 0) {
            TblCitas.getColumnModel().getColumn(0).setResizable(false);
            TblCitas.getColumnModel().getColumn(1).setResizable(false);
            TblCitas.getColumnModel().getColumn(2).setResizable(false);
            TblCitas.getColumnModel().getColumn(3).setResizable(false);
            TblCitas.getColumnModel().getColumn(4).setResizable(false);
            TblCitas.getColumnModel().getColumn(5).setResizable(false);
            TblCitas.getColumnModel().getColumn(6).setResizable(false);
            TblCitas.getColumnModel().getColumn(7).setResizable(false);
        }

        BtnModCita.setBackground(new java.awt.Color(255, 255, 255));
        BtnModCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconostablas/modificar.png"))); // NOI18N
        BtnModCita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnModCita.setFocusable(false);
        BtnModCita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnModCita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Eliminar");

        BtnElimCita.setBackground(new java.awt.Color(255, 255, 255));
        BtnElimCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconostablas/eliminar.png"))); // NOI18N
        BtnElimCita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnElimCita.setFocusable(false);
        BtnElimCita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnElimCita.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Eras Medium ITC", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Modificar");

        BtnCM_Med.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnCM_Med.setText("Citas medicas, atendidas por medico durante el mes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCM_Med, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnModCita, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtnElimCita, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 6, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(BtnModCita, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(BtnElimCita, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCM_Med, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCM_Med;
    private javax.swing.JButton BtnElimCita;
    private javax.swing.JButton BtnModCita;
    private javax.swing.JTable TblCitas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

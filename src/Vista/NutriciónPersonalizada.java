package Vista;

public class NutriciónPersonalizada extends javax.swing.JFrame {

    public NutriciónPersonalizada() {
        initComponents();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboseleccionar = new javax.swing.JComboBox<>();
        btnelegir = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtamostrar = new javax.swing.JTextArea();
        txtexceso = new javax.swing.JTextField();
        txtequilibrio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarecomendaciones = new javax.swing.JTextArea();
        btnguardar = new javax.swing.JButton();
        txtdianostico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btninicio = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnnutricion = new javax.swing.JButton();
        btnpersonalizada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUTRICIÓN PERSONALIZADA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboseleccionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Seleccionar---", "Registro N1°", "Registro N2°", "Registro N3°" }));
        cboseleccionar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cboseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(cboseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 173, 40));

        btnelegir.setBackground(new java.awt.Color(0, 204, 51));
        btnelegir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnelegir.setForeground(new java.awt.Color(255, 255, 255));
        btnelegir.setText("ELEGIR");
        btnelegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelegirActionPerformed(evt);
            }
        });
        jPanel1.add(btnelegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 140, 40));

        btnmostrar.setBackground(new java.awt.Color(0, 204, 51));
        btnmostrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnmostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnmostrar.setText("MOSTRAR DIETA");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("INDICADORES:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));

        txtamostrar.setColumns(20);
        txtamostrar.setRows(5);
        txtamostrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOSTRAR DIETA SUGERIDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jScrollPane3.setViewportView(txtamostrar);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 350, 220));

        txtexceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXCESO O DEFICIT CALORICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtexceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 340, 60));

        txtequilibrio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EQUILIBRIO DE MACRONUTRIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtequilibrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 340, 50));

        txtarecomendaciones.setColumns(20);
        txtarecomendaciones.setRows(5);
        txtarecomendaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECOMENDACIONES ESPECIFICAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jScrollPane1.setViewportView(txtarecomendaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 340, 130));

        btnguardar.setBackground(new java.awt.Color(0, 204, 51));
        btnguardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("GUARDAR");
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 740, 170, 30));

        txtdianostico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIAGNOSTICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtdianostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 340, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btninicio.setText("Inicio");
        btninicio.setBorder(null);
        jPanel2.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        btnregistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrar.setText("Registro");
        btnregistrar.setBorder(null);
        jPanel2.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 60));

        btnnutricion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnnutricion.setText("Nutricion");
        btnnutricion.setBorder(null);
        jPanel2.add(btnnutricion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 80, 60));

        btnpersonalizada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpersonalizada.setText("Personalizacion");
        btnpersonalizada.setBorder(null);
        jPanel2.add(btnpersonalizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 150, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 390, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmostrarActionPerformed

    private void btnelegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelegirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnelegirActionPerformed

    private void cboseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NutriciónPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NutriciónPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NutriciónPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NutriciónPersonalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NutriciónPersonalizada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnelegir;
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btninicio;
    public javax.swing.JButton btnmostrar;
    public javax.swing.JButton btnnutricion;
    public javax.swing.JButton btnpersonalizada;
    public javax.swing.JButton btnregistrar;
    public javax.swing.JComboBox<String> cboseleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea txtamostrar;
    public javax.swing.JTextArea txtarecomendaciones;
    public javax.swing.JTextField txtdianostico;
    public javax.swing.JTextField txtequilibrio;
    public javax.swing.JTextField txtexceso;
    // End of variables declaration//GEN-END:variables
}

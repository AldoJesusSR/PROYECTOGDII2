package Vista;

public class Nutrición extends javax.swing.JFrame {

    public Nutrición() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtcalorias = new javax.swing.JTextField();
        txtalertas = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarecomendacion = new javax.swing.JTextArea();
        btnresumen = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtguardado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btninicio = new javax.swing.JButton();
        btnregistro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnpersonalizada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUTRICIÓN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESUMEN DIARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("RECOMENDACION DIARIA:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, -1));

        txtcalorias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calorias Consumidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.add(txtcalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 60));

        txtalertas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alertas de Riesgo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        txtalertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalertasActionPerformed(evt);
            }
        });
        jPanel2.add(txtalertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 60));

        txtarecomendacion.setColumns(20);
        txtarecomendacion.setRows(5);
        jScrollPane2.setViewportView(txtarecomendacion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 320, 130));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 340, 330));

        btnresumen.setBackground(new java.awt.Color(0, 204, 51));
        btnresumen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnresumen.setForeground(new java.awt.Color(255, 255, 255));
        btnresumen.setText("RESUMEN");
        jPanel1.add(btnresumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, 30));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DESDE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 120, 60));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HASTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 130, 60));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GUARDAR");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 130, 30));

        txtguardado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE DE GUARDADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtguardado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 340, 70));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btninicio.setText("Inicio");
        btninicio.setBorder(null);
        jPanel3.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        btnregistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistro.setText("Registro");
        btnregistro.setBorder(null);
        jPanel3.add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 80, 60));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Nutricion");
        jButton2.setBorder(null);
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 90, 60));

        btnpersonalizada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpersonalizada.setText("Personalizacion");
        btnpersonalizada.setBorder(null);
        jPanel3.add(btnpersonalizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 140, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 380, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtalertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalertasActionPerformed

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
            java.util.logging.Logger.getLogger(Nutrición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nutrición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nutrición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nutrición.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nutrición().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btninicio;
    public javax.swing.JButton btnpersonalizada;
    public javax.swing.JButton btnregistro;
    public javax.swing.JButton btnresumen;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField txtalertas;
    public javax.swing.JTextArea txtarecomendacion;
    public javax.swing.JTextField txtcalorias;
    public javax.swing.JTextField txtguardado;
    // End of variables declaration//GEN-END:variables

}

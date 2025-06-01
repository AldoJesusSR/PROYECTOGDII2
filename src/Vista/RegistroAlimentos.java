package Vista;

public class RegistroAlimentos extends javax.swing.JFrame {

    public RegistroAlimentos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtAlimento = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtCalorias = new javax.swing.JTextField();
        txtNombreregistro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btninicio = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        btnpersonalizada = new javax.swing.JButton();
        btnnutricion = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO DE ALIMENTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAlimento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALIMENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtAlimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 220, 60));

        txtCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CANTIDAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 220, 60));

        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 220, 60));

        txtCalorias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CALORIAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtCalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 220, 60));

        txtNombreregistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE DE REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(txtNombreregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 220, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btninicio.setText("Inicio");
        btninicio.setBorder(null);
        jPanel2.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        btnregistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnregistrar.setText("Registro");
        btnregistrar.setBorder(null);
        jPanel2.add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 50));

        btnpersonalizada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpersonalizada.setText("Personalizacion");
        btnpersonalizada.setBorder(null);
        jPanel2.add(btnpersonalizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 120, 50));

        btnnutricion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnnutricion.setText("Nutricion");
        btnnutricion.setBorder(null);
        btnnutricion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnutricionActionPerformed(evt);
            }
        });
        jPanel2.add(btnnutricion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 70, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 320, 50));

        btnguardar.setBackground(new java.awt.Color(0, 204, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("GUARDAR");
        jPanel1.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 130, 40));

        btnlimpiar.setBackground(new java.awt.Color(0, 204, 51));
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("LIMPIAR");
        jPanel1.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnutricionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnutricionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnnutricionActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAlimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnguardar;
    public javax.swing.JButton btninicio;
    public javax.swing.JButton btnlimpiar;
    public javax.swing.JButton btnnutricion;
    public javax.swing.JButton btnpersonalizada;
    public javax.swing.JButton btnregistrar;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtAlimento;
    public javax.swing.JTextField txtCalorias;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtNombreregistro;
    // End of variables declaration//GEN-END:variables
}

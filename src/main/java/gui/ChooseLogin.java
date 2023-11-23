package gui;

import java.awt.Dimension;

public class ChooseLogin extends javax.swing.JFrame {
    private MahasiswaForm mahasiswaForm;
    private StaffForm staffForm;
    public ChooseLogin() {
        initComponents();
        mahasiswaForm = new MahasiswaForm();
        staffForm = new StaffForm();
        this.setPreferredSize(new Dimension(800, 600));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoGraphic = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        loginMahasiswa = new javax.swing.JButton();
        loginNonMahasiswa = new javax.swing.JButton();
        jTextPane1 = new javax.swing.JTextPane();
        jTextPane2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoGraphic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Colorful Background.png"))); // NOI18N
        infoGraphic.setText("jLabel1");
        getContentPane().add(infoGraphic, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 47, 450, 330));
        infoGraphic.getAccessibleContext().setAccessibleName("infoGraphicBackground");

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(960, 580));
        background.setMinimumSize(new java.awt.Dimension(300, 300));
        background.setName(""); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(960, 580));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginMahasiswa.setBackground(new java.awt.Color(255, 255, 255));
        loginMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Mahasiswa Icon.png"))); // NOI18N
        loginMahasiswa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginMahasiswa.setBorderPainted(false);
        loginMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMahasiswaActionPerformed(evt);
            }
        });
        background.add(loginMahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        loginNonMahasiswa.setBackground(new java.awt.Color(255, 255, 255));
        loginNonMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/NonIcon.png"))); // NOI18N
        loginNonMahasiswa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginNonMahasiswa.setBorderPainted(false);
        loginNonMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginNonMahasiswaActionPerformed(evt);
            }
        });
        background.add(loginNonMahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane1.setContentType(""); // NOI18N
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(255, 153, 51));
        jTextPane1.setText("E-SURAT FALKULTAS TEKNIK");
        jTextPane1.setFocusable(false);
        jTextPane1.setVerifyInputWhenFocusTarget(false);
        background.add(jTextPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextPane2.setForeground(new java.awt.Color(51, 51, 51));
        jTextPane2.setText("Surat Menyurat Lebih Mudah Dengan E-Surat");
        jTextPane2.setFocusable(false);
        jTextPane2.setVerifyInputWhenFocusTarget(false);
        background.add(jTextPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 340, 60));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginNonMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginNonMahasiswaActionPerformed
        // TODO add your handling code here:
        staffForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginNonMahasiswaActionPerformed

    private void loginMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMahasiswaActionPerformed
        // TODO add your handling code here:
        mahasiswaForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginMahasiswaActionPerformed

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
            java.util.logging.Logger.getLogger(ChooseLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChooseLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel infoGraphic;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JButton loginMahasiswa;
    private javax.swing.JButton loginNonMahasiswa;
    // End of variables declaration//GEN-END:variables

}

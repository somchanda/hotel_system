/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_system;

import javax.swing.JFrame;

/**
 *
 * @author Somchanda
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemClients = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemRoom = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemReservations = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jmChangePassword = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main pic.jpg"))); // NOI18N

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu1.setText("Manage");
        jMenu1.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N

        jMenuItemClients.setFont(new java.awt.Font("Oswald Stencil", 0, 18)); // NOI18N
        jMenuItemClients.setText("Clients");
        jMenuItemClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClients);
        jMenu1.add(jSeparator1);

        jMenuItemRoom.setFont(new java.awt.Font("Oswald Stencil", 0, 18)); // NOI18N
        jMenuItemRoom.setText("Room");
        jMenuItemRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRoomActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRoom);
        jMenu1.add(jSeparator2);

        jMenuItemReservations.setFont(new java.awt.Font("Oswald Stencil", 0, 18)); // NOI18N
        jMenuItemReservations.setText("Reservations");
        jMenuItemReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReservationsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemReservations);
        jMenu1.add(jSeparator3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Security");
        jMenu2.setFont(new java.awt.Font("Oswald", 0, 24)); // NOI18N

        jmChangePassword.setFont(new java.awt.Font("Oswald", 0, 18)); // NOI18N
        jmChangePassword.setText("Change password");
        jmChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmChangePasswordActionPerformed(evt);
            }
        });
        jMenu2.add(jmChangePassword);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 897, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientsActionPerformed
        ManageClientForm clientForm=new ManageClientForm();
        clientForm.setVisible(true);
        clientForm.pack();
        clientForm.setLocationRelativeTo(null);
        clientForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemClientsActionPerformed

    private void jMenuItemRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRoomActionPerformed
        ManageRoomForm roomForm=new ManageRoomForm();
        roomForm.setVisible(true);
        roomForm.pack();
        roomForm.setLocationRelativeTo(null);
        roomForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemRoomActionPerformed

    private void jMenuItemReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReservationsActionPerformed
         ManageReservationsForm ReservationForm=new ManageReservationsForm();
        ReservationForm.setVisible(true);
        ReservationForm.pack();
        ReservationForm.setLocationRelativeTo(null);
        ReservationForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItemReservationsActionPerformed

    private void jmChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmChangePasswordActionPerformed
        ChangePassword chp = new ChangePassword();
        chp.setLocationRelativeTo(null);
        chp.setVisible(true);
    }//GEN-LAST:event_jmChangePasswordActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabel2.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemClients;
    private javax.swing.JMenuItem jMenuItemReservations;
    private javax.swing.JMenuItem jMenuItemRoom;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem jmChangePassword;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import control.user.UserHandler;
import date.ADate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author patrick
 */
public class RemoveUserDIA extends javax.swing.JDialog {

    private UserHandler userHandler;
    private User selectedUser;

    public RemoveUserDIA(java.awt.Frame parent, boolean modal, UserHandler userHandler) {
        super(parent, modal);
        initComponents();
        this.userHandler = userHandler;
    }

    private void populateList() {
        ArrayList<User> users = userHandler.getAllUsers();
        DefaultListModel dlm = new DefaultListModel();
        for (User u : users) {
            dlm.addElement(u.getId() + ":" + u.getFirstname() + " " + u.getLastname());
        }
        list_List.setModel(dlm);
    }

    public void setUser(User u) {
        this.selectedUser = u;
        firstname_TextField.setText(u.getFirstname());
        middlename_TextField.setText(u.getMiddlename());
        lastname_TextField.setText(u.getLastname());
        email_TextField.setText(u.getEmail());
        if (u.isAdministrator()) {
            administrator_TextField.setText("Ja");
        } else {
            administrator_TextField.setText("Nej");
        }
        if (u.isReserve()) {
            reserve_TextField.setText("Ja");
        } else {
            reserve_TextField.setText("Nej");
        }
        creationDate_TextField.setText(ADate.formatADate(u.getCreationDate(), "/"));
        remove_Button.setEnabled(true);
    }

    private void clean() {
        firstname_TextField.setText("");
        middlename_TextField.setText("");
        lastname_TextField.setText("");
        email_TextField.setText("");
        administrator_TextField.setText("");
        reserve_TextField.setText("");
        creationDate_TextField.setText("");
        remove_Button.setEnabled(false);
        try {
            DefaultListModel dlm = new DefaultListModel();
            list_List.setModel(dlm);
        } catch (NullPointerException e) {
        }
    }

    private void cleanUser() {
        firstname_TextField.setText("");
        middlename_TextField.setText("");
        lastname_TextField.setText("");
        email_TextField.setText("");
        administrator_TextField.setText("");
        reserve_TextField.setText("");
        creationDate_TextField.setText("");
        remove_Button.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_Pane = new javax.swing.JPanel();
        list_Pane = new javax.swing.JPanel();
        list_ScrollPane = new javax.swing.JScrollPane();
        list_List = new javax.swing.JList();
        details_Pane = new javax.swing.JPanel();
        firstnameInfo_Label = new javax.swing.JLabel();
        middlenameInfo_Label = new javax.swing.JLabel();
        lastnameInfo_Label = new javax.swing.JLabel();
        emailInfo_Label = new javax.swing.JLabel();
        remove_Button = new javax.swing.JButton();
        administratorInfo_Label = new javax.swing.JLabel();
        reserveInfo_Label = new javax.swing.JLabel();
        creationDateInfo_Label = new javax.swing.JLabel();
        firstname_TextField = new javax.swing.JTextField();
        middlename_TextField = new javax.swing.JTextField();
        lastname_TextField = new javax.swing.JTextField();
        email_TextField = new javax.swing.JTextField();
        administrator_TextField = new javax.swing.JTextField();
        reserve_TextField = new javax.swing.JTextField();
        creationDate_TextField = new javax.swing.JTextField();
        bottom_Pane = new javax.swing.JPanel();
        close_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        main_Pane.setBackground(new java.awt.Color(51, 51, 51));

        list_List.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_List.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_ListValueChanged(evt);
            }
        });
        list_ScrollPane.setViewportView(list_List);

        javax.swing.GroupLayout list_PaneLayout = new javax.swing.GroupLayout(list_Pane);
        list_Pane.setLayout(list_PaneLayout);
        list_PaneLayout.setHorizontalGroup(
            list_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(list_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        list_PaneLayout.setVerticalGroup(
            list_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(list_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list_ScrollPane)
                .addContainerGap())
        );

        firstnameInfo_Label.setText("Fornavn:");

        middlenameInfo_Label.setText("Mellemnavn:");

        lastnameInfo_Label.setText("Efternavn:");

        emailInfo_Label.setText("E-mail:");

        remove_Button.setText("Slet bruger");
        remove_Button.setEnabled(false);
        remove_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_ButtonActionPerformed(evt);
            }
        });

        administratorInfo_Label.setText("Administrator:");

        reserveInfo_Label.setText("Reserve:");

        creationDateInfo_Label.setText("Oprettelses dato:");

        firstname_TextField.setEditable(false);

        middlename_TextField.setEditable(false);

        lastname_TextField.setEditable(false);

        email_TextField.setEditable(false);
        email_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_TextFieldActionPerformed(evt);
            }
        });

        administrator_TextField.setEditable(false);

        reserve_TextField.setEditable(false);

        creationDate_TextField.setEditable(false);

        javax.swing.GroupLayout details_PaneLayout = new javax.swing.GroupLayout(details_Pane);
        details_Pane.setLayout(details_PaneLayout);
        details_PaneLayout.setHorizontalGroup(
            details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, details_PaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(remove_Button))
                    .addGroup(details_PaneLayout.createSequentialGroup()
                        .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(creationDateInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reserveInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(administratorInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastnameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(middlenameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(firstnameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstname_TextField)
                            .addComponent(middlename_TextField)
                            .addComponent(lastname_TextField)
                            .addComponent(email_TextField)
                            .addComponent(administrator_TextField)
                            .addComponent(reserve_TextField)
                            .addComponent(creationDate_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
                .addContainerGap())
        );
        details_PaneLayout.setVerticalGroup(
            details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(details_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameInfo_Label)
                    .addComponent(firstname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middlenameInfo_Label)
                    .addComponent(middlename_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameInfo_Label)
                    .addComponent(lastname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailInfo_Label)
                    .addComponent(email_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(administratorInfo_Label)
                    .addComponent(administrator_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reserveInfo_Label)
                    .addComponent(reserve_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(details_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creationDateInfo_Label)
                    .addComponent(creationDate_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remove_Button)
                .addContainerGap())
        );

        close_Button.setText("Luk");
        close_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottom_PaneLayout = new javax.swing.GroupLayout(bottom_Pane);
        bottom_Pane.setLayout(bottom_PaneLayout);
        bottom_PaneLayout.setHorizontalGroup(
            bottom_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottom_PaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close_Button)
                .addContainerGap())
        );
        bottom_PaneLayout.setVerticalGroup(
            bottom_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottom_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close_Button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_PaneLayout = new javax.swing.GroupLayout(main_Pane);
        main_Pane.setLayout(main_PaneLayout);
        main_PaneLayout.setHorizontalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottom_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(main_PaneLayout.createSequentialGroup()
                        .addComponent(details_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(list_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        main_PaneLayout.setVerticalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(details_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(list_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottom_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void email_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_TextFieldActionPerformed

    private void close_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_close_ButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        clean();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        populateList();
    }//GEN-LAST:event_formWindowActivated

    private void list_ListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_ListValueChanged
        if (!evt.getValueIsAdjusting()) {
            if (!list_List.isSelectionEmpty()) {
                String selectionText = (String) list_List.getSelectedValue();
                String ids = "";
                for (int i = 0; i <= selectionText.length(); i++) {
                    if (selectionText.substring(i, i + 1).equals(":")) {
                        break;
                    }
                    String s = selectionText.substring(i, i + 1);
                    ids = ids + s;
                }
                int id = Integer.valueOf(ids);
                setUser(userHandler.getUser(id));
            }
        }
    }//GEN-LAST:event_list_ListValueChanged

    private void remove_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_ButtonActionPerformed
        if (selectedUser.isAdministrator()) {
            if (userHandler.countAdmins() == 1) {
                JOptionPane.showMessageDialog(this, "Du kan ikke slette den sidste administrator", "Fejl", JOptionPane.ERROR_MESSAGE);
            } else {
                int n = JOptionPane.showConfirmDialog(this, "Er du sikker på du vil slette " + selectedUser.getFirstname() + "?", "Slet?", JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    userHandler.removeUser(selectedUser);
                    cleanUser();
                }
            }
        } else {
            int n = JOptionPane.showConfirmDialog(this, "Er du sikker på du vil slette " + selectedUser.getFirstname() + "?", "Slet?", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                userHandler.removeUser(selectedUser);
                cleanUser();
            }
        }
    }//GEN-LAST:event_remove_ButtonActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RemoveUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RemoveUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RemoveUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RemoveUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                RemoveUserDIA dialog = new RemoveUserDIA(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel administratorInfo_Label;
    private javax.swing.JTextField administrator_TextField;
    private javax.swing.JPanel bottom_Pane;
    private javax.swing.JButton close_Button;
    private javax.swing.JLabel creationDateInfo_Label;
    private javax.swing.JTextField creationDate_TextField;
    private javax.swing.JPanel details_Pane;
    private javax.swing.JLabel emailInfo_Label;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JLabel firstnameInfo_Label;
    private javax.swing.JTextField firstname_TextField;
    private javax.swing.JLabel lastnameInfo_Label;
    private javax.swing.JTextField lastname_TextField;
    private javax.swing.JList list_List;
    private javax.swing.JPanel list_Pane;
    private javax.swing.JScrollPane list_ScrollPane;
    private javax.swing.JPanel main_Pane;
    private javax.swing.JLabel middlenameInfo_Label;
    private javax.swing.JTextField middlename_TextField;
    private javax.swing.JButton remove_Button;
    private javax.swing.JLabel reserveInfo_Label;
    private javax.swing.JTextField reserve_TextField;
    // End of variables declaration//GEN-END:variables
}
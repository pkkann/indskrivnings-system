/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.LoginHandler;
import model.TableTool;
import control.UserHandler;
import entity.User;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import view.message.DialogMessage;

/**
 *
 * @author patrick
 */
public class EditUserDIA extends javax.swing.JDialog {

    private UserHandler usH;
    private int selectedUser = -1;

    public EditUserDIA(java.awt.Frame parent, boolean modal, UserHandler usH) {
        super(parent, modal);
        initComponents();
        setTitleIcon();
        initTableListener();
        this.usH = usH;
    }

    private void setTitleIcon() {
        Image icon = null;
        try {
            icon = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("res/editUser.png"));
        } catch (IOException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        titleIcon_PicturePane.setPicture(icon, false);
    }

    private void initTableListener() {
        result_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && result_Table.getSelectedRowCount() != 0) {
                    int selRow = result_Table.getSelectedRow();
                    Object selIDObject = result_Table.getModel().getValueAt(selRow, 0);
                    int selID = Integer.valueOf(String.valueOf(selIDObject));
                    setUser(selID);
                }
            }
        });
    }

    private void setUser(int id) {
        cleanSelectedUser();
        if (LoginHandler.loggedIn.getIduser() != id) {
            selectedUser = id;
            User u = usH.getUser(id);
            firstname_TextField.setText(u.getFirstname());
            middlename_TextField.setText(u.getMiddlename());
            lastname_TextField.setText(u.getLastname());
            username_TextField.setText(u.getUsername());
            admin_CheckBox.setSelected(u.isAdministrator());
            reserve_CheckBox.setSelected(u.isReserve());
            password_TextField.setText(u.getPassword());

            firstname_TextField.setEnabled(true);
            middlename_TextField.setEnabled(true);
            lastname_TextField.setEnabled(true);
            username_TextField.setEnabled(true);
            admin_CheckBox.setEnabled(true);
            reserve_CheckBox.setEnabled(true);
            password_TextField.setEnabled(true);
            save_Button.setEnabled(true);
        } else {
            info_Label.setText("Du skal redigere dig selv ved at klikke på \"Rediger profil\" knappen");
        }
    }

    public void cleanSelectedUser() {
        selectedUser = -1;
        firstname_TextField.setText("");
        middlename_TextField.setText("");
        lastname_TextField.setText("");
        username_TextField.setText("");
        admin_CheckBox.setSelected(false);
        reserve_CheckBox.setSelected(false);
        password_TextField.setText("");

        firstname_TextField.setEnabled(false);
        middlename_TextField.setEnabled(false);
        lastname_TextField.setEnabled(false);
        username_TextField.setEnabled(false);
        admin_CheckBox.setEnabled(false);
        reserve_CheckBox.setEnabled(false);
        password_TextField.setEnabled(false);
        save_Button.setEnabled(false);
        info_Label.setText("");
    }

    private void cleanSearchField() {
        search_TextField.setText("");
    }

    private void cleanTable() {
        DefaultTableModel dtm = TableTool.createEmtpyUserTableModel();
        result_Table.setModel(dtm);
    }

    public void search() {
        cleanSelectedUser();
        ArrayList<String[]> data = usH.searchUser(search_TextField.getText());
        DefaultTableModel dtm = TableTool.createUserTableModel(data);
        result_Table.setModel(dtm);
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
        users_Pane = new javax.swing.JPanel();
        users_ScrollPane = new javax.swing.JScrollPane();
        result_Table = new javax.swing.JTable();
        search_TextField = new javax.swing.JTextField();
        search_Button = new javax.swing.JButton();
        fields_Pane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        firstname_TextField = new javax.swing.JTextField();
        middlename_TextField = new javax.swing.JTextField();
        lastname_TextField = new javax.swing.JTextField();
        username_TextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        admin_CheckBox = new javax.swing.JCheckBox();
        reserve_CheckBox = new javax.swing.JCheckBox();
        save_Button = new javax.swing.JButton();
        password_TextField = new javax.swing.JPasswordField();
        tools_Pane = new javax.swing.JPanel();
        close_Button = new javax.swing.JButton();
        info_Label = new javax.swing.JLabel();
        title_Pane = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        titleIcon_PicturePane = new view.image.PicturePane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        main_Pane.setBackground(new java.awt.Color(51, 51, 51));

        result_Table.setAutoCreateRowSorter(true);
        result_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Navn", "Brugernavn", "Administrator", "Reserve"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        result_Table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        users_ScrollPane.setViewportView(result_Table);

        search_TextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_TextFieldActionPerformed(evt);
            }
        });

        search_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_Button.setText("Søg");
        search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout users_PaneLayout = new javax.swing.GroupLayout(users_Pane);
        users_Pane.setLayout(users_PaneLayout);
        users_PaneLayout.setHorizontalGroup(
            users_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(users_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(users_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addGroup(users_PaneLayout.createSequentialGroup()
                        .addComponent(search_TextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_Button)))
                .addContainerGap())
        );
        users_PaneLayout.setVerticalGroup(
            users_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, users_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(users_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(users_ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fornavn:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mellemnavn:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Efternavn:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Brugernavn:");

        firstname_TextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstname_TextField.setEnabled(false);

        middlename_TextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        middlename_TextField.setEnabled(false);

        lastname_TextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastname_TextField.setEnabled(false);

        username_TextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username_TextField.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kode:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Rettigheder:");

        admin_CheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        admin_CheckBox.setText("Administrator");
        admin_CheckBox.setEnabled(false);

        reserve_CheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reserve_CheckBox.setText("Reserve");
        reserve_CheckBox.setEnabled(false);

        save_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save_Button.setText("Gem bruger");
        save_Button.setEnabled(false);
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });

        password_TextField.setEnabled(false);

        javax.swing.GroupLayout fields_PaneLayout = new javax.swing.GroupLayout(fields_Pane);
        fields_Pane.setLayout(fields_PaneLayout);
        fields_PaneLayout.setHorizontalGroup(
            fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(firstname_TextField)
                    .addComponent(middlename_TextField)
                    .addComponent(lastname_TextField)
                    .addComponent(username_TextField)
                    .addGroup(fields_PaneLayout.createSequentialGroup()
                        .addComponent(admin_CheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(reserve_CheckBox))
                    .addComponent(password_TextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fields_PaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save_Button)
                .addContainerGap())
        );
        fields_PaneLayout.setVerticalGroup(
            fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(middlename_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lastname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(username_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(admin_CheckBox)
                    .addComponent(reserve_CheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(save_Button)
                .addContainerGap())
        );

        close_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        close_Button.setText("Luk");
        close_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ButtonActionPerformed(evt);
            }
        });

        info_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        info_Label.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout tools_PaneLayout = new javax.swing.GroupLayout(tools_Pane);
        tools_Pane.setLayout(tools_PaneLayout);
        tools_PaneLayout.setHorizontalGroup(
            tools_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tools_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close_Button)
                .addContainerGap())
        );
        tools_PaneLayout.setVerticalGroup(
            tools_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tools_PaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tools_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(close_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        title_Pane.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Rediger en bruger");

        javax.swing.GroupLayout titleIcon_PicturePaneLayout = new javax.swing.GroupLayout(titleIcon_PicturePane);
        titleIcon_PicturePane.setLayout(titleIcon_PicturePaneLayout);
        titleIcon_PicturePaneLayout.setHorizontalGroup(
            titleIcon_PicturePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        titleIcon_PicturePaneLayout.setVerticalGroup(
            titleIcon_PicturePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout title_PaneLayout = new javax.swing.GroupLayout(title_Pane);
        title_Pane.setLayout(title_PaneLayout);
        title_PaneLayout.setHorizontalGroup(
            title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleIcon_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        title_PaneLayout.setVerticalGroup(
            title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(title_PaneLayout.createSequentialGroup()
                        .addComponent(titleIcon_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout main_PaneLayout = new javax.swing.GroupLayout(main_Pane);
        main_Pane.setLayout(main_PaneLayout);
        main_PaneLayout.setHorizontalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(users_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fields_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tools_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        main_PaneLayout.setVerticalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(users_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fields_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tools_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void close_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_close_ButtonActionPerformed

    private void search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ButtonActionPerformed
        search();
    }//GEN-LAST:event_search_ButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cleanSelectedUser();
        cleanSearchField();
        cleanTable();
    }//GEN-LAST:event_formWindowClosed

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        String firstname = firstname_TextField.getText();
        String middlename = middlename_TextField.getText();
        String lastname = lastname_TextField.getText();
        String username = username_TextField.getText();
        String password = password_TextField.getText();
        boolean admin = admin_CheckBox.isSelected();
        boolean reserve = reserve_CheckBox.isSelected();

        int errorCode = usH.saveUser(selectedUser, username, password, firstname, middlename, lastname, reserve, admin);

        DialogMessage.showMessage(this, errorCode);

        if (errorCode == 0) {
            search();
            cleanSelectedUser();
        }
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void search_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_TextFieldActionPerformed
        search();
    }//GEN-LAST:event_search_TextFieldActionPerformed
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
//            java.util.logging.Logger.getLogger(EditUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditUserDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                EditUserDIA dialog = new EditUserDIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox admin_CheckBox;
    private javax.swing.JButton close_Button;
    private javax.swing.JPanel fields_Pane;
    private javax.swing.JTextField firstname_TextField;
    private javax.swing.JLabel info_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastname_TextField;
    private javax.swing.JPanel main_Pane;
    private javax.swing.JTextField middlename_TextField;
    private javax.swing.JPasswordField password_TextField;
    private javax.swing.JCheckBox reserve_CheckBox;
    private javax.swing.JTable result_Table;
    private javax.swing.JButton save_Button;
    private javax.swing.JButton search_Button;
    private javax.swing.JTextField search_TextField;
    private view.image.PicturePane titleIcon_PicturePane;
    private javax.swing.JPanel title_Pane;
    private javax.swing.JPanel tools_Pane;
    private javax.swing.JTextField username_TextField;
    private javax.swing.JPanel users_Pane;
    private javax.swing.JScrollPane users_ScrollPane;
    // End of variables declaration//GEN-END:variables
}
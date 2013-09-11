/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.person;

import control.person.PersonHandler;
import date.ADate;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import login.LoginHandler;

/**
 *
 * @author patrick
 */
class MyCustomFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".jpeg") || file.getAbsolutePath().endsWith(".jpg") || file.getAbsolutePath().endsWith(".png");
    }

    @Override
    public String getDescription() {
        return "Picture (.jpeg / .jpg / .png)";
    }
}

public class CreatePersonDIA extends javax.swing.JDialog {

    private File picturePath;
    private Image picture;
    private PersonHandler personHandler;
    private LoginHandler loginHandler;
    private CharSequence cs = "ABCD";

    public CreatePersonDIA(java.awt.Frame parent, boolean modal, PersonHandler personHandler, LoginHandler loginHandler) {
        super(parent, modal);
        initComponents();
        this.personHandler = personHandler;
        this.loginHandler = loginHandler;
    }

    public void setUser() {
        if (loginHandler.getLoggedInUser().isAdministrator()) {
            oneOne_CheckBox.setEnabled(true);
        } else {
            oneOne_CheckBox.setEnabled(false);
        }
    }

    private void clean() {
        firstname_TextField.setText("");
        middlename_TextField.setText("");
        lastname_TextField.setText("");
        birthday_day_TextField.setText("");
        birthday_month_TextField.setText("");
        birthday_yeah_TextField.setText("");
        expirationDate_day_TextField.setText("");
        expirationDate_month_TextField.setText("");
        expirationDate_year_TextField.setText("");
        address_TextField.setText("");
        oneOne_CheckBox.setSelected(false);
        picturePath = null;
        picturePane_PicturePane.setPicture(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser_FileChooser = new javax.swing.JFileChooser();
        main_Pane = new javax.swing.JPanel();
        pane1_Pane = new javax.swing.JPanel();
        firstnameInfo_Label = new javax.swing.JLabel();
        middlenameInfo_Label = new javax.swing.JLabel();
        lastnameInfo_Label = new javax.swing.JLabel();
        birthdayInfo_Label = new javax.swing.JLabel();
        expirationDateInfo_Label = new javax.swing.JLabel();
        addressInfo_Label = new javax.swing.JLabel();
        firstname_TextField = new javax.swing.JTextField();
        middlename_TextField = new javax.swing.JTextField();
        lastname_TextField = new javax.swing.JTextField();
        birthday_day_TextField = new javax.swing.JTextField();
        expirationDate_day_TextField = new javax.swing.JTextField();
        address_TextField = new javax.swing.JTextField();
        birthday_month_TextField = new javax.swing.JTextField();
        birthday_yeah_TextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        expirationDate_month_TextField = new javax.swing.JTextField();
        expirationDate_year_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pane2_Pane = new javax.swing.JPanel();
        picturePane_PicturePane = new view.image.PicturePane();
        choose_Button = new javax.swing.JButton();
        pane3_Pane = new javax.swing.JPanel();
        oneOne_CheckBox = new javax.swing.JCheckBox();
        create_Button = new javax.swing.JButton();
        cancel_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        main_Pane.setBackground(new java.awt.Color(51, 51, 51));

        firstnameInfo_Label.setText("Fornavn:");

        middlenameInfo_Label.setText("Mellemnavn:");

        lastnameInfo_Label.setText("Efternavn:");

        birthdayInfo_Label.setText("Fødselsdag:");

        expirationDateInfo_Label.setText("Udløbsdato:");

        addressInfo_Label.setText("Adresse:");

        jLabel1.setText("dd/mm/yyyy");

        jLabel2.setText("dd/mm/yyyy");

        jLabel3.setText("Block - Husnummer");

        javax.swing.GroupLayout pane1_PaneLayout = new javax.swing.GroupLayout(pane1_Pane);
        pane1_Pane.setLayout(pane1_PaneLayout);
        pane1_PaneLayout.setHorizontalGroup(
            pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane1_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(middlenameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(firstnameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastnameInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(birthdayInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expirationDateInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressInfo_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstname_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(middlename_TextField)
                    .addComponent(lastname_TextField)
                    .addGroup(pane1_PaneLayout.createSequentialGroup()
                        .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(address_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pane1_PaneLayout.createSequentialGroup()
                                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(expirationDate_day_TextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(birthday_day_TextField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(birthday_month_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(expirationDate_month_TextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(birthday_yeah_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(expirationDate_year_TextField))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pane1_PaneLayout.setVerticalGroup(
            pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane1_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameInfo_Label)
                    .addComponent(firstname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(middlenameInfo_Label)
                    .addComponent(middlename_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameInfo_Label)
                    .addComponent(lastname_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayInfo_Label)
                    .addComponent(birthday_day_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthday_month_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthday_yeah_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expirationDateInfo_Label)
                    .addComponent(expirationDate_day_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expirationDate_month_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expirationDate_year_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane1_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressInfo_Label)
                    .addComponent(address_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout picturePane_PicturePaneLayout = new javax.swing.GroupLayout(picturePane_PicturePane);
        picturePane_PicturePane.setLayout(picturePane_PicturePaneLayout);
        picturePane_PicturePaneLayout.setHorizontalGroup(
            picturePane_PicturePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        picturePane_PicturePaneLayout.setVerticalGroup(
            picturePane_PicturePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        choose_Button.setText("Vælg");
        choose_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane2_PaneLayout = new javax.swing.GroupLayout(pane2_Pane);
        pane2_Pane.setLayout(pane2_PaneLayout);
        pane2_PaneLayout.setHorizontalGroup(
            pane2_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane2_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picturePane_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choose_Button)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        pane2_PaneLayout.setVerticalGroup(
            pane2_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane2_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane2_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choose_Button)
                    .addComponent(picturePane_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        oneOne_CheckBox.setText("1-1");

        create_Button.setText("Opret");
        create_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_ButtonActionPerformed(evt);
            }
        });

        cancel_Button.setText("Annuller");
        cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane3_PaneLayout = new javax.swing.GroupLayout(pane3_Pane);
        pane3_Pane.setLayout(pane3_PaneLayout);
        pane3_PaneLayout.setHorizontalGroup(
            pane3_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane3_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oneOne_CheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel_Button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(create_Button)
                .addContainerGap())
        );
        pane3_PaneLayout.setVerticalGroup(
            pane3_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane3_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane3_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneOne_CheckBox)
                    .addComponent(create_Button)
                    .addComponent(cancel_Button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout main_PaneLayout = new javax.swing.GroupLayout(main_Pane);
        main_Pane.setLayout(main_PaneLayout);
        main_PaneLayout.setHorizontalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane1_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pane2_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pane3_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        main_PaneLayout.setVerticalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pane1_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pane2_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pane3_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancel_ButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        clean();
    }//GEN-LAST:event_formWindowClosed

    private void create_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_ButtonActionPerformed
        if (!firstname_TextField.getText().isEmpty() && !lastname_TextField.getText().isEmpty() && !birthday_day_TextField.getText().isEmpty() && !expirationDate_day_TextField.getText().isEmpty() && !address_TextField.getText().isEmpty() && picturePath != null) {
            if (birthday_day_TextField.getText().length() == 2 && birthday_month_TextField.getText().length() == 2 && birthday_yeah_TextField.getText().length() == 4) {
                if (expirationDate_day_TextField.getText().length() == 2 && expirationDate_month_TextField.getText().length() == 2 && expirationDate_year_TextField.getText().length() == 4) {
                    if (Integer.valueOf(birthday_month_TextField.getText()) <= 12) {
                        if (Integer.valueOf(expirationDate_month_TextField.getText()) <= 12) {
                            try {
                                String firstname = firstname_TextField.getText();
                                String middlename = middlename_TextField.getText();
                                String lastname = lastname_TextField.getText();
                                ADate birthday = new ADate(Integer.valueOf(birthday_day_TextField.getText()), Integer.valueOf(birthday_month_TextField.getText()), Integer.valueOf(birthday_yeah_TextField.getText()));
                                ADate expirationDate = new ADate(Integer.valueOf(expirationDate_day_TextField.getText()), Integer.valueOf(expirationDate_month_TextField.getText()), Integer.valueOf(expirationDate_year_TextField.getText()));
                                String address = address_TextField.getText();
                                boolean oneOne = oneOne_CheckBox.isSelected();
                                Calendar c = Calendar.getInstance();
                                ADate creationDate = new ADate(c.get(Calendar.DATE), (c.get(Calendar.MONTH)+1), c.get(Calendar.YEAR));

                                personHandler.createPerson(firstname, middlename, lastname, address, birthday, expirationDate, picturePath, creationDate);
                                JOptionPane.showMessageDialog(this, "Personen blev oprettet", "Oprettet", JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "En dato består kun af tal", "Fejl", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Der findes kun 12 måneder", "Fejl", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Der findes kun 12 måneder", "Fejl", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Dato formatet er forkert. Skal være dd/mm/yyyy", "Fejl", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Dato formatet er forkert. Skal være dd/mm/yyyy", "Fejl", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Alle felter skal være udfyldt, og der skal vælges et billed", "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_create_ButtonActionPerformed

    private void choose_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_ButtonActionPerformed
        int returnVal = fileChooser_FileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            picturePath = fileChooser_FileChooser.getSelectedFile();
            try {
                picture = ImageIO.read(picturePath);
                picturePane_PicturePane.setPicture(picture);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_choose_ButtonActionPerformed
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
//            java.util.logging.Logger.getLogger(CreatePersonDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreatePersonDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreatePersonDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreatePersonDIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CreatePersonDIA dialog = new CreatePersonDIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel addressInfo_Label;
    private javax.swing.JTextField address_TextField;
    private javax.swing.JLabel birthdayInfo_Label;
    private javax.swing.JTextField birthday_day_TextField;
    private javax.swing.JTextField birthday_month_TextField;
    private javax.swing.JTextField birthday_yeah_TextField;
    private javax.swing.JButton cancel_Button;
    private javax.swing.JButton choose_Button;
    private javax.swing.JButton create_Button;
    private javax.swing.JLabel expirationDateInfo_Label;
    private javax.swing.JTextField expirationDate_day_TextField;
    private javax.swing.JTextField expirationDate_month_TextField;
    private javax.swing.JTextField expirationDate_year_TextField;
    private javax.swing.JFileChooser fileChooser_FileChooser;
    private javax.swing.JLabel firstnameInfo_Label;
    private javax.swing.JTextField firstname_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lastnameInfo_Label;
    private javax.swing.JTextField lastname_TextField;
    private javax.swing.JPanel main_Pane;
    private javax.swing.JLabel middlenameInfo_Label;
    private javax.swing.JTextField middlename_TextField;
    private javax.swing.JCheckBox oneOne_CheckBox;
    private javax.swing.JPanel pane1_Pane;
    private javax.swing.JPanel pane2_Pane;
    private javax.swing.JPanel pane3_Pane;
    private view.image.PicturePane picturePane_PicturePane;
    // End of variables declaration//GEN-END:variables
}

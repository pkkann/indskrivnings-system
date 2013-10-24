/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.PersonHandler;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.TableTool;
import view.message.DialogMessage;

/**
 *
 * @author patrick
 */
public class RemovePersonDIA extends javax.swing.JDialog {

    private PersonHandler peH;
    private int selectedPerson = -1;

    public RemovePersonDIA(java.awt.Frame parent, boolean modal, PersonHandler peH) {
        super(parent, modal);
        initComponents();
        setTitleIcon();
        initTableListener();
        this.peH = peH;
    }

    private void setTitleIcon() {
        Image icon = null;
        try {
            icon = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("res/deletePerson.png"));
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
                    setPerson(selID);
                }
            }
        });
    }

    private void setPerson(int idPerson) {
        selectedPerson = idPerson;
        if (!peH.isEnrolled(idPerson)) {
            delete_Button.setEnabled(true);
        } else {
            info_Label.setText("Du kan ikke slette en person der er indskrevet");
        }
    }

    private void cleanSearchField() {
        search_TextField.setText("");
    }

    private void cleanTable() {
        DefaultTableModel dtm = TableTool.createEmptyPersonTableModel();
        result_Table.setModel(dtm);
    }

    public void cleanSelectedUser() {
        selectedPerson = -1;
        delete_Button.setEnabled(false);
        info_Label.setText("");
    }

    public void search() {
        cleanSelectedUser();
        ArrayList<String[]> data = peH.searchPerson(search_TextField.getText(), false);
        DefaultTableModel dtm = TableTool.createPersonTableModel(data);
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
        title_Pane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleIcon_PicturePane = new view.image.PicturePane();
        persons_Pane = new javax.swing.JPanel();
        search_TextField = new javax.swing.JTextField();
        search_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result_Table = new javax.swing.JTable();
        fields_Pane = new javax.swing.JPanel();
        delete_Button = new javax.swing.JButton();
        info_Label = new javax.swing.JLabel();
        tools_Pane = new javax.swing.JPanel();
        close_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        main_Pane.setBackground(new java.awt.Color(51, 51, 51));

        title_Pane.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Slet en person");

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleIcon_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        title_PaneLayout.setVerticalGroup(
            title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(title_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(title_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(title_PaneLayout.createSequentialGroup()
                        .addComponent(titleIcon_PicturePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

        result_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Navn", "Adresse", "Fødselsdag", "Udløbsdato", "Oprettelsesdato", "Høne", "Reserve", "1-1"
            }
        ));
        jScrollPane1.setViewportView(result_Table);

        javax.swing.GroupLayout persons_PaneLayout = new javax.swing.GroupLayout(persons_Pane);
        persons_Pane.setLayout(persons_PaneLayout);
        persons_PaneLayout.setHorizontalGroup(
            persons_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(persons_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(persons_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(persons_PaneLayout.createSequentialGroup()
                        .addComponent(search_TextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_Button)))
                .addContainerGap())
        );
        persons_PaneLayout.setVerticalGroup(
            persons_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(persons_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(persons_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        delete_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete_Button.setText("Slet den valgte person");
        delete_Button.setEnabled(false);
        delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_ButtonActionPerformed(evt);
            }
        });

        info_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        info_Label.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout fields_PaneLayout = new javax.swing.GroupLayout(fields_Pane);
        fields_Pane.setLayout(fields_PaneLayout);
        fields_PaneLayout.setHorizontalGroup(
            fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fields_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(info_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete_Button)
                .addContainerGap())
        );
        fields_PaneLayout.setVerticalGroup(
            fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fields_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(info_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        close_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        close_Button.setText("Luk");
        close_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tools_PaneLayout = new javax.swing.GroupLayout(tools_Pane);
        tools_Pane.setLayout(tools_PaneLayout);
        tools_PaneLayout.setHorizontalGroup(
            tools_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tools_PaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close_Button)
                .addContainerGap())
        );
        tools_PaneLayout.setVerticalGroup(
            tools_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tools_PaneLayout.createSequentialGroup()
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
                    .addComponent(title_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(persons_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fields_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tools_Pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        main_PaneLayout.setVerticalGroup(
            main_PaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_PaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(persons_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fields_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tools_Pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_ButtonActionPerformed
        search();
    }//GEN-LAST:event_search_ButtonActionPerformed

    private void search_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_TextFieldActionPerformed
        search();
    }//GEN-LAST:event_search_TextFieldActionPerformed

    private void delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_ButtonActionPerformed
        int n = DialogMessage.showQuestionMessage(this, "Er du sikker på du vil slette den valgte person", "Sikker?");
        if (n == 0) {
            peH.removePerson(selectedPerson);
            search();
        }
    }//GEN-LAST:event_delete_ButtonActionPerformed

    private void close_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_ButtonActionPerformed
        dispose();
    }//GEN-LAST:event_close_ButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cleanSearchField();
        cleanSelectedUser();
        cleanTable();
    }//GEN-LAST:event_formWindowClosed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close_Button;
    private javax.swing.JButton delete_Button;
    private javax.swing.JPanel fields_Pane;
    private javax.swing.JLabel info_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel main_Pane;
    private javax.swing.JPanel persons_Pane;
    private javax.swing.JTable result_Table;
    private javax.swing.JButton search_Button;
    private javax.swing.JTextField search_TextField;
    private view.image.PicturePane titleIcon_PicturePane;
    private javax.swing.JPanel title_Pane;
    private javax.swing.JPanel tools_Pane;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerApp;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ListModel;

/**
 *
 * @author madel
 */
public class EmployeePegawai extends javax.swing.JFrame {
    ControllerApp ck = new ControllerApp();
    /**
     * Creates new form Assign
     */
    public EmployeePegawai() {
        initComponents();
        ck.fillDataPegawai(listPegawai);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPegawai = new javax.swing.JList<>();
        Button_Add = new javax.swing.JButton();
        Button_Delete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Button_Pegawai = new javax.swing.JButton();
        Button_Manager = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Deskrip_Pegawai2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Deskrip_Gaji = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Deskrip_Standar = new javax.swing.JLabel();
        Button_setGaji = new javax.swing.JButton();
        Button_setJam = new javax.swing.JButton();
        Deskrip_Pegawai = new javax.swing.JLabel();
        Deskrip_Pegawai1 = new javax.swing.JLabel();
        Deskrip_Pegawai3 = new javax.swing.JLabel();
        Deskrip_Pegawai4 = new javax.swing.JLabel();
        Deskrip_Standar1 = new javax.swing.JLabel();
        Deskrip_Standar2 = new javax.swing.JLabel();
        Deskrip_Standar3 = new javax.swing.JLabel();
        assign = new javax.swing.JButton();
        logkehadiran = new javax.swing.JButton();
        employee = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("List Pegawai");

        listPegawai.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listPegawai.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPegawaiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPegawai);

        Button_Add.setBackground(new java.awt.Color(102, 255, 102));
        Button_Add.setText("Add");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });

        Button_Delete.setBackground(new java.awt.Color(255, 102, 102));
        Button_Delete.setText("Delete");
        Button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Button_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Add)
                    .addComponent(Button_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        Button_Pegawai.setBackground(new java.awt.Color(153, 153, 153));
        Button_Pegawai.setForeground(new java.awt.Color(255, 255, 255));
        Button_Pegawai.setText("Pegawai");

        Button_Manager.setText("Manager");
        Button_Manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_Pegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Manager)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Pegawai)
                    .addComponent(Button_Manager))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Deskripsi Pegawai");

        Deskrip_Pegawai2.setText("Nama Pegawai :");
        Deskrip_Pegawai2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Deskripsi Gaji");

        Deskrip_Gaji.setText("Standar Gaji : ");
        Deskrip_Gaji.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Standar Jam Kerja");

        Deskrip_Standar.setText("Standar Jam Masuk :");
        Deskrip_Standar.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Button_setGaji.setBackground(new java.awt.Color(102, 255, 102));
        Button_setGaji.setText("Set Gaji");
        Button_setGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_setGajiActionPerformed(evt);
            }
        });

        Button_setJam.setBackground(new java.awt.Color(102, 255, 102));
        Button_setJam.setText("Set Jam");
        Button_setJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_setJamActionPerformed(evt);
            }
        });

        Deskrip_Pegawai.setText("Jabatan :");
        Deskrip_Pegawai.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Pegawai1.setText("Id : ");
        Deskrip_Pegawai1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Pegawai3.setText("Umur :");
        Deskrip_Pegawai3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Pegawai4.setText("No. Telepon : ");
        Deskrip_Pegawai4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Standar1.setText("Standar Jam Keluar :");
        Deskrip_Standar1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Standar2.setText("Status Lembur  :");
        Deskrip_Standar2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Deskrip_Standar3.setText("Total Lembur  :");
        Deskrip_Standar3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Deskrip_Pegawai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Deskrip_Standar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Deskrip_Standar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_setJam))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_setGaji))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Deskrip_Gaji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(253, 253, 253)))
                        .addGap(209, 209, 209))
                    .addComponent(Deskrip_Pegawai1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Deskrip_Pegawai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Deskrip_Pegawai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Deskrip_Pegawai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Deskrip_Standar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Deskrip_Standar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskrip_Pegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskrip_Pegawai1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskrip_Pegawai2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskrip_Pegawai3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Deskrip_Pegawai4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Button_setGaji)
                        .addGap(90, 90, 90)
                        .addComponent(Button_setJam)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deskrip_Gaji)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deskrip_Standar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deskrip_Standar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deskrip_Standar2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskrip_Standar3)
                .addGap(46, 46, 46))
        );

        assign.setText("Assign");
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignActionPerformed(evt);
            }
        });

        logkehadiran.setText("Log Kehadiran");
        logkehadiran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logkehadiranActionPerformed(evt);
            }
        });

        employee.setBackground(new java.awt.Color(153, 153, 153));
        employee.setText("Employee");

        logout.setBackground(new java.awt.Color(255, 51, 51));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logkehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(assign, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logkehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assign, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employee, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ck.showAddPegawai();
    }//GEN-LAST:event_Button_AddActionPerformed

    private void logkehadiranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logkehadiranActionPerformed
        this.setVisible(false);
        ck.showLogKehadiran();
    }//GEN-LAST:event_logkehadiranActionPerformed

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignActionPerformed
        this.setVisible(false);
        ck.ShowAssign();
    }//GEN-LAST:event_assignActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.setVisible(false);
        ck.showLogin();
    }//GEN-LAST:event_logoutActionPerformed

    private void Button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DeleteActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ck.showDelete(false, listPegawai.getSelectedIndex());
    }//GEN-LAST:event_Button_DeleteActionPerformed

    private void listPegawaiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPegawaiValueChanged
        // TODO add your handling code here:
        ck.updateFormPegawai();
    }//GEN-LAST:event_listPegawaiValueChanged

    private void Button_setGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_setGajiActionPerformed
        // TODO add your handling code here:
        ck.showSetGajiPegawai();
    }//GEN-LAST:event_Button_setGajiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ck.fillDataPegawai(listPegawai);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Button_ManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ManagerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ck.showemployeeManager();
    }//GEN-LAST:event_Button_ManagerActionPerformed

    private void Button_setJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_setJamActionPerformed
        // TODO add your handling code here:
        ck.showSetkehadiranPegawai();
    }//GEN-LAST:event_Button_setJamActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Delete;
    private javax.swing.JButton Button_Manager;
    private javax.swing.JButton Button_Pegawai;
    private javax.swing.JButton Button_setGaji;
    private javax.swing.JButton Button_setJam;
    private javax.swing.JLabel Deskrip_Gaji;
    private javax.swing.JLabel Deskrip_Pegawai;
    private javax.swing.JLabel Deskrip_Pegawai1;
    private javax.swing.JLabel Deskrip_Pegawai2;
    private javax.swing.JLabel Deskrip_Pegawai3;
    private javax.swing.JLabel Deskrip_Pegawai4;
    private javax.swing.JLabel Deskrip_Standar;
    private javax.swing.JLabel Deskrip_Standar1;
    private javax.swing.JLabel Deskrip_Standar2;
    private javax.swing.JLabel Deskrip_Standar3;
    private javax.swing.JButton assign;
    private javax.swing.JButton employee;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listPegawai;
    private javax.swing.JButton logkehadiran;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getDeskrip_Gaji() {
        return Deskrip_Gaji;
    }

    public javax.swing.JLabel getDeskrip_Pegawai() {
        return Deskrip_Pegawai;
    }

    public javax.swing.JLabel getDeskrip_Standar() {
        return Deskrip_Standar;
    }

    public javax.swing.JList<String> getListPegawai() {
        return listPegawai;
    }
    public ListModel  getListModel() {
        return listPegawai.getModel();
    }

    public JLabel getDeskrip_Pegawai1() {
        return Deskrip_Pegawai1;
    }

    public JLabel getDeskrip_Pegawai2() {
        return Deskrip_Pegawai2;
    }

    public JLabel getDeskrip_Pegawai3() {
        return Deskrip_Pegawai3;
    }

    public JLabel getDeskrip_Pegawai4() {
        return Deskrip_Pegawai4;
    }

    public JLabel getDeskrip_Standar1() {
        return Deskrip_Standar1;
    }

    public JLabel getDeskrip_Standar2() {
        return Deskrip_Standar2;
    }

    public JLabel getDeskrip_Standar3() {
        return Deskrip_Standar3;
    }
    
    
}

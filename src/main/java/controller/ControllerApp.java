/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBPr.*;
import EmpWork.*;
import view.*;
import java.util.*;
import javax.swing.*;
import Dao.*;
import java.time.LocalDateTime;


/**
 *
 * @author Liyan & Max & Andry
 */
public class ControllerApp {

    //Class GUI Assign--------
    private Assign assign;
    EmpWork.Pegawai pegawai;
    
    public ControllerApp() {
        
    }
    
    //Untuk show GUI Assign-------
    public void ShowAssign(){
        assign = new Assign();
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
        AssignList();
    }
    
    public void AssignList(){
        var tiketPegawai = pegawai.statusLembur.getStatusTiket(); //Navigasi dari Pegawai ke TiketLembur
        listPgw = DaoEmp.getAllPegawai();
        framePegawai.getListModel().removeAllElements();
        for (Pegawai pgw : listPgw) {
            if(tiketPegawai = true){
                framePegawai.getListModel().addElement(pgw.getNamaEmployee());
            }
        }
        updateFormPegawai();
    }
    
    public void AssignDesc(){
        
    }
    
    //update list item di GUI------
    public void updateFormAssign() {
        int jamLembur = pegawai.statusLembur.getWaktuLembur();
        String sJamLembur = Integer.toString(jamLembur); // Convert int to String
        var pengizin = pegawai.statusLembur.getPengizin();
        var selectedIndex = assign.getjList1().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
            Pegawai pgw = listPgw.get(selectedIndex);
            assign.getjLabel4().setText(pgw.getNamaEmployee());
            assign.getjLabel6().setText(pengizin);
            assign.getjLabel8().setText(sJamLembur);
        } else {
            assign.getjLabel4().setText("");
            assign.getjLabel6().setText("");
            assign.getjLabel8().setText("");
        }
        
    }
    
    List<Pegawai> listPgw;
    List<Manager> listMngr;
    EmployeeDao DaoEmp;
    private EmployeePegawai framePegawai;
    private EmployeeManager frameManager;
    
    //liyan
    public void refreshPegawai() {
        listPgw = DaoEmp.getAllPegawai();
        framePegawai.getListModel().removeAllElements();
        for (Pegawai pgw : listPgw) {
            framePegawai.getListModel().addElement(pgw.getNamaEmployee());
        }
        updateFormPegawai();
    }
    
    public void refreshManager() {
        listMngr = DaoEmp.getAllManager();
        frameManager.getListModel().removeAllElements();
        for (Manager m : listMngr) {
            frameManager.getListModel().addElement(m.getNamaEmployee());
        }
        updateForm();
    }
 
    public void updateFormPegawai() {
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
            Pegawai pgw = listPgw.get(selectedIndex);
            int gaji = pgw.statusGaji.getStandarGaji();
            String standarJamMasuk = pgw.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = pgw.kartuKehadiran.getWaktuKeluar();
            String statusLembur = pgw.statusLembur.toString();
            String totalLembur = ;
            
            framePegawai.getDeskrip_Pegawai().setText(pgw.getDataPegawai());
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji :"+gaji);
            framePegawai.getDeskrip_Standar().setText("Standar Jam Masuk: "+standarJamMasuk+
                                                        "\n Standar Jam Keluar: "+standarJamKeluar+
                                                        "\n\n Status Lembur: "+statusLembur+
                                                        "\n Total Lembur: ");
                
        } else {
            
        }
    }
//andry
    InterfaceDaoEmployee EmployeeDao;
    LogKehadiran frameLog;
    public void isiTableKehadiran(){
        List<Pegawai> listPegawai = EmployeeDao.getAllPegawai();
        ModelTableKehadiran mt = new ModelTableKehadiran(listPegawai);
        frameLog.getTable().setModel(mt);
    }
}

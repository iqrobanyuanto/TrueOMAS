/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBPr.*;
import EmpWork.*;
import view.*;
import java.util.List;
import javax.swing.*;
import Dao.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Liyan & Max & Andry
 */
public class ControllerApp {

    private Assign assign;
    
    public ControllerApp() {
        
    }
    
    public void ShowAssign(){
        assign = new Assign();
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
    }
    
    public void listBuilder(){}
    
    public void listChecker(){
        //for(Employee em: DBPr.KumpulanEmployee.getListPegawai()){}
    }
    
    public void selectedLembur(){
        //if(assign.getjList1()){}
    }
    List<Pegawai> listPgw;
    List<Manager> listMngr;
    EmployeeDao DaoEmp;
    private EmployeePegawai framePegawai;
    private EmployeeManager frameManager;
    private SetGaji setGaji; //Frame SetGaji
    Employee emp; //akses Employee dari EmpWork
    Pegawai pegawai; //akses Pegawai dari EmpWork
    Manager manager; //akses Manager dari EmpWork
    Kehadiran kehadiran; //Frame Kehadiran
    PerhitunganGajiDao DAOgaji; //akses DAO Gaji dari DAO
    RecordKehadiranDao DAOkehadiran; //akses DAO Kehadiran dari DAO
    private SetKehadiran setKehadiran;
    
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
        updateFormManager();
    }
 
    public void updateFormPegawai() {
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
            Pegawai pgw = listPgw.get(selectedIndex);
            int gaji = pgw.statusGaji.getStandarGaji();
            String standarJamMasuk = pgw.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = pgw.kartuKehadiran.getStandarKeluar().toString();
            String statusLembur = pgw.statusLembur.toString();
            int totalLembur = pgw.recordKerja.getTotalLembur();
            
            framePegawai.getDeskrip_Pegawai().setText(pgw.getDataPegawai());
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji :"+gaji);
            framePegawai.getDeskrip_Standar().setText("Standar Jam Masuk: "+standarJamMasuk+
                                                        "\n Standar Jam Keluar: "+standarJamKeluar+
                                                        "\n\n Status Lembur: "+statusLembur+
                                                        "\n Total Lembur: "+totalLembur);
        } else {
             framePegawai.getDeskrip_Pegawai().setText("""
                                                       Jabatan:
                                                       Id Manager: 
                                                       Nama: 
                                                       Umur: 
                                                       Nomor Telepon: """);
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji :");       
            framePegawai.getDeskrip_Standar().setText("""
                                                      Standar Jam Masuk: 
                                                      Standar Jam Keluar:  
                                                       Status Lembur:  
                                                       Total Lembur: """);
        }
    }
    
    //Menampilkan JDialog SetGaji (Pegawai)
    public void showSetGajiPegawai(){
        setGaji = new SetGaji(framePegawai,true);
        setGaji.setVisible(true);
        setGaji.setLocationRelativeTo(null);
    }
    
    //Menampilkan JDialog SetGaji (Manager)
    public void showSetGajiManager(){
        setGaji = new SetGaji(frameManager,true);
        setGaji.setVisible(true);
        setGaji.setLocationRelativeTo(null);
    }
    
    //SetGaji Pegawai sesuai input
    public void setGajiPegawai(){
        
        int convertTextField = Integer.parseInt(setGaji.getjTextField1().getText()); //Mengubah String jadi int
        pegawai.statusGaji.setStandarGaji(convertTextField); //Replace standar gaji pada pegawai
        framePegawai.getDeskrip_Gaji().setText(setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
        DAOgaji.updatePerhitunganGaji(emp.statusGaji, emp.getIdEmployee(), emp.getNamaJabatan()); //Update ke database
        setGaji.setVisible(false); //Menghilangkan JDialog ketika ditekan
    }
    
    //SetGaji Manager sesuai input
    public void setGajiManager(){
        int convertTextField = Integer.parseInt(setGaji.getjTextField1().getText()); //Mengubah String jadi int
        manager.statusGaji.setStandarGaji(convertTextField); //Replace standar gaji pada manager
        framePegawai.getDeskrip_Gaji().setText(setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
        DAOgaji.updatePerhitunganGaji(emp.statusGaji, emp.getIdEmployee(), emp.getNamaJabatan()); //Update ke database
        setGaji.setVisible(false); //Menghilangkan JDialog ketika ditekan
    }
    
    //Menampilkan JDialog untuk SetKehadiran (Pegawai)
    public void showSetkehadiranPegawai(){
        setKehadiran = new SetKehadiran(framePegawai,true);
        setKehadiran.setVisible(true);
        setKehadiran.setLocationRelativeTo(null);
    }
    
    //Menampilkan JDialog untuk SetKehadiran (Manager)
    public void showSetkehadiranManager(){
        setKehadiran = new SetKehadiran(frameManager,true);
        setKehadiran.setVisible(true);
        setKehadiran.setLocationRelativeTo(null);
    }
    
    //Set Kehadiran Pegawai
    public void setKehadiranPegawai(){
        int convertTextFieldMasuk = Integer.parseInt(setKehadiran.getjTextField1().getText()); //Mengubah String jadi int
        int convertTextFieldKeluar = Integer.parseInt(setKehadiran.getjTextField2().getText()); //Mengubah String jadi int
        
        kehadiran.setJamMasuk(convertTextFieldMasuk); //Replace Jam Masuk
        kehadiran.setJamKeluar(convertTextFieldKeluar); //Replace Jam Keluar
        framePegawai.getDeskrip_Standar().setText("Jam Masuk: "+setKehadiran.getjTextField1().getText()+"\n"+
                "Jam Keluar: "+setKehadiran.getjTextField2().getText()); //Mengganti label standar
        
        DateTimeFormatter jam = DateTimeFormatter.ofPattern("HH:mm"); //Membuat format jam
        LocalDateTime waktu = LocalDateTime.parse(setKehadiran.getjTextField1().getText(),jam); //Mengubah String menjadi Jam
        DAOkehadiran.insertRecord(waktu, emp.getIdEmployee(), emp.getNamaJabatan()); //Memasukkan jam ke database
        
        setKehadiran.setVisible(false); //Menghilangkan JDialog SetKehadiran
    }
    
    //Set Kehadiran Manager
    public void setKehadiranManager(){
        int convertTextFieldMasuk = Integer.parseInt(setKehadiran.getjTextField1().getText()); //Mengubah String jadi int
        int convertTextFieldKeluar = Integer.parseInt(setKehadiran.getjTextField2().getText()); //Mengubah String jadi int
        
        kehadiran.setJamMasuk(convertTextFieldMasuk); //Replace Jam Masuk
        kehadiran.setJamKeluar(convertTextFieldKeluar); //Replace Jam Keluar
        frameManager.getDeskrip_Standar().setText("Jam Masuk: "+setKehadiran.getjTextField1().getText()+"\n"+
                "Jam Keluar: "+setKehadiran.getjTextField2().getText()); //Mengganti label standar
        
        DateTimeFormatter jam = DateTimeFormatter.ofPattern("HH:mm"); //Membuat format jam
        LocalDateTime waktu = LocalDateTime.parse(setKehadiran.getjTextField1().getText(),jam); //Mengubah String menjadi Jam
        DAOkehadiran.insertRecord(waktu, emp.getIdEmployee(), emp.getNamaJabatan()); //Memasukkan jam ke database
        
        setKehadiran.setVisible(false); //Menghilangkan JDialog SetKehadiran
    }
    
    public void updateFormManager() {
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listMngr.size()) {
            Manager m = listMngr.get(selectedIndex);
            int gaji = m.statusGaji.getStandarGaji();
            String standarJamMasuk = m.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = m.kartuKehadiran.getStandarKeluar().toString();
            
            frameManager.getDeskrip_Manager().setText(m.getDataManager());
            frameManager.getDeskrip_Gaji().setText("Standar Gaji :"+gaji);
            frameManager.getDeskrip_Standar().setText("Standar Jam Masuk: "+standarJamMasuk+
                                                        "\n Standar Jam Keluar: "+standarJamKeluar);
                                                        
        } else {
             frameManager.getDeskrip_Manager().setText("""
                                                       Jabatan:
                                                       Id Manager: 
                                                       Nama: 
                                                       Umur: 
                                                       Nomor Telepon: """);
            frameManager.getDeskrip_Gaji().setText("Standar Gaji :");       
            frameManager.getDeskrip_Standar().setText("""
                                                      Standar Jam Masuk: 
                                                      Standar Jam Keluar:  
                                                        """);
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

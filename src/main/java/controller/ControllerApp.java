/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import AdmWork.Administrator;
import AdmWork.AkunAdmin;
import DBPr.*;
import EmpWork.*;
import view.*;
import java.util.List;
import javax.swing.*;
import Dao.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Liyan & Max & Andry
 */
public class ControllerApp {
    
    //Pemanggilan Class
    List<Pegawai> listPgw;
    List<Manager> listMngr;
    List<AkunAdmin> listAkunAdmn;
    EmployeeDao DaoEmp = new EmployeeDao();
    PerhitunganGajiDao DAOgaji = new PerhitunganGajiDao(); //akses DAO Gaji dari DAO
    KehadiranDao DaoKehadiran = new KehadiranDao();
    InterfaceDaoEmployee EmployeeDao = new EmployeeDao();
    AkunAdminDao DaoAdmin = new AkunAdminDao();
    PerhitunganWaktuDao DaoWaktu = new PerhitunganWaktuDao();
    TiketLemburDao DaoLembur = new TiketLemburDao();
    RecordKehadiranDao DaoRecordKehadiran = new RecordKehadiranDao();
    
    private static Login frameLogin = new Login();
    private static EmployeePegawai framePegawai = new EmployeePegawai();
    private static EmployeeManager frameManager = new EmployeeManager();
    private static Assign assign = new Assign();
    private static SetGaji setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
    private static LogKehadiran frameLog = new LogKehadiran();
    private static SetKehadiran setKehadiran;
    private static AddPegawai dialogAddPegawai = new AddPegawai(framePegawai,true);
    private static LogKehadiran frameKehadiran = new LogKehadiran();
    private static RemovePegawai dialogDeletePegawai;
    private static RemovePegawai dialogDeleteManager;
    private static SetLembur setLembur = new SetLembur(framePegawai,true);
//Class GUI
    /*
    private static Login frameLogin = new Login();
    private static EmployeePegawai framePegawai = new EmployeePegawai(this);
    private static EmployeeManager frameManager = new EmployeeManager(this);
    private static Assign assign = new Assign(this);
    private static SetGaji setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
    private static LogKehadiran frameLog = new LogKehadiran();
    private static SetKehadiran setKehadiran = new SetKehadiran(framePegawai,true);
    private static AddPegawai dialogAddPegawai = new AddPegawai(framePegawai,true);
    private static LogKehadiran frameKehadiran = new LogKehadiran();
    private static RemovePegawai dialogDeletePegawai = new RemovePegawai(framePegawai, true, false);
    private static RemovePegawai dialogDeleteManager = new RemovePegawai(frameManager, true, true);
    
    */
//Controller kosong
    public ControllerApp(){
        DaoEmp = new EmployeeDao();
        listPgw = DaoEmp.getAllPegawai();
        listMngr = DaoEmp.getAllManager();
    }
    
 //#################################################################### ASSIGN #####################################################################
    //Untuk show GUI Assign-------
    public void ShowAssign(){
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
//        refreshAssign();
    }
    
    //Mengupdate list pada Assign lembur
    public void refreshAssign(JList jlist) {
        DefaultListModel model = new DefaultListModel();
        listPgw = DaoEmp.getAllPegawai();
        
        for (Pegawai pgw : listPgw) {
            TiketLembur lembur = DaoLembur.getTiketLembur(pgw.getIdEmployee());

            if(lembur.getStatusTiket() == true){
                model.addElement(pgw.getNamaEmployee());
            }else{
                model.removeElement(pgw.getNamaEmployee());
            }
        }
        jlist.setModel(model);
    }

    //update list pegawai di GUI Assign
    public void updateFormAssign() {
        int selectedIndex = assign.getjList1().getSelectedIndex();
        Pegawai peg = listPgw.get(selectedIndex);
        
        TiketLembur lembur = DaoLembur.getTiketLembur(peg.getIdEmployee());

        String pengizin = lembur.getPengizin();
        String jamMulai = lembur.getWaktuMulai().toString();
        String jamSelesai = lembur.getWaktuAkhir().toString();
        
        peg.statusLembur.setStatusTiket(lembur.getStatusTiket());
        peg.statusLembur.setPengizin(pengizin);

        if (selectedIndex >= 0) {
            Pegawai pgw = listPgw.get(selectedIndex);
            assign.getjLabel4().setText(pgw.getNamaEmployee());
            assign.getjLabel6().setText(jamMulai);
            assign.getjLabel10().setText(jamSelesai);
            assign.getjLabel8().setText(pengizin);
        } else {
            assign.getjLabel4().setText("");
            assign.getjLabel6().setText("");
            assign.getjLabel10().setText("");
            assign.getjLabel8().setText("");
        }
    }
    
    public void fillDataLembur(JList jlist){
        DefaultListModel model = new DefaultListModel();
        listPgw = DaoEmp.getAllPegawai();
        TiketLembur status; 
        for (Pegawai e: listPgw){
            status = DaoLembur.getTiketLembur(e.getIdEmployee());
            if(status.getStatusTiket() == true){
                model.addElement(e.getNamaEmployee());
            }
        }
        jlist.setModel(model);
    }
    
 //###############################################################################################################################################
    
 //################################################################## EMPLOYEE #############################################################################  
    
    //Show Frame Employee (Pegawai)
    public void showemployeePegawai(){
        framePegawai.setVisible(true);
        framePegawai.setLocationRelativeTo(null);
    }
    
    //Show Frame Employee (Manager)
    public void showemployeeManager(){
        frameManager.setVisible(true);
        frameManager.setLocationRelativeTo(null);
    }
    
    //Mengupdate list pegawai
//    public void refreshPegawai() {
//        listPgw = DaoEmp.getAllPegawai();
//        framePegawai.getListModel().removeAllElements();
//        for (Pegawai pgw : listPgw) {
//            framePegawai.getListModel().addElement(pgw.getNamaEmployee());
//        }
//        updateFormPegawai();
//    }
    
//    //Mengupdate list manager
//    public void refreshManager() {
//        listMngr = DaoEmp.getAllManager();
//        frameManager.getListModel().removeAllElements();
//        for (Manager m : listMngr) {
//            frameManager.getListModel().addElement(m.getNamaEmployee());
//        }
//        updateFormManager();
//    }
    
    //Mengupdate list GUI pegawai
    public void updateFormPegawai() {
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
            Pegawai pgw = listPgw.get(selectedIndex);
            //update isi object 
            PerhitunganGaji statusGaji = DAOgaji.getPerhiitunganGaji(pgw.getIdEmployee(), pgw.getNamaJabatan());
            pgw.statusGaji.setStandarGaji(statusGaji.getStandarGaji());
            pgw.statusGaji.setTotalGaji(statusGaji.getTotalJamGaji());
            
            //update isi object Standar Jam
            Kehadiran hadir = DaoKehadiran.getKehadiran(pgw.getIdEmployee(), pgw.getNamaJabatan());
            
            //update status lembur
            TiketLembur lembur = DaoLembur.getTiketLembur(pgw.getIdEmployee());
            
            //update perhitungan waktu untuk total lembur
            var waktuLembur = DaoWaktu.getPerhitunganWaktu(pgw.getIdEmployee(), pgw.getNamaJabatan());

            //Pemanggilan variblen untuk di format cetak
            int gaji = statusGaji.getStandarGaji();
            String standarJamMasuk = hadir.getStandarMasuk().toString();
            String standarJamKeluar = hadir.getStandarKeluar().toString();
            boolean statusLembur = lembur.getStatusTiket();
            int totalLembur = waktuLembur.getTotalLembur();
            
            //Update object
            pgw.recordKerja.setTotalLembur(totalLembur);

            //format cetak terupdate
            framePegawai.getDeskrip_Pegawai().setText("Jabatan: "+pgw.getNamaJabatan());
            framePegawai.getDeskrip_Pegawai1().setText("Id Pegawai: "+pgw.getIdEmployee());
            framePegawai.getDeskrip_Pegawai2().setText("Nama Employee: "+pgw.getNamaEmployee());
            framePegawai.getDeskrip_Pegawai3().setText("Umur: "+pgw.getUmur());
            framePegawai.getDeskrip_Pegawai4().setText("No. Telepon: "+pgw.getNomorTelepon());
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji: "+gaji);
            framePegawai.getDeskrip_Standar().setText("Standar Jam Masuk: "+ standarJamMasuk);
            framePegawai.getDeskrip_Standar1().setText("Standar Jam Keluar: "+standarJamKeluar);
            framePegawai.getDeskrip_Standar2().setText("Status Lembur: "+statusLembur);
            framePegawai.getDeskrip_Standar3().setText("Total Lembur: "+totalLembur);
        } else {
            framePegawai.getDeskrip_Pegawai().setText("Jabatan: ");
            framePegawai.getDeskrip_Pegawai1().setText("Id Pegawai: ");
            framePegawai.getDeskrip_Pegawai2().setText("Nama Employee: ");
            framePegawai.getDeskrip_Pegawai3().setText("Umur: ");
            framePegawai.getDeskrip_Pegawai4().setText("No. Telepon: ");
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji:");
            framePegawai.getDeskrip_Standar().setText("Standar Jam Masuk: ");
            framePegawai.getDeskrip_Standar1().setText("Standar Jam Keluar: ");
            framePegawai.getDeskrip_Standar2().setText("Status Lembur: ");
            framePegawai.getDeskrip_Standar3().setText("Total Lembur: ");
        }
    }
    
    //Mengisi list GUI pegawai
    public void fillDataPegawai(JList jlist){
        DefaultListModel model = new DefaultListModel();
        listPgw = DaoEmp.getAllPegawai();
        System.out.println(listPgw.size());
        for (Pegawai e: listPgw){
            model.addElement(e.getNamaEmployee());
        }
        jlist.setModel(model);
    }
    
    //Mengupdate list GUI Manager
    public void updateFormManager() {
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listMngr.size()) {
            Manager m = listMngr.get(selectedIndex);
            
            //update isi object statusGaji
            PerhitunganGaji statusGaji = DAOgaji.getPerhiitunganGaji(m.getIdEmployee(), m.getNamaJabatan());
            m.statusGaji.setStandarGaji(statusGaji.getStandarGaji());
            m.statusGaji.setTotalGaji(statusGaji.getTotalJamGaji());
            
            //update isi object Standar Jam
            Kehadiran hadir = DaoKehadiran.getKehadiran(m.getIdEmployee(), m.getNamaJabatan());

            //Pemanggilan variblen untuk di format cetak
            int gaji = statusGaji.getStandarGaji();
            String standarJamMasuk = hadir.getStandarMasuk() != null ? hadir.getStandarMasuk().toString() : "Kosong";
            String standarJamKeluar = hadir.getStandarKeluar() != null ? hadir.getStandarKeluar().toString() : "Kosong";
            //String standarJamMasuk = hadir.getStandarMasuk().toString();
            //String standarJamKeluar = hadir.getStandarKeluar().toString();
            
            frameManager.getDeskrip_Pegawai().setText("Jabatan: "+m.getNamaJabatan());
            frameManager.getDeskrip_Pegawai1().setText("Id Pegawai: "+m.getIdEmployee());
            frameManager.getDeskrip_Pegawai2().setText("Nama Employee: "+m.getNamaEmployee());
            frameManager.getDeskrip_Pegawai3().setText("Umur: "+m.getUmur());
            frameManager.getDeskrip_Pegawai4().setText("No. Telepon: "+m.getNomorTelepon());
            frameManager.getDeskrip_Gaji().setText("Standar Gaji:"+gaji);
            frameManager.getDeskrip_Standar().setText("Standar Jam Masuk: "+standarJamMasuk);
            frameManager.getDeskrip_Standar1().setText("Standar Jam Keluar: "+standarJamKeluar);                        
        } else {
            frameManager.getDeskrip_Pegawai().setText("Jabatan: ");
            frameManager.getDeskrip_Pegawai1().setText("Id Pegawai: ");
            frameManager.getDeskrip_Pegawai2().setText("Nama Employee: ");
            frameManager.getDeskrip_Pegawai3().setText("Umur: ");
            frameManager.getDeskrip_Pegawai4().setText("No. Telepon: ");
            frameManager.getDeskrip_Gaji().setText("Standar Gaji:");
            frameManager.getDeskrip_Standar().setText("Standar Jam Masuk: ");
            frameManager.getDeskrip_Standar1().setText("Standar Jam Keluar: ");
        }
    }
    
    //Mengisi list GUI Manager
    public void fillDataManager(JList jlist){
        DefaultListModel model = new DefaultListModel();
        listMngr = DaoEmp.getAllManager();
        System.out.println(listMngr.size());
        for (Manager e: listMngr){
            model.addElement(e.getNamaEmployee());
        }
        jlist.setModel(model);
    }
//------------------------------------------------------------------------- SET GAJI ----------------------------------------------------------------------------------------
    
    //Menampilkan JDialog SetGaji (Pegawai)
    public void showSetGajiPegawai(){
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        if(selectedIndex >= 0){
            setGaji.setVisible(true);
            setGaji.setLocationRelativeTo(null);
        }        
    }
    
    //Menampilkan JDialog SetGaji (Manager)
    public void showSetGajiManager(){
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        if(selectedIndex >= 0){
            setGaji.setVisible(true);
            setGaji.setLocationRelativeTo(null);
        } 
        
    }
    
    //SetGaji Pegawai sesuai input
    public void setGajiPegawai(){
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        Pegawai pgw = listPgw.get(selectedIndex);
        int convertTextField = Integer.parseInt(setGaji.getjTextField1().getText()); //Mengubah String jadi int
        
        if (selectedIndex >= 0) {
            pgw.statusGaji.setStandarGaji(convertTextField);//Replace standar gaji pada pegawai
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji: "+setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
            DAOgaji.updatePerhitunganGaji(pgw.statusGaji, pgw.getIdEmployee(), pgw.getNamaJabatan()); //Update ke database
            setGaji.getjTextField1().setText("");
            setGaji.setVisible(false); //Menghilangkan JDialog ketika ditekan
        }
    }
    
    //SetGaji Manager sesuai input
    public void setGajiManager(){
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        Manager m = listMngr.get(selectedIndex);
        int convertTextField = Integer.parseInt(setGaji.getjTextField1().getText()); //Mengubah String jadi int
        
        if (selectedIndex >= 0) {
            m.statusGaji.setStandarGaji(convertTextField);//Replace standar gaji pada pegawai
            frameManager.getDeskrip_Gaji().setText("Standar Gaji: "+setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
            DAOgaji.updatePerhitunganGaji(m.statusGaji, m.getIdEmployee(), m.getNamaJabatan()); //Update ke database
            setGaji.getjTextField1().setText("");
            setGaji.setVisible(false); //Menghilangkan JDialog ketika ditekan
        }
    }
 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------- SET KEHADIRAN ----------------------------------------------------------------------------------------
    
    //Menampilkan JDialog untuk SetKehadiran (Pegawai)
    public void showSetkehadiranPegawai(){
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        if(selectedIndex >= 0){
            setKehadiran = new SetKehadiran(framePegawai, true, false);
            setKehadiran.setVisible(true);
            setKehadiran.setLocationRelativeTo(null);
        }    
    }
    
    //Menampilkan JDialog untuk SetKehadiran (Manager)
    public void showSetkehadiranManager(){
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        if(selectedIndex >= 0){
            setKehadiran = new SetKehadiran(frameManager, true, true);
            setKehadiran.setVisible(true);
            setKehadiran.setLocationRelativeTo(null);
        }    
    }
    
    //Set Kehadiran Pegawai
    public void setKehadiranPegawai(){
        
        Kehadiran k = new Kehadiran();
        Pegawai pgw = listPgw.get(framePegawai.getListPegawai().getSelectedIndex());
        
        //String untuk menggabungkan inputan
        String in1 =setKehadiran.getjTextField1().getText();
        String in2 =setKehadiran.getjTextField3().getText();
        String in3 =setKehadiran.getjTextField2().getText();
        String in4 =setKehadiran.getjTextField4().getText();
        String masuk = in1+":"+in2;
        String keluar = in3+":"+in4;
        
        //Mengubah string menjadi LocalTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); //Membuat format jam
        LocalTime waktuMasuk = LocalTime.parse(masuk,formatter); //Mengubah String menjadi Jam
        LocalTime waktuKeluar = LocalTime.parse(keluar,formatter); //Mengubah String menjadi Jam
        
        k.setStadarMasuk(waktuMasuk);
        k.setStandarKeluar(waktuKeluar);
        
        //Update kehadiran ke database
        DaoKehadiran.updateKartuKehadiran(k, pgw.getIdEmployee(), pgw.getNamaJabatan());
        
        //Update label pada view
        framePegawai.getDeskrip_Standar().setText("Jam Masuk: "+masuk);
        framePegawai.getDeskrip_Standar1().setText("Jam Keluar: "+keluar);
        
        setKehadiran.setVisible(false); //Menghilangkan JDialog SetKehadiran
    }
    
    
    //Set Kehadiran Manager
    public void setKehadiranManager(){
        
        Kehadiran k = new Kehadiran();
        Manager pgw = listMngr.get(frameManager.getListManager().getSelectedIndex());
        
        //String untuk menggabungkan inputan
        String in1 =setKehadiran.getjTextField1().getText();
        String in2 =setKehadiran.getjTextField3().getText();
        String in3 =setKehadiran.getjTextField2().getText();
        String in4 =setKehadiran.getjTextField4().getText();
        String masuk = in1+":"+in2;
        String keluar = in3+":"+in4;
        
        //Mengubah string menjadi LocalTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); //Membuat format jam
        LocalTime waktuMasuk = LocalTime.parse(masuk,formatter); //Mengubah String menjadi Jam
        LocalTime waktuKeluar = LocalTime.parse(keluar,formatter); //Mengubah String menjadi Jam
        
        k.setStadarMasuk(waktuMasuk);
        k.setStandarKeluar(waktuKeluar);
        
        //Update kehadiran ke database
        DaoKehadiran.updateKartuKehadiran(k, pgw.getIdEmployee(), pgw.getNamaJabatan());
        
        //Update label pada view
        frameManager.getDeskrip_Standar().setText("Jam Masuk: "+masuk);
        frameManager.getDeskrip_Standar1().setText("Jam Keluar: "+keluar);
        
        setKehadiran.setVisible(false); //Menghilangkan JDialog SetKehadiran
    }
    
//------------------------------------------------------------------------------- Set Lembur ----------------------------------------------------------------------------------------

    public void showSetLembur(){
        setLembur.setVisible(true);
        setLembur.setLocationRelativeTo(null);
    }
    
    public void setLembur(){
        LocalDate ld;
        
        //Membuat tanggal LocalDate
        int y = Integer.parseInt(setLembur.getYear().getText());
        int m = Integer.parseInt(setLembur.getMonth().getText());
        int d = Integer.parseInt(setLembur.getDay().getText());
        ld = LocalDate.of(y, Month.of(m), d);
        
        //Pengizin
        String pengizin = setLembur.getPengizin().getText();
        
        //Masuk
        int hm = Integer.parseInt(setLembur.getMulaiJam().getText());
        int mm = Integer.parseInt(setLembur.getMulaiMenit().getText());
        
        //Keluar
        int hk = Integer.parseInt(setLembur.getAkhirJam().getText());
        int mk = Integer.parseInt(setLembur.getMenitAkhir().getText());
        
        //Convert into LocalTime
        LocalTime ltm = LocalTime.of(hm, mm);
        LocalTime ltk = LocalTime.of(hk, mk);
        
        //Selected pegawai
        Pegawai pgw = listPgw.get(framePegawai.getListPegawai().getSelectedIndex());
        
        //Update status lembur ke database
        pgw.statusLembur.setStatusLembur(pengizin, ld, ltm, ltk);
        DaoLembur.updateTiketLembur(pgw.statusLembur, pgw);
        
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void showAddPegawai(){
        dialogAddPegawai.setVisible(true);
    }
    
    //Menambahkan pegawai ke database
    public void AddPegawai(){
        Pegawai pgw;
        Manager m;
        if(dialogAddPegawai.getJabatan().getText().equals("Pegawai")){
            pgw = new Pegawai(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), 
                    Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), 
                        dialogAddPegawai.getAlamat().getText());
            

            
            DaoEmp.insertEmployee(pgw.getIdEmployee(), pgw.getNamaEmployee(), pgw.getUmur(), pgw.getNomorTelepon(), 
                        pgw.getAlamat(), pgw.getNamaJabatan());
            
            DaoLembur.insertTiketLembur(pgw.statusLembur, pgw);
            
            DAOgaji.insertPerhitunganGaji(pgw.statusGaji, pgw.getIdEmployee(), pgw.getNamaJabatan());
            DaoKehadiran.insertKartuKehadiran(pgw.kartuKehadiran, pgw.getIdEmployee(), pgw.getNamaEmployee());
            DaoWaktu.insertPerhitunganWaktu(pgw.recordKerja, pgw.getIdEmployee(), pgw.getNamaJabatan());
        }else if(dialogAddPegawai.getJabatan().getText().equals("Manager")){
            m = new Manager(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), 
                        Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), 
                            dialogAddPegawai.getAlamat().getText());
            
            DaoEmp.insertEmployee(m.getIdEmployee(), m.getNamaEmployee(), m.getUmur(), m.getNomorTelepon(), 
                        m.getAlamat(), m.getNamaJabatan());
            
            DAOgaji.insertPerhitunganGaji(m.statusGaji, m.getIdEmployee(), m.getNamaJabatan());
            DaoKehadiran.insertKartuKehadiran(m.kartuKehadiran, m.getIdEmployee(), m.getNamaJabatan());
            DaoWaktu.insertPerhitunganWaktu(m.recordKerja, m.getIdEmployee(), m.getNamaJabatan());
        }
        
    }
    
    public void showDelete(boolean isManager, int selectedIndex){
        if(isManager){
            dialogDeleteManager = new RemovePegawai(frameManager, true, true, selectedIndex);
            dialogDeleteManager.getjLabel1().setText("Apakah anda ingin menghapus "+listMngr.get(selectedIndex).getNamaEmployee()+" dari database?");
            dialogDeleteManager.setVisible(true);
        }else{
            dialogDeletePegawai = new RemovePegawai(framePegawai, true, false, selectedIndex);
            dialogDeletePegawai.getjLabel1().setText("Apakah anda ingin menghapus "+listPgw.get(selectedIndex).getNamaEmployee()+" dari database?");
            dialogDeletePegawai.setVisible(true);
        }
    }
    //Menghapus Employee
    public void DeleteEmployee(boolean isManager, int selectedIndex){
        if(isManager){
            Manager m = listMngr.get(selectedIndex);
            DaoKehadiran.deleteKartuKehadiran(m.getIdEmployee(), m.getNamaJabatan());
            DaoWaktu.deletePerhitunganWaktu(m.getIdEmployee(), m.getNamaJabatan());
            DAOgaji.deletePerhitunganGaji(m.getIdEmployee(), m.getNamaJabatan());
            DaoRecordKehadiran.deleteAllLog(m);
            DaoEmp.deleteEmployee(m.getIdEmployee(), "Manager");
        }else{
            Pegawai pgw = listPgw.get(selectedIndex);
            DaoLembur.deleteTiketLembur(pgw.getIdEmployee());
            DaoKehadiran.deleteKartuKehadiran(pgw.getIdEmployee(), pgw.getNamaJabatan());
            DaoWaktu.deletePerhitunganWaktu(pgw.getIdEmployee(), pgw.getNamaJabatan());
            DAOgaji.deletePerhitunganGaji(pgw.getIdEmployee(), pgw.getNamaJabatan());
            DaoRecordKehadiran.deleteAllLog(pgw);
            DaoEmp.deleteEmployee(pgw.getIdEmployee(), "Pegawai");
        }
    }
    
//###############################################################################################################################################

//####################################################################### LOG KEHADIRAN ########################################################################
    
    public void showLogKehadiran(){
        frameKehadiran.setVisible(true);
        frameKehadiran.setLocationRelativeTo(null);
    }
    
    public void isiTableKehadiran(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        String columns[] = {"Id", "Nama", "Jabatan", "Tanggal", "Waktu Masuk", "Waktu Keluar"};
        String data[][] = DaoRecordKehadiran.getAllDataLog(DaoRecordKehadiran.getLogSize());
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
    }
    
    public void isiTableKehadiranManager(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        String columns[] = {"Id", "Nama", "Jabatan", "Tanggal", "Waktu Masuk", "Waktu Keluar"};
        String data[][] = DaoRecordKehadiran.getAllDataLogManager(DaoRecordKehadiran.getLogSizeManager());
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
    }
    
    public void isiTableKehadiranAll(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        String columns[] = {"Id", "Nama", "Jabatan", "Tanggal", "Waktu Masuk", "Waktu Keluar"};
        String data1[][] = DaoRecordKehadiran.getAllDataLogManager(DaoRecordKehadiran.getLogSizeManager());
        String data2[][] = DaoRecordKehadiran.getAllDataLog(DaoRecordKehadiran.getLogSize());
        
        String data[][] = new String[data1.length+data2.length][6];
        int j = 0;
        for(int i = 0; i < data1.length; i++){
            data[i][0] = data1[i][0];
            data[i][1] = data1[i][1];
            data[i][2] = data1[i][2];
            data[i][3] = data1[i][3];
            data[i][4] = data1[i][4];
            data[i][5] = data1[i][5];
            j++;
        }
       System.out.println("Banyak j"+j);
        for(int i = 0; i < data2.length; i++){
            data[j][0] = data2[i][0];
            data[j][1] = data2[i][1];
            data[j][2] = data2[i][2];
            data[j][3] = data2[i][3];
            data[j][4] = data2[i][4];
            data[j][5] = data2[i][5];
            j++;
        }
        
        System.out.println(data[0][0]);
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
    }
    
    public void isiTableKehadiranToday(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        String columns[] = {"Id", "Nama", "Jabatan", "Tanggal", "Waktu Masuk", "Waktu Keluar"};
        String data1[][] = DaoRecordKehadiran.getTodayDataLogManager(DaoRecordKehadiran.getTodayLogSizeManager());
        String data2[][] = DaoRecordKehadiran.getTodayDataLog(DaoRecordKehadiran.getTodayLogSizePegawai());
        
        String data[][] = new String[data1.length+data2.length][6];
        int j = 0;
        for(int i = 0; i < data1.length; i++){
            data[i][0] = data1[i][0];
            data[i][1] = data1[i][1];
            data[i][2] = data1[i][2];
            data[i][3] = data1[i][3];
            data[i][4] = data1[i][4];
            data[i][5] = data1[i][5];
            j++;
        }
       System.out.println("Banyak j"+j);
        for(int i = 0; i < data2.length; i++){
            data[j][0] = data2[i][0];
            data[j][1] = data2[i][1];
            data[j][2] = data2[i][2];
            data[j][3] = data2[i][3];
            data[j][4] = data2[i][4];
            data[j][5] = data2[i][5];
            j++;
        }
        
        System.out.println(data[0][0]);
        DefaultTableModel model = new DefaultTableModel(data, columns);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
    }
    
    
//###############################################################################################################################################
    
//########################################################################## LOGIN #####################################################################
    
    //Memunculkan GUI login
    public void showLogin(){
        frameLogin.setVisible(true);
        frameLogin.setLocationRelativeTo(null);
    }
    
    public void Login(String id, String pass){
        if(id.length() == 0 || pass.length() == 0){
            
            //Membuat JDialog baru yang berisikan notif error
            JDialog errorDialog = new JDialog(frameLogin, "Error", true);
            errorDialog.setLayout(new FlowLayout());
            JLabel errorMessageLabel = new JLabel("Please put a correct input");
            errorDialog.add(errorMessageLabel);

            errorDialog.pack();
            errorDialog.setLocationRelativeTo(frameLogin);
            errorDialog.setVisible(true);
        }else{
            //mencari akun
            listAkunAdmn = DaoAdmin.getAllAkunAdmin();
            for(int i=0; i < listAkunAdmn.size() ;i++ ){
                if(listAkunAdmn.get(i).getid().equals(id)){
                    if (listAkunAdmn.get(i).getpassword().equals(pass)){
                        frameKehadiran.setVisible(true);
                        frameLogin.setVisible(false);
                    }
                } else {
                    LoginError error = new LoginError(frameLogin, true);
                    error.setVisible(true);
                    error.setLocationRelativeTo(null);
                }
            }
        }
    }
}

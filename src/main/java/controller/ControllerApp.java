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
    
    private static Login frameLogin = new Login();
    private static EmployeePegawai framePegawai = new EmployeePegawai();
    private static EmployeeManager frameManager = new EmployeeManager();
    private static Assign assign = new Assign();
    private static SetGaji setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
    private static LogKehadiran frameLog = new LogKehadiran();
    static Kehadiran kehadiran = new Kehadiran(); //Frame Kehadiran
    private static SetKehadiran setKehadiran = new SetKehadiran(framePegawai,true);
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
//    public void refreshAssign() {
//        listPgw = DaoEmp.getAllPegawai();
//        framePegawai.getListModel().removeAllElements();
//        for (Pegawai pgw : listPgw) {
//            if(pgw.statusLembur.getStatusTiket() == true){
//                framePegawai.getListModel().addElement(pgw.getNamaEmployee());
//            }
//        }
//        updateFormAssign();
//    }
    
    //Deskripsi pada list yang dituju
//    public void AssignDesc(){
//        
//    }
    
    //update list pegawai di GUI Assign
//    public void updateFormAssign() {
//        int jamLembur = pegawai.statusLembur.getWaktuLembur();
//        String sJamLembur = Integer.toString(jamLembur); // Convert int to String
//        var pengizin = pegawai.statusLembur.getPengizin();
//        var selectedIndex = assign.getjList1().getSelectedIndex();
//        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
//            Pegawai pgw = listPgw.get(selectedIndex);
//            assign.getjLabel4().setText(pgw.getNamaEmployee());
//            assign.getjLabel6().setText(pengizin);
//            assign.getjLabel8().setText(sJamLembur);
//        } else {
//            assign.getjLabel4().setText("");
//            assign.getjLabel6().setText("");
//            assign.getjLabel8().setText("");
//        }
//        
//    }
    
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
            //update isi object statusGaji
            PerhitunganGaji statusGaji = DAOgaji.getPerhiitunganGaji(pgw.getIdEmployee(), pgw.getNamaJabatan());
            pgw.statusGaji.setStandarGaji(statusGaji.getStandarGaji());
            pgw.statusGaji.setTotalGaji(statusGaji.getTotalJamGaji());
            
            //Pemanggilan variblen untuk di format cetak
            int gaji = statusGaji.getStandarGaji();
            String standarJamMasuk = pgw.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = pgw.kartuKehadiran.getStandarKeluar().toString();
            boolean statusLembur = pgw.statusLembur.getStatusTiket();
            int totalLembur = pgw.recordKerja.getTotalLembur();
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
            
            //Pemanggilan variblen untuk di format cetak
            int gaji = statusGaji.getStandarGaji();
            String standarJamMasuk = m.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = m.kartuKehadiran.getStandarKeluar().toString();
            
            
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
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji: "+setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
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
            setKehadiran.setVisible(true);
            setKehadiran.setLocationRelativeTo(null);
        }    
        
    }
    
    //Menampilkan JDialog untuk SetKehadiran (Manager)
    public void showSetkehadiranManager(){
        int selectedIndex = frameManager.getListManager().getSelectedIndex();
        if(selectedIndex >= 0){
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
        framePegawai.getDeskrip_Standar().setText("Jam Masuk: "+masuk+"\n"+
                "Jam Keluar: "+keluar);
        
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
            pgw = new Pegawai(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), dialogAddPegawai.getAlamat().getText());
            
            DaoLembur.insertTiketLembur(pgw.statusLembur, pgw);
            DaoEmp.insertEmployee(pgw.getIdEmployee(), pgw.getNamaEmployee(), pgw.getUmur(), pgw.getNomorTelepon(), pgw.getAlamat(), pgw.getNamaJabatan());
            DAOgaji.insertPerhitunganGaji(pgw.statusGaji, pgw.getIdEmployee(), pgw.getNamaJabatan());
            DaoKehadiran.insertKartuKehadiran(pgw.kartuKehadiran, pgw.getIdEmployee(), pgw.getNamaEmployee());
            DaoWaktu.insertPerhitunganWaktu(pgw.recordKerja, pgw.getIdEmployee(), pgw.getNamaJabatan());
        }else{
            m = new Manager(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), dialogAddPegawai.getAlamat().getText());
            DaoEmp.insertEmployee(m.getIdEmployee(), m.getNamaEmployee(), m.getUmur(), m.getNomorTelepon(), m.getAlamat(), m.getNamaJabatan());
            DAOgaji.insertPerhitunganGaji(m.statusGaji, m.getIdEmployee(), m.getNamaJabatan());
            DaoKehadiran.insertKartuKehadiran(m.kartuKehadiran, m.getIdEmployee(), m.getNamaEmployee());
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
            DaoEmp.deleteEmployee(listMngr.get(selectedIndex).getIdEmployee(), "Manager");
        }else{
            Pegawai pgw = listPgw.get(selectedIndex);
            DaoEmp.deleteEmployee(listPgw.get(selectedIndex).getIdEmployee(), listPgw.get(selectedIndex).getNamaJabatan());
        }
    }
    
//###############################################################################################################################################

//####################################################################### LOG KEHADIRAN ########################################################################
    
    public void showLogKehadiran(){
        frameKehadiran.setVisible(true);
        frameKehadiran.setLocationRelativeTo(null);
    }
    
    public void isiTableKehadiran(){
        List<Pegawai> listPegawai = EmployeeDao.getAllPegawai();
        ModelTableKehadiran mt = new ModelTableKehadiran(listPegawai);
        frameLog.getTable().setModel(mt);
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

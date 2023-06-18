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
import java.time.LocalDateTime;
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
    Employee emp; //akses Employee dari EmpWork
    Pegawai pegawai; //akses Pegawai dari EmpWork
    Manager manager; //akses Manager dari EmpWork
    PerhitunganGajiDao DAOgaji; //akses DAO Gaji dari DAO
    RecordKehadiranDao DAOkehadiran; //akses DAO Kehadiran dari DAO
    InterfaceDaoEmployee EmployeeDao;
    
    //Class GUI
    private static Login frameLogin = new Login();
    private static EmployeePegawai framePegawai = new EmployeePegawai();
    private static EmployeeManager frameManager = new EmployeeManager();
    private static Assign assign = new Assign();
    private static SetGaji setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
    static LogKehadiran frameLog = new LogKehadiran();
    static Kehadiran kehadiran = new Kehadiran(); //Frame Kehadiran
    private static SetKehadiran setKehadiran = new SetKehadiran(framePegawai,true);
    private static AddPegawai dialogAddPegawai = new AddPegawai(framePegawai,true);
    static AkunAdminDao DaoAdmin = new AkunAdminDao();
    private static LogKehadiran frameKehadiran = new LogKehadiran();
    private static RemovePegawai dialogDeletePegawai;
    private static RemovePegawai dialogDeleteManager;
    //Controller kosong
    public ControllerApp(){
        /*
        this.frameLogin = new Login();
        this.framePegawai = new EmployeePegawai();
        this.frameManager = new EmployeeManager();
        this.assign = new Assign();
        this.setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
        this.frameLog = new LogKehadiran();
        this.kehadiran = new Kehadiran(); //Frame Kehadiran
        this.setKehadiran = new SetKehadiran(framePegawai,true);
        this.dialogAddPegawai = new AddPegawai(framePegawai,true);
        this.DaoAdmin = new AkunAdminDao();
        this.frameKehadiran = new LogKehadiran();
        */
        listPgw = DaoEmp.getAllPegawai();
        listMngr = DaoEmp.getAllManager();
    }
    
 //#################################################################### ASSIGN #####################################################################
    //Untuk show GUI Assign-------
    public static void ShowAssign(){
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
        //refreshAssign();
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
    public void AssignDesc(){
        
    }
    
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
            int gaji = pgw.statusGaji.getStandarGaji();
            String standarJamMasuk = pgw.kartuKehadiran.getStandarMasuk().toString();
            String standarJamKeluar = pgw.kartuKehadiran.getStandarKeluar().toString();
            String statusLembur = pgw.statusLembur.toString();
            int totalLembur = pgw.recordKerja.getTotalLembur();
            
            framePegawai.getDeskrip_Pegawai().setText("Jabatan: "+pgw.getNamaJabatan());
            framePegawai.getDeskrip_Pegawai1().setText("Id Pegawai: "+pgw.getIdEmployee());
            framePegawai.getDeskrip_Pegawai2().setText("Nama Employee: "+pgw.getNamaEmployee());
            framePegawai.getDeskrip_Pegawai3().setText("Umur: "+pgw.getUmur());
            framePegawai.getDeskrip_Pegawai4().setText("No. Telepon: "+pgw.getNomorTelepon());
            framePegawai.getDeskrip_Gaji().setText("Standar Gaji:"+gaji);
            framePegawai.getDeskrip_Standar().setText("Standar Jam Masuk: "+standarJamMasuk);
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
            int gaji = m.statusGaji.getStandarGaji();
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
        setGaji.setVisible(true);
        setGaji.setLocationRelativeTo(null);
    }
    
    //Menampilkan JDialog SetGaji (Manager)
    public void showSetGajiManager(){
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
 
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//------------------------------------------------------------------------- SET KEHADIRAN ----------------------------------------------------------------------------------------
    
    //Menampilkan JDialog untuk SetKehadiran (Pegawai)
    public void showSetkehadiranPegawai(){
        setKehadiran.setVisible(true);
        setKehadiran.setLocationRelativeTo(null);
    }
    
    //Menampilkan JDialog untuk SetKehadiran (Manager)
    public void showSetkehadiranManager(){
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
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
    public void showAddPegawai(){
        dialogAddPegawai.setVisible(true);
    }
    //Menambahkan pegawai ke database
    public void AddPegawai(){
        DaoEmp.insertEmployee(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), dialogAddPegawai.getAlamat().getText(), dialogAddPegawai.getJabatan().getText());
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
        if(id == null || pass == null){
            LoginError error = new LoginError(frameLogin, true);
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
                }
            }
        }
    }
}

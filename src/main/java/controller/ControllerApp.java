/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import AdmWork.*;
import DBPr.*;
import EmpWork.*;
import view.*;
import java.util.List;
import javax.swing.*;
import Dao.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    InterfaceDaoEmployee EmployeeDao;
    AkunAdminDao DaoAdmin = new AkunAdminDao();
    
    private  Login frameLogin;
    private  EmployeePegawai framePegawai;
    private  EmployeeManager frameManager;
    private  Assign assign;
    private  SetGaji setGaji; //Frame SetGaji
    private  LogKehadiran frameLog;
    private  SetKehadiran setKehadiran;
    private  AddPegawai dialogAddPegawai;
    private  LogKehadiran frameKehadiran;
    private  RemovePegawai dialogDeletePegawai;
    private  RemovePegawai dialogDeleteManager;
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
        
        this.frameLogin = new Login(this);
        this.framePegawai = new EmployeePegawai(this);
        this.frameManager = new EmployeeManager(this);
        this.assign = new Assign(this);
        this.setGaji = new SetGaji(framePegawai,true); //Frame SetGaji
        this.frameLog = new LogKehadiran();
        //this.kehadiran = new Kehadiran(); //Frame Kehadiran
        this.setKehadiran = new SetKehadiran(framePegawai,true);
        this.dialogAddPegawai = new AddPegawai(framePegawai,true);
        this.DaoAdmin = new AkunAdminDao();
        this.frameKehadiran = new LogKehadiran();
       
    }
    
 //#################################################################### ASSIGN #####################################################################
    //Untuk show GUI Assign-------
    public void ShowAssign(){
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
        refreshAssign();
    }
    
    //Mengupdate list pada Assign lembur
    public void refreshAssign(JList jlist) {
        DefaultListModel model = new DefaultListModel();
        listPgw = DaoEmp.getAllPegawai();
        for (Pegawai pgw : listPgw) {
            if(pgw.statusLembur.getStatusTiket() == true){
                model.addElement(pgw.getNamaEmployee());
            }
        }
        jlist.setModel(model);
    }
    
    //update list pegawai di GUI Assign
    public void updateFormAssign() {
        int jamLembur = pegawai.statusLembur.getWaktuLembur();
        String sJamLembur = Integer.toString(jamLembur); // Convert int to String
        var pengizin = pegawai.statusLembur.getPengizin();
        int selectedIndex = assign.getjList1().getSelectedIndex();
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
    
    //update list pegawai di GUI Assign
    public void updateFormAssign() {
        int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
        Pegawai pgw = listPgw.get(selectedIndex);
        String pengizin = pgw.statusLembur.getPengizin();
        int jamLembur = pgw.statusLembur.getWaktuLembur();
        assign.getjLabel4().setText(pgw.getNamaEmployee());
        assign.getjLabel6().setText(pengizin);
        assign.getjLabel8().setText(""+jamLembur);
        if (selectedIndex >= 0 && selectedIndex < listPgw.size()) {
            assign.getjLabel4().setText(pgw.getNamaEmployee());
            assign.getjLabel6().setText(pengizin);
            assign.getjLabel8().setText(""+jamLembur);
        } else {
            assign.getjLabel4().setText("");
            assign.getjLabel6().setText("");
            assign.getjLabel8().setText("");
        }
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
    public void refreshPegawai() {
        listPgw = DaoEmp.getAllPegawai();
        framePegawai.getListModel().removeAllElements();
        for (Pegawai pgw : listPgw) {
            framePegawai.getListModel().addElement(pgw.getNamaEmployee());
        }
        updateFormPegawai();
    }
    
    //Mengupdate list manager
    public void refreshManager() {
        listMngr = DaoEmp.getAllManager();
        frameManager.getListModel().removeAllElements();
        for (Manager m : listMngr) {
            frameManager.getListModel().addElement(m.getNamaEmployee());
        }
        updateFormManager();
    }
    
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
    
    //Mengupdate list GUI Manager
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
        
        Pegawai pgw = listPgw.get(framePegawai.getListPegawai().getSelectedIndex());
        pgw.statusGaji.setStandarGaji(convertTextField);
        
        DAOgaji.updatePerhitunganGaji(pgw.statusGaji, pgw.getIdEmployee(), pgw.getNamaJabatan()); //Replace standar gaji pada pegawai
        
        framePegawai.getDeskrip_Gaji().setText(setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
        //DAOgaji.updatePerhitunganGaji(emp.statusGaji, emp.getIdEmployee(), emp.getNamaJabatan()); //Update ke database
        
        setGaji.setVisible(false); //Menghilangkan JDialog ketika ditekan
    }
    
    //SetGaji Manager sesuai input
    public void setGajiManager(){
        
        int convertTextField = Integer.parseInt(setGaji.getjTextField1().getText()); //Mengubah String jadi int
        
        Manager mngr = listMngr.get(frameManager.getListManager().getSelectedIndex());
        mngr.statusGaji.setStandarGaji(convertTextField);
        
        DAOgaji.updatePerhitunganGaji(mngr.statusGaji, mngr.getIdEmployee(), mngr.getNamaJabatan()); //Replace standar gaji pada pegawai
        
        framePegawai.getDeskrip_Gaji().setText(setGaji.getjTextField1().getText()); //Mengganti text di frame SetGaji
        //DAOgaji.updatePerhitunganGaji(emp.statusGaji, emp.getIdEmployee(), emp.getNamaJabatan()); //Update ke database
        
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
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
    public void showAddPegawai(){
        dialogAddPegawai.setVisible(true);
    }
    //Menambahkan pegawai ke database
    public void AddPegawai(){
        DaoEmp.insertEmployee(dialogAddPegawai.getId().getText(), dialogAddPegawai.getNama().getText(), Integer.parseInt(dialogAddPegawai.getUmur().getText()), dialogAddPegawai.getNoHP().getText(), dialogAddPegawai.getAlamat().getText(), dialogAddPegawai.getJabatan().getText());
    }
    
    public void showDelete(boolean isManager, String selectedPegawai){
        if(isManager){
            dialogDeleteManager.getjLabel1().setText("Apakah anda ingin menghapus "+selectedPegawai+" dari database?");
            dialogDeleteManager.setVisible(true);
        }else{
            dialogDeletePegawai.getjLabel1().setText("Apakah anda ingin menghapus "+selectedPegawai+" dari database?");
            dialogDeletePegawai.setVisible(true);
        }
        
    }
    //Menghapus Employee
    public void DeleteEmployee(boolean isManager){
        if(isManager){
            int selectedIndex = frameManager.getListManager().getSelectedIndex();
            DaoEmp.deleteEmployee(listPgw.get(selectedIndex).getIdEmployee(), "Manager");
        }else{
            int selectedIndex = framePegawai.getListPegawai().getSelectedIndex();
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

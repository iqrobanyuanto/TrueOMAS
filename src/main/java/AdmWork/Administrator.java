/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmWork;

import java.time.LocalTime;
import DBPr.*;
import EmpWork.*;

/**
 *
 * @author Iqro Banyuanto & Liyan & Max
 */

public class Administrator {
    private AkunAdmin akunAdmin;
    
    public Administrator(String id,String password ){
        KumpulanAkunAdmin k = new KumpulanAkunAdmin();
        try{
            if(k.getAkun(id, password) == null){
                //ketika akun tidak ada di listadmin
                throw new Exception("Id atau password salah");
            }
            //ketika ada di listadmin
            this.akunAdmin = k.getAkun(id, password);
            System.out.println("Login berhasil");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void addEmployee(String Nama_Jabatan, String idEmployee, String nama, int umur, String nomortelepon, String alamat){
            /* Menerima input isi dari Admin untuk menambahkan Employee sesuai 
        dengan Jabatan dan jika Jabatan tidak sesuai mengembalikan pesan*/
            KumpulanEmployee listEmp = new KumpulanEmployee();
            
            if(Nama_Jabatan.equals("Manager")){
                Manager managerBaru = new Manager(idEmployee,nama,umur, nomortelepon, alamat);
                listEmp.addManager(managerBaru);
            }else if(Nama_Jabatan.equals("Pegawai")){
                Pegawai pegawaiBaru = new Pegawai(idEmployee,nama,umur, nomortelepon, alamat);
                listEmp.addPegawai(pegawaiBaru);
            }else{
                System.out.println("Nama Jabatan Employee Tidak valid");
            }
    }
    public void hapusEmployee(String Nama_Jabatan, String idEmployee){
        /*Menerima nama jabatan dan id employee dan menghapus employee tersebut jika ada*/
        KumpulanEmployee listEmp = new KumpulanEmployee();
        
        if(Nama_Jabatan.equals("Manager")){
            listEmp.hapusManager(idEmployee);
        }else if(Nama_Jabatan.equals("Pegawai")){
            listEmp.hapusPegawai(idEmployee);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarGaji(String nama_Jabatan, String idEmployee, int standarGaji){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equals("Manager")){
            Manager empManager = (Manager)emp;
            empManager.statusGaji.setStandarGaji(standarGaji);
        }else if(nama_Jabatan.equals("Pegawai")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.statusGaji.setStandarGaji(standarGaji);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarMasuk(String nama_Jabatan, String idEmployee, LocalTime jamMasuk){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equals("Manager")){
            Manager empManager = (Manager)emp;
            empManager.kartuKehadiran.setStadarMasuk(jamMasuk);
        }else if(nama_Jabatan.equals("Pegawai")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.kartuKehadiran.setStadarMasuk(jamMasuk);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarKeluar(String nama_Jabatan, String idEmployee, LocalTime jamKeluar){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equals("Manager")){
            Manager empManager = (Manager)emp;
            empManager.kartuKehadiran.setStandarKeluar(jamKeluar);
        }else if(nama_Jabatan.equals("Pegawai")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.kartuKehadiran.setStandarKeluar(jamKeluar);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
/*
    public void assignLembur(String idEmployee, int waktuLembur, String pengizin){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("Masukkan nama pengizin dan id pegawai: ");
        Pegawai e = ke.getPegawai(idEmployee);
        e.statusLembur.setStatusLembur(pengizin, waktuLembur);
        e.recordKerja.tambahTotalLembur(waktuLembur);
        System.out.println("Status lembur "+ e.getNamaEmployee()+" telah aktif");
    }
*/
    public void resetStatusLembur(String idEmployee){
        KumpulanEmployee ke = new KumpulanEmployee();
        Pegawai e = ke.getPegawai(idEmployee);
        e.statusLembur.resetStatus();
        System.out.println("Status lembur "+ e.getNamaEmployee()+" Sudah di reset");
    }
    
    public void showDescEmployee(String nama_Jabatan, String idEmployee){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("Masukkan nama jabatan dan id pegawai: ");
        Employee qa = ke.searchEmployee(nama_Jabatan, idEmployee);
        if(nama_Jabatan.equals( "Manager")){
            Manager d = (Manager)qa;
            d.showEmployee();
        }else if(nama_Jabatan.equals( "Pegawai")){
            Pegawai d = (Pegawai)qa;
            d.showEmployee();
        }else{
            System.out.println("Jabatan tersebut tidak bisa diakses!");
        }
    }
    
    public void showDescAllEmployee(){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("------");
        ke.showAllManager();
        System.out.println("------");
        ke.showAllPegawai();
        System.out.println("------");
    }
    
    public void showAdminIdentity(){
        System.out.println("<< Admin "+akunAdmin.getnamaAdmin()+" dengan id "+akunAdmin.getid()+" >>");
    }
}

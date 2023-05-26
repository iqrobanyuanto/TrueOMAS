/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmWork;

import DBPr.KumpulanAkunAdmin;
import DBPr.KumpulanEmployee;
import EmpWork.Employee;
import EmpWork.Manager;
import EmpWork.Pegawai;
import java.time.LocalTime;

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
    public void addEmployee(String Nama_Jabatan, String idEmployee, String nama, int umur, String nomortelepon, String alamat,
            int standarGaji, LocalTime standarMasuk, LocalTime standarKeluar){
            /* Menerima input isi dari Admin untuk menambahkan Employee sesuai 
        dengan Jabatan dan jika Jabatan tidak sesuai mengembalikan pesan*/
            KumpulanEmployee listEmp = new KumpulanEmployee();
            
            if(Nama_Jabatan.equalsIgnoreCase("MANAGER")){
                Manager managerBaru = new Manager(idEmployee,nama,umur, nomortelepon, alamat);
                managerBaru.setStandarGaji(standarGaji);
                managerBaru.setStadarMasuk(standarMasuk);
                managerBaru.setStandarKeluar(standarKeluar);
                listEmp.addManager(managerBaru);
            }else if(Nama_Jabatan.equalsIgnoreCase("PEGAWAI")){
                Pegawai pegawaiBaru = new Pegawai(idEmployee,nama,umur, nomortelepon, alamat);
                pegawaiBaru.setStandarGaji(standarGaji);
                pegawaiBaru.setStadarMasuk(standarMasuk);
                pegawaiBaru.setStandarKeluar(standarKeluar);
                listEmp.addPegawai(pegawaiBaru);
            }else{
                System.out.println("Nama Jabatan Employee Tidak valid");
            }
    }
    public void hapusEmployee(String Nama_Jabatan, String idEmployee){
        /*Menerima nama jabatan dan id employee dan menghapus employee tersebut jika ada*/
        KumpulanEmployee listEmp = new KumpulanEmployee();
        
        if(Nama_Jabatan.equalsIgnoreCase("MANAGER")){
            listEmp.hapusManager(idEmployee);
        }else if(Nama_Jabatan.equalsIgnoreCase("PEGAWAI")){
            listEmp.hapusPegawai(idEmployee);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarGaji(String nama_Jabatan, String idEmployee, int standarGaji){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equalsIgnoreCase("MANAGER")){
            Manager empManager = (Manager)emp;
            empManager.setStandarGaji(standarGaji);
        }else if(nama_Jabatan.equalsIgnoreCase("PEGAWAI")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.setStandarGaji(standarGaji);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarMasuk(String nama_Jabatan, String idEmployee, LocalTime jamMasuk){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equalsIgnoreCase("MANAGER")){
            Manager empManager = (Manager)emp;
            empManager.setStadarMasuk(jamMasuk);
        }else if(nama_Jabatan.equalsIgnoreCase("PEGAWAI")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.setStadarMasuk(jamMasuk);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
    public void setStandarKeluar(String nama_Jabatan, String idEmployee, LocalTime jamKeluar){
        KumpulanEmployee listEmp = new KumpulanEmployee();
        Employee emp = listEmp.searchEmployee(nama_Jabatan, idEmployee);
        
        if(nama_Jabatan.equalsIgnoreCase("MANAGER")){
            Manager empManager = (Manager)emp;
            empManager.setStadarMasuk(jamKeluar);
        }else if(nama_Jabatan.equalsIgnoreCase("PEGAWAI")){
            Pegawai empPegawai = (Pegawai)emp;
            empPegawai.setStadarMasuk(jamKeluar);
        }else{
            System.out.println("Nama Jabatan Employee Tidak valid");
        }
    }
}

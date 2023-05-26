/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmWork;
import DBPr.*;
import EmpWork.*;
/**
 *
 * @author Iqro Banyuanto
 */
public class Administrator{
    
    public void assignLembur(String idEmployee, int waktuLembur, String pengizin){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("Masukkan nama pengizin dan id pegawai: ");
        Pegawai e = ke.getPegawai(idEmployee);
        e.statusLembur.setStatusLembur(pengizin, waktuLembur);
    }
    
    public void showDescEmployee(String nama_Jabatan, String idEmployee){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("Masukkan nama jabatan dan id pegawai: ");
        ke.searchEmployee(nama_Jabatan, idEmployee);
        if(nama_Jabatan.equalsIgnoreCase( "Manager")){
            System.out.println("Nama: "+ke.getManager(idEmployee).getNamaEmployee());
            System.out.println("Umur: "+ke.getManager(idEmployee).getUmur());
            System.out.println("Jabatan: "+ke.getManager(idEmployee).getNamaJabatan());
            System.out.println("Standar Gaji: "+ke.getManager(idEmployee).getStandarGaji());
            System.out.println("Nomor Telepon: "+ke.getManager(idEmployee).getNomorTelepon());
            System.out.println("Alamat: "+ke.getManager(idEmployee).getAlamat());
        }else if(nama_Jabatan.equalsIgnoreCase( "Pegawai")){
            System.out.println("Nama: "+ke.getPegawai(idEmployee).getNamaEmployee());
            System.out.println("Umur: "+ke.getPegawai(idEmployee).getUmur());
            System.out.println("Jabatan: "+ke.getPegawai(idEmployee).getNamaJabatan());
            System.out.println("Standar Gaji: "+ke.getPegawai(idEmployee).getStandarGaji());
            System.out.println("Nomor Telepon: "+ke.getPegawai(idEmployee).getNomorTelepon());
            System.out.println("Alamat: "+ke.getPegawai(idEmployee).getAlamat());
        }else{
            System.out.println("Jabatan tersebut tidak bisa diakses!");
        }
    }
    
    public void showDescAllEmployee(){
        KumpulanEmployee ke = new KumpulanEmployee();
        System.out.println("List Manager: ");
        ke.showAllManager();
        System.out.println("List Pegawai: ");
        ke.showAllPegawai();
    }
    
    public void showAdminIdentity(String id, String password){
        KumpulanAkunAdmin ka = new KumpulanAkunAdmin();
        System.out.println("ID Admin dan Password: "+ka.getAkun(id, password));
    }
}

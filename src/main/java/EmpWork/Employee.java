/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Iqro Banyuanto
 */
public abstract class Employee {
    private String idEmployee;
    protected String nama;
    private int umur;
    private String nomor_telepon;
    private String alamat;
    //Untuk menyimpan data kehadiran satu hari, dan tapping sistem satu employee
    public Kehadiran kartuKehadiran;
    //Untuk menyimpan record jam kerja selama sebulan
    public PerhitunganWaktu recordKerja;
    //Untuk menyimpan data gaji pegawai
    public PerhitunganGaji statusGaji;
    //untuk menyimpan tanggal dan waktu kehadiran
    public List<RecordKehadiran> list_kehadiran;
    
    public Employee(String idEmployee, String nama, int umur, String nomor_telepon, String alamat){
        this.idEmployee = idEmployee;
        this.nama = nama;
        this.umur = umur;
        this.nomor_telepon = nomor_telepon;
        this.alamat = alamat;
        kartuKehadiran = new Kehadiran();
        recordKerja = new PerhitunganWaktu();
        statusGaji = new PerhitunganGaji();
        list_kehadiran = new ArrayList();
    }
    
    public void setIdEmployee(String id){
        idEmployee = id;
    }
    
    public String getIdEmployee(){
        return idEmployee;
    }
    
    public void setNamaEmployee(String name){
        nama = name;
    }
    
    public String getNamaEmployee(){
        return nama;
    }
    
    public void setUmur(int umur){
        this.umur = umur;
    }
    
    public int getUmur(){
        return umur;
    }

    public void setNomorTelepon(String nomortelp){
        nomor_telepon = nomortelp;
    }
    
    public String getNomorTelepon(){
        return nomor_telepon;
    }
    
    public void setAlamat(String address){
        alamat = address;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public List<RecordKehadiran> getkehadiran(){
        return list_kehadiran;
    }
    
    public void showListKehadiran(){
        System.out.println("--Data Rekaman Kehadiran--");
        for(RecordKehadiran s : list_kehadiran){
            System.out.println("Kehadiran tanggal: "+s.getTanggal().toString());
            System.out.println("Jam Masuk: "+s.getWaktuMasuk().toString());
            System.out.println("Jam Keluar: "+s.getWaktuKeluar().toString());
            System.out.println("___________________");
        }
        System.out.println("------");
    }
    
    public abstract String getNamaJabatan();
    
    public abstract void showEmployee();
        
}

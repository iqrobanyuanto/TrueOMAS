/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import java.util.List;
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
    //Untuk menyimpan data gaji pegawai
    public PerhitunganGaji StatusGaji;
    //untuk menyimpan tanggal dan waktu kehadiran
    public List<String> list_kehadiran;
    
    public Employee(String nama, int umur, String nomor_telepon, String alamat){
        this.nama = nama;
        this.umur = umur;
        this.nomor_telepon = nomor_telepon;
        this.alamat = alamat;
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
    
    public void addkehadiran(String kehadiran){
        list_kehadiran.add(kehadiran);
    }
    
    public List<String> getkehadiran(){
        return list_kehadiran;
    }
    
    public abstract void showIdentity();
    
}

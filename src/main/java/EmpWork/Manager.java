/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;

import java.time.LocalTime;

/**
 *
 * @author Iqro Banyuanto
 */
public class Manager extends Employee{
     private String nama_jabatan;
  
     public Manager(String idEmployee, String namaEMP, int umur, String nomor_telepon, String alamat){
         super(idEmployee, namaEMP, umur, nomor_telepon, alamat);
         statusGaji.setStandarGaji(35000);
         kartuKehadiran.setStadarMasuk(LocalTime.of(11, 0, 0));
         kartuKehadiran.setStandarKeluar(LocalTime.of(15, 0, 0));
         nama_jabatan = "Manager";
     }
     
     @Override
     public String getNamaJabatan(){
         return nama_jabatan;
     }
     
     @Override
     public void showEmployee(){
        System.out.println("Jabatan: "+this.getNamaJabatan());
        System.out.println("Id Manager: "+this.getIdEmployee());
        System.out.println("Nama: "+this.getNamaEmployee());
        System.out.println("Umur: "+this.getUmur());
        System.out.println("Nomor Telepon: "+this.getNomorTelepon());
        System.out.println("Alamat: "+this.getAlamat());
        this.statusGaji.showDescGaji();
        this.kartuKehadiran.showStandarJamKerja();
        this.recordKerja.showDescJamKerja();
        this.showListKehadiran();
     }
         //test Liyan
     public String getDataManager(){
        String str = ("Jabatan: "+this.getNamaJabatan()+
                "Id Manager: "+this.getIdEmployee()+
                "Nama: "+this.getNamaEmployee()+
                "Umur: "+this.getUmur()+
                "Nomor Telepon: "+this.getNomorTelepon()+
                "Alamat: "+this.getAlamat());
        return str;
     }
}

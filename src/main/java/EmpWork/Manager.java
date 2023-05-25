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
     private int standargaji;
     private LocalTime standarJamMasuk;
     private LocalTime standarJamKeluar;
     public TiketLembur statusLembur;
     
     public Manager(String namaEMP, int umur, String nomor_telepon, String alamat){
         super(namaEMP, umur, nomor_telepon, alamat);
         statusLembur = new TiketLembur(nama);
         nama_jabatan = "Manager";
     }
     
     public String getNamaJabatan(){
         return nama_jabatan;
     }
     
     public void setStandarGaji(int standarGaji){
         this.standargaji = standarGaji;
     }
     
     public int getStandarGaji(){
         return standargaji;
     }
     
     public void setStadarMasuk(LocalTime standarjammasuk){
        standarJamMasuk = standarjammasuk; 
     }
     
     public LocalTime getStandarMasuk(){
         return standarJamMasuk;
     }
     
     public void setStandarKeluar(LocalTime standarjamkeluar){
         standarJamKeluar = standarjamkeluar;
     }
     
     public LocalTime getStandarKeluar(){
         return standarJamKeluar;
     }
     
     @Override
     public void showEmployee(){
         
     }
}

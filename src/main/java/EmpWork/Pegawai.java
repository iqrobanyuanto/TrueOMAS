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
public class Pegawai extends Employee{
     private String nama_jabatan;
     private int standargaji;
     private LocalTime standarJamMasuk;
     private LocalTime standarJamKeluar;
     public TiketLembur statusLembur;
     
     public Pegawai(String idEmployee, String namaEMP, int umur, String nomor_telepon, String alamat){
         super(idEmployee, namaEMP, umur, nomor_telepon, alamat);
         statusLembur = new TiketLembur(nama);
         nama_jabatan = "Pegawai";
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
     
     public void assignLembur(String pengizin, int lamalembur){
         statusLembur.setStatusLembur(pengizin, lamalembur);
     }
     
     @Override
     public void showEmployee(){
         
     }
     
}

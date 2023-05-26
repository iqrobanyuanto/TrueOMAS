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
     public TiketLembur statusLembur;
     
     public Pegawai(String idEmployee, String namaEMP, int umur, String nomor_telepon, String alamat){
         super(idEmployee, namaEMP, umur, nomor_telepon, alamat);
         statusLembur = new TiketLembur(nama);
         statusGaji.setStandarGaji(25000);
         kartuKehadiran.setStadarMasuk(LocalTime.of(8, 0, 0));
         kartuKehadiran.setStandarKeluar(LocalTime.of(17, 0, 0));
         nama_jabatan = "Pegawai";
     }
     
     @Override
     public String getNamaJabatan(){
         return nama_jabatan;
     }
     
     public void assignLembur(String pengizin, int lamalembur){
         statusLembur.setStatusLembur(pengizin, lamalembur);
     }
     
     @Override
     public void showEmployee(){
         
     }
     
}

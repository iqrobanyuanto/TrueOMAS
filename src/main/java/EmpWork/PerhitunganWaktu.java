/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;

/**
 *
 * @author Iqro Banyuanto
 */
public class PerhitunganWaktu {
    private int totalLembur;
    private int totalTerlambat;
    private int totalJamKerja;
    
    public void tambahTotalLembur(int jamLembur){
        totalLembur += jamLembur;
    }
    public int getTotalLembur(){
        return totalLembur;
    }
    public void tambahTotalTerlambat(int jamTerlambat){
        totalTerlambat += jamTerlambat;
    }
    public int getTotalTerlambat(){
        return totalTerlambat;
    }
    public void tambahTotaljamKerja(int lamaKerja){
        totalJamKerja = lamaKerja;
    }
    public int getTotalJamKerja(){
        return totalJamKerja;
    }
      //Belum ada algoritma untuk terlambat ketika saat jam masuk
      //Belum ada algoritma untuk mendapatkan waktu lama lembur
    
}

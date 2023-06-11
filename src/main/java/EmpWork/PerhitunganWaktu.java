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
    public void setTotalLembur(int totalLembur){
        this.totalLembur = totalLembur;
    }
    public int getTotalLembur(){
        return totalLembur;
    }
    public void tambahTotalTerlambat(int jamTerlambat){
        totalTerlambat += jamTerlambat;
    }
    public void setTotalTerlambat(int totalTerlambat){
        this.totalTerlambat = totalTerlambat;
    }
    public int getTotalTerlambat(){
        return totalTerlambat;
    }
    public void tambahTotaljamKerja(int lamaKerja){
        totalJamKerja = lamaKerja;
    }
    public void setTotalJamKerja(int totalJamKerja){
        this.totalJamKerja = totalJamKerja;
    }
    public int getTotalJamKerja(){
        return totalJamKerja;
    }
    public void showDescJamKerja(){
        System.out.println("--Deskripsi Kehadiran--");
        System.out.println("Total Waktu Lembur Bulan Ini: "+totalLembur+ " Jam");
        System.out.println("Total Waktu Terlambat Bulan Ini: "+ totalTerlambat+" Jam");
        System.out.println("Ekspektasi Total Waktu Kerja Bulan Ini: "+totalJamKerja+" Jam");
        System.out.println("Fakta Total Waktu Kerja Bulan Ini: "+ (totalJamKerja-totalTerlambat)+" Jam");
        System.out.println("------");
    }
}

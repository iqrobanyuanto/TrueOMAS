/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;

/**
 *
 * @author Iqro Banyuanto
 */
public class PerhitunganGaji {
    private int standargaji;
    private int totalGaji;
    
    public void setStandarGaji(int standarGaji){
        this.standargaji = standarGaji;
    }
    
    public int getStandarGaji(){
        return standargaji;
    }
    
    public void hitungTotalGaji_1Bulan(int totalLembur, int totalTerlambat, int totalJamKerja){
        totalGaji = standargaji * (totalLembur + (totalTerlambat - totalJamKerja));
    }
    
    public void setTotalGaji(int totalgaji){
        totalGaji = totalgaji;
    }
    
    public int getTotalJamGaji(){
        return totalGaji;
    }
    
    public void showDescGaji(){
        System.out.println("--Deskripsi Gaji--");
        System.out.println("Standar Gaji Per-Bulan: "+ standargaji);
        System.out.println("Total Gaji Bulan Ini: "+ totalGaji);
        System.out.println("------");
    }
}

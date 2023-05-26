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
    
    public int hitungTotalGaji_1Bulan(int totalLembur, int totalTerlambat, int totalJamKerja){
        totalGaji = standargaji * (totalLembur + (totalTerlambat - totalJamKerja));
        return totalGaji;
    }
    
    public int getTotalJamGaji(){
        return totalGaji;
    }
    
    public void showDescGaji(){
        System.out.println("Total Gaji: "+ totalGaji);
    }
}

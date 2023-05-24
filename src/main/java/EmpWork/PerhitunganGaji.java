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
    private int totalGaji;
    
    private int tambahTotalGaji(int standarGaji, int totalLembur, int totalTerlambat, int totalJamKerja){
        totalGaji = standarGaji * (totalLembur + (totalTerlambat - totalJamKerja));
        return totalGaji;
    }
    public int getTotalJamGaji(){
        return totalGaji;
    }
    public void showDescGaji(){
        System.out.println("Total Gaji: "+ totalGaji);
    }
}

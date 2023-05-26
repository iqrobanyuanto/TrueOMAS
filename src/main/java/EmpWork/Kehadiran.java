/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Iqro Banyuanto
 */
public class Kehadiran {
    private LocalTime standarJamMasuk;
    private LocalTime standarJamKeluar;
    private static LocalDateTime waktu_masuk;
    private static LocalDateTime waktu_keluar;
    private static int jam_masuk;
    private static int jam_keluar;
    
    public Kehadiran(){
        waktu_masuk = null;
        waktu_keluar = null;
        jam_masuk = -99;
        jam_keluar = -99;
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
    
    public void setWaktuMasuk(){
        waktu_masuk = LocalDateTime.now();
        jam_masuk = waktu_masuk.getHour();
    }
    
    public void setWaktuKeluar(){
        waktu_keluar = LocalDateTime.now();
        jam_keluar = waktu_keluar.getHour();
    }
    
    public void resetRecord(){
        waktu_masuk = null;
        waktu_keluar = null;
        jam_masuk = -99;
        jam_keluar = -99;
    }
    
    public int cekJamMasuk(){
        return jam_masuk;
    }
    
    public int cekJamKeluar(){
        return jam_keluar;
    }
    
    public String getWaktuMasuk(){
        return "Jam Masuk: "+waktu_masuk.toString();
    }
    
    public String getWaktuKeluar(){
        return "Jam Keluar: "+waktu_keluar.toString();
    }
    
    public void kalkulasiTotalJamKerja(){
        
    }
}

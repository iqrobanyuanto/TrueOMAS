/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import java.time.LocalDateTime;
/**
 *
 * @author Iqro Banyuanto
 */
public class Kehadiran {
    private boolean tapping;
    private LocalDateTime waktu_masuk;
    private LocalDateTime waktu_keluar;
    private int jam_masuk;
    private int jam_keluar;
    
    public Kehadiran(){
        tapping = false;
    }
    public void setWaktuMasuk(boolean tapping){
        waktu_masuk = LocalDateTime.now();
        jam_masuk = waktu_masuk.getHour();
    }
    public void setWaktuKeluar(boolean tapping){
        waktu_keluar = LocalDateTime.now();
        jam_keluar = waktu_keluar.getHour();
    }
    public void resetRecord(){
        waktu_masuk = null;
        waktu_keluar = null;
        jam_masuk = 0;
        jam_keluar = 0;
    }
    public String getWaktuMasuk(){
        return waktu_masuk.toString();
    }
    public String getWaktuKeluar(){
        return waktu_keluar.toString();
    }
    
    
}

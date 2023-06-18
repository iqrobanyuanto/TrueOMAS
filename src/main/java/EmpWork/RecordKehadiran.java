/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Iqro Banyuanto
 */
public class RecordKehadiran {
    private LocalDate tanggal;
    private LocalTime waktuMasuk;
    private LocalTime waktuKeluar;
    
    public void setTanggal(LocalDate r){
        tanggal = r;
    }
    public LocalDate getTanggal(){
        return tanggal;
    }
    public void setWaktuMasuk(LocalTime r){
        waktuMasuk = r;
    }
    public LocalTime getWaktuMasuk(){
        return waktuMasuk;
    }
    public void setWaktuKeluar(LocalTime r){
        waktuKeluar = r;
    }
    public LocalTime getWaktuKeluar(){
        return waktuKeluar;
    }
}

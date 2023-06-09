/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Iqro Banyuanto
 */
public class Kehadiran {
    private LocalTime standarJamMasuk;
    private LocalTime standarJamKeluar;
    private LocalDateTime waktu_masuk;
    private LocalDateTime waktu_keluar;
    private int jam_masuk;
    private int jam_keluar;
    
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
    
    public void setWaktu_Masuk(LocalDateTime waktuMasuk){
        waktu_masuk = waktuMasuk;
    }
    
    public void setWaktu_Keluar(LocalDateTime waktuKeluar){
        waktu_keluar = waktuKeluar;
    }
    
    public void setTappingWaktuMasuk(){
        if(LocalTime.now().isAfter(standarJamMasuk) && LocalTime.now().isBefore(standarJamKeluar)){
            waktu_masuk = LocalDateTime.now();
            jam_masuk = waktu_masuk.getHour();
        }else{
            System.out.println("Tapping masuk tak boleh diluar jam kerja");
        }
    }
    
    public LocalDateTime getWaktu_masuk(){
        if(waktu_masuk == null){
            System.out.println("Tidak ada waktu masuk yang tercatat");
            return null;
        }else{
            return waktu_masuk;
        }
    }
    
    public void setTappingWaktuKeluar(){
        if(LocalTime.now().isBefore(standarJamKeluar)){
            waktu_keluar = LocalDateTime.now();
            jam_keluar = waktu_keluar.getHour();
        }else{
            waktu_keluar = LocalDateTime.of(LocalDate.now(), standarJamKeluar);
            jam_keluar = waktu_keluar.getHour();
        }
    }
    
    public LocalDateTime getWaktu_keluar(){
        return waktu_keluar;
    }
    
    public void resetRecord(){
        waktu_masuk = null;
        waktu_keluar = null;
        jam_masuk = -99;
        jam_keluar = -99;
    }
    
    public void setJamMasuk(int jamMasuk){
        jam_masuk = jamMasuk;
    }
    
    public int cekJamMasuk(){
        return jam_masuk;
    }
    
    public void setJamKeluar(int jamKeluar){
        jam_keluar = jamKeluar;
    }
    
    public int cekJamKeluar(){
        return jam_keluar;
    }
    
    public void showStandarJamKerja(){
        System.out.println("--Deskripsi Standar Jam Kerja--");
        System.out.println("Standar Jam Masuk: "+ standarJamMasuk.toString());
        System.out.println("Standar Jam Keluar: " + standarJamKeluar.toString());
        System.out.println("------");
    }
}

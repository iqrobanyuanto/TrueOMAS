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
public class TiketLembur {
    private String namaPegawai;
    private LocalDate tanggal;
    private LocalTime waktuMulai;
    private LocalTime waktuAkhir;
    private String pengizin;
    private boolean statusTiket;
    
    public TiketLembur(){}
    public TiketLembur(String nama){
        namaPegawai = nama;
        tanggal = null;
        waktuMulai = null;
        waktuAkhir = null;
        pengizin = "";
        statusTiket = false;
    }
    public void setTanggal(LocalDate r){
        tanggal = r;
    }
    public LocalDate getTanggal(){
        return tanggal;
    }
    public void setWaktuMulai(LocalTime r){
        waktuMulai = r;
    }
    public LocalTime getWaktuMulai(){
        return waktuMulai;
    }
    public void setWaktuAkhir(LocalTime r){
        waktuAkhir = r;
    }
    public LocalTime getWaktuAkhir(){
        return waktuAkhir;
    }
    public void setNamaPegawai(String namaPegawai){
        this.namaPegawai = namaPegawai;
    }
    public String getNamaPegawai(){
        return namaPegawai;
    }
    public void setPengizin(String pengizin){
        this.pengizin = pengizin;
    }
    public String getPengizin(){
        return pengizin;
    }
    public void setStatusTiket(boolean statusTiket){
        this.statusTiket = statusTiket;
    }
    public boolean getStatusTiket(){
        return statusTiket;
    }
    public void setStatusLembur(String pengizin, LocalDate tanggalLembur, LocalTime waktuMulai, LocalTime waktuBerakhir){
        tanggal = tanggalLembur;
        this.waktuMulai = waktuMulai;
        waktuAkhir = waktuBerakhir;
        this.pengizin = pengizin;
        statusTiket = true;
    }
    public void resetStatus(){
        if(statusTiket == true){
            tanggal = null;
            waktuMulai = null;
            waktuAkhir = null;
            this.pengizin = "";
            statusTiket = false;
        }
    }
    /*
    public void showTiketDesc(){
        System.out.println("---Tiket Lembur---");
        System.out.println("Nama Pegawai: "+ namaPegawai+"\n Lama lembur: "+ waktuLembur +" jam \n "+ "Pengizin: "+pengizin+" \n Status lembur: "+ statusTiket);
    }
    */
}

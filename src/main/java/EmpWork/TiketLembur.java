/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;

/**
 *
 * @author Iqro Banyuanto
 */
public class TiketLembur {
    private String namaPegawai;
    private int waktuLembur;
    private String pengizin;
    private boolean statusTiket;
    
    public TiketLembur(String nama){
        namaPegawai = nama;
        statusTiket = false;
    }
    public void setStatusLembur(String pengizin, int waktulembur){
        waktuLembur = waktulembur;
        this.pengizin = pengizin;
        statusTiket = true;
    }
    public void resetStatus(){
        if(statusTiket == true){
            waktuLembur = 0;
            this.pengizin = "";
            statusTiket = false;
        }
    }
    public void showTiketDesc(){
        System.out.println("---Tiket Lembur---");
        System.out.println("Nama Pegawai: "+ namaPegawai+"\n Lama lembur: "+ waktuLembur +" jam \n "+ "Pengizin: "+pengizin+" \n Status lembur: "+ statusTiket);
    }
}

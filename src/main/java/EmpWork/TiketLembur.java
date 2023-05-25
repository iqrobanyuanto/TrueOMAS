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
    private boolean statuslembur;
    
    public TiketLembur(String nama){
        namaPegawai = nama;
        statuslembur = false;
    }
    public boolean setStatusLembur(String pengizin, int waktulembur){
        waktuLembur = waktulembur;
        this.pengizin = pengizin;
        statuslembur = true;
        return statuslembur;
    }
    public void showTiketDesc(){
        System.out.println("---Tiket Lembur---");
        System.out.println("Nama Pegawai: "+ namaPegawai+"\n Lama lembur: "+ waktuLembur +" jam \n "+ "Pengizin: "+pengizin+" \n Status lembur: "+ statuslembur);
    }
}

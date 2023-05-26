/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmWork;

import DBPr.KumpulanAkunAdmin;

/**
 *
 * @author Iqro Banyuanto
 */
public class Login {
    public String id;
    public String password;
    
//    Cara pakainya panggil dulu getAkun sebelum verifikasiAkun sama jangan lupa dibuatkan dulu objek Login.
//    Login l = new Login();
//    l.getAkun([id akun], [password akun]);
//    l.verifikasiAkun();
    public Login(){
    }
    
    public void getAkun(String id, String password){
        this.id = id;
        this.password = password;
    }
    
    public void verifikasiAkun(){
        
        KumpulanAkunAdmin k = new KumpulanAkunAdmin();
        try{
            if(k.getAkun(id, password) == null){
                throw new Exception("Id atau password salah");
            }
//          @MAx @Liyan Nanti isi kode dibawah ini, apa yang terjadi kalau id dan password BENAR
            System.out.println("Benar");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

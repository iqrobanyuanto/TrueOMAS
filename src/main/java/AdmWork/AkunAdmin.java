/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdmWork;

/**
 *
 * @author Iqro Banyuanto
 */
public class AkunAdmin {
    private String id;
    private String password;
    private String namaAdmin;
    
    public AkunAdmin(String id, String password, String namaAdmin){
        this.id = id;
        this.password = password;
        this.namaAdmin  = namaAdmin;
    }
    public String getid(){
        return id;
    }
    public String getpassword(){
        return password;
    }
    public String getnamaAdmin(){
        return namaAdmin;
    }
}

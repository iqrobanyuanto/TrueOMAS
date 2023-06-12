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
    
    public AkunAdmin(){
        
    }
    public AkunAdmin(String id, String password, String namaAdmin){
        this.id = id;
        this.password = password;
        this.namaAdmin  = namaAdmin;
    }
    public void setid(String id){
        this.id = id;
    }
    public String getid(){
        return id;
    }
    public void setpassword(String password){
        this.password = password;
    }
    public String getpassword(){
        return password;
    }
    public void setnamaAdmin(String namaAdmin){
        this.namaAdmin = namaAdmin;
    }
    public String getnamaAdmin(){
        return namaAdmin;
    }
}

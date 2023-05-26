package DBPr;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.List;
import java.util.ArrayList;
import AdmWork.AkunAdmin;
/**
 *
 * @author Iqro Banyuanto
 */
public class KumpulanAkunAdmin {
    private static List<AkunAdmin> listAkunAdmin = new ArrayList();
    
    public void addAkun(AkunAdmin akun){
        listAkunAdmin.add(akun);
    }
    public void hapusAkun(String id){
        for(AkunAdmin s : listAkunAdmin){
            if(s.getid().equals(id)){
                listAkunAdmin.remove(s);
                break;
            }
        }
    }
    public AkunAdmin getAkun(String id, String password){
        for(AkunAdmin s : listAkunAdmin){
            if(s.getid().equals(id) && s.getpassword().equals(password)){
                return s;
            }
        }
        return null;
    }
    public List<AkunAdmin> getListAkun(){
        return listAkunAdmin;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBPr;
import EmpWork.Manager;
import EmpWork.Pegawai;
import EmpWork.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iqro Banyuanto
 */
public class KumpulanEmployee {
    private static List<Manager> listManager = new ArrayList();
    private static List<Pegawai> listPegawai = new ArrayList(); 
    
    public void addManager(Manager manager){
        listManager.add(manager);
    }
    public void hapusManager(String idEmployee){
        for(Manager s : listManager){
            if(s.getIdEmployee().equals(idEmployee)){
                listManager.remove(s);
                break;
            }
        }
    }
        public void addPegawai(Pegawai pegawai){
        listPegawai.add(pegawai);
    }
    public void hapusPegawai(String idEmployee){
        for(Pegawai s : listPegawai){
            if(s.getIdEmployee().equals(idEmployee)){
                listPegawai.remove(s);
                break;
            }
        }
    }
    public Manager getManager(String idEmployee){
        for(Manager s : listManager){
            if(s.getIdEmployee().equals(idEmployee)){
                return s;
            }
        }
        return null;
    }
    
    public List<Manager> getListManager(){
        return listManager;
    }
    
    public Pegawai getPegawai(String idEmployee){
        for(Pegawai s : listPegawai){
            if(s.getIdEmployee().equals(idEmployee)){
                return s;
            }
        }
        return null;
    }

    public List<Pegawai> getListPegawai(){
        return listPegawai;
    }    
    
    public void showAllManager(){
        System.out.println("List Manager: ");
        System.out.println("_____________");
        for(Manager s: listManager){
            s.showEmployee();
            System.out.println("");
        }
    }
    public void showAllPegawai(){
        System.out.println("List Pegawai: ");
        System.out.println("_____________");
        for(Pegawai s: listPegawai){
            s.showEmployee();
            System.out.println("");
        }
    }
    public Employee searchEmployee(String namaJabatan, String idEmployee){
        if(namaJabatan.equals("Manager")){
            return getManager(idEmployee);
        }else if(namaJabatan.equals("Pegawai")){
            return getPegawai(idEmployee);
        }else{
            return null;
        }
    }
}

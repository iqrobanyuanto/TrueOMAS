/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import DBPr.KumpulanEmployee;
/**
 *
 * @author Iqro Banyuanto
 */
public class Tapping {
    public Tapping(String namaJabatan, String idEmployee){
        try{
            KumpulanEmployee r = new KumpulanEmployee();
            Employee q = r.searchEmployee(namaJabatan, idEmployee);
            if(q.kartuKehadiran.cekJamMasuk() == -99){
                q.kartuKehadiran.setWaktuMasuk();
                q.list_kehadiran.add(q.kartuKehadiran.getWaktuMasuk());
            }else{
                q.kartuKehadiran.setWaktuKeluar();
                q.list_kehadiran.add(q.kartuKehadiran.getWaktuKeluar());
                q.kartuKehadiran.resetRecord();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void prosesKalkulasi(Employee emp){
        if(emp.kartuKehadiran.getWaktu_masuk().getHour() > emp.kartuKehadiran.getStandarMasuk().getHour()){
            
        }
    }
}

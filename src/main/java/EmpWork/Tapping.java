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
            if(q == null){
                throw new IllegalArgumentException("Employee tidak ditemukan");
            }
            if(q.kartuKehadiran.cekJamMasuk() == -99){
                q.kartuKehadiran.setWaktuMasuk();
                q.list_kehadiran.add(q.kartuKehadiran.getWaktuMasuk());
            }else{
                q.kartuKehadiran.setWaktuKeluar();
                q.list_kehadiran.add(q.kartuKehadiran.getWaktuKeluar());
                prosesTambahTotalJamKerja(q);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private void prosesTambahTotalJamKerja(Employee emp){
        if(emp.kartuKehadiran.getWaktu_masuk().getHour() > emp.kartuKehadiran.getStandarMasuk().getHour()){
             emp.recordKerja.tambahTotalTerlambat(emp.kartuKehadiran.getWaktu_masuk().getHour() - emp.kartuKehadiran.getStandarMasuk().getHour());
        }
        emp.recordKerja.tambahTotaljamKerja(emp.kartuKehadiran.getStandarMasuk().getHour());
        emp.kartuKehadiran.resetRecord();
    }
}

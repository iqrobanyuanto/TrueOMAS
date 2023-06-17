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
    public static void Tap(String namaJabatan, String idEmployee){
        try{
            KumpulanEmployee r = new KumpulanEmployee();
            Employee q = r.searchEmployee(namaJabatan, idEmployee);
            if(q == null){
                throw new IllegalArgumentException("Employee tidak ditemukan");
            }
            if(q.kartuKehadiran.cekJamMasuk() == -99){
                q.kartuKehadiran.setTappingWaktuMasuk();
                
                if(q.kartuKehadiran.getWaktu_masuk() == null){
                    LogKehadiran e = new LogKehadiran();
                    e.setTanggal(q.kartuKehadiran.getWaktu_masuk().toLocalDate());
                    e.setWaktuMasuk(q.kartuKehadiran.getWaktu_masuk().toLocalTime());
                    q.list_kehadiran.add(e);
                }
            }else{
                q.kartuKehadiran.setTappingWaktuKeluar();
                LogKehadiran e = q.list_kehadiran.get(q.list_kehadiran.size());
                e.setWaktuKeluar(q.kartuKehadiran.getWaktu_keluar().toLocalTime());
                prosesTambahTotalJamKerja(q);
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static void prosesTambahTotalJamKerja(Employee emp){
        if(emp.kartuKehadiran.getWaktu_masuk().getHour() > emp.kartuKehadiran.getStandarMasuk().getHour()){
             emp.recordKerja.tambahTotalTerlambat(emp.kartuKehadiran.getWaktu_masuk().getHour() - emp.kartuKehadiran.getStandarMasuk().getHour());
        }
        emp.recordKerja.tambahTotaljamKerja(emp.kartuKehadiran.getStandarMasuk().getHour());
        emp.kartuKehadiran.resetRecord();
    }
}

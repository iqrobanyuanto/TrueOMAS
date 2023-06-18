/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import Dao.KehadiranDao;
import Dao.RecordKehadiranDao;
/**
 *
 * @author Iqro Banyuanto
 */
public class Tapping {
    public static void Tap(Employee q){
        try{
            if(q == null){
                throw new IllegalArgumentException("Employee tidak ditemukan");
            }
            KehadiranDao DBkehadiran = new KehadiranDao();
            if(q.kartuKehadiran.cekJamMasuk() == -99){
                q.kartuKehadiran.setTappingWaktuMasuk();
                DBkehadiran.updateKartuKehadiran(q.kartuKehadiran, q.getIdEmployee(), q.getNamaJabatan());
            }else{
                q.kartuKehadiran.setTappingWaktuKeluar();
                RecordKehadiran e = new RecordKehadiran();
                e.setTanggal(q.kartuKehadiran.getWaktu_masuk().toLocalDate());
                e.setWaktuMasuk(q.kartuKehadiran.getWaktu_masuk().toLocalTime());
                e.setWaktuKeluar(q.kartuKehadiran.getWaktu_keluar().toLocalTime());
                RecordKehadiranDao a = new RecordKehadiranDao();
                a.insertLog(e, q);
                prosesTambahTotalJamKerja(q);
                DBkehadiran.updateKartuKehadiran(q.kartuKehadiran, q.getIdEmployee(), q.getNamaJabatan());
                
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmpWork;
import Dao.KehadiranDao;
import Dao.PerhitunganWaktuDao;
import Dao.RecordKehadiranDao;
import Dao.TiketLemburDao;
import java.time.LocalDate;
import java.time.LocalTime;
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
            //Pengecekan antara pegawai atau manager
            if(q.getNamaJabatan().equals("Manager")){
                q.kartuKehadiran = DBkehadiran.getKehadiran(q.getIdEmployee(), q.getNamaJabatan());
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
            }else{
                TiketLemburDao tkt = new TiketLemburDao();
                Pegawai p = (Pegawai)q;
                p.statusLembur = tkt.getTiketLembur(p.getIdEmployee());
                //Penentuan Tapping diluar jam kerja atau dalam jam kerja
                if(LocalTime.now().isAfter(p.kartuKehadiran.getStandarKeluar()) && LocalTime.now().isBefore(p.kartuKehadiran.getStandarMasuk())){
                    //Pengecekan nilai null pada tanggal waktu status lembur 
                    if(p.statusLembur.getTanggal() != null && p.statusLembur.getWaktuMulai() != null && p.statusLembur.getWaktuAkhir() != null){
                        //Pengecekan kebolehan untuk mulai tapping lembur
                        if( p.statusLembur.getTanggal().equals(LocalDate.now()) && LocalTime.now().isAfter(p.statusLembur.getWaktuMulai()) && LocalTime.now().isBefore(p.statusLembur.getWaktuAkhir())){
                            prosesTambahTotalJamLembur(p);
                            p.statusLembur.resetStatus();
                            tkt.updateTiketLembur(p.statusLembur, p);
                        }else{
                            System.out.println("Waktu Lembur "+ p.getIdEmployee()+" belum dimulai");
                        }                
                    }else{
                        System.out.println("Pegawai dengan id "+p.getIdEmployee()+" belum membuat tiket lembur");
                    }
                }else{
                    q.kartuKehadiran = DBkehadiran.getKehadiran(q.getIdEmployee(), q.getNamaJabatan());
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
                }
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }   
    private static void prosesTambahTotalJamKerja(Employee emp){
        PerhitunganWaktuDao waktu = new PerhitunganWaktuDao();
        emp.recordKerja = waktu.getPerhitunganWaktu(emp.getIdEmployee(), emp.getNamaJabatan());
        if(emp.kartuKehadiran.getWaktu_masuk().getHour() > emp.kartuKehadiran.getStandarMasuk().getHour()){
             emp.recordKerja.tambahTotalTerlambat(emp.kartuKehadiran.getWaktu_masuk().getHour() - emp.kartuKehadiran.getStandarMasuk().getHour());
        }
        emp.recordKerja.tambahTotaljamKerja(emp.kartuKehadiran.getStandarMasuk().getHour());
        waktu.updatePerhitunganWaktu(emp.recordKerja, emp.getIdEmployee(), emp.getNamaJabatan());
        emp.kartuKehadiran.resetRecord();
    }
    
    private static void prosesTambahTotalJamLembur(Pegawai p){
        PerhitunganWaktuDao waktu = new PerhitunganWaktuDao();
        p.recordKerja = waktu.getPerhitunganWaktu(p.getIdEmployee(), p.getNamaJabatan());
        p.recordKerja.tambahTotalLembur(p.statusLembur.getWaktuAkhir().getHour() - p.statusLembur.getWaktuMulai().getHour());
        waktu.updatePerhitunganWaktu(p.recordKerja, p.getIdEmployee(), p.getNamaJabatan());
    }
}

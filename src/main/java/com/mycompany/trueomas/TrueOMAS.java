/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trueomas;

import Dao.*;
import EmpWork.Manager;
import EmpWork.Pegawai;
import EmpWork.RecordKehadiran;
import EmpWork.Tapping;
import controller.ControllerApp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Iqro Banyuanto
 */
public class TrueOMAS {

    public static void main(String[] args) {
        
//        EmployeeDao dao = new EmployeeDao();
//        KehadiranDao dao1 = new KehadiranDao();
//        PerhitunganGajiDao dao2 = new PerhitunganGajiDao();
//        PerhitunganWaktuDao dao3 = new PerhitunganWaktuDao();
//        RecordKehadiranDao dao4 = new RecordKehadiranDao();
//        TiketLemburDao dao5 = new TiketLemburDao();
////        Manager man = new Manager("111","Irqo",20,"08132213122","Banjar");
////        dao.insertEmployee(man.getIdEmployee(), man.getNamaEmployee(), man.getUmur(), man.getNomorTelepon(), man.getAlamat(), man.getNamaJabatan());
////        dao1.insertKartuKehadiran(man.kartuKehadiran, man.getIdEmployee(), man.getNamaJabatan());
////        dao2.insertPerhitunganGaji(man.statusGaji, man.getIdEmployee(), man.getNamaJabatan());
////        dao3.insertPerhitunganWaktu(man.recordKerja, man.getIdEmployee(), man.getNamaJabatan());
//        Manager man = dao.getManager("111");
//        man.kartuKehadiran = dao1.getKehadiran(man.getIdEmployee(), man.getNamaJabatan());
//        man.list_kehadiran = dao4.getAllLog(man);
//        man.kartuKehadiran.setStandarKeluar(LocalTime.of(18, 0, 0));
//        dao1.updateKartuKehadiran(man.kartuKehadiran, man.getIdEmployee(), man.getNamaJabatan());
//        man.showEmployee();
//        man.kartuKehadiran.setWaktu_Masuk(LocalDateTime.now());
//        dao1.updateKartuKehadiran(man.kartuKehadiran, man.getIdEmployee(), man.getNamaJabatan());
//        System.out.println(man.kartuKehadiran.getWaktu_masuk().toString());
//        Tapping.Tap(man);
        
          ControllerApp ck = new ControllerApp();
          ck.showLogKehadiran();
        //Pegawai peg = new Pegawai("111","Irqo",20,"08132213122","Banjar");
//        Pegawai peg = dao.getPegawai("111");
//        peg.statusLembur = dao5.getTiketLembur("111");
//        //dao.insertEmployee(peg.getIdEmployee(), peg.getNamaEmployee(), peg.getUmur(), peg.getNomorTelepon(), peg.getAlamat(), peg.getNamaJabatan());
//        //dao1.insertKartuKehadiran(peg.kartuKehadiran, peg.getIdEmployee(), peg.getNamaJabatan());
//        //dao2.insertPerhitunganGaji(peg.statusGaji, peg.getIdEmployee(), peg.getNamaJabatan());
//        //dao3.insertPerhitunganWaktu(peg.recordKerja, peg.getIdEmployee(), peg.getNamaJabatan());
//        //dao5.insertTiketLembur(peg.statusLembur, peg);
//        //peg.statusLembur.setStatusLembur("Rod", LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(3));
//        System.out.println(peg.statusLembur.getNamaPegawai());
//        System.out.println(peg.statusLembur.getPengizin());
//        System.out.println(peg.statusLembur.getTanggal());
//        System.out.println(peg.statusLembur.getWaktuMulai());
//        System.out.println(peg.statusLembur.getWaktuAkhir());
//        System.out.println(peg.statusLembur.getStatusTiket());
        //dao5.updateTiketLembur(peg.statusLembur, peg);
        //dao5.deleteTiketLembur(peg.getIdEmployee());
        //dao3.deletePerhitunganWaktu(peg.getIdEmployee(), peg.getNamaJabatan());
        //dao2.deletePerhitunganGaji(peg.getIdEmployee(), peg.getNamaJabatan());
        //dao1.deleteKartuKehadiran(peg.getIdEmployee(), peg.getNamaJabatan());
        //dao.deleteEmployee(peg.getIdEmployee(), peg.getNamaJabatan());
        
    }
}

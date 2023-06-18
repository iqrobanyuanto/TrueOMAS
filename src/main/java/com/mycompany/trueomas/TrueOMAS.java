/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trueomas;

import Dao.*;
import EmpWork.Manager;
import EmpWork.RecordKehadiran;
import EmpWork.Tapping;
import java.time.LocalTime;

/**
 *
 * @author Iqro Banyuanto
 */
public class TrueOMAS {

    public static void main(String[] args) {
        
        EmployeeDao dao = new EmployeeDao();
        KehadiranDao dao1 = new KehadiranDao();
        PerhitunganGajiDao dao2 = new PerhitunganGajiDao();
        PerhitunganWaktuDao dao3 = new PerhitunganWaktuDao();
        RecordKehadiranDao dao4 = new RecordKehadiranDao();
        //Manager man = new Manager("111","Irqo",20,"08132213122","Banjar");
        //dao.insertEmployee(man.getIdEmployee(), man.getNamaEmployee(), man.getUmur(), man.getNomorTelepon(), man.getAlamat(), man.getNamaJabatan());
        //dao1.insertKartuKehadiran(man.kartuKehadiran, man.getIdEmployee(), man.getNamaJabatan());
        //dao2.insertPerhitunganGaji(man.statusGaji, man.getIdEmployee(), man.getNamaJabatan());
        //dao3.insertPerhitunganWaktu(man.recordKerja, man.getIdEmployee(), man.getNamaJabatan());
        Manager man = dao.getManager("111");
        man.kartuKehadiran = dao1.getKehadiran(man.getIdEmployee(), man.getNamaJabatan());
        man.list_kehadiran = dao4.getAllLog(man);
        //man.kartuKehadiran.setStandarKeluar(LocalTime.of(18, 0, 0));
        //dao1.updateKartuKehadiran(man.kartuKehadiran, man.getIdEmployee(), man.getNamaJabatan());
        man.showEmployee();
        //System.out.println(man.kartuKehadiran.getWaktu_masuk().toString());
        //Tapping.Tap(man);
        
    }
}

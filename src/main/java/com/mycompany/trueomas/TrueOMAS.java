/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trueomas;
import AdmWork.*;
import DBPr.*;
import Dao.EmployeeDao;
import EmpWork.*;
/**
 *
 * @author Iqro Banyuanto
 */
public class TrueOMAS {

    public static void main(String[] args) {
        KumpulanAkunAdmin a = new KumpulanAkunAdmin();
        KumpulanEmployee b = new KumpulanEmployee();
        EmployeeDao dao = new EmployeeDao();
        a.addAkun(new AkunAdmin("hentai", "baka", "regy"));
        
        /*Test Process non database
        Administrator q = new Administrator("hentai", "baka");
        q.showAdminIdentity();
        q.addEmployee("Manager", "1", "rudi", 12, "21321332", "Bandung");
        q.addEmployee("Pegawai", "1", "rasi", 15, "32132132", "Jakarta");
        q.assignLembur("1", 3, "rudi");
        q.resetStatusLembur("1");
        Tapping.Tap("Pegawai", "1");
        Tapping.Tap("Pegawai", "1");
        q.showDescAllEmployee();
        */
        
        //Test Process with database
        Pegawai peg = new Pegawai("1", "rasi", 15, "32132132", "Jakarta");
        dao.insertEmployee(peg);
        
    }
}

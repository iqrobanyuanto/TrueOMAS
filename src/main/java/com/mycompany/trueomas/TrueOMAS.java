/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trueomas;
import AdmWork.*;
import DBPr.*;
import EmpWork.*;
/**
 *
 * @author Iqro Banyuanto
 */
public class TrueOMAS {

    public static void main(String[] args) {
        KumpulanAkunAdmin a = new KumpulanAkunAdmin();
        KumpulanEmployee b = new KumpulanEmployee();
        a.addAkun(new AkunAdmin("hentai", "baka", "regy"));
        
        //Test Process
        Administrator q = new Administrator("hentai", "baka");
        q.showAdminIdentity();
        q.addEmployee("Manager", "1", "rudi", 12, "21321332", "Bandung");
        q.addEmployee("Pegawai", "1", "rasi", 15, "32132132", "Jakarta");
        q.assignLembur("1", 3, "rudi");
        q.resetStatusLembur("1");
        q.showDescAllEmployee();
    }
}

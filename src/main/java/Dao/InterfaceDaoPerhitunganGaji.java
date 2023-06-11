/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import EmpWork.PerhitunganGaji;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoPerhitunganGaji {
    public abstract void insertPerhitunganGaji(PerhitunganGaji statusGaji, String idEmployee, String namaJabatan);
    public abstract void updatePerhitunganGaji(PerhitunganGaji statusGaji, String idEmployee, String namaJabatan);
    public abstract void deletePerhitunganGaji(String idEmployee, String namaJabatan);
    public abstract PerhitunganGaji getPerhiitunganGaji(String idEmployee, String namaJabatan);
}

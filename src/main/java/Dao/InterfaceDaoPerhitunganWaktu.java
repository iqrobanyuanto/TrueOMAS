/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import EmpWork.PerhitunganWaktu;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoPerhitunganWaktu {
    public abstract void insertPerhitunganWaktu(PerhitunganWaktu recordKerja, String idEmployee, String namaJabatan);
    public abstract void deletePerhitunganWaktu(String idEmployee, String namaJabatan);
    public abstract void updatePerhitunganWaktu(PerhitunganWaktu recordKerja, String idEmployee, String namaJabatan);
    public abstract PerhitunganWaktu getPerhitunganWaktu(String idEmployee, String namaJabatan);
}

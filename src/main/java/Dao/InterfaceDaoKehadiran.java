/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import EmpWork.Kehadiran;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoKehadiran {
    public abstract void insertKartuKehadiran(Kehadiran kartu, String idEmployee, String namaJabatan);
    public abstract void updateKartuKehadiran(Kehadiran kartu, String idEmployee, String namaJabatan);
    public abstract void deleteKartuKehadiran(String idEmployee, String namaJabatan);
    public Kehadiran getKehadiran(String idEmployee, String namaJabatan);
}

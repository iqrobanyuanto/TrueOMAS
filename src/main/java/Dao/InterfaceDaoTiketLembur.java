/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import EmpWork.TiketLembur;
/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoTiketLembur {
    public abstract void insertTiketLembur(TiketLembur statusLembur, String idPegawai);
    public abstract void deleteTiketLembur(String idPegawai);
    public abstract void updateTiketLembur(TiketLembur statusLembur, String idPegawai);
    public abstract TiketLembur getTiketLembur(String idPegawai);
}

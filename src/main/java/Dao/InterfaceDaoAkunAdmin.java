/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import AdmWork.AkunAdmin;
import java.util.List;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoAkunAdmin {
    //Masukin akun admin
    public abstract void insertAkunAdmin(AkunAdmin akun);
    //update akun admin berdasarkan id akun yang terdapat dalam konfigurasi AkunAdmin yang ingin di update
    public abstract void updateAkunAdmin(AkunAdmin akun);
    //delete akun admin berdasarkan id
    public abstract void deleteAkunAdmin(String id);
    //dapeting list berisikan semua akun admin
    public abstract List<AkunAdmin> getAllAkunAdmin();
}

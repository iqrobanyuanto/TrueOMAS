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
    public abstract void insertKartuKehadiran();
    public abstract void updateKartuKehadiran();
    public abstract void deleteKartuKehadiran();
    public abstract Kehadiran getKehadiran();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoRecordKehadiran {
    public abstract void insertRecord(LocalDateTime record, String idEmployee, String namaJabatan);
    public abstract void deleteAllRecord(String idEmployee, String namaJabatan);
    public abstract List<LocalDateTime> getRecordKehadiran(String idEmployee, String namaJabatan);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import EmpWork.Employee;
import EmpWork.RecordKehadiran;
import java.util.List;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoRecordKehadiran {
    public abstract void insertLog(RecordKehadiran log, Employee e);
    public abstract void updateLog(RecordKehadiran log, Employee e);
    public abstract void deleteAllLog(Employee e);
    public abstract List<RecordKehadiran> getAllLog(Employee e);
}

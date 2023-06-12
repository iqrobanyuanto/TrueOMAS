/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import EmpWork.Employee;
import EmpWork.Manager;
import EmpWork.Pegawai;
import java.util.List;

/**
 *
 * @author Iqro Banyuanto
 */
public interface InterfaceDaoEmployee {
    public abstract void insertEmployee(String idEmployee, String nama, int umur, String nomor_telepon, String alamat, String namaJabatan);
    public abstract void deleteEmployee(String id, String namaEmployee);
    public abstract void updateEmployee(Employee emp);
    public abstract Pegawai getPegawai(String id);
    public abstract List<Pegawai> getAllPegawai();
    public abstract Manager getManager(String id);
    public abstract List<Manager> getAllManager();
}

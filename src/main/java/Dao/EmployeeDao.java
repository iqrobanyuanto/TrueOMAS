/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.Employee;
import EmpWork.Manager;
import EmpWork.Pegawai;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class EmployeeDao implements InterfaceDaoEmployee{
    @Override
    public void insertEmployee(String idEmployee, String nama, int umur, String nomor_telepon, String alamat, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "INSERT INTO Manager(idManager, namaJabatan, nama, umur, nomor_telepon, alamat) VALUES(?,?,?,?,?,?)";
            info = "Manager baru telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO Pegawai(idPegawai, namaJabatan, nama, umur, nomor_telepon, alamat) VALUES(?,?,?,?,?,?)";
            info = "Pegawai baru telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idEmployee);
             statement.setString(2, namaJabatan);
             statement.setString(3, nama);
             statement.setInt(4, umur);
             statement.setString(5, nomor_telepon);
             statement.setString(6, alamat);
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void deleteEmployee(String id, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "DELETE FROM Manager WHERE idManager = ?";
            info = "Manager dengan id [" + id +"] telah dihapus";
        }else{
            sql = "DELETE FROM Pegawai WHERE idPegawai = ?";
            info = "Pegawai dengan id [" + id +"] telah dihapus";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, id);
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void updateEmployee(Employee emp){
        String sql;
        String info;
        if(emp.getNamaJabatan().equals("Manager")){
            sql = "UPDATE Manager SET nama = ?, umur = ?, nomor_telepon = ?, alamat = ? WHERE idManager = "+ emp.getIdEmployee();
            info = "data Manager dengan id "+emp.getIdEmployee()+" telah dilakukan update";
        }else{
            sql = "UPDATE Pegawai SET nama = ?, umur = ?, nomor_telepon = ?, alamat = ? WHERE idPegawai = "+ emp.getIdEmployee();
            info = "data Pegawai dengan id "+emp.getIdEmployee()+" telah dilakukan update";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, emp.getNamaEmployee());
             statement.setInt(2, emp.getUmur());
             statement.setString(3, emp.getNomorTelepon());
             statement.setString(4, emp.getAlamat());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public Pegawai getPegawai(String id){
        Pegawai pegawai = null;
        String sql;
        sql = "SELECT * FROM Pegawai WHERE idPegawai = " + id;
         try (Statement statement = DBConnection.getConnection().createStatement()) {
             ResultSet result = statement.executeQuery(sql);
             if(result.next()){
                 String idpegawai = result.getString("idPegawai");
                 String nama = result.getString("nama");
                 int umur = result.getInt("umur");
                 String nomortelp = result.getString("nomor_telepon");
                 String alamat = result.getString("alamat");
                 pegawai = new Pegawai(idpegawai, nama, umur, nomortelp, alamat);
                 
                 statement.close();
             }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return pegawai;
    }
    @Override
    public List<Pegawai> getAllPegawai(){
        List<Pegawai> listPegawai = new ArrayList();
        String sql = "SELECT * FROM Pegawai";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                 String idpegawai = result.getString("idPegawai");
                 String nama = result.getString("nama");
                 int umur = result.getInt("umur");
                 String nomortelp = result.getString("nomor_telepon");
                 String alamat = result.getString("alamat");
                Pegawai peg = new Pegawai(idpegawai, nama, umur, nomortelp, alamat);
                listPegawai.add(peg);
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return listPegawai;
    }
    @Override
    public Manager getManager(String id){
        Manager manager = null;
        String sql;
        sql = "SELECT * FROM Manager WHERE idManager = " + id;
         try (Statement statement = DBConnection.getConnection().createStatement()) {
             ResultSet result = statement.executeQuery(sql);
             if(result.next()){
                 String idpegawai = result.getString("idManager");
                 String nama = result.getString("nama");
                 int umur = result.getInt("umur");
                 String nomortelp = result.getString("nomor_telepon");
                 String alamat = result.getString("alamat");
                 manager = new Manager(idpegawai, nama, umur, nomortelp, alamat);
                 
                 statement.close();
             }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return manager;
    }
    @Override
    public List<Manager> getAllManager(){
        List<Manager> listManager = new ArrayList();
        String sql = "SELECT * FROM Manager";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                 String idManager = result.getString("idManager");
                 String nama = result.getString("nama");
                 int umur = result.getInt("umur");
                 String nomortelp = result.getString("nomor_telepon");
                 String alamat = result.getString("alamat");
                Manager peg = new Manager(idManager, nama, umur, nomortelp, alamat);
                listManager.add(peg);
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return listManager;
    }
}

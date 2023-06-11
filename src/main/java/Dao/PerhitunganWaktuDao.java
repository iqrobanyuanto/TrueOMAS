/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.PerhitunganWaktu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class PerhitunganWaktuDao implements InterfaceDaoPerhitunganWaktu{
    @Override
    public void insertPerhitunganWaktu(PerhitunganWaktu recordKerja, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "INSERT INTO ManagerRecordJamKerja(idManager, totalLembur, totalTerlambat, totalJamKerja) VALUES(?,?,?,?)";
            info = "Data PerhitunganWaktu Manager dengan id "+ idEmployee +" baru telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO PegawaiRecordJamKerja(idPegawai, totalLembur, totalTerlambat, totalJamKerja) VALUES(?,?,?,?)";
            info = "Data PerhitunganWaktu Pegawai dengan id "+ idEmployee +" baru telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idEmployee);
             statement.setInt(2, recordKerja.getTotalLembur());
             statement.setInt(3, recordKerja.getTotalTerlambat());
             statement.setInt(4, recordKerja.getTotalJamKerja());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void deletePerhitunganWaktu(String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "DELETE FROM ManagerRecordJamKerja WHERE idManager = "+idEmployee;
            info = "Data PerhitunganWaktu Manager dengan id "+ idEmployee +" telah dihapus dari dalam database!";
        }else{
            sql = "DELETE FROM PegawaiRecordJamKerja WHERE idPegawai = "+idEmployee;
            info = "Data PerhitunganWaktu Pegawai dengan id "+ idEmployee +" telah dihapus dari dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void updatePerhitunganWaktu(PerhitunganWaktu recordKerja, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "UPDATE ManagerRecordJamKerja SET totalLembur = ?, totalTerlambat = ?, totalJamKerja = ? WHERE idManager = " + idEmployee;
            info = "Data PerhitunganWaktu Manager dengan id "+ idEmployee +" telah diupdate ke dalam database!";
        }else{
            sql = "UPDATE PegawaiRecordJamKerja SET totalLembur = ?, totalTerlambat = ?, totalJamKerja = ? WHERE idPegawai = " + idEmployee;
            info = "Data PerhitunganWaktu Pegawai dengan id "+ idEmployee +" telah diupdate ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setInt(1, recordKerja.getTotalLembur());
             statement.setInt(2, recordKerja.getTotalTerlambat());
             statement.setInt(3, recordKerja.getTotalJamKerja());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public PerhitunganWaktu getPerhitunganWaktu(String idEmployee, String namaJabatan){
        String sql;
        PerhitunganWaktu recordKerja = new PerhitunganWaktu();
        if(namaJabatan.equals("Manager")){
            sql = "SELECT * FROM ManagerRecordJamKerja WHERE idManager = " + idEmployee;
        }else{
            sql = "SELECT * FROM PegawaiRecordJamKerja WHERE idPegawai = " + idEmployee;
        }
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                recordKerja.setTotalLembur(result.getInt("totalLembur"));
                recordKerja.setTotalTerlambat(result.getInt("totalTerlambat"));
                recordKerja.setTotalJamKerja(result.getInt("totalJamKerja"));
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return recordKerja;
    }
}

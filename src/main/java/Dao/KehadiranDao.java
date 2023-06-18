/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.Kehadiran;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class KehadiranDao implements InterfaceDaoKehadiran{
    @Override
    public void insertKartuKehadiran(Kehadiran kartu, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "INSERT INTO ManagerKartuKehadiran(idManager, standarJamMasuk, standarJamKeluar, waktu_masuk, waktu_keluar, jam_masuk, jam_keluar) VALUES(?,?,?,?,?,?,?)";
            info = "Data kartu kehadiran Manager baru telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO PegawaiKartuKehadiran(idPegawai, standarJamMasuk, standarJamKeluar, waktu_masuk, waktu_keluar, jam_masuk, jam_keluar) VALUES(?,?,?,?,?,?,?)";
            info = "Data kartu kehadiran Pegawai baru telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idEmployee);
             statement.setTime(2, Time.valueOf(kartu.getStandarMasuk()));
             statement.setTime(3, Time.valueOf(kartu.getStandarKeluar()));
             if(kartu.getWaktu_masuk() != null){
                statement.setTimestamp(4, Timestamp.valueOf(kartu.getWaktu_masuk()));                 
             }else{
                statement.setNull(4, java.sql.Types.TIMESTAMP);
             }
             if(kartu.getWaktu_keluar() != null){
                statement.setTimestamp(5, Timestamp.valueOf(kartu.getWaktu_keluar()));
             }else{
                statement.setNull(5, java.sql.Types.TIMESTAMP);
             }
             statement.setInt(6, kartu.cekJamMasuk());
             statement.setInt(7, kartu.cekJamKeluar());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void updateKartuKehadiran(Kehadiran kartu, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "UPDATE ManagerKartuKehadiran SET standarJamMasuk = ?, standarJamKeluar = ?, waktu_masuk = ?, waktu_keluar = ?, jam_masuk = ?, jam_keluar = ? WHERE idManager = '" + idEmployee+"'";
            info = "data Kehadiran Manager dengan id "+idEmployee+" telah dilakukan update";
        }else{
            sql = "UPDATE PegawaiKartuKehadiran SET standarJamMasuk = ?, standarJamKeluar = ?, waktu_masuk = ?, waktu_keluar = ?, jam_masuk = ?, jam_keluar = ? WHERE idPegawai = '"+ idEmployee+"'";
            info = "data Kehadiran Pegawai dengan id "+idEmployee+" telah dilakukan update";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setTime(1, Time.valueOf(kartu.getStandarMasuk()));
             statement.setTime(2, Time.valueOf(kartu.getStandarKeluar()));
             if(kartu.getWaktu_masuk() != null){
                statement.setTimestamp(3, Timestamp.valueOf(kartu.getWaktu_masuk()));                 
             }else{
                statement.setNull(3, java.sql.Types.TIMESTAMP);
             }
             if(kartu.getWaktu_keluar() != null){
                statement.setTimestamp(4, Timestamp.valueOf(kartu.getWaktu_keluar()));
             }else{
                statement.setNull(4, java.sql.Types.TIMESTAMP);
             }
             statement.setInt(5, kartu.cekJamMasuk());
             statement.setInt(6, kartu.cekJamKeluar());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void deleteKartuKehadiran(String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "DELETE FROM ManagerKartuKehadiran WHERE idManager = " + idEmployee;
            info = "data Kehadiran Manager dengan id "+idEmployee+" telah dihapus";
        }else{
            sql = "DELETE FROM PegawaiKartuKehadiran WHERE idPegawai = " + idEmployee;
            info = "data Kehadiran Pegawai dengan id "+idEmployee+" telah dihapus";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public Kehadiran getKehadiran(String idEmployee, String namaJabatan){
        String sql;
        Kehadiran kartu = new Kehadiran();
        if(namaJabatan.equals("Manager")){
            sql = "SELECT * FROM ManagerKartuKehadiran WHERE idManager = '" + idEmployee+"'";
        }else{
            sql = "SELECT * FROM PegawaiKartuKehadiran WHERE idPegawai = '" + idEmployee+"'";
        }
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                kartu.setStadarMasuk(result.getTime("standarJamMasuk").toLocalTime());
                kartu.setStandarKeluar(result.getTime("standarJamKeluar").toLocalTime());
             //LocalDateTime Null handler
             if(result.getTimestamp("waktu_masuk") != null){
                kartu.setWaktu_Masuk(result.getTimestamp("waktu_masuk").toLocalDateTime());                
             }else{
                kartu.setWaktu_Masuk(null);
             }
             //LocalDateTime Null handler
             if(result.getTimestamp("waktu_keluar") != null){
                kartu.setWaktu_Keluar(result.getTimestamp("waktu_keluar").toLocalDateTime());
             }else{
                kartu.setWaktu_Keluar(null);
             }
             
                kartu.setJamMasuk(result.getInt("jam_masuk"));
                kartu.setJamKeluar(result.getInt("jam_keluar"));
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return kartu;
    }
}

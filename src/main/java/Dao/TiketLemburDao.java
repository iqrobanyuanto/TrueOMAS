/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.TiketLembur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class TiketLemburDao implements InterfaceDaoTiketLembur{
    @Override
    public void insertTiketLembur(TiketLembur statusLembur, String idPegawai){
        String sql;
        String info;
        sql = "INSERT INTO PegawaiStatusLembur(idPegawai, namaPegawai, tanggalLembur, waktuMulai, waktuAkhir, pengizin, statusTiket) VALUES(?,?,?,?,?)";
        info = "Data TiketLembur Pegawai baru dengan id "+ idPegawai +", telah ditambahkan ke dalam database!";
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idPegawai);
             statement.setString(2, statusLembur.getNamaPegawai());
             // Menginisiasi null Handler
             if(statusLembur.getTanggal() != null){
                 statement.setDate(3, Date.valueOf(statusLembur.getTanggal()));
             }else{
                 statement.setNull(3, java.sql.Types.DATE);
             }
             if(statusLembur.getWaktuMulai() != null){
                statement.setTime(4, Time.valueOf(statusLembur.getWaktuMulai()));
             }else{
                 statement.setNull(4, java.sql.Types.TIME);
             }
             if(statusLembur.getWaktuAkhir() != null){
                  statement.setTime(5, Time.valueOf(statusLembur.getWaktuAkhir()));
             }else{
                 statement.setNull(5, java.sql.Types.TIME);
             }
             statement.setString(6,statusLembur.getPengizin());
             statement.setBoolean(7,statusLembur.getStatusTiket());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void deleteTiketLembur(String idPegawai){
        String sql;
        String info;
        sql = "DELETE FROM PegawaiStatusLembur WHERE idPegawai = " + idPegawai;
        info = "Data TiketLembur Pegawai dengan id "+ idPegawai +", telah dihapus dari database!";
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void updateTiketLembur(TiketLembur statusLembur, String idPegawai){
        String sql;
        String info;
        sql = "UPDATE PegawaiStatusLembur SET namaPegawai = ?, waktuLembur = ?, pengizin = ?, statusTiket = ? WHERE idPegawai = "+idPegawai;
        info = "Data TiketLembur Pegawai dengan id "+ idPegawai +", telah diupdate ke dalam database!";
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, statusLembur.getNamaPegawai());
             // Menginisiasi null Handler
             if(statusLembur.getTanggal() != null){
                 statement.setDate(3, Date.valueOf(statusLembur.getTanggal()));
             }else{
                 statement.setNull(3, java.sql.Types.DATE);
             }
             if(statusLembur.getWaktuMulai() != null){
                statement.setTime(4, Time.valueOf(statusLembur.getWaktuMulai()));
             }else{
                 statement.setNull(4, java.sql.Types.TIME);
             }
             if(statusLembur.getWaktuAkhir() != null){
                  statement.setTime(5, Time.valueOf(statusLembur.getWaktuAkhir()));
             }else{
                 statement.setNull(5, java.sql.Types.TIME);
             }
             statement.setString(3,statusLembur.getPengizin());
             statement.setBoolean(4,statusLembur.getStatusTiket());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public TiketLembur getTiketLembur(String idPegawai){
        String sql;
        TiketLembur statusLembur = new TiketLembur();
        sql = "SELECT * FROM PegawaiStatusLembur WHERE idPegawai = " + idPegawai;
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                statusLembur.setNamaPegawai(result.getString("namaPegawai"));
                if(result.getDate("tanggalLembur") != null){
                    statusLembur.setTanggal(result.getDate("tanggalLembur").toLocalDate());
                }else{
                    statusLembur.setTanggal(null);
                }
                if(result.getTime("waktuMulai") != null){
                    statusLembur.setWaktuMulai(result.getTime("waktuMulai").toLocalTime());
                }else{
                    statusLembur.setWaktuMulai(null);
                }
                if(result.getTime("waktuAkhir") != null){
                    statusLembur.setWaktuAkhir(result.getTime("waktuAkhir").toLocalTime());
                }else{
                    statusLembur.setWaktuAkhir(null);
                }
                statusLembur.setPengizin(result.getString("pengizin"));
                statusLembur.setStatusTiket(result.getBoolean("statusTiket"));
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return statusLembur;
    }
}

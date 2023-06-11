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
        sql = "INSERT INTO PegawaiStatusLembur(idPegawai, namaPegawai, waktuLembur, pengizin, statusTiket) VALUES(?,?,?,?,?)";
        info = "Data TiketLembur Pegawai baru dengan id "+ idPegawai +", telah ditambahkan ke dalam database!";
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idPegawai);
             statement.setString(2, statusLembur.getNamaPegawai());
             statement.setInt(3, statusLembur.getWaktuLembur());
             statement.setString(4,statusLembur.getPengizin());
             statement.setBoolean(5,statusLembur.getStatusTiket());
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
             statement.setInt(2, statusLembur.getWaktuLembur());
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
                statusLembur.setWaktuLembur(result.getInt("waktuLembur"));
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

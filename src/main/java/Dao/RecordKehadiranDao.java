/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqro Banyuanto
 */
public class RecordKehadiranDao implements InterfaceDaoRecordKehadiran{
    @Override
    public void insertRecord(LocalDateTime record, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "INSERT INTO ManagerRecordKehadiran(idManager, kehadiran) VALUES(?,?)";
            info = "Record kehadiran baru dengan id Manager "+ idEmployee +" telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO PegawaiRecordKehadiran(idPegawai, kehadiran) VALUES(?,?)";
            info = "Record kehadiran baru dengan id Pegawai "+ idEmployee +" telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idEmployee);
             statement.setTimestamp(2, Timestamp.valueOf(record));
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void deleteAllRecord(String idEmployee, String namaJabatan){
                String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "DELETE FROM ManagerRecordKehadiran WHERE idManager = " + idEmployee;
            info = "Seluruh record kehadiran dengan id Manager "+ idEmployee +" telah dihapus dari database!";
        }else{
            sql = "DELETE FROM PegawaiRecordKehadiran WHERE idPegawai = " + idEmployee;
            info = "Seluruh Record kehadiran dengan id Pegawai "+ idEmployee +" telah dihapus dari database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public List<LocalDateTime> getRecordKehadiran(String idEmployee, String namaJabatan){
        String sql;
        List<LocalDateTime> list_kehadiran = new ArrayList();
        if(namaJabatan.equals("Manager")){
            sql = "SELECT * FROM ManagerRecordKehadiran WHERE idManager = " + idEmployee;
        }else{
            sql = "SELECT * FROM PegawaiRecordKehadiran WHERE idPegawai = " + idEmployee;
        }
        
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                list_kehadiran.add(result.getTimestamp("kehadiran").toLocalDateTime());
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list_kehadiran;
    }
}

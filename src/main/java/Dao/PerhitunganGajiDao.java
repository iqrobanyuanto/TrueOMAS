/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.PerhitunganGaji;
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
public class PerhitunganGajiDao implements InterfaceDaoPerhitunganGaji{
    @Override
    public void insertPerhitunganGaji(PerhitunganGaji statusGaji, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "INSERT INTO ManagerRecordStatusGaji(idManager, standarGaji, totalGaji) VALUES(?,?,?)";
            info = "Data PerhitunganGaji Manager baru telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO PegawaiRecordStatusGaji(idPegawai, standarGaji, totalGaji) VALUES(?,?,?)";
            info = "Data PerhitunganGaji Pegawai baru telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, idEmployee);
             statement.setInt(2, statusGaji.getStandarGaji());
             statement.setInt(3, statusGaji.getTotalJamGaji());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void updatePerhitunganGaji(PerhitunganGaji statusGaji, String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "UPDATE ManagerRecordStatusGaji SET standarGaji = ?, totalGaji = ? WHERE idManager = '" + idEmployee +"'";
            info = "Data PerhitunganGaji Manager dengan id "+ idEmployee +" telah diupdate ke dalam database!";
        }else{
            sql = "UPDATE PegawaiRecordStatusGaji SET standarGaji = ?, totalGaji = ? WHERE idPegawai = '" + idEmployee+"'";
            info = "Data PerhitunganGaji Pegawai dengan id "+ idEmployee +" telah diupdate ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setInt(1, statusGaji.getStandarGaji());
             statement.setInt(2, statusGaji.getTotalJamGaji());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void deletePerhitunganGaji(String idEmployee, String namaJabatan){
        String sql;
        String info;
        if(namaJabatan.equals("Manager")){
            sql = "DELETE FROM ManagerRecordStatusGaji WHERE idManager = " + idEmployee;
            info = "Data PerhitunganGaji Manager dengan id "+ idEmployee +" telah dihapus dari database!";
        }else{
            sql = "DELETE FROM PegawaiRecordStatusGaji WHERE idPegawai = " + idEmployee;
            info = "Data PerhitunganGaji Pegawai dengan id "+ idEmployee +" telah dihapus dari database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public PerhitunganGaji getPerhiitunganGaji(String idEmployee, String namaJabatan){
        String sql;
        PerhitunganGaji statusGaji = new PerhitunganGaji();
        if(namaJabatan.equals("Manager")){
            sql = "SELECT * FROM ManagerRecordStatusGaji WHERE idManager = '" + idEmployee+"'";
        }else{
            sql = "SELECT * FROM PegawaiRecordStatusGaji WHERE idPegawai = '" + idEmployee+"'";
        }
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                statusGaji.setStandarGaji(result.getInt("standarGaji"));
                statusGaji.setTotalGaji(result.getInt("totalGaji"));
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return statusGaji;
    }
}

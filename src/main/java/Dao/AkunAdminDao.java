/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import AdmWork.AkunAdmin;
import DBPr.DBConnection;
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
public class AkunAdminDao implements InterfaceDaoAkunAdmin{
    //Masukin akun admin
    @Override
    public void insertAkunAdmin(AkunAdmin akun){
        String sql;
        String info;
        sql = "INSERT INTO AkunAdmin(idAdmin, password, namaAdmin) VALUES(?,?,?)";
        info = "Akun admin baru telah ditambahkan ke dalam database!";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, akun.getid());
            statement.setString(2, akun.getpassword());
            statement.setString(3, akun.getnamaAdmin());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    //update akun admin berdasarkan id akun yang terdapat dalam konfigurasi AkunAdmin yang ingin di update
    public void updateAkunAdmin(AkunAdmin akun){
        String sql;
        String info;
        sql = "UPDATE AkunAdmin SET password = ?, namaAdmin = ? WHERE idAdmin = " + akun.getid();
        info = "Akun admin dengan id "+akun.getid() +" telah diupdate ke dalam database!";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
            statement.setString(1, akun.getpassword());
            statement.setString(2, akun.getnamaAdmin());
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    //delete akun admin berdasarkan id
    public void deleteAkunAdmin(String idAdmin){
        String sql;
        String info;
        sql = "DELETE FROM AkunAdmin WHERE idAdmin = " + idAdmin;
        info = "Akun admin dengan id "+ idAdmin +" telah dihapus dari database!";
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    //dapeting list berisikan semua akun admin
    public List<AkunAdmin> getAllAkunAdmin(){
        String sql;
        List<AkunAdmin> listAkunAdmin = new ArrayList();
        sql = "SELECT * FROM AkunAdmin";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                AkunAdmin ar = new AkunAdmin();
                ar.setid(result.getString("idAdmin"));
                ar.setnamaAdmin(result.getString("namaAdmin"));
                ar.setpassword(result.getString("password"));
                listAkunAdmin.add(ar);
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return listAkunAdmin;
    }
}

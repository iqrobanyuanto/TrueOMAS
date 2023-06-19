/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DBPr.DBConnection;
import EmpWork.Employee;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import EmpWork.RecordKehadiran;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Iqro Banyuanto
 */
public class RecordKehadiranDao implements InterfaceDaoRecordKehadiran{
    @Override
    public void insertLog(RecordKehadiran log, Employee r){
        String sql;
        String info;
        if(r.getNamaJabatan().equals("Manager")){
            sql = "INSERT INTO ManagerRecordKehadiran(idManager, tanggal, waktuMasuk, waktuKeluar) VALUES(?,?,?,?)";
            info = "Record kehadiran baru pada tanggal "+ log.getTanggal().toString() +" dengan id Manager "+ r.getIdEmployee()+" telah ditambahkan ke dalam database!";
        }else{
            sql = "INSERT INTO PegawaiRecordKehadiran(idPegawai, tanggal, waktuMasuk, waktuKeluar) VALUES(?,?,?,?)";
            info = "Record kehadiran baru pada tanggal "+ log.getTanggal().toString() +" dengan id Manager "+ r.getIdEmployee()+" telah ditambahkan ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setString(1, r.getIdEmployee());
             statement.setDate(2, Date.valueOf(log.getTanggal()));
             statement.setTime(3, Time.valueOf(log.getWaktuMasuk()));
             statement.setTime(4, Time.valueOf(log.getWaktuKeluar()));
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public void updateLog(RecordKehadiran log, Employee r){
        String sql;
        String info;
        if(r.getNamaJabatan().equals("Manager")){
            sql = "UPDATE ManagerRecordKehadiran SET tanggal = ?, waktuMasuk = ?, waktuKeluar = ? WHERE idManager = "+ r.getIdEmployee();
            info = "Record kehadiran pada tanggal "+ log.getTanggal().toString() +" dengan id Manager "+ r.getIdEmployee()+" telah diupdate ke dalam database!";
        }else{
            sql = "UPDATE PegawaiRecordKehadiran SET tanggal = ?, waktuMasuk = ?, waktuKeluar = ? WHERE idPegawai = "+ r.getIdEmployee();
            info = "Record kehadiran pada tanggal "+ log.getTanggal().toString() +" dengan id Pegawai "+ r.getIdEmployee()+" telah diupdate ke dalam database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.setDate(1, Date.valueOf(log.getTanggal()));
             statement.setTime(2, Time.valueOf(log.getWaktuMasuk()));
             statement.setTime(3, Time.valueOf(log.getWaktuKeluar()));
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void deleteAllLog(Employee r){
        String sql;
        String info;
        if(r.getNamaJabatan().equals("Manager")){
            sql = "DELETE FROM ManagerRecordKehadiran WHERE idManager = "+r.getIdEmployee();
            info = "Log kehadiran dengan id Manager "+ r.getIdEmployee()+" telah dihapus dari database!";
        }else{
            sql = "DELETE FROM PegawaiRecordKehadiran WHERE idPegawai = "+r.getIdEmployee();
            info = "Log kehadiran dengan id Pegawai "+ r.getIdEmployee()+" telah dihapus dari database!";
        }
         try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql)) {
             statement.executeUpdate();
             System.out.println(info);
        } catch (SQLException e) {
             Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    @Override
    public List<RecordKehadiran> getAllLog(Employee r){
        String sql;
        if(r.getNamaJabatan().equals("Manager")){
            sql = "SELECT * FROM ManagerRecordKehadiran WHERE idManager = "+r.getIdEmployee();
        }else{
            sql = "SELECT * FROM PegawaiRecordKehadiran WHERE idPegawai = "+r.getIdEmployee();
        }
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                RecordKehadiran q = new RecordKehadiran();
                q.setTanggal(result.getDate("tanggal").toLocalDate());
                q.setWaktuMasuk(result.getTime("waktuMasuk").toLocalTime());
                q.setWaktuKeluar(result.getTime("waktuKeluar").toLocalTime());
                r.list_kehadiran.add(q);
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return r.list_kehadiran;
    }
    
    @Override
    public int getLogSize(){
        String sql;
        int i = 0;
        sql = "SELECT * FROM PegawaiRecordKehadiran";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                i++;
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
    
    @Override
    public int getLogSizeManager(){
        String sql;
        int i = 0;
        sql = "SELECT * FROM ManagerRecordKehadiran";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                i++;
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
   
    @Override
    public String[][] getAllDataLog(int row){
        String sql = "SELECT * FROM PegawaiRecordKehadiran";
        EmployeeDao dao = new EmployeeDao();
        String data[][] = new String[row][6];
        
        int i = 0;
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String idpegawai = result.getString("idPegawai");
                String nama = dao.getPegawai(idpegawai).getNamaEmployee();
                String jabatan = dao.getPegawai(idpegawai).getNamaJabatan();
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalTime waktuMasuk = result.getTime("waktuMasuk").toLocalTime();
                LocalTime waktuKeluar = result.getTime("waktuKeluar").toLocalTime();
                data[i][0] = idpegawai;
                data[i][1] = nama;
                data[i][2] = jabatan;
                data[i][3] = tanggal.toString();
                data[i][4] = waktuMasuk.toString();
                data[i][5] = waktuKeluar.toString();
                i++;
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    @Override
    public String[][] getAllDataLogManager(int row){
        String sql = "SELECT * FROM ManagerRecordKehadiran";
        EmployeeDao dao = new EmployeeDao();
        String data[][] = new String[row][6];
        
        int i = 0;
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String idpegawai = result.getString("idManager");
                String nama = dao.getManager(idpegawai).getNamaEmployee();
                String jabatan = dao.getManager(idpegawai).getNamaJabatan();
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalTime waktuMasuk = result.getTime("waktuMasuk").toLocalTime();
                LocalTime waktuKeluar = result.getTime("waktuKeluar").toLocalTime();
                data[i][0] = idpegawai;
                data[i][1] = nama;
                data[i][2] = jabatan;
                data[i][3] = tanggal.toString();
                data[i][4] = waktuMasuk.toString();
                data[i][5] = waktuKeluar.toString();
                i++;
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    
    @Override
    public String[][] getTodayDataLogManager(int row){
        String sql = "SELECT * FROM ManagerRecordKehadiran";
        EmployeeDao dao = new EmployeeDao();
        String data[][] = new String[row][6];
        
        int i = 0;
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String idpegawai = result.getString("idManager");
                String nama = dao.getManager(idpegawai).getNamaEmployee();
                String jabatan = dao.getManager(idpegawai).getNamaJabatan();
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalTime waktuMasuk = result.getTime("waktuMasuk").toLocalTime();
                LocalTime waktuKeluar = result.getTime("waktuKeluar").toLocalTime();
                LocalDate now = LocalDate.now();
                if(tanggal.equals(now)){
                    data[i][0] = idpegawai;
                    data[i][1] = nama;
                    data[i][2] = jabatan;
                    data[i][3] = tanggal.toString();
                    data[i][4] = waktuMasuk.toString();
                    data[i][5] = waktuKeluar.toString();
                    i++;
                }
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
    @Override
    public int getTodayLogSizeManager(){
        String sql;
        int i = 0;
        sql = "SELECT * FROM ManagerRecordKehadiran";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
               
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalDate now = LocalDate.now();
                if(tanggal.equals(now)){
                    i++;
                }
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
    
    @Override
    public int getTodayLogSizePegawai(){
        String sql;
        int i = 0;
        sql = "SELECT * FROM ManagerRecordKehadiran";
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalDate now = LocalDate.now();
                if(tanggal.equals(now)){
                    System.out.println("tes");
                    i++;
                }
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return i;
    }
    
    @Override
    public String[][] getTodayDataLog(int row){
        String sql = "SELECT * FROM PegawaiRecordKehadiran";
        EmployeeDao dao = new EmployeeDao();
        String data[][] = new String[row][6];
        System.out.println(row);
        int i = 0;
        try(Statement statement = DBConnection.getConnection().createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                String idpegawai = result.getString("idPegawai");
                String nama = dao.getPegawai(idpegawai).getNamaEmployee();
                String jabatan = dao.getPegawai(idpegawai).getNamaJabatan();
                LocalDate tanggal = result.getDate("tanggal").toLocalDate();
                LocalTime waktuMasuk = result.getTime("waktuMasuk").toLocalTime();
                LocalTime waktuKeluar = result.getTime("waktuKeluar").toLocalTime();
                LocalDate now = LocalDate.now();
                if(tanggal.equals(now)){
                    data[i][0] = idpegawai;
                    data[i][1] = nama;
                    data[i][2] = jabatan;
                    data[i][3] = tanggal.toString();
                    data[i][4] = waktuMasuk.toString();
                    data[i][5] = waktuKeluar.toString();
                    i++;
                }
                
                
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return data;
    }
}

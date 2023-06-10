/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import EmpWork.Pegawai;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andry
 */
public class ModelTableKehadiran extends AbstractTableModel{
    List <Pegawai> listPegawai;
    
    public ModelTableKehadiran(List<Pegawai> listPegawai) { this.listPegawai = listPegawai; }
    
    public Pegawai getRow(int row) { return listPegawai.get(row); } 
    @Override
    public int getRowCount() { return listPegawai.size(); }
    @Override
    public int getColumnCount() { return listPegawai.getClass().getDeclaredFields().length; }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0: return listPegawai.get(rowIndex).getIdEmployee();
            case 1: return listPegawai.get(rowIndex).getNamaEmployee();
            case 2: return listPegawai.get(rowIndex).getNamaJabatan();
            case 3: return listPegawai.get(rowIndex).getkehadiran();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Id";
            case 1: return "Nama";
            case 2: return "Jabatan";
            case 3: return "Kehadiran";
            default: return null;
        }
    }
}

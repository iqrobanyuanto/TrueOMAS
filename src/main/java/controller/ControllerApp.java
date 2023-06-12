/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DBPr.*;
import EmpWork.*;
import view.*;
import java.util.*;
import javax.swing.*;
import Dao.*;

/**
 *
 * @author Liyan & Max & Andry
 */
public class ControllerApp {
    private Assign assign;
    
    public ControllerApp() {
        
    }
    
    public void ShowAssign(){
        assign = new Assign();
        assign.setVisible(true);
        assign.setLocationRelativeTo(null);
    }
    
    public void listBuilder(){}
    
    public void listChecker(){
        //for(Employee em: DBPr.KumpulanEmployee.getListPegawai()){}
    }
    
    public void selectedLembur(){
        //if(assign.getjList1()){}
    }
}

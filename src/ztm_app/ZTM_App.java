/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

/**
 *
 * @author Dawid Gruszczyński
 * Michał Stolarz
 */

import java.sql.*;
import javax.swing.JOptionPane;


public class ZTM_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
        String DB_USER = "ktos";
        String DB_PASS = "ktos";
        String statement = "SELECT Nr_poczty, Kod_pocztowy, Poczta FROM POCZTY";

        
        try{
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            JOptionPane.showMessageDialog(null,"Confirmed","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Failed to connect user: " + DB_USER + " to " + " database with url: " + DB_URL,"Error",JOptionPane.ERROR_MESSAGE);
        }        
        
        

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(statement);

             while(rs.next()){                 
                System.out.print(rs.getInt(1));            
                System.out.print(rs.getString(2));            
                System.out.print(rs.getString(2));                            
            }
        }
        
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Failed to create statement","Error",JOptionPane.ERROR_MESSAGE);
        }    
        catch(NullPointerException e){
            System.out.print("NullPointerException caught");
        }    
        
       
        
        
    }
    
}

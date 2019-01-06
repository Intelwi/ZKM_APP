/*
 * Klasa glowna.
 */
package ztm_app;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dawid Gruszczyński, Michał Stolarz
 */
public class ZTM_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs =null;
        String DB_URL = "jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf";
        String DB_USER = "nie_podam"; //tu podaj swoj login do bazy danych
        String DB_PASS = "nie_podam"; //tu podaj swoje haslo do bazy danych
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
                System.out.println(rs.getInt(1));            
                System.out.println(rs.getString(2));            
                System.out.println(rs.getString(3));                            
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

/*
 * Klasa sluzaca do pobierania danych z bazy danych.
 */
package ztm_app;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dawid Gruszczyński, Michał Stolarz
 */
public class Poczty {
    private Integer NrPoczty;
    private String KodPocztowy;
    private String Poczta;

    public Integer getNrPoczty() {
        return NrPoczty;
    }

    public void setNrPoczty(Integer NrPoczty) {
        this.NrPoczty = NrPoczty;
    }

    public String getKodPocztowy() {
        return KodPocztowy;
    }

    public void setKodPocztowy(String KodPocztowy) {
        this.KodPocztowy = KodPocztowy;
    }

    public String getPoczta() {
        return Poczta;
    }

    public void setPoczta(String Poczta) {
        this.Poczta = Poczta;
    }
    
    public List<Poczty> getAll(Connection conn) throws SQLException {
        List <Poczty> pocztyList = new ArrayList();
        Statement stmt = null;
        ResultSet rs =null;
        
        stmt = conn.createStatement();
        String statement = "SELECT Nr_poczty, Kod_pocztowy, Poczta FROM POCZTY";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                Poczty poczta = new Poczty();
                poczta.setNrPoczty(rs.getInt(1));            
                poczta.setKodPocztowy(rs.getString(2));            
                poczta.setPoczta(rs.getString(3));
                
                pocztyList.add(poczta);
            }
        
        return pocztyList;
    }
    int updatePoczty(Connection conn, Poczty poczt){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "UPDATE Poczty SET kod_pocztowy = ?, poczta = ? WHERE nr_poczty = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setString(1, poczt.KodPocztowy);
            stmt.setString(2, poczt.Poczta);
            stmt.setInt(3, poczt.NrPoczty);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    int deletePoczta(Connection conn, Integer ID){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "DELETE FROM Poczty WHERE nr_poczty = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setInt(1, ID);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    int addPoczta(Connection conn, Poczty poczt) {
        PreparedStatement stmt = null;
        int result;
        
        String statement = "INSERT INTO Poczty VALUES (?,?,?)";
        try{
            stmt = conn.prepareStatement(statement);
            
            stmt.setInt(1, poczt.NrPoczty);
            stmt.setString(2, poczt.KodPocztowy);
            stmt.setString(3, poczt.Poczta);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
}

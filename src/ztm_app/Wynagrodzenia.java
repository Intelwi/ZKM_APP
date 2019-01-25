/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author micha
 */
public class Wynagrodzenia {
    private Integer NrWynagrodzenia;
    private Float KwotaPodstawowa;
    private Float Premia;
    private String DataWynagrodzenia;
    private Integer NrPracownika;

    public Integer getNrWynagrodzenia() {
        return NrWynagrodzenia;
    }

    public void setNrWynagrodzenia(Integer NrWynagrodzenia) {
        this.NrWynagrodzenia = NrWynagrodzenia;
    }

    public Float getKwotaPodstawowa() {
        return KwotaPodstawowa;
    }

    public void setKwotaPodstawowa(Float KwotaPodstawowa) {
        this.KwotaPodstawowa = KwotaPodstawowa;
    }

    public Float getPremia() {
        return Premia;
    }

    public void setPremia(Float Premia) {
        this.Premia = Premia;
    }

    public String getDataWynagrodzenia() {
        return DataWynagrodzenia;
    }

    public void setDataWynagrodzenia(String DataWynagrodzenia) {
        this.DataWynagrodzenia = DataWynagrodzenia;
    }

    public Integer getNrPracownika() {
        return NrPracownika;
    }

    public void setNrPracownika(Integer NrPracownika) {
        this.NrPracownika = NrPracownika;
    }

    
    
    public List<Wynagrodzenia> getAll(Connection conn) throws SQLException {
        List <Wynagrodzenia> wynagrodzeniaList = new ArrayList();
        Statement stmt = null;
        ResultSet rs =null;
        
        stmt = conn.createStatement();
        String statement = "SELECT * FROM WYNAGRODZENIA ORDER BY NR_WYNAGRODZENIA";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
                wynagrodzenie.setNrWynagrodzenia(rs.getInt(1));            
                wynagrodzenie.setKwotaPodstawowa(rs.getFloat(2));            
                wynagrodzenie.setPremia(rs.getFloat(3));
                wynagrodzenie.setDataWynagrodzenia(rs.getString(4).substring(0, 10));
                wynagrodzenie.setNrPracownika(rs.getInt(5));
                
                wynagrodzeniaList.add(wynagrodzenie);
            }
        
        return wynagrodzeniaList;
    }
    
    public List<Wynagrodzenia> getRestrictedWynagrodzenie(Connection conn, Integer ID) throws SQLException {
        List<Wynagrodzenia> wynagrodzeniaList = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String statement = "SELECT * FROM WYNAGRODZENIA WHERE NR_PRACOWNIKA = ? ORDER BY NR_WYNAGRODZENIA";
        stmt = conn.prepareStatement(statement);
        stmt.setInt(1, ID);
        rs = stmt.executeQuery();
        
        while(rs.next()) {              
            Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
            wynagrodzenie.setNrWynagrodzenia(rs.getInt(1));            
            wynagrodzenie.setKwotaPodstawowa(rs.getFloat(2));            
            wynagrodzenie.setPremia(rs.getFloat(3));
            wynagrodzenie.setDataWynagrodzenia(rs.getString(4).substring(0, 10));
            wynagrodzenie.setNrPracownika(rs.getInt(5));
                
            wynagrodzeniaList.add(wynagrodzenie);
        }
        return wynagrodzeniaList;
    }
    
    int updateWynagrodzenie(Connection conn, Wynagrodzenia wyn){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "UPDATE Wynagrodzenia set kwota_podstawowa = ?, premia = ?, data_wynagrodzenia = ?, nr_pracownika = ? WHERE nr_wynagrodzenia = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setFloat(1, wyn.KwotaPodstawowa);
            stmt.setFloat(2, wyn.Premia);
            stmt.setString(3, wyn.DataWynagrodzenia);
            stmt.setInt(4, wyn.NrPracownika);
            stmt.setInt(5, wyn.NrWynagrodzenia);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    int deleteWynagrodzenie(Connection conn, Integer ID){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "DELETE FROM Wynagrodzenia WHERE nr_wynagrodzenia = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setInt(1, ID);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    int addWynagrodzenie(Connection conn, Wynagrodzenia wyn) {
        PreparedStatement stmt = null;
        int result;
        
        String statement = "INSERT INTO Wynagrodzenia VALUES (?,?,?,?,?)";
        try{
            stmt = conn.prepareStatement(statement);
            
            stmt.setInt(1, wyn.NrWynagrodzenia);
            stmt.setFloat(2, wyn.KwotaPodstawowa);
            stmt.setFloat(3, wyn.Premia);
            stmt.setString(4, wyn.DataWynagrodzenia);
            stmt.setInt(5, wyn.NrPracownika);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    public List<Wynagrodzenia> getWynagrodzeniaBy(Connection conn, String atrybut, String reqValue) throws SQLException {
        List <Wynagrodzenia> wynagrodzeniaList = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs =null;
        
        String statement;
        if (atrybut.equalsIgnoreCase("Nr_wynagrodzenia"))
            statement = "SELECT * FROM WYNAGRODZENIA WHERE Nr_wynagrodzenia = ?";
        else if (atrybut.equalsIgnoreCase("Data_wynagrodzenia"))
            statement = "SELECT * FROM WYNAGRODZENIA WHERE Data_wynagrodzenia = ? ORDER BY NR_WYNAGRODZENIA";
        else
            statement = "SELECT * FROM WYNAGRODZENIA WHERE Nr_pracownika = ? ORDER BY NR_WYNAGRODZENIA";
        
        stmt = conn.prepareStatement(statement);
        stmt.setString(1, reqValue);
        rs = stmt.executeQuery();
        
        while(rs.next()){
                Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
                wynagrodzenie.setNrWynagrodzenia(rs.getInt(1));            
                wynagrodzenie.setKwotaPodstawowa(rs.getFloat(2));            
                wynagrodzenie.setPremia(rs.getFloat(3));
                wynagrodzenie.setDataWynagrodzenia(rs.getString(4).substring(0, 10));
                wynagrodzenie.setNrPracownika(rs.getInt(5));
                
                wynagrodzeniaList.add(wynagrodzenie);
            }
        
        return wynagrodzeniaList;
    }
}
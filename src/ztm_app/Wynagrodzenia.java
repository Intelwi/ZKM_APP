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
        String statement = "SELECT * FROM WYNAGRODZENIA";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
                wynagrodzenie.setNrWynagrodzenia(rs.getInt(1));            
                wynagrodzenie.setKwotaPodstawowa(rs.getFloat(2));            
                wynagrodzenie.setPremia(rs.getFloat(3));
                wynagrodzenie.setDataWynagrodzenia(rs.getString(4));
                wynagrodzenie.setNrPracownika(rs.getInt(5));
                
                wynagrodzeniaList.add(wynagrodzenie);
            }
        
        return wynagrodzeniaList;
    }
    
    public List<Wynagrodzenia> getRestrictedWynagrodzenie(Connection conn, Integer ID) throws SQLException {
        List<Wynagrodzenia> wynagrodzeniaList = new ArrayList();
        Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String statement = "SELECT * FROM WYNAGRODZENIA WHERE NR_PRACOWNIKA = ?";
        stmt = conn.prepareStatement(statement);
        stmt.setInt(1, ID);
        rs = stmt.executeQuery();
        rs.next();
                    
        wynagrodzenie.setNrWynagrodzenia(rs.getInt(1));            
        wynagrodzenie.setKwotaPodstawowa(rs.getFloat(2));            
        wynagrodzenie.setPremia(rs.getFloat(3));
        wynagrodzenie.setDataWynagrodzenia(rs.getString(4));
        wynagrodzenie.setNrPracownika(rs.getInt(5));
                
        wynagrodzeniaList.add(wynagrodzenie);
        
        return wynagrodzeniaList;
    }
}

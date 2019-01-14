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
}

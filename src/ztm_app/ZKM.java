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
public class ZKM {
    private Integer NrZarzadu;
    private String NazwaZarzadu;
    private String Ulica;
    private String NrBudynku;
    private String NrTelefonu;
    private String Email;
    private Integer NrPoczty;

    public Integer getNrZarzadu() {
        return NrZarzadu;
    }

    public void setNrZarzadu(Integer NrZarzadu) {
        this.NrZarzadu = NrZarzadu;
    }

    public String getNazwaZarzadu() {
        return NazwaZarzadu;
    }

    public void setNazwaZarzadu(String NazwaZarzadu) {
        this.NazwaZarzadu = NazwaZarzadu;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String Ulica) {
        this.Ulica = Ulica;
    }

    public String getNrBudynku() {
        return NrBudynku;
    }

    public void setNrBudynku(String NrBSudynku) {
        this.NrBudynku = NrBSudynku;
    }

    public String getNrTelefonu() {
        return NrTelefonu;
    }

    public void setNrTelefonu(String NrTelefonu) {
        this.NrTelefonu = NrTelefonu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Integer getNrPoczty() {
        return NrPoczty;
    }

    public void setNrPoczty(Integer NrPoczty) {
        this.NrPoczty = NrPoczty;
    }


    
    public List<ZKM> getAll(Connection conn) throws SQLException {
        List <ZKM> zkmList = new ArrayList();
        Statement stmt = null;
        ResultSet rs =null;
        
        stmt = conn.createStatement();
        String statement = "SELECT Nr_zarzadu, Nazwa_zarzadu, Ulica, Nr_budynku, Nr_telefonu, Email, Nr_poczty FROM Zarzad_komunikacji_miejskiej";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                ZKM zkm = new ZKM();
                zkm.setNrZarzadu(rs.getInt(1));            
                zkm.setNazwaZarzadu(rs.getString(2));            
                zkm.setUlica(rs.getString(3));
                zkm.setNrBudynku(rs.getString(4));            
                zkm.setNrTelefonu(rs.getString(5));            
                zkm.setEmail(rs.getString(6));
                zkm.setNrPoczty(rs.getInt(7));
                
                zkmList.add(zkm);
            }
        
        return zkmList;
    }
}

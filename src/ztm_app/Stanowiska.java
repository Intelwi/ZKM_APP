/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author micha
 */
public class Stanowiska {
    private Integer NrStanowiska;
    private String NazwaStanowiska;
    private String Opis;

    public Integer getNrStanowiska() {
        return NrStanowiska;
    }

    public void setNrStanowiska(Integer NrStanowiska) {
        this.NrStanowiska = NrStanowiska;
    }

    public String getNazwaStanowiska() {
        return NazwaStanowiska;
    }

    public void setNazwaStanowiska(String NazwaStanowiska) {
        this.NazwaStanowiska = NazwaStanowiska;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String Opis) {
        this.Opis = Opis;
    }
    
    public List<Stanowiska> getAll(Connection conn) throws SQLException {
        List <Stanowiska> stanowiskaList = new ArrayList();
        Statement stmt = null;
        ResultSet rs =null;
        
        stmt = conn.createStatement();
        String statement = "SELECT * FROM STANOWISKA";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                Stanowiska stanowisko = new Stanowiska();
                stanowisko.setNrStanowiska(rs.getInt(1));            
                stanowisko.setNazwaStanowiska(rs.getString(2));            
                stanowisko.setOpis(rs.getString(3));
                
                stanowiskaList.add(stanowisko);
            }
        
        return stanowiskaList;
    }
    public List<Stanowiska> getRestrictedStanowisko(Connection conn, Integer ID) throws SQLException {
        List<Stanowiska> stanowiskaList = new ArrayList();
        Stanowiska stanowisko = new Stanowiska();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String statement = "SELECT * FROM STANOWISKA WHERE NR_STANOWISKA = (SELECT nr_stanowiska from pracownicy where nr_pracownika = ?)";
        stmt = conn.prepareStatement(statement);
        stmt.setInt(1, ID);
        rs = stmt.executeQuery();
        rs.next();
        
        stanowisko.setNrStanowiska(rs.getInt(1));            
        stanowisko.setNazwaStanowiska(rs.getString(2));
        stanowisko.setOpis(rs.getString(3));
        
        stanowiskaList.add(stanowisko);
        return stanowiskaList;
    }
}

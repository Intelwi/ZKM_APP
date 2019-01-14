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
}

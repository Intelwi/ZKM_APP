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
public class Pracownicy {
    private Integer NrPracownika;
    private String Imie;
    private String Nazwisko;
    private String Miejscowosc;
    private String Ulica;
    private String NrBudynku;
    private String NrLokalu;
    private String NrTelefonu;
    private String DataUrodzenia;
    private String DataZatrudnienia;
    private Integer NrZarzadu;
    private Integer NrPoczty;
    private Integer NrStanowiska;

    public Integer getNrPracownika() {
        return NrPracownika;
    }

    public void setNrPracownika(Integer NrPracownika) {
        this.NrPracownika = NrPracownika;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public String getMiejscowosc() {
        return Miejscowosc;
    }

    public void setMiejscowosc(String Miejscowosc) {
        this.Miejscowosc = Miejscowosc;
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

    public void setNrBudynku(String NrBudynku) {
        this.NrBudynku = NrBudynku;
    }

    public String getNrLokalu() {
        return NrLokalu;
    }

    public void setNrLokalu(String NrLokalu) {
        this.NrLokalu = NrLokalu;
    }

    public String getNrTelefonu() {
        return NrTelefonu;
    }

    public void setNrTelefonu(String NrTelefonu) {
        this.NrTelefonu = NrTelefonu;
    }

    public String getDataUrodzenia() {
        return DataUrodzenia;
    }

    public void setDataUrodzenia(String DataUrodzenia) {
        this.DataUrodzenia = DataUrodzenia;
    }

    public String getDataZatrudnienia() {
        return DataZatrudnienia;
    }

    public void setDataZatrudnienia(String DataZatrudnienia) {
        this.DataZatrudnienia = DataZatrudnienia;
    }

    public Integer getNrZarzadu() {
        return NrZarzadu;
    }

    public void setNrZarzadu(Integer NrZarzadu) {
        this.NrZarzadu = NrZarzadu;
    }

    public Integer getNrPoczty() {
        return NrPoczty;
    }

    public void setNrPoczty(Integer NrPoczty) {
        this.NrPoczty = NrPoczty;
    }

    public Integer getNrStanowiska() {
        return NrStanowiska;
    }

    public void setNrStanowiska(Integer NrStanowiska) {
        this.NrStanowiska = NrStanowiska;
    }
    
    
    public List<Pracownicy> getAll(Connection conn) throws SQLException {
        List <Pracownicy> pracownicyList = new ArrayList();
        Statement stmt = null;
        ResultSet rs =null;
        
        stmt = conn.createStatement();
        String statement = "SELECT * FROM PRACOWNICY";
        rs = stmt.executeQuery(statement);
        
        while(rs.next()){
                Pracownicy pracownik = new Pracownicy();
                pracownik.setNrPracownika(rs.getInt(1));            
                pracownik.setImie(rs.getString(2));            
                pracownik.setNazwisko(rs.getString(3));
                pracownik.setMiejscowosc(rs.getString(4));
                pracownik.setUlica(rs.getString(5));
                pracownik.setNrBudynku(rs.getString(6));
                pracownik.setNrLokalu(rs.getString(7));
                pracownik.setNrTelefonu(rs.getString(8));
                pracownik.setDataUrodzenia(rs.getString(9));
                pracownik.setDataZatrudnienia(rs.getString(10));
                pracownik.setNrZarzadu(rs.getInt(11));
                pracownik.setNrPoczty(rs.getInt(12));
                pracownik.setNrStanowiska(rs.getInt(13));
                
                pracownicyList.add(pracownik);
            }
        
        return pracownicyList;
    }
    
    public List<Pracownicy> getRestrictedPracownik(Connection conn, Integer ID) throws SQLException {
        List<Pracownicy> pracownicyList = new ArrayList();
        Pracownicy pracownik = new Pracownicy();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String statement = "SELECT * FROM PRACOWNICY WHERE NR_PRACOWNIKA = ?";
        stmt = conn.prepareStatement(statement);
        stmt.setInt(1, ID);
        rs = stmt.executeQuery();
        rs.next();
        
        pracownik.setNrPracownika(rs.getInt(1));            
        pracownik.setImie(rs.getString(2));            
        pracownik.setNazwisko(rs.getString(3));
        pracownik.setMiejscowosc(rs.getString(4));
        pracownik.setUlica(rs.getString(5));
        pracownik.setNrBudynku(rs.getString(6));
        pracownik.setNrLokalu(rs.getString(7));
        pracownik.setNrTelefonu(rs.getString(8));
        pracownik.setDataUrodzenia(rs.getString(9));
        pracownik.setDataZatrudnienia(rs.getString(10));
        pracownik.setNrZarzadu(rs.getInt(11));
        pracownik.setNrPoczty(rs.getInt(12));
        pracownik.setNrStanowiska(rs.getInt(13));
        
        pracownicyList.add(pracownik);
        return pracownicyList;
    }
    
    int updatePracownik(Connection conn, Pracownicy prac){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "UPDATE Pracownicy set Imię = ?, Nazwisko = ?, Miejscowosc = ?, Ulica = ?, Nr_budynku = ?, Nr_lokalu = ?, Nr_telefonu = ?, data_urodzenia = ?, data_zatrudnienia = ?, nr_zarzadu = ?, nr_poczty = ?, nr_stanowiska = ? WHERE nr_pracownika = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setString(1, prac.Imie);
            stmt.setString(2, prac.Nazwisko);
            stmt.setString(3, prac.Miejscowosc);
            stmt.setString(4, prac.Miejscowosc);
            stmt.setString(5, prac.Ulica);
            stmt.setString(6, prac.NrBudynku);
            stmt.setString(7, prac.NrLokalu);
            stmt.setString(8, prac.NrTelefonu);
            stmt.setString(9, prac.DataUrodzenia);
            stmt.setString(10, prac.DataZatrudnienia);
            stmt.setInt(11, prac.NrZarzadu);
            stmt.setInt(12, prac.NrPoczty);
            stmt.setInt(13, prac.NrPracownika);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
    
    int deletePracownik(Connection conn, Integer ID){
        PreparedStatement stmt = null;
        int result;
        
        String statement = "DELETE FROM Pracownicy WHERE nr_pracownika = ?";
        try{
            stmt = conn.prepareStatement(statement);
            stmt.setInt(1, ID);
            result = stmt.executeUpdate();
        } catch (SQLException exc){
            result = 0;
        }
        return result;
    }
}

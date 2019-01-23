/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author micha
 */
public class PracownicyTableModel extends AbstractTableModel{
    private List<Pracownicy> pracownicyList;
    private String[] columnName = {"Nr pracownika","Imie","Nazwisko","Miejscowosc","Ulica","Nr budynku","Nr lokalu","Nr telefonu","Data urodzenia","Data zatrudnienia","Na zarządu","Nr poczty","Nr staowiska"};
    
    public PracownicyTableModel(List<Pracownicy> pracownicyList){
        this.pracownicyList = pracownicyList;
    }
    
    @Override
    public int getRowCount() {
        return pracownicyList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pracownicy pracownik = new Pracownicy();
        pracownik = pracownicyList.get(rowIndex);
        if(columnIndex == -1){
            return pracownik;
        }
        switch(columnIndex){
            case 0: return pracownik.getNrPracownika();
            case 1: return pracownik.getImie();
            case 2: return pracownik.getNazwisko();
            case 3: return pracownik.getMiejscowosc();
            case 4: return pracownik.getUlica();
            case 5: return pracownik.getNrBudynku();
            case 6: return pracownik.getNrLokalu();
            case 7: return pracownik.getNrTelefonu();
            case 8: return pracownik.getDataUrodzenia();
            case 9: return pracownik.getDataZatrudnienia();
            case 10: return pracownik.getNrZarzadu();
            case 11: return pracownik.getNrPoczty();
            case 12: return pracownik.getNrStanowiska();
        }
        
        return "null";
    }
    @Override
    public String getColumnName(int index) {
        return columnName[index];
    }       
}

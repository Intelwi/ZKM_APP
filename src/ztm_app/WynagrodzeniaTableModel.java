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
public class WynagrodzeniaTableModel extends AbstractTableModel{

    private List<Wynagrodzenia> wynagrodzeniaList;
    private String[] columnName = {"Nr wynagrodzenia","Kwota podstawowa","Premia","Data wynagrodzenia","Nr pracownika"};
    
    public WynagrodzeniaTableModel(List<Stanowiska> stanowiskaList){
        this.wynagrodzeniaList = wynagrodzeniaList;
    }
    
    @Override
    public int getRowCount() {
        return wynagrodzeniaList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
        wynagrodzenie = wynagrodzeniaList.get(rowIndex);
        switch(columnIndex){
            case 0: return wynagrodzenie.getNrWynagrodzenia();
            case 1: return wynagrodzenie.getKwotaPodstawowa();
            case 2: return wynagrodzenie.getPremia();
            case 3: return wynagrodzenie.getDataWynagrodzenia();
            case 4: return wynagrodzenie.getNrPracownika();
        }
        return "null";
    }
    @Override
    public String getColumnName(int index) {
        return columnName[index];
    }    
    
}

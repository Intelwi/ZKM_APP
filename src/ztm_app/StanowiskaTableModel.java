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
public class StanowiskaTableModel extends AbstractTableModel{

    private List<Stanowiska> stanowiskaList;
    private String[] columnName = {"Nr stanowiska","Nazwa stanowiska","Opis"};
    
    public StanowiskaTableModel(List<Stanowiska> stanowiskaList){
        this.stanowiskaList = stanowiskaList;
    }
    
    @Override
    public int getRowCount() {
        return stanowiskaList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stanowiska stanowisko = new Stanowiska();
        stanowisko = stanowiskaList.get(rowIndex);
        switch(columnIndex){
            case 0: return stanowisko.getNrStanowiska();
            case 1: return stanowisko.getNazwaStanowiska();
            case 2: return stanowisko.getOpis();
        }
        return "null";
    }
    @Override
    public String getColumnName(int index) {
        return columnName[index];
    }  
    public Stanowiska getRow(int index) {
        return stanowiskaList.get(index);
    } 
}

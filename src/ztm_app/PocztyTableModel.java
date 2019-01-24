/*
 * Klasa uzywana do obslugi klasy PocztyJFrame.
 */
package ztm_app;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dawid Gruszczyński, Michał Stolarz
 */
public class PocztyTableModel extends AbstractTableModel{

    private List<Poczty> pocztyList;
    private String[] columnName = {"Nr poczty","Kod pocztowy","Poczta"};
    
    public PocztyTableModel(List<Poczty> pocztyList){
        this.pocztyList = pocztyList;
    }
    
    @Override
    public int getRowCount() {
        return pocztyList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Poczty poczta = new Poczty();
        poczta = pocztyList.get(rowIndex);
        if(columnIndex == -1){
            return poczta;
        }
        switch(columnIndex){
            case 0: return poczta.getNrPoczty();
            case 1: return poczta.getKodPocztowy();
            case 2: return poczta.getPoczta();
        }
        return "null";
    }

    @Override
    public String getColumnName(int index) {
        return columnName[index];
    }
}

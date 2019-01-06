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

    private List<Poczta> pocztyList;
    private String[] columnName = {"Nr poczty","Kod pocztowy","Poczta"};
    
    public PocztyTableModel(List<Poczta> pocztyList){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

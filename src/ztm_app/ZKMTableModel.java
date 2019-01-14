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
public class ZKMTableModel extends AbstractTableModel{
    private List<ZKM> zkmList;
    private String[] columnName = {"Nr zarządu","Nazwa zarządu","Ulica","Nr budynku","Nr telefonu","Email","Nr poczty"};
    
    public ZKMTableModel(List<ZKM> zkmList){
        this.zkmList = zkmList;
    }
    
    @Override
    public int getRowCount() {
        return zkmList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZKM zkm = new ZKM();
        zkm = zkmList.get(rowIndex);
        switch(columnIndex){
            case 0: return zkm.getNrZarzadu();
            case 1: return zkm.getNazwaZarzadu();
            case 2: return zkm.getUlica();
            case 3: return zkm.getNrBudynku();
            case 4: return zkm.getNrTelefonu();
            case 5: return zkm.getEmail();
            case 6: return zkm.getNrPoczty();
        }
        return "null";
    }
    @Override
    public String getColumnName(int index) {
        return columnName[index];
    }    
}

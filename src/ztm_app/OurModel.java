/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author DAWID
 */
public class OurModel implements ComboBoxModel<String> { 
    private List<String> list = new ArrayList();
    private javax.swing.JComboBox<String> searchByComboBox;
    
    public OurModel(Integer option, javax.swing.JComboBox<String> searchByComboBox){
        this.searchByComboBox = searchByComboBox;
        switch (option){
            case 0:
                list.add("Nr_pracownika");
                list.add("Imię");
                list.add("Nazwisko");
                break;
            case 1:
                list.add("Nr_poczty");
                list.add("Kod_pocztowy");
                list.add("Poczta");
                break;
            case 2:
                list.add("Nr_wynagrodzenia");
                list.add("Data_wynagrodzenia");
                list.add("Nr_pracownika");
                break;
        }
    }

    @Override
    public void setSelectedItem(Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSelectedItem() {
        return 0;
    }

    @Override
    public int getSize() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return list.size();
    }

    @Override
    public String getElementAt(int i) {
        return list.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    
}

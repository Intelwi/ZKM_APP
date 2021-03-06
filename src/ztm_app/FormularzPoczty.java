/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class FormularzPoczty extends javax.swing.JFrame {

    /**
     * Creates new form FormularzPoczty
     */
    
    private adminWindow adminFormular; 
    private Boolean isToAdd;
    private Connection conn;
    
    public FormularzPoczty() {
        initComponents();
        this.setLocationRelativeTo(adminFormular);
    }

    public FormularzPoczty(Connection conn, Integer ID, adminWindow admin, Boolean isToAdd) {
        initComponents();
        this.conn = conn;
        this.setLocationRelativeTo(adminFormular);
        this.adminFormular = admin;
        this.isToAdd = isToAdd;
        nrPocztyLabel.setText(ID.toString());
        nrPocztyLabel.setEnabled(true);
    }
    
    public FormularzPoczty(Connection conn, Poczty poczta, adminWindow admin, Boolean isToAdd) {
        initComponents();
        this.conn = conn;
        this.setLocationRelativeTo(adminFormular);
        this.adminFormular = admin;
        this.isToAdd = isToAdd;
        nrPocztyLabel.setText(poczta.getNrPoczty().toString());
        kodPocztowyLabel.setText(poczta.getKodPocztowy().toString());
        pocztaLabel.setText(poczta.getPoczta().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nrPocztyLabel = new javax.swing.JTextField();
        kodPocztowyLabel = new javax.swing.JTextField();
        pocztaLabel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        commitButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        infoLabel.setText("Dodawanie/Modyfikacja rekordu w tabeli poczt");

        jLabel2.setText("Nr poczty");

        jLabel3.setText("Kod pocztowy");

        jLabel4.setText("Poczta");

        nrPocztyLabel.setEnabled(false);
        nrPocztyLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nrPocztyLabelActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 34, 34));
        jLabel6.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 34, 34));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 34, 34));
        jLabel8.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nrPocztyLabel)
                    .addComponent(pocztaLabel)
                    .addComponent(kodPocztowyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nrPocztyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kodPocztowyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pocztaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commitButton.setText("Commit");
        commitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commitButtonActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 34, 34));
        jLabel10.setText("* pole obowiązkowe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(infoLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commitButton)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commitButton)
                    .addComponent(jLabel10))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nrPocztyLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nrPocztyLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nrPocztyLabelActionPerformed

    private void commitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commitButtonActionPerformed
        Poczty poczta = new Poczty();

        try{
            if (nrPocztyLabel.getText().trim().isEmpty() || kodPocztowyLabel.getText().trim().isEmpty() || pocztaLabel.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Obowiązkowe pola nie zostały wypełnione","Błąd",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        
            poczta.setNrPoczty(Integer.parseInt(nrPocztyLabel.getText().trim()));
            poczta.setKodPocztowy(kodPocztowyLabel.getText().trim());
            poczta.setPoczta(pocztaLabel.getText().trim());
        }
        
        catch(NumberFormatException exc){
            JOptionPane.showMessageDialog(this,"Wprowadzono niepoprawne dane","Błąd",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (isToAdd){
            if (poczta.addPoczta(conn, poczta) != 0){
                JOptionPane.showMessageDialog(this,"Rekord został pomyślnie dodany do bazy danych","Sukces",JOptionPane.INFORMATION_MESSAGE);
                adminFormular.setEnabled(true);
                this.dispose();
            } else 
                JOptionPane.showMessageDialog(this,"Nie udało się dodać rekordu do bazy danych","Błąd",JOptionPane.WARNING_MESSAGE);
        } else {
            if (poczta.updatePoczty(conn, poczta) != 0){
                JOptionPane.showMessageDialog(this,"Rekord został pomyślnie zmodyfikowany","Sukces",JOptionPane.INFORMATION_MESSAGE);
                adminFormular.setEnabled(true);
                this.dispose();
            } else 
                JOptionPane.showMessageDialog(this,"Nie udało się zmodyfikować rekordu","Błąd",JOptionPane.WARNING_MESSAGE);
        }
        adminFormular.refreshTable();
    }//GEN-LAST:event_commitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commitButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kodPocztowyLabel;
    private javax.swing.JTextField nrPocztyLabel;
    private javax.swing.JTextField pocztaLabel;
    // End of variables declaration//GEN-END:variables
}

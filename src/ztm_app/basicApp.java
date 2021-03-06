/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ztm_app;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author DAWID
 */
public class basicApp extends javax.swing.JFrame {
    /**
     * Creates new form basicApp
     */
    private Connection conn;
    private Integer pracownikID;
    Integer option = 0;
    public basicApp() {
        initComponents();
        this.setResizable(false);
        setLocation(300, 200);
    }
    public basicApp(Connection conn) {
        this.conn = conn;
        initComponents();
        this.setResizable(false);
        setLocation(300, 200);
        
    }
    public basicApp(Connection conn, Integer nr_pracownika) {
        this.conn = conn;
        this.pracownikID = nr_pracownika;
        initComponents();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select imię, nazwisko from pracownicy where nr_pracownika = ?";

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, nr_pracownika);
            rs = stmt.executeQuery();
            while (rs.next()){
                userNameLabel.setText(rs.getString(1) + " " + rs.getString(2));
            }
            mainTable.setModel(new PracownicyTableModel(new Pracownicy().getRestrictedPracownik(conn, pracownikID)));
        } catch (SQLException exc){
            JOptionPane.showMessageDialog(this,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE);
            this.dispose();
        } catch (NullPointerException exc){
            JOptionPane.showMessageDialog(this,"Nie znaleziono danych","Error",JOptionPane.ERROR_MESSAGE);
            this.dispose();
            this.dispose();
        }
        this.setResizable(false);
        setLocation(300, 200);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choiceGroup = new javax.swing.ButtonGroup();
        topPanel = new javax.swing.JPanel();
        loggedLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        choiceLabel = new javax.swing.JLabel();
        personalDataButton = new javax.swing.JRadioButton();
        salaryButton = new javax.swing.JRadioButton();
        stanowiskoButton = new javax.swing.JRadioButton();
        tablePane = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Baza Komunikacji Miejskiej BetaVersion");
        setForeground(new java.awt.Color(0, 51, 51));

        loggedLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loggedLabel.setText("Zalogowany jako:");

        userNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userNameLabel.setText("Imię i nazwisko");

        logOutButton.setText("Wyloguj");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(loggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        choiceLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        choiceLabel.setText("Wybierz informacje jakie chcesz wyszukać:");

        choiceGroup.add(personalDataButton);
        personalDataButton.setSelected(true);
        personalDataButton.setText("Dane osobowe");
        personalDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalDataButtonActionPerformed(evt);
            }
        });

        choiceGroup.add(salaryButton);
        salaryButton.setText("Wynagrodzenia");
        salaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryButtonActionPerformed(evt);
            }
        });

        choiceGroup.add(stanowiskoButton);
        stanowiskoButton.setText("Stanowisko");
        stanowiskoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stanowiskoButtonActionPerformed(evt);
            }
        });

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mainTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablePane.setViewportView(mainTable);

        searchButton.setText("Wyszukaj");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choiceLabel)
                    .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(salaryButton)
                                .addComponent(stanowiskoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(personalDataButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(choiceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personalDataButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(salaryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stanowiskoButton)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(topPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personalDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalDataButtonActionPerformed
        option = 0;
        try{
            mainTable.setModel(new PracownicyTableModel(new Pracownicy().getRestrictedPracownik(conn, pracownikID)));
        } catch(SQLException exc){
            JOptionPane.showMessageDialog(this,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_personalDataButtonActionPerformed

    private void salaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryButtonActionPerformed
        option = 1;
        try{
            mainTable.setModel(new WynagrodzeniaTableModel(new Wynagrodzenia().getRestrictedWynagrodzenie(conn, pracownikID)));
        } catch(SQLException exc){
            System.err.println(exc);
            JOptionPane.showMessageDialog(this,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_salaryButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try{
            switch (option){
                case 0:
                    mainTable.setModel(new PracownicyTableModel(new Pracownicy().getRestrictedPracownik(conn, pracownikID)));
                    break;
                case 1:
                    mainTable.setModel(new WynagrodzeniaTableModel(new Wynagrodzenia().getRestrictedWynagrodzenie(conn, pracownikID)));
                    break;
                case 2:
                    mainTable.setModel(new StanowiskaTableModel(new Stanowiska().getRestrictedStanowisko(conn, pracownikID)));
                    break;
            }
        } catch(SQLException exc){
            JOptionPane.showMessageDialog(this,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void stanowiskoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stanowiskoButtonActionPerformed
        option = 2;
        try{
            mainTable.setModel(new StanowiskaTableModel(new Stanowiska().getRestrictedStanowisko(conn, pracownikID)));
        } catch(SQLException exc){
            JOptionPane.showMessageDialog(this,"Nie udało się połączyć z bazą danych","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stanowiskoButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        Integer userOption;
        userOption = JOptionPane.showConfirmDialog(this, "Na pewno chcesz się wylogować?", "Wylogowywanie",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (userOption == JOptionPane.YES_OPTION){
            userOption = JOptionPane.showConfirmDialog(this, "Jestes pewien?", "Wylogowywanie",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (userOption == JOptionPane.YES_OPTION){
                try{
                    conn.close();
                } catch(SQLException exc){
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_logOutButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.ButtonGroup choiceGroup;
    private javax.swing.JLabel choiceLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel loggedLabel;
    private javax.swing.JTable mainTable;
    private javax.swing.JRadioButton personalDataButton;
    private javax.swing.JRadioButton salaryButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JRadioButton stanowiskoButton;
    private javax.swing.JScrollPane tablePane;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}

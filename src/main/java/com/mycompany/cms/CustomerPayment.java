/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

/**
 *
 * @author AmirIjaz
 */
public class CustomerPayment extends javax.swing.JFrame {

    /**
     * Creates new form CustomerPayment
     */
    String theater = "";
    String movie = "";
    String getcardNo = null;
    String getCVV = null;
    String getDate = null;
    String getPrice = null;
    String email;
    int p_id;

    public CustomerPayment() {
        initComponents();
        dataInsertPrice();
    }

    public CustomerPayment(String theater, String movie, String email) {
        this.theater = theater;
        this.movie = movie;
        this.email = email;
        initComponents();
        dataInsertPrice();
    }

    public void dataInsertPrice() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fatima1", "12345");
            java.sql.Statement st = con.createStatement();
            String SQL = "SELECT * From theater where t_name='" + theater + "'";
            ResultSet result = st.executeQuery(SQL);
            while (result.next()) {
                getPrice = result.getString("t_tickets_price");
                pricelabel.setText("Total Price " + getPrice);

            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JLabel();
        card = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        cvv = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        back = new javax.swing.JButton();
        pricelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        top.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        top.setText("Enter Payment Details");

        card.setText("Enter Card No");

        date.setText("Enter Date");

        cvv.setText("Enter CVV");

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        pricelabel.setText("Total Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pricelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(top)
                .addGap(18, 18, 18)
                .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(pricelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CustomerBuyTickets().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        // TODO add your handling code here:
        Connection con;
        try {
            Random r = new Random();
            p_id = r.nextInt(100) + 1;

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fatima1", "12345");
            java.sql.Statement st = con.createStatement();
            String SQL = "INSERT INTO payment (p_id, p_date, customer_email_id, p_card_no, p_cvv) Values ('" + p_id + "','" + date.getText() + "','" + email + "','" + card.getText() + "', '" + cvv.getText() + "')";
            ResultSet result = st.executeQuery(SQL);
            addTicketData();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_confirmActionPerformed

    public void addTicketData() {

        Connection con;
        try {
            Random r = new Random();
            int randId = r.nextInt(100) + 1;

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fatima1", "12345");
            java.sql.Statement st = con.createStatement();
            String SQL = "INSERT INTO tickets (ticket_id, ticket_price, ticket_date, payment_p_id, movies_m_name, customer_email_id, employee_e_id) Values ('" + randId + "','" + getPrice + "','" + date.getText() + "','" + p_id + "', '" + movie + "', '" + email + "', '" + randId + "')";
            ResultSet result = st.executeQuery(SQL);

            updateTheaterTickets();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void updateTheaterTickets() {
        int soldTickets = 0;
        Connection con;
        try {
            Random r = new Random();
            int randId = r.nextInt(100) + 1;

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "fatima1", "12345");
            java.sql.Statement st = con.createStatement();
            String SQL = "Select * from theater where t_name='" + theater + "'";
            ResultSet result = st.executeQuery(SQL);
            while (result.next()) {
                soldTickets = Integer.parseInt(result.getString("t_sold_tickets"));
            }
            soldTickets = soldTickets + 1;
            SQL = "UPDATE theater SET t_sold_tickets='" + soldTickets + "' WHERE t_name='" + theater + "'";
            result = st.executeQuery(SQL);
            this.setVisible(false);
            new CustomerDashboard().setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField card;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField cvv;
    private javax.swing.JTextField date;
    private javax.swing.JLabel pricelabel;
    private javax.swing.JLabel top;
    // End of variables declaration//GEN-END:variables
}

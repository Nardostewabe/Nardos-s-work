/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package school_project;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fasik
 */
public class user_menu extends javax.swing.JFrame {

    /**
     * Creates new form user_menu
     */
    public user_menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view = new javax.swing.JButton();
        issue = new javax.swing.JButton();
        returns = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Functions");

        view.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        view.setText("View Books");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        issue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        issue.setText("Borrow Book");
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        returns.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        returns.setText("Return Book");
        returns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(issue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(returns)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returns, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        Issuebook i = new Issuebook();
        i.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_issueActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
         JFrame f = new JFrame("Books Available");
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
         String[] columnNames = {"Title", "Id", "Author"};
         Connection connection= null;
         try{
         connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
         Statement stmt = connection.createStatement();
         String sql = ("SELECT * FROM books");
             ResultSet rs = stmt.executeQuery(sql);
               JTable book_list= new JTable();
               DefaultTableModel x = new DefaultTableModel();
               x.setColumnIdentifiers(columnNames);
                book_list.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        book_list.setFillsViewportHeight(true);
               book_list.setModel(x);
        String title= "";
        int id ;
        String author= "";
            int i = 0;
            while (rs.next()) {
                id = rs.getInt("book_id");
                title= rs.getString("book_name");
                author= rs.getString("author");
                x.addRow(new Object[]{id, title, author});
                i++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
                JScrollPane scrollPane = new JScrollPane(book_list);
                f.add(scrollPane);
                f.setSize(800, 400);
                f.setVisible(true);
         }// TODO add your handling code here:
         catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_viewActionPerformed

    private void returnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnsActionPerformed
        Return_book r= new Return_book();
        r.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_returnsActionPerformed

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
            java.util.logging.Logger.getLogger(user_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton issue;
    private javax.swing.JButton returns;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}

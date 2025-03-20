
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ganar
 */
public class UpdateAddress extends javax.swing.JFrame {

    /**
     * Creates new form LoginSuccessful
     */
    public UpdateAddress() {
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

        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(650, 350));
        setMaximumSize(new java.awt.Dimension(550, 300));
        setMinimumSize(new java.awt.Dimension(550, 300));
        getContentPane().setLayout(null);

        jLabel1.setDisplayedMnemonic('L');
        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 21)); // NOI18N
        jLabel1.setText("Enter Employee ID :-");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 35));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 35));
        jLabel1.setName("successMessage"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, -10, 364, 66);

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("UPDATE");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(60, 170, 145, 60);

        jToggleButton2.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton2.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("BACK");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2);
        jToggleButton2.setBounds(280, 170, 134, 60);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(60, 40, 360, 40);

        jLabel2.setDisplayedMnemonic('L');
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 21)); // NOI18N
        jLabel2.setText("Enter New Address :-");
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 35));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 35));
        jLabel2.setName("successMessage"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 70, 364, 66);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(60, 120, 360, 40);
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 100, 100);

        jDesktopPane2.setMaximumSize(new java.awt.Dimension(550, 300));
        jDesktopPane2.setMinimumSize(new java.awt.Dimension(550, 300));
        getContentPane().add(jDesktopPane2);
        jDesktopPane2.setBounds(0, 0, 640, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
         String eaddress = jTextField2.getText();
         int eid = Integer.parseInt(jTextField1.getText());
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms2","root","");
        
     
        
        Statement smt = con.createStatement();
        //smt.executeUpdate("DELETE from employee where eid = " + eid +"");
         ResultSet rs=smt.executeQuery("select * from employee where eid="+eid+"");
         //while(rs.next()){
            // int result;
        // }
         if(rs.next()==false){
             new DeleteFail().setVisible(true);
         }
         else{
            smt.executeUpdate("UPDATE employee set eaddress ='"+ eaddress + "' where eid = " + eid +"");
             new UpdateSuccess().setVisible(true);
         }

        System.out.println("Connection Established Successfully");
       
        
        
        
        con.close();
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e); 
        }                                       

                                                      

     // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        new Update().setVisible(true);
            setVisible(false);
            //System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAddress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}

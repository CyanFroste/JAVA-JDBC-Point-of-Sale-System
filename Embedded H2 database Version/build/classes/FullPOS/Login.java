package FullPOS;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * @author Cyan Froste
 */
public class Login extends javax.swing.JFrame {
    /**
     * Creates new form Login
     */
    int mousepX;
    int mousepY;
    
    public Login() {
        initComponents();
        TextFieldStyler(txtLUsername);
        TextFieldStyler(txtLPassword);        
    }
    
    private static final String URL = "jdbc:h2:~/pos"; 
    private static final String USER = "root";
    private static final String PASS = "";    
    Connection con = null;
    PreparedStatement pstmt  = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd  = null;
    Statement stmt = null;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        txtLUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        txtLPassword = new javax.swing.JPasswordField();
        close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.96F);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans Extrabold", 0, 24)); // NOI18N
        jLabel1.setText("LOG IN");
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        labelUsername.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        labelUsername.setText("Username :");

        txtLUsername.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        txtLUsername.setForeground(new java.awt.Color(51, 51, 51));
        txtLUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLUsernameKeyPressed(evt);
            }
        });

        labelPassword.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        labelPassword.setText("Password :");

        txtLPassword.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        txtLPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLPasswordKeyPressed(evt);
            }
        });

        close.setFont(new java.awt.Font("Open Sans", 2, 14)); // NOI18N
        close.setForeground(new java.awt.Color(255, 51, 0));
        close.setText("exit");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        close.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                closeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsername)
                            .addComponent(labelPassword))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtLPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(close)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(txtLUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(txtLPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Login();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }//GEN-LAST:event_txtLPasswordKeyPressed
    
    private void closeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeKeyPressed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void txtLUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLUsernameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Login();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }//GEN-LAST:event_txtLUsernameKeyPressed
    
    public void getPrerequisites(){
        try{
            
            con = DriverManager.getConnection(URL,USER,PASS);
            stmt = con.createStatement();
            
            stmt.execute("CREATE TABLE catalogtable (\n" +
                "  PID int(12) AUTO_INCREMENT PRIMARY KEY,\n" +
                "  prodname varchar(10) NOT NULL,\n" +
                "  description text DEFAULT NULL,\n" +
                "  PCID int(12) NOT NULL,\n" +
                "  MRP decimal(14,2) NOT NULL,\n" +
                "  costprice decimal(14,2) DEFAULT NULL,\n" +
                "  qty int(12) NOT NULL,\n" +
                "  prodstatus varchar(200) NOT NULL,\n" +
                "  prodcode int(12) NOT NULL,\n" +
                "  tax int(12) DEFAULT NULL\n" +
                ")");
            
            stmt.execute("CREATE TABLE category (\n" +
                "  CID int(12) AUTO_INCREMENT PRIMARY KEY,\n" +
                "  catname varchar(200) NOT NULL,\n" +
                "  status varchar(200) NOT NULL\n" +
                ")");
            
            stmt.execute("CREATE TABLE productsold (\n" +
                "  ID int(12) AUTO_INCREMENT PRIMARY KEY,\n" +
                "  SID int(12) NOT NULL,\n" +
                "  prodcode int(12) NOT NULL,\n" +
                "  MRP decimal(14,2) NOT NULL,\n" +
                "  total decimal(14,2) NOT NULL,\n" +
                "  qty int(12) NOT NULL,\n" +
                "  discount varchar(200) DEFAULT NULL\n" +
                ")");
            
            stmt.execute("CREATE TABLE salestable (\n" +
                "  SID int(12) AUTO_INCREMENT PRIMARY KEY,\n" +
                "  date varchar(200) NOT NULL,\n" +
                "  total decimal(14,2) NOT NULL,\n" +
                "  paid decimal(14,2) NOT NULL,\n" +
                "  balance decimal(14,2) NOT NULL,\n" +
                "  user varchar(200) NOT NULL\n" +
                ")");
            
            stmt.execute("CREATE TABLE users (\n" +
               "  ID int(12) AUTO_INCREMENT PRIMARY KEY,\n" +
               "  username varchar(200) NOT NULL,\n" +
               "  password varchar(200) NOT NULL,\n" +
               "  status varchar(200) NOT NULL,\n" +
               "  type varchar(200) NOT NULL\n" +
               ")");               
                    
            
            stmt.executeUpdate("INSERT INTO users VALUES (1, 'admin', 'none', 'Active', 'admin')");
            
            
            String name = "";
           
           
            rs = stmt.executeQuery("SELECT * FROM users");
            while(rs.next()){
                name = rs.getString("username");
            }
            
            
            JOptionPane.showMessageDialog(this, "Initial Setup Complete!");
            
            
        }catch(SQLException e){
            
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e, "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        getPrerequisites();
    }//GEN-LAST:event_formWindowOpened

    private void TextFieldStyler(JTextField textField){
        textField.setHorizontalAlignment(JTextField.CENTER);
    }    
    
    private void Login() throws ClassNotFoundException{
        String Username = txtLUsername.getText();        
        String Password = String.valueOf(txtLPassword.getPassword());        
        try{
            con = DriverManager.getConnection(URL,USER,PASS);Class.forName ("org.h2.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            String sql = "SELECT type FROM users WHERE username=? and password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Username);
            pstmt.setString(2, Password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                // if admin
                switch (rs.getString("type")) {
                    case "admin":
                        {
                            MainPOS session = new MainPOS();
                            new MainPOS(txtLUsername.getText()).setVisible(true);
                            this.dispose();
                            break;
                        }
                    case "manager":
                        {
                            MainPOSuserLevel session = new MainPOSuserLevel();
                            new MainPOSuserLevel(txtLUsername.getText()).setVisible(true);
                            this.dispose();
                            break;
                        }
                    default:
                        {
                            MainPOScounterLevel session = new MainPOScounterLevel();
                            this.dispose();
                            new MainPOScounterLevel(txtLUsername.getText()).setVisible(true);
                            break;
                        }
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e, "SQL Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e, "SQL Error", JOptionPane.ERROR_MESSAGE);
            }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField txtLPassword;
    private javax.swing.JTextField txtLUsername;
    // End of variables declaration//GEN-END:variables
}
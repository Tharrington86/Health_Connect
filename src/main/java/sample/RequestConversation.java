/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
package sample;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RequestConversation extends javax.swing.JFrame {
    int requestNumber;
    String userID;
    String userType;
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    String element;
    int testSignal;

    public void setFinalString(String finalString) {
        this.finalString = finalString;
    }
    public void setTestSignal(int testSignal){
        this.testSignal = testSignal;
    }

    String finalString = "noTest";

    public RequestConversation() {

    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public void setElement(String element) {
        this.element = element;
    }
    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
        return conn;
    }
    /**
     * Creates new form RequestConversation     * @param new_requestID     * @param new_userID     * @param new_userType
     */
    public RequestConversation(int new_requestID, String new_userID, String new_userType) {
        initComponents();
        requestNumber = new_requestID;
        userID = new_userID;
        userType = new_userType;
        try {
            conn = connection();
            //JOptionPane.showMessageDialog (null, "Connected");
            Statement statement = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        String sql = "select * from Message where RID=?";
        try {
            pst = conn.prepareStatement(sql);
            String temp = Integer.toString(requestNumber);
            pst.setString(1, temp);
            rs = pst.executeQuery();
            currentRequest.setLineWrap(true);
            currentRequest.setWrapStyleWord(true);
            addToRequest.setLineWrap(true);
            addToRequest.setWrapStyleWord(true);
            if (rs.next()) {
                element = rs.getString("TimeStamp");
                currentRequest.append(element + "\n");
                element = rs.getString("Message");
                currentRequest.append(element + "\n");
                while (rs.next()) {
                    element = rs.getString("TimeStamp");
                    currentRequest.append(element + "\n");
                    element = rs.getString("Message");
                    currentRequest.append(element + "\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No message added");
            }
            if ("Doctor".equals(userType)) {
                sql = "update Message set DUsername=? where RID=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, userID);
                //noinspection JpaQueryApiInspection
                pst.setString(2, temp);
                pst.execute();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        sql = "select Status from Request where RID =?";
        try {
            pst = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);       //added ability to move the pointer
            String temp = Integer.toString(requestNumber);
            pst.setString(1, temp);
            rs = pst.executeQuery();

            // reset the result set pointer to the first record
            rs.first();

            if ("Closed".equals(rs.getString("Status"))) {
                closeButton.setEnabled(false);
                addButton.setEnabled(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        currentRequest = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        addToRequest = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        currentRequest.setColumns(20);
        currentRequest.setRows(5);
        jScrollPane1.setViewportView(currentRequest);
        addToRequest.setColumns(20);
        addToRequest.setRows(5);
        jScrollPane2.setViewportView(addToRequest);
        addButton.setText("Add to Request");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        closeButton.setText("Close Request");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jLabel7.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("HealthConnect");
        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 2, 24)); // NOI18N
        jLabel1.setText("View Request");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(30, 30, 30)
                                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 19, Short.MAX_VALUE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(closeButton)
                                                .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backButton))
                                        .addGap(6, 6, 6))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pack();
    }// </editor-fold>

    public boolean addButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to add your message to the request?", "Add To Request", JOptionPane.YES_NO_OPTION);
        if (pane == 0) {
            String sql = "insert into Message (RID, DUsername, TimeStamp, Message) values (?, ?, ?, ?)";

            try {
                conn = connection();
                pst = conn.prepareStatement(sql);
                String temp = Integer.toString(requestNumber);
                pst.setString(1, temp);
                pst.setString(2, userID);
                Date date = new Date();
                String timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
                pst.setString(3, timestamp);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\n");
                if(finalString == "noTest"){
                    stringBuilder.append(addToRequest.getText());
                    stringBuilder.append("\n Added by ").append(userType).append(" ").append(userID);
                    finalString = stringBuilder.toString();
                }
                else{
                    finalString = finalString + "\n Added by " + userType + " " + userID;;
                }
                pst.setString(4, finalString);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Message added");

                /* Added the if statement so that the status can only be changed to "In Progress"
                 * when a doctor adds to the message, otherwise if the patient adds to it prior
                 * to the doctor seeing it, it will be moved into "In Progress" and the doctor
                 * will not be able to view it. Additionally the else statement prevents the
                 * status from changing to "New" everytime the patient adds to the message
                */
                if ("Doctor".equals(userType)) {
                    sql = "update Request set Status ='In Progress' where RID =?";
                }
                else {
                    // dont change the status if already "in progress"
                    sql = "update Request set Status = 'New' where RID =? and Status <> 'In Progress'";
                }
                pst = conn.prepareStatement(sql);
                temp = Integer.toString(requestNumber);
                pst.setString(1, temp);
                pst.execute();
                try{
                    currentRequest.append("\n");
                    currentRequest.append(timestamp);
                    currentRequest.append("\n");
                    currentRequest.append(finalString);
                    addToRequest.setText("");

                } catch(NullPointerException e) {
                    System.out.println(" ");
                }


                sql = "update Message set DUsername=? where RID =?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, userID);
                pst.setString(2, temp);
                pst.execute();

            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            } finally {
                try {
                    if (testSignal != 0) {
                        rs.close();
                    }
                    pst.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
        return true;
    }

    public boolean closeButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        int pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the request?", "Close Request", JOptionPane.YES_NO_OPTION);
        if (pane == 0) {
            String sql = "update Request set Status='Closed' where RID =?";
            try {
                conn = connection();
                pst = conn.prepareStatement(sql);
                String temp = Integer.toString(requestNumber);
                pst.setString(1, temp);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Request has been closed.");
            } catch (SQLException | HeadlessException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (testSignal != 0) {
                        rs.close();
                    }
                    pst.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            if ("Doctor".equals(userType)) {
                NewJFrame n = new NewJFrame();
                DoctorView d = new DoctorView(userID);
                d.setVisible(true);
                dispose();
            } else {
                NewJFrame n = new NewJFrame();
                PatientView p = new PatientView(userID);
                p.setVisible(true);
                dispose();
            }
        }

        return true;
    }


    public boolean backButtonActionPerformed(ActionEvent evt) throws NullPointerException {
        // TODO add your handling code here:
        //Added a if else block to close the rs and pst for testing
        if(testSignal != 0){
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        if ("Doctor".equals(userType)) {
            NewJFrame n = new NewJFrame();
            DoctorView d = new DoctorView(userID);
            d.setVisible(true);
            dispose();
        } else {
            NewJFrame n = new NewJFrame();
            PatientView p = new PatientView(userID);
            p.setVisible(true);
            dispose();
        }
        return true;
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestConversation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        //</editor-fold>

        NewJFrame n = new NewJFrame();
        final DoctorView d = new DoctorView(n.getUsername());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RequestConversation(d.getRequestID(), d.getUsername(), d.getUserType()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                         
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addToRequest;
    private javax.swing.JButton backButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea currentRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;    // End of variables declaration                   
}    
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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public final class DoctorView extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int curRow = 0;
    String username, userType;
    DefaultListModel model = new DefaultListModel();
    int index;
    int requestID;
    String testSqlString;

    public void setTestSqlString(String testSqlString) {
        this.testSqlString = testSqlString;
    }

    public DoctorView() {

    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Creates new form DoctorView     * @param doctor
     */
    public DoctorView(String doctor) {
        initComponents();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
            //JOptionPane.showMessageDialog (null, "Connected");
            Statement statement = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        setUsername(doctor);
        setUserType("Doctor");
        welcome.setText("Welcome Back, " + username + "!");
        requestsList.setVisible(false);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRequestID() {
        return this.requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestsList = new javax.swing.JList();
        viewedRequests = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        newRequestButton = new javax.swing.JButton();
        inProgressButton = new javax.swing.JButton();
        closeRequestButton = new javax.swing.JButton();
        openSelectedButton = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel5.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("HealthConnect");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        requestsList.setModel(new javax.swing.AbstractListModel() {

            //Previous code generated empty items in the table.
            // String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            String[] strings;

            public int getSize() {
                if (strings != null) {
                    return strings.length;
                } else {
                    return 0;
                }
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        requestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                requestsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(requestsList);
        viewedRequests.setFont(new java.awt.Font("Eras Demi ITC", 2, 18)); // NOI18N
        viewedRequests.setText("Requests");
        welcome.setFont(new java.awt.Font("Eras Demi ITC", 2, 24)); // NOI18N
        welcome.setText("Welcome Back");
        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("HealthConnect");
        newRequestButton.setText("New");
        newRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRequestButtonActionPerformed(evt);
            }
        });
        inProgressButton.setText("In Progress");
        inProgressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inProgressButtonActionPerformed(evt);
            }
        });
        closeRequestButton.setText("Closed");
        closeRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeRequestButtonActionPerformed(evt);
            }
        });
        openSelectedButton.setText("Open Selected Request");
        openSelectedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSelectedButtonActionPerformed(evt);
            }
        });
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator1)
                                        .addContainerGap())
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(viewedRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(39, 39, 39)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(closeRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(inProgressButton, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                .addComponent(newRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(0, 34, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(openSelectedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGap(289, 658, Short.MAX_VALUE)
                        .addComponent(logout).addGap(31, 31, 31)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(welcome))
                                .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewedRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(newRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)
                                        .addComponent(inProgressButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(closeRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openSelectedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        pack();
    }// </editor-fold>

    boolean newRequestButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String element;
        String sql = "select * from Request where Status=?";
        model.removeAllElements();
        element = "RID        Date                                        Patient Username";
        model.addElement(element);
        try {
            viewedRequests.setText("New Requests");
            requestsList.setVisible(true);
        } catch (NullPointerException e) {
            System.out.println(" ");
        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
            /*Created false string for SQL to check what happened if there is nothing new in the database*/

            if(testSqlString == "false"){
                testSqlString  = "false";
            }
            else{
                testSqlString = "New";
            }
            pst = conn.prepareStatement(sql);
            pst.setString(1, testSqlString);
            rs = pst.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                model.addElement(element);
                while (rs.next()) {
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " +
                            rs.getString("PUsername");
                    model.addElement(element);
                }
                try {
                    requestsList.setModel(model);
                }
                catch(NullPointerException e) {
                    System.out.println(" ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No new requests created.");
                return false;
            }
        } catch (SQLException | HeadlessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return true;
    }

    boolean inProgressButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        try{
            viewedRequests.setText("In Progress Requests");
            requestsList.setVisible(true);

        } catch (NullPointerException e) {
            System.out.println(" ");
        }

        String element;
        String sql = "select distinct Request.RID, Date, PUsername from Request, Message where Request.RID = Message.RID and Request.Status=? and Message.DUsername=?";
        model.removeAllElements();
        element = "RID        Date                                        Patient Username";
        model.addElement(element);
        try {
            if(testSqlString == "false"){
                testSqlString  = "false";
            }
            else{
                testSqlString = "In Progress";
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
            pst = conn.prepareStatement(sql);
            pst.setString(1, testSqlString);
            pst.setString(2, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                model.addElement(element);
                while (rs.next()) {
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                    model.addElement(element);
                }
                try {
                    requestsList.setModel(model);
                }
                catch(NullPointerException e) {
                    System.out.println(" ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No requests are in progress");
                return false;
            }
        } catch (SQLException | HeadlessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return true;
    }

    private void openSelectedButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (requestsList.getSelectedIndex() != -1) {
            String temp_requestID = requestsList.getSelectedValue().toString();
            temp_requestID = temp_requestID.substring(0, 3);
            requestID = Integer.parseInt(temp_requestID);
            setRequestID(requestID);
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            RequestConversation r = new RequestConversation(requestID, username, userType);
            dispose();
            r.setVisible(true);
        } else JOptionPane.showMessageDialog(null, "Please select a request");
    }

    boolean closeRequestButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        String element;
        String sql = "select Distinct Request.RID, Date, PUsername from Request, Message where Request.RID = Message.RID and Request.Status=? and Message.DUsername=?";
        model.removeAllElements();
        element = "RID        Date                                        Patient Username";
        model.addElement(element);
        try{
            viewedRequests.setText("Closed Requests");
            requestsList.setVisible(true);

        } catch (NullPointerException e) {
            System.out.println(" ");
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104-128-64-141.cloud-xip.io:3306/healthconnect?serverTimezone=UTC", "root", "Healthconnect1");
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Closed");
            pst.setString(2, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                model.addElement(element);
                while (rs.next()) {
                    element = rs.getString("RID") + "        " + rs.getString("Date") + "           " + rs.getString("PUsername");
                    model.addElement(element);
                }
                try{
                    requestsList.setModel(model);

                } catch (NullPointerException e) {
                    System.out.println(" ");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No requests have been closed.");
                return false;
            }
        } catch (SQLException | HeadlessException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return true;
    }

    private void requestsListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
        if (requestsList.getSelectedIndex() == -1) {
            //Nothing was selected.  Do nothing
        } else
            index = requestsList.getSelectedIndex();
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
        /* Removed the Try/Catch block here that was trying to close the conn.
           It was creating a null pointer exception due to the conn being closed
           by a previous operation
         */
        int pane = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (pane == 0) {
            dispose();
            NewJFrame n = new NewJFrame();
            n.setVisible(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        final NewJFrame s = new NewJFrame();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoctorView(s.getUsername()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton closeRequestButton;
    private javax.swing.JButton inProgressButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logout;
    private javax.swing.JButton newRequestButton;
    private javax.swing.JButton openSelectedButton;
    private javax.swing.JList requestsList;
    private javax.swing.JLabel viewedRequests;
    private javax.swing.JLabel welcome;    // End of variables declaration
}


import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class QuanLyDiem extends javax.swing.JFrame {
    
    private ArrayList<GradeStudent> list = new ArrayList<GradeStudent>();
    private int CurrentIndex = -1;
    GradeStudent st = new GradeStudent();
    double AVG;
    private String header[] = {"StudentID", "Name", "Java", "English", "GDTC", "AVG"};
    DefaultTableModel model =new DefaultTableModel(header,0);
    /**
     * Creates new form QuanLyDiem
     */
    public QuanLyDiem() {
        initComponents();
        loadData();
        DisplayStudent(CurrentIndex);
        loadDataToTable();
    }
     private void loadDataToTable() {
        try {
            
            Connection conn = null;
            Statement stmt = null;
            //connection databse
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            //Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Top 3 ID, GRADE.MASV AS MASV, Hoten, Tienganh, Tinhoc, GDTC ,((Tinhoc+Tienganh+GDTC)/3) AS TB FROM GRADE, STUDENTS WHERE GRADE.MASV = STUDENTS.MASV ORDER BY TB DESC";
            ResultSet rs = stmt.executeQuery(sql);
            Vector sv = null;
            model.setRowCount(0);
            while (rs.next()) {
                sv = new Vector();
                sv.add(rs.getString("MASV"));
                sv.add(rs.getString("Hoten"));
                sv.add(rs.getString("Tinhoc"));
                sv.add(rs.getString("Tienganh"));
                sv.add(rs.getString("GDTC"));
                double avg = Integer.parseInt(rs.getString("Tinhoc")) + Integer.parseInt(rs.getString("Tienganh")) + Integer.parseInt(rs.getString("GDTC"));
                sv.add(avg/3);
                model.addRow(sv);
                
                
                
            }
        
            tblTop3.setModel(model);
            
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Connection Faild...");
        }
    }
    private void loadData() {
        txtStudentID.setEditable(false);
        txtName.setEnabled(false);
        try {
            list.clear();
            Connection conn = null;
            Statement stmt = null;
            //connection databse
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            //Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ID, GRADE.MASV AS MASV, Hoten, Tienganh, Tinhoc, " + "GDTC FROM GRADE, STUDENTS WHERE GRADE.MASV = STUDENTS.MASV";
            //dat cau lenh truy van o day...
            ResultSet rs = stmt.executeQuery(sql);

            //Doc du lieu tu database...
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String StudentID = rs.getString("MASV");
                String Name = rs.getString("Hoten");
                int Gdtc = rs.getInt("GDTC");
                int Tienganh = rs.getInt("Tienganh");
                int Tinhoc = rs.getInt("Tinhoc");
                
                //Them vao doi tuong vao list
                GradeStudent stu = new GradeStudent(StudentID, Name, ID, Tinhoc, Tienganh, Gdtc);
                list.add(stu);
                
                //doc du lieu len from  
            }
            CurrentIndex = 0;
            DisplayStudent(CurrentIndex);
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Connection Faild...");
        }
    }
    
    private void DisplayStudent(int i) {
        GradeStudent st = list.get(CurrentIndex);
        txtStudentID.setText(st.getMaSV());
        txtName.setText(st.getTenSV());
        txtGdtc.setText(String.valueOf(st.getGdtc()));
        txtEg.setText(String.valueOf(st.getTienganh()));
        txtTinhoc.setText(String.valueOf(st.getTinhoc()));
        UpdateAVG();
    }
    
    private void UpdateAVG() {
        double Java = Double.parseDouble(txtTinhoc.getText());
        double English = Double.parseDouble(txtEg.getText());
        double SQLServer = Double.parseDouble(txtGdtc.getText());
        AVG = (Java + English + SQLServer) / 3;
        txtAVG.setText(AVG + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNew = new javax.swing.JButton();
        btnSaveFile = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        bntUpdate = new javax.swing.JButton();
        btnSearch2 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtTinhoc = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtEg = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        bntPre = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtGdtc = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtAVG = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTop3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        Setting = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new2.jpg"))); // NOI18N
        btnNew.setText("New");
        btnNew.setFocusable(false);
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setMaximumSize(new java.awt.Dimension(50, 509));
        btnNew.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNew.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.jpg"))); // NOI18N
        btnSaveFile.setText("Save File");
        btnSaveFile.setFocusable(false);
        btnSaveFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveFile.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSaveFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete2.jpg"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setMaximumSize(new java.awt.Dimension(49, 49));
        btnDelete.setMinimumSize(new java.awt.Dimension(49, 49));
        btnDelete.setPreferredSize(new java.awt.Dimension(49, 49));
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        bntUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.jpg"))); // NOI18N
        bntUpdate.setText("Update");
        bntUpdate.setFocusable(false);
        bntUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntUpdate.setPreferredSize(new java.awt.Dimension(49, 49));
        bntUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdateActionPerformed(evt);
            }
        });

        btnSearch2.setText("Search StuID");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel5.setText("Student ID: ");

        jLabel51.setText("Name: ");

        txtName.setEditable(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel46.setText("Java");

        jLabel48.setText("English");

        jLabel50.setText("GDTC");

        btnFirst.setText("||<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        bntPre.setText("<<");
        bntPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPreActionPerformed(evt);
            }
        });

        bntNext.setText(">>");
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        btnLast.setText(">>||");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntPre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(bntPre)
                    .addComponent(bntNext)
                    .addComponent(btnLast))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel52.setText("AVG:");

        txtAVG.setEditable(false);
        txtAVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAVGActionPerformed(evt);
            }
        });

        tblTop3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tblTop3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Top 3:");
        jLabel1.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 30));

        jMenuBar1.setBorder(null);
        jMenuBar1.setToolTipText("");

        File.setText("File");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        File.add(jMenuItem3);
        File.add(jSeparator1);

        jMenuItem4.setText("Quit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        File.add(jMenuItem4);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("New");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Edit.add(jMenuItem7);

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        Edit.add(Delete);

        jMenuBar1.add(Edit);

        Setting.setText("Setting");

        jMenuItem8.setText("Language");
        Setting.add(jMenuItem8);

        jMenuItem9.setText("Connection");
        Setting.add(jMenuItem9);
        Setting.add(jSeparator2);

        jMenuItem13.setText("Update Software");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Setting.add(jMenuItem13);

        jMenuBar1.add(Setting);

        Help.setText("Help");

        jMenuItem11.setText("HomePage");
        Help.add(jMenuItem11);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem14.setText("Guide");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        Help.add(jMenuItem14);
        Help.add(jSeparator3);

        jMenuItem12.setText("About");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        Help.add(jMenuItem12);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(34, 34, 34)))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel51))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtTinhoc)
                                    .addComponent(txtEg)
                                    .addComponent(txtStudentID, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtGdtc)
                                    .addComponent(txtAVG)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addComponent(btnSaveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearch2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAVG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
           String sql = "Insert into GRADE(MASV,Tienganh,Tinhoc,GDTC) Values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, (String) txtStudentID.getText());
            ps.setInt(2, Integer.parseInt(txtEg.getText().toString()));
            ps.setInt(3, Integer.parseInt(txtTinhoc.getText().toString()));
            ps.setInt(4, Integer.parseInt(txtGdtc.getText().toString()));           
            ps.execute();
            JOptionPane.showMessageDialog(this, "Save successfully..", "Message", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Save faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Do you really want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        
        txtStudentID.setEditable(true);
        txtStudentID.setText("");
        txtName.setText("");
        txtTinhoc.setText("");
        txtEg.setText("");
        txtGdtc.setText("");
        txtAVG.setText("");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
         String sql = "DELETE FROM GRADE WHERE MASV=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1,  txtStudentID.getText().toString());
            
            ps.execute();
            JOptionPane.showMessageDialog(this, "DELETE successfully..", "Message", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            loadDataToTable();
            DisplayStudent(0);
            
        } catch (SQLException se) {
           // se.printStackTrace();
            JOptionPane.showMessageDialog(this, "DELETE faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
         list.remove(st);
    }//GEN-LAST:event_DeleteActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed
int max=0;
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        txtStudentID.setEditable(true);
        txtStudentID.setText("");
        txtName.setText("");
        txtTinhoc.setText("");
        txtEg.setText("");
        txtGdtc.setText("");
        txtAVG.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        // TODO add your handling code here:
        
        String sql = "Insert into GRADE(MASV,Tienganh,Tinhoc,GDTC) Values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, (String) txtStudentID.getText());
            ps.setInt(2, Integer.parseInt(txtEg.getText().toString()));
            ps.setInt(3, Integer.parseInt(txtTinhoc.getText().toString()));
            ps.setInt(4, Integer.parseInt(txtGdtc.getText().toString()));           
            ps.execute();
            JOptionPane.showMessageDialog(this, "Save successfully..", "Message", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Save faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      String sql = "DELETE FROM GRADE WHERE MASV=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1,  txtStudentID.getText().toString());
            
            ps.execute();
            JOptionPane.showMessageDialog(this, "DELETE successfully..", "Message", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            loadDataToTable();
            DisplayStudent(0);
            
        } catch (SQLException se) {
           // se.printStackTrace();
            JOptionPane.showMessageDialog(this, "DELETE faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
         list.remove(st);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void bntUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdateActionPerformed
        // TODO add your handling code here:
        String sql = "UPDATE GRADE set Tienganh =?, Tinhoc=?, GDTC=? WHERE MASV=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtEg.getText().toString()));
            ps.setInt(2, Integer.parseInt(txtTinhoc.getText().toString()));
            ps.setInt(3, Integer.parseInt(txtGdtc.getText().toString()));
            ps.setString(4, (String) txtStudentID.getText());
            ps.execute();
            JOptionPane.showMessageDialog(this, "Update successfully..", "Message", JOptionPane.INFORMATION_MESSAGE);
            loadData();
           loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }catch(Exception ex2){
                ex2.printStackTrace();
            }
        }
         list.remove(st);
    }//GEN-LAST:event_bntUpdateActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        // TODO add your handling code here:
         int i;
        String stuid = txtSearch.getText();
        for (i = 0; i < list.size(); i++) {
            GradeStudent gs = list.get(i);
            if (gs.getMaSV().equalsIgnoreCase(stuid)) {
                JOptionPane.showMessageDialog(this, "OK!", "Message", JOptionPane.INFORMATION_MESSAGE);
                CurrentIndex = i;
                DisplayStudent(i);
                break;
            }
        }

        if (i == list.size()) {
            JOptionPane.showMessageDialog(this, stuid + " not found!", "Message", JOptionPane.INFORMATION_MESSAGE);
            txtSearch.requestFocus();
        }

    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        CurrentIndex = 0;
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void bntPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPreActionPerformed
        // TODO add your handling code here:
        CurrentIndex--;
        if (CurrentIndex < 0) {
            JOptionPane.showMessageDialog(null, "first page");
            return;
        }
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_bntPreActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed
        // TODO add your handling code here:
        CurrentIndex++;
        if (CurrentIndex >= list.size()) {
            JOptionPane.showMessageDialog(null, "last page");
            return;
        }
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_bntNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        CurrentIndex = list.size() - 1;
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtAVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAVGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAVGActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Setting;
    private javax.swing.JButton bntNext;
    private javax.swing.JButton bntPre;
    private javax.swing.JButton bntUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable tblTop3;
    private javax.swing.JTextField txtAVG;
    private javax.swing.JTextField txtEg;
    private javax.swing.JTextField txtGdtc;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtTinhoc;
    // End of variables declaration//GEN-END:variables
}

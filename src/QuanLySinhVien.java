
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class QuanLySinhVien extends javax.swing.JFrame {

    private ArrayList<Student> list = new ArrayList<Student>();
    private int CurrentIndex = -1;
    Student st = new Student();
    private String header[] = {"StudentID", "Name", "Email", "Phone", "Sex", "Address", "Image"};
    private DefaultTableModel modelTableStudents = new DefaultTableModel(header, 0);

    /**
     * Creates new form QuanLySinhVien
     */
    public QuanLySinhVien() {
        initComponents();
        loadData();
        loadDataToTable();
    }
    public void UpdateHinh(String img){
        ImageIcon img1=new ImageIcon("src/image/"+img);
        Image im= img1.getImage();
        ImageIcon icon=new ImageIcon(im.getScaledInstance(lblPic.getWidth(),lblPic.getHeight(),im.SCALE_SMOOTH));
        lblPic.setIcon(icon);
    }
    private void loadData() {
        try {
            Connection conn = null;
            Statement stmt = null;
            //connection databse
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            //Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "Select*from STUDENTS";
            //dat cau lenh truy van o day...
            ResultSet rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(this, "Connection successfully...", "Message", JOptionPane.INFORMATION_MESSAGE);
            //Doc du lieu tu database...
            while (rs.next()) {
                String StudentID = rs.getString("MASV");
                String Name = rs.getString("Hoten");
                String Email = rs.getString("Email");
                String PhoneNumber = rs.getString("SoDT");
                String Sex = rs.getString("GioiTinh");
                String Address = rs.getString("Diachi");
                int gt = Integer.parseInt(Sex);
                String IMG = rs.getString("Hinh");
                //Them vao doi tuong vao list
                Student st = new Student(StudentID, Name, Email, PhoneNumber, Address, IMG, gt);
                list.add(st);
                
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

    private void loadDataToTable() {
        try {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            String sql = "Select*from STUDENTS";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Vector sv = null;
            modelTableStudents.setRowCount(0);
            while (rs.next()) {
                sv = new Vector();
                sv.add(rs.getString("MASV"));
                sv.add(rs.getString("Hoten"));
                sv.add(rs.getString("Email"));
                sv.add(rs.getString("SoDT"));
                sv.add(rs.getString("Gioitinh"));
                sv.add(rs.getString("Diachi"));
                sv.add(rs.getString("Hinh"));
                modelTableStudents.addRow(sv);

            }
            tblStudent.setModel(modelTableStudents);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
private void resetTable(){
                   modelTableStudents = (DefaultTableModel) tblStudent.getModel();                  
                   modelTableStudents.setRowCount(0);
                    
    }
    public void reset() {
      
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtStudentID.setText("");
        txtAddress.setText("");
        cbSex.setSelectedItem("");
       
    }

    private void DisplayStudent(int i) {
        Student st = list.get(CurrentIndex);
        txtStudentID.setText(st.getStudentID());
        txtName.setText(st.getName());
        int gt = st.getSex();
        if (gt == 0) {
            cbSex.setSelectedItem("Nam");
        } else {
            cbSex.setSelectedItem("Nu");
        }

        txtEmail.setText(st.getEmail());
        txtPhone.setText(st.getPhoneNumber());
        txtAddress.setText(st.getAddress());
        txtSource.setText(st.getIMG());
        UpdateHinh(st.getIMG());
    }
    private void DisplayTable(int i) {
        Student st =list.get(CurrentIndex);
        tblStudent.setValueAt(st.getStudentID(), i, 0);
        tblStudent.setValueAt(st.getName(), i, 1);
        tblStudent.setValueAt(st.getSex(), i, 2);
        tblStudent.setValueAt(st.getEmail(), i, 3);
        tblStudent.setValueAt(st.getPhoneNumber(), i, 4);
        tblStudent.setValueAt(st.getAddress(), i, 5);
        tblStudent.setValueAt(st.getIMG(), i, 6);
        UpdateHinh(st.getIMG());
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
        bntUpdate1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbSex = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        btnBrowser1 = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        bntPre = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        tblStu = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        txtSource = new javax.swing.JTextField();
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

        bntUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.jpg"))); // NOI18N
        bntUpdate1.setText("Update");
        bntUpdate1.setFocusable(false);
        bntUpdate1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntUpdate1.setPreferredSize(new java.awt.Dimension(49, 49));
        bntUpdate1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntUpdate1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Sex");

        jLabel1.setText("Student ID:");

        jLabel2.setText("Name");

        jLabel7.setText("Email: ");

        jLabel6.setText("Phone number: ");

        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });

        jLabel8.setText("Address: ");

        cbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Sex--", "Nam", "Nu", " " }));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avatar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        lblPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPic.setText("Avatar");

        btnBrowser1.setText("Browser");
        btnBrowser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnBrowser1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowser1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        btnLast.setText(">>||");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        bntNext.setText(">>");
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        tblStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStuMouseClicked(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Email", "Phone Number", "Sex", "Address", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        tblStu.setViewportView(tblStudent);

        btnSearch.setText("SearchID");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        txtSource.setEnabled(false);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSearch)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStudentID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bntPre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bntNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101)))))))
                .addContainerGap())
            .addComponent(tblStu)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntPre)
                            .addComponent(btnFirst)
                            .addComponent(bntNext)
                            .addComponent(btnLast))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tblStu, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
         Vector dataRow = new Vector();
        dataRow.add(txtStudentID.getText().trim());
        dataRow.add(txtName.getText().trim());
        dataRow.add(txtEmail.getText().trim());
        dataRow.add(txtPhone.getText().trim());
        dataRow.add(cbSex.getSelectedItem());
        dataRow.add(txtAddress.getText().trim());
        String sql = "Insert into STUDENTS Values(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getStudentID().equalsIgnoreCase(String.valueOf(txtStudentID.getText()))) {
                    JOptionPane.showMessageDialog(this, "Save fail", "Lỗi: Trùng ID", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    ps.setString(1, String.valueOf(txtStudentID.getText()));
                }
            }
            ps.setString(2, String.valueOf(txtName.getText()));
            ps.setString(3, String.valueOf(txtEmail.getText()));
            ps.setString(4, String.valueOf(txtPhone.getText()));
            if (String.valueOf(cbSex.getSelectedItem()).equalsIgnoreCase("Nam")) {
                ps.setInt(5, 0);
            } else {
                ps.setInt(5, 1);
            }
            ps.setString(6, String.valueOf(txtAddress.getText()));
            ps.setString(7, String.valueOf("''"));
            ps.execute();
            txtStudentID.setEditable(false);
            JOptionPane.showMessageDialog(this, "Save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Save faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        list.remove(st);
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
        reset();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM STUDENTS Where MASV = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtStudentID.getText());
            ps.execute();
            JOptionPane.showMessageDialog(this, "Delete successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
            DisplayStudent(CurrentIndex--);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Delete fail...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

        list.remove(st);
    }                                         

    private void bntUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update STUDENTS set Hoten = ?, Email = ? , SoDT = ?, Gioitinh = ?, Diachi = ?  where MASV = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(txtName.getText()));
            ps.setString(2, String.valueOf(txtEmail.getText()));
            ps.setString(3, String.valueOf(txtPhone.getText()));

            if (String.valueOf(cbSex.getSelectedItem()).equalsIgnoreCase("Nam")) {
                ps.setInt(4, 0);
            } else {
                ps.setInt(4, 1);
            }
            ps.setString(5, String.valueOf(txtAddress.getText()));
            ps.setString(6,String.valueOf(txtStudentID.getText()));
            ps.execute();
            JOptionPane.showMessageDialog(this, "Update succesfully...", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update Fail..", "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        list.remove(st);
    }//GEN-LAST:event_DeleteActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        reset();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        // TODO add your handling code here:
        Vector dataRow = new Vector();
        dataRow.add(txtStudentID.getText().trim());
        dataRow.add(txtName.getText().trim());
        dataRow.add(txtEmail.getText().trim());
        dataRow.add(txtPhone.getText().trim());
        dataRow.add(cbSex.getSelectedItem());
        dataRow.add(txtAddress.getText().trim());
        dataRow.add(txtSource.getText().trim());
        modelTableStudents.addRow(dataRow);
        String sql = "Insert into STUDENTS Values(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getStudentID().equalsIgnoreCase(String.valueOf(txtStudentID.getText()))) {
                    JOptionPane.showMessageDialog(this, "Save fail", "Lỗi: Trùng ID", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    ps.setString(1, String.valueOf(txtStudentID.getText()));
                }
            }
            ps.setString(2, String.valueOf(txtName.getText()));
            ps.setString(3, String.valueOf(txtEmail.getText()));
            ps.setString(4, String.valueOf(txtPhone.getText()));
            if (String.valueOf(cbSex.getSelectedItem()).equalsIgnoreCase("Nam")) {
                ps.setInt(5, 0);
            } else {
                ps.setInt(5, 1);
            }
            ps.setString(6, String.valueOf(txtAddress.getText()));
            ps.setString(7, String.valueOf(txtSource.getText()));
            ps.execute();
            txtStudentID.setEditable(false);
            JOptionPane.showMessageDialog(this, "Save successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Save faild...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
        list.remove(st);
    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String sql = "DELETE FROM STUDENTS Where MASV = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, txtStudentID.getText());
            ps.execute();
            JOptionPane.showMessageDialog(this, "Delete successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
            DisplayStudent(CurrentIndex--);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Delete fail...", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

        list.remove(st);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void bntUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntUpdate1ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update STUDENTS set Hoten = ?, Email = ? , SoDT = ?, Gioitinh = ?, Diachi = ?  where MASV = ?";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(txtName.getText()));
            ps.setString(2, String.valueOf(txtEmail.getText()));
            ps.setString(3, String.valueOf(txtPhone.getText()));

            if (String.valueOf(cbSex.getSelectedItem()).equalsIgnoreCase("Nam")) {
                ps.setInt(4, 0);
            } else {
                ps.setInt(4, 1);
            }
            ps.setString(5, String.valueOf(txtAddress.getText()));
            ps.setString(6,String.valueOf(txtStudentID.getText()));
            ps.execute();
            JOptionPane.showMessageDialog(this, "Update succesfully...", "Message", JOptionPane.INFORMATION_MESSAGE);
            conn.close();
            loadData();
            loadDataToTable();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update Fail..", "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        list.remove(st);
    }//GEN-LAST:event_bntUpdate1ActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void btnBrowser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowser1ActionPerformed
        // TODO add your handling code here:
         JFileChooser filechooser = new JFileChooser();
        int result = filechooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String fileName = filechooser.getSelectedFile().getAbsolutePath();
            lblPic.setIcon(new ImageIcon(fileName));
            String[] a= fileName.split(fileName);
            txtSource.setText(fileName);
        }
    }//GEN-LAST:event_btnBrowser1ActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        CurrentIndex = 0;
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void bntPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPreActionPerformed
        // TODO add your handling code here:
        CurrentIndex--;
        if (CurrentIndex < 0) {
            JOptionPane.showMessageDialog(null, "First Page");
            return;
        }
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_bntPreActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        CurrentIndex = list.size() - 1;
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_btnLastActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed
        // TODO add your handling code here:
        CurrentIndex++;
        if (CurrentIndex >= list.size()) {
            JOptionPane.showMessageDialog(null, "Last Page");
            return;
        }
        DisplayStudent(CurrentIndex);
    }//GEN-LAST:event_bntNextActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:int row = tblSinhVien.getSelectedRow();
        int row = tblStudent.getSelectedRow();
        String a= tblStudent.getValueAt(row, 4).toString();
        if (row < 0) {
            return;
        }
        txtStudentID.setText(tblStudent.getValueAt(row, 0).toString());
        txtName.setText(tblStudent.getValueAt(row, 1).toString());
        txtEmail.setText(tblStudent.getValueAt(row, 2).toString());
        txtPhone.setText(tblStudent.getValueAt(row, 3).toString());
        if(a.equals("0")){
            cbSex.setSelectedItem("Nam");
        }else{
            cbSex.setSelectedItem("Nu");
        }
        
        txtAddress.setText(tblStudent.getValueAt(row, 5).toString());
        UpdateHinh((String) modelTableStudents.getValueAt(row, 6));
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        resetTable();
        int i;
        String stuid = txtSearch.getText();
        for (i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            if (st.getStudentID().equalsIgnoreCase(stuid)) {
                JOptionPane.showMessageDialog(this, "OK!", "Message", JOptionPane.INFORMATION_MESSAGE);
                CurrentIndex = i;
                DisplayStudent(CurrentIndex);
                
                break;
            }
        }
        if (i == list.size()) {
            JOptionPane.showMessageDialog(this, stuid + " not found!", "Message", JOptionPane.INFORMATION_MESSAGE);
            txtSearch.requestFocus();
        }
        try {
            Connection conn = null;
            
            ResultSet rs = null;
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SOF203", "sa", "123");
            String sql = "Select*from STUDENTS WHERE MASV=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stuid );
             rs = pst.executeQuery();
            Vector sv = null;
            modelTableStudents.setRowCount(0);
            while (rs.next()) {
                sv = new Vector();
                sv.add(rs.getString("MASV"));
                sv.add(rs.getString("Hoten"));
                sv.add(rs.getString("Email"));
                sv.add(rs.getString("SoDT"));
                sv.add(rs.getString("Gioitinh"));
                sv.add(rs.getString("Diachi"));

                modelTableStudents.addRow(sv);

            }
            tblStudent.setModel(modelTableStudents);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStuMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_tblStuMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
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
    private javax.swing.JButton bntUpdate1;
    private javax.swing.JButton btnBrowser1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lblPic;
    private javax.swing.JScrollPane tblStu;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSource;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}

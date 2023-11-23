package gui;

import action.PanelAction;
import action.TableActionCellRender;
import controller.DataUpdate;
import database.Database;
import entitas.Admin;
import entitas.DataDiri;
import entitas.Pengajuan;
import entitas.RiwayatSurat;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StaffInterface extends javax.swing.JFrame {
    final Database database;
    private final String roleChecker;
    private CardLayout cardLayout;
    private RiwayatSurat riwayatSurat;
    private String email;
    private String password;
    private String mahasiswaNIM;
    private String peruntukan;
    private String mahasiswaNim;
    private String checkNim;
    private String currentNim;
    private String idSuratToAccept;

    public StaffInterface(String roleChecker) {
        initComponents();
        database = new Database();
        this.roleChecker = roleChecker;
        initializePanels();
    }
    
    private void initializePanels() {
        riwayatSurat = new RiwayatSurat();
        pnlCards.add(welcomePanel, "pnlCard5");
        pnlCards.add(suratPanel, "pnlCard2");
        pnlCards.add(profilPane, "pnlCard1");
        pnlCards.add(hidePanel, "pnlCard4");
        Navigation.setPreferredSize(new Dimension(50, 520)); 
        Navigation.setVisible(true);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        suratTabel.setDefaultEditor(Object.class, null);
        suratTabel.setCellSelectionEnabled(false);
        showTable();
    }
    
     public void setPeruntukan(String peruntukan) {
        this.peruntukan = peruntukan;
    }

    public void setMahasiswaNim(String mahasiswaNim) {
        this.mahasiswaNim = mahasiswaNim;
    }

    public void setCheckNim(String checkNim) {
        this.checkNim = checkNim;
    }

    private void showTable() {
        DefaultTableModel model = new DefaultTableModel();
        Admin admin = new Admin(email, password);

        model.addColumn("ID Surat");
        model.addColumn("Jenis Surat");
        model.addColumn("Status");
        model.addColumn("Posisi Surat");
        model.addColumn("Action");

        List<String[]> riwayatSuratData = riwayatSurat.readData();

        for (String[] row : riwayatSuratData) {
            model.addRow(row);
        }

        suratTabel.setModel(model);

        TableColumn column = suratTabel.getColumnModel().getColumn(4);
        column.setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new PanelAction();
            }
        });

        suratTabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = suratTabel.getColumnModel().getColumnIndex("Action");
                int row = suratTabel.rowAtPoint(e.getPoint());
                if (column == 4 && row >= 0) {
                    idSuratToAccept = (String) suratTabel.getValueAt(row, 0);
                    currentNim = admin.findData(idSuratToAccept);
                    System.out.println("NIM: " + currentNim);
                    System.out.println(".mouseClicked()");
                    cardLayout.show(pnlCards, "pnlCard1");
                    showData(currentNim, idSuratToAccept);
                }
            }
        });
    }

    private void showData(String nimToCheck, String idSurat) {
        DataDiri dataMahasiswa = new DataDiri();
        Pengajuan dataSurat = new Pengajuan(null, nimToCheck, null);
        String[] data = dataMahasiswa.readData(nimToCheck);
        String peruntukanData = dataSurat.readData(nimToCheck);
        
        if (peruntukanData != null) {
            intededPanel.setText(peruntukanData);
        } else {
            System.out.println("Data tidak ditemukan");
        }

        String fullName = (String) data[1];
        String[] names = fullName.split("\\s", 2);
        if (data != null && data.length > 1) {
            
            if (names.length > 0) {
                firstName.setText(names[0]);
            }
            if (names.length > 1) {
                lastName.setText(" " + names[1]);
            }
            studyProgram.setText(data[2]);
            studyLevel.setText(data[3]);
            gpaPoint.setText(data[4]);
            phoneNumber.setText(data[5]);
            enrollYear.setText(data[6]);
            semesterYear.setText(data[7]);
            addressPlace.setText(data[8]);
            placeBirth.setText(data[10]);
            
            String[] dateComponents = data[11].split("-");
            if (dateComponents.length == 3) {
                String year = dateComponents[0];
                String month = dateComponents[1];
                String day = dateComponents[2];
                dayCombo.setText(day);
                monthCombo.setText(month);
                yearCombo.setText(year);
            }
            
            emailUser.setText(data[12]);
        } else {
            System.out.println("Data tidak ditemukan");
        }
    }

    private void navigateToLoginScreen() {
            ChooseLogin loginScreen = new ChooseLogin();
            loginScreen.setVisible(true); 
            this.dispose();
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        Navigation = new javax.swing.JPanel();
        surat = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        orangePanel = new javax.swing.JPanel();
        navButton = new javax.swing.JButton();
        mahasiswaText = new javax.swing.JLabel();
        signOut = new javax.swing.JButton();
        pnlCards = new javax.swing.JPanel();
        welcomePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        suratPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        suratTabel = new javax.swing.JTable();
        hidePanel = new javax.swing.JPanel();
        successfullyPop = new javax.swing.JOptionPane();
        optionPanel = new javax.swing.JOptionPane();
        profilPane = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        firstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studyProgram = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        gpaPoint = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JTextField();
        emailUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enrollYear = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        semesterYear = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        placeBirth = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        addressPlace = new javax.swing.JTextField();
        studyLevel = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        deniedButton1 = new javax.swing.JButton();
        acceptButton1 = new javax.swing.JButton();
        dayCombo = new javax.swing.JTextField();
        yearCombo = new javax.swing.JTextField();
        monthCombo = new javax.swing.JTextField();
        intededPanel = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(204, 204, 204));
        background.setMaximumSize(new java.awt.Dimension(960, 578));
        background.setPreferredSize(new java.awt.Dimension(960, 578));

        Navigation.setBackground(new java.awt.Color(204, 204, 204));
        Navigation.setMaximumSize(new java.awt.Dimension(110, 520));
        Navigation.setMinimumSize(new java.awt.Dimension(10, 520));
        Navigation.setName(""); // NOI18N
        Navigation.setPreferredSize(new java.awt.Dimension(50, 520));
        Navigation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        surat.setBackground(new java.awt.Color(51, 51, 51));
        surat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        surat.setForeground(new java.awt.Color(51, 51, 51));
        surat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashIcon.png"))); // NOI18N
        surat.setText("Home");
        surat.setBorderPainted(false);
        surat.setContentAreaFilled(false);
        surat.setIconTextGap(16);
        surat.setInheritsPopupMenu(true);
        surat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suratActionPerformed(evt);
            }
        });
        Navigation.add(surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, -1));

        dashboard.setBackground(new java.awt.Color(51, 51, 51));
        dashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dashboard.setForeground(new java.awt.Color(51, 51, 51));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/messageIcon.png"))); // NOI18N
        dashboard.setText("Surat");
        dashboard.setBorderPainted(false);
        dashboard.setContentAreaFilled(false);
        dashboard.setIconTextGap(16);
        dashboard.setInheritsPopupMenu(true);
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        Navigation.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 140, -1));

        orangePanel.setBackground(new java.awt.Color(255, 153, 51));
        orangePanel.setMaximumSize(new java.awt.Dimension(970, 60));
        orangePanel.setName(""); // NOI18N

        navButton.setBackground(new java.awt.Color(255, 153, 51));
        navButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ButtonIcon.png"))); // NOI18N
        navButton.setContentAreaFilled(false);
        navButton.setDoubleBuffered(true);
        navButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navButtonActionPerformed(evt);
            }
        });

        mahasiswaText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mahasiswaText.setForeground(new java.awt.Color(255, 255, 255));
        mahasiswaText.setText("DASHBOARD");

        signOut.setBackground(new java.awt.Color(255, 255, 255));
        signOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        signOut.setForeground(new java.awt.Color(0, 0, 0));
        signOut.setText("Sign Out");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orangePanelLayout = new javax.swing.GroupLayout(orangePanel);
        orangePanel.setLayout(orangePanelLayout);
        orangePanelLayout.setHorizontalGroup(
            orangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mahasiswaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 652, Short.MAX_VALUE)
                .addComponent(signOut)
                .addGap(20, 20, 20))
        );
        orangePanelLayout.setVerticalGroup(
            orangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orangePanelLayout.createSequentialGroup()
                .addComponent(mahasiswaText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(orangePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(orangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signOut)
                    .addComponent(navButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlCards.setBackground(new java.awt.Color(255, 255, 255));
        pnlCards.setLayout(new java.awt.CardLayout());

        welcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        welcomePanel.setMaximumSize(new java.awt.Dimension(960, 578));
        welcomePanel.setMinimumSize(new java.awt.Dimension(960, 578));
        welcomePanel.setName(""); // NOI18N
        welcomePanel.setPreferredSize(new java.awt.Dimension(960, 578));
        welcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DASHBOARD");
        welcomePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Selamat datang Admin");
        welcomePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        pnlCards.add(welcomePanel, "card2");

        suratPanel.setBackground(new java.awt.Color(255, 255, 255));
        suratPanel.setMaximumSize(new java.awt.Dimension(960, 578));
        suratPanel.setMinimumSize(new java.awt.Dimension(960, 578));
        suratPanel.setName(""); // NOI18N
        suratPanel.setPreferredSize(new java.awt.Dimension(960, 578));
        suratPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        suratTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Jenis Surat", "Status", "Posisi", "Aksi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        suratTabel.setRowHeight(30);
        suratTabel.getTableHeader().setReorderingAllowed(false);
        suratTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suratTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(suratTabel);
        if (suratTabel.getColumnModel().getColumnCount() > 0) {
            suratTabel.getColumnModel().getColumn(0).setHeaderValue("No");
            suratTabel.getColumnModel().getColumn(1).setResizable(false);
            suratTabel.getColumnModel().getColumn(1).setHeaderValue("Jenis Surat");
            suratTabel.getColumnModel().getColumn(2).setHeaderValue("Status");
            suratTabel.getColumnModel().getColumn(3).setHeaderValue("Posisi");
            suratTabel.getColumnModel().getColumn(4).setHeaderValue("Aksi");
        }

        suratPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 30, 680, -1));

        pnlCards.add(suratPanel, "card2");

        hidePanel.setBackground(new java.awt.Color(255, 255, 255));
        hidePanel.setMaximumSize(new java.awt.Dimension(960, 578));
        hidePanel.setMinimumSize(new java.awt.Dimension(960, 578));
        hidePanel.setName(""); // NOI18N
        hidePanel.setPreferredSize(new java.awt.Dimension(960, 578));
        hidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        hidePanel.add(successfullyPop, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));
        hidePanel.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        pnlCards.add(hidePanel, "card2");

        profilPane.setBackground(new java.awt.Color(255, 255, 255));
        profilPane.setMaximumSize(new java.awt.Dimension(892, 492));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Account Personal Information");

        backButton.setBackground(new java.awt.Color(255, 153, 51));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        firstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        firstName.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("First Name");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Last Name");

        lastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lastName.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Study Program");

        studyProgram.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        studyProgram.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("GPA");

        gpaPoint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gpaPoint.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Phone Number");

        phoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        phoneNumber.setFocusable(false);

        emailUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        emailUser.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Enrollment Year");

        enrollYear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        enrollYear.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Semester");

        semesterYear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semesterYear.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Adress");

        placeBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        placeBirth.setFocusable(false);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Place of Birth");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Date of Birth");

        addressPlace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addressPlace.setFocusable(false);

        studyLevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        studyLevel.setFocusable(false);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Study Level and Degree");

        deniedButton1.setBackground(new java.awt.Color(204, 0, 0));
        deniedButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deniedButton1.setForeground(new java.awt.Color(255, 255, 255));
        deniedButton1.setText("Denied");
        deniedButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deniedButton1ActionPerformed(evt);
            }
        });

        acceptButton1.setBackground(new java.awt.Color(255, 153, 51));
        acceptButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptButton1.setForeground(new java.awt.Color(255, 255, 255));
        acceptButton1.setText("Accept");
        acceptButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButton1ActionPerformed(evt);
            }
        });

        dayCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dayCombo.setFocusable(false);

        yearCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        yearCombo.setFocusable(false);

        monthCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monthCombo.setFocusable(false);

        intededPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        intededPanel.setFocusable(false);
        intededPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intededPanelActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Intended purpose of requesting a letter");

        javax.swing.GroupLayout profilPaneLayout = new javax.swing.GroupLayout(profilPane);
        profilPane.setLayout(profilPaneLayout);
        profilPaneLayout.setHorizontalGroup(
            profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilPaneLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addComponent(acceptButton1)
                        .addGap(18, 18, 18)
                        .addComponent(deniedButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(studyProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel14)
                            .addComponent(addressPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel11)
                            .addComponent(semesterYear, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addGroup(profilPaneLayout.createSequentialGroup()
                                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(yearCombo))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(gpaPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailUser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(placeBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel23)
                            .addComponent(jLabel10)
                            .addComponent(enrollYear, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(intededPanel, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(205, 205, 205))
        );
        profilPaneLayout.setVerticalGroup(
            profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addGap(26, 26, 26)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(profilPaneLayout.createSequentialGroup()
                                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(profilPaneLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(studyProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(profilPaneLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gpaPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(studyLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(profilPaneLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(enrollYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(semesterYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(placeBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilPaneLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addGap(8, 8, 8)
                .addComponent(intededPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addGroup(profilPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(acceptButton1)
                        .addComponent(deniedButton1)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pnlCards.add(profilPane, "card5");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(orangePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(orangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Navigation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suratActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard5");
        showTable();
    }//GEN-LAST:event_suratActionPerformed

    private void navButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navButtonActionPerformed
        // TODO add your handling code here:
        Dimension currentSize = Navigation.getSize();

        if (currentSize.equals(new Dimension(50, 520))) {
            Navigation.setPreferredSize(new Dimension(110, 520));
        } else {
            Navigation.setPreferredSize(new Dimension(50, 520));
        }

        Navigation.revalidate();
        Navigation.repaint();
    }//GEN-LAST:event_navButtonActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard2");
        showTable();
    }//GEN-LAST:event_dashboardActionPerformed

    private void suratTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratTabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_suratTabelMouseClicked

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        // TODO add your handling code here:
        navigateToLoginScreen();
    }//GEN-LAST:event_signOutActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard2");
        showTable();

    }//GEN-LAST:event_backButtonActionPerformed

    private void deniedButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deniedButton1ActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showOptionDialog(this, 
        "Are you sure you want to deny the surat?", 
        "Deny Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        null, 
        null);

        if (choice == JOptionPane.YES_OPTION) {
            DataUpdate dataUpdate = new DataUpdate(idSuratToAccept, "Denied");
            RiwayatSurat riwayatSurat = new RiwayatSurat();
            boolean updateSuccessful = riwayatSurat.updateData(dataUpdate);

            if (updateSuccessful) {
                System.out.println("Status updated to 'denied'");
                JOptionPane.showMessageDialog(this, "Surat has been denied!");
            } else {
                System.out.println("Status update failed");
            }
        } else {
        }
    }//GEN-LAST:event_deniedButton1ActionPerformed

    private void acceptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButton1ActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showOptionDialog(this, 
        "Are you sure you want to accept the surat?", 
        "Accept Confirmation", 
        JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        null, 
        null);

        if (choice == JOptionPane.YES_OPTION) {
            DataUpdate dataUpdate = new DataUpdate(idSuratToAccept, "Accept");
            RiwayatSurat riwayatSurat = new RiwayatSurat();
            boolean updateSuccessful = riwayatSurat.updateData(dataUpdate);

            if (updateSuccessful) {
                System.out.println("Status updated to 'accept'");
                JOptionPane.showMessageDialog(optionPanel, "Surat has been accepted successfully!");
            } else {
                System.out.println("Status update failed");
            }
        } else {
        }
    }//GEN-LAST:event_acceptButton1ActionPerformed

    private void intededPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intededPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intededPanelActionPerformed

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
            java.util.logging.Logger.getLogger(StaffInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            StaffInterface staffInterface = new StaffInterface("roleChecker");
            staffInterface.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton acceptButton1;
    private javax.swing.JTextField addressPlace;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel background;
    private javax.swing.JButton dashboard;
    private javax.swing.JTextField dayCombo;
    private javax.swing.JButton deniedButton1;
    private javax.swing.JTextField emailUser;
    private javax.swing.JTextField enrollYear;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField gpaPoint;
    private javax.swing.JPanel hidePanel;
    private javax.swing.JTextField intededPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel mahasiswaText;
    private javax.swing.JTextField monthCombo;
    private javax.swing.JButton navButton;
    private javax.swing.JOptionPane optionPanel;
    private javax.swing.JPanel orangePanel;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JTextField placeBirth;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel profilPane;
    private javax.swing.JPanel profilPanel;
    private javax.swing.JPanel profilPanel1;
    private javax.swing.JPanel profilPanel2;
    private javax.swing.JPanel profilPanel3;
    private javax.swing.JButton saveData;
    private javax.swing.JButton saveData1;
    private javax.swing.JButton saveData2;
    private javax.swing.JButton saveData3;
    private javax.swing.JTextField semesterYear;
    private javax.swing.JButton signOut;
    private javax.swing.JTextField studyLevel;
    private javax.swing.JTextField studyProgram;
    private javax.swing.JOptionPane successfullyPop;
    private javax.swing.JButton surat;
    private javax.swing.JPanel suratPanel;
    private javax.swing.JTable suratTabel;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JTextField yearCombo;
    // End of variables declaration//GEN-END:variables
}

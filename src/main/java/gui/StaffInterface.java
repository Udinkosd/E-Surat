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
    RiwayatSurat riwayatSurat = new RiwayatSurat();
//    PanelAction actionPanel = new PanelAction();
    CardLayout cardLayout;
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
        pnlCards.add(welcomePanel, "pnlCard5");
        pnlCards.add(suratPanel, "pnlCard2");
        pnlCards.add(profilPanel, "pnlCard1");
        pnlCards.add(buatPanel, "pnlCard4");
        Navigation.setPreferredSize(new Dimension(50, 520)); 
        Navigation.setVisible(true);
        cardLayout = (CardLayout) (pnlCards.getLayout());
        suratTabel.setDefaultEditor(Object.class, null);
        suratTabel.setCellSelectionEnabled(false);
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
        String[] data = (String[]) dataMahasiswa.readData(nimToCheck); 

        if (data != null) {
            System.out.println("NIM: " + Arrays.toString(data));
            namaLengkap.setText((String) data[0]);
            nimNomor.setText((String) data[1]);
            programStudi.setText((String) data[2]);
            jenjangStudi.setText((String) data[3]);
            ipkMahasiswa.setText((String) data[4]);
            kontakNomor.setText((String) data[5]);
            angkatanTahun.setText((String) data[6]);
            semesterTahun.setText((String) data[7]);
            alamatRumah.setText((String) data[8]);
            tempatTanggalLahir.setText((String) data[9]);
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
        profilPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabeel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLebeel = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        namaLengkap = new javax.swing.JLabel();
        nimNomor = new javax.swing.JLabel();
        programStudi = new javax.swing.JLabel();
        jenjangStudi = new javax.swing.JLabel();
        ipkMahasiswa = new javax.swing.JLabel();
        kontakNomor = new javax.swing.JLabel();
        angkatanTahun = new javax.swing.JLabel();
        semesterTahun = new javax.swing.JLabel();
        alamatRumah = new javax.swing.JLabel();
        tempatTanggalLahir = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        deniedButton = new javax.swing.JButton();
        buatPanel = new javax.swing.JPanel();
        pilihSurat = new javax.swing.JComboBox<>();
        buatSurat = new javax.swing.JButton();
        peruntukanField = new javax.swing.JTextField();

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
        suratTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suratTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(suratTabel);

        suratPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 30, 680, -1));

        pnlCards.add(suratPanel, "card2");

        profilPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 166, 90));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 166, 90));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        jLabel4.setText("Berikut adalah data mahasiswa yang melakukan pengajuan surat, mohon periksa dengan seksama");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 800, 30));

        jLabeel.setBackground(new java.awt.Color(51, 51, 51));
        jLabeel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabeel.setForeground(new java.awt.Color(51, 51, 51));
        jLabeel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeel.setText("Nama Lengkap");

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Nim");

        jLebeel.setBackground(new java.awt.Color(51, 51, 51));
        jLebeel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLebeel.setForeground(new java.awt.Color(51, 51, 51));
        jLebeel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLebeel.setText("Program Studi");

        jLabel36.setBackground(new java.awt.Color(51, 51, 51));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Jenjang Studi");

        jLabel37.setBackground(new java.awt.Color(51, 51, 51));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("IPK");

        jLabel38.setBackground(new java.awt.Color(51, 51, 51));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Kontak");

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Angkatan");

        jLabel40.setBackground(new java.awt.Color(51, 51, 51));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Semester");

        jLabel41.setBackground(new java.awt.Color(51, 51, 51));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Alamat");

        jLabel42.setBackground(new java.awt.Color(51, 51, 51));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Tempat Tanggal Lahir");

        jLabel43.setBackground(new java.awt.Color(51, 51, 51));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText(":");

        jLabel44.setBackground(new java.awt.Color(51, 51, 51));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText(":");

        jLabel45.setBackground(new java.awt.Color(51, 51, 51));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText(":");

        jLabel46.setBackground(new java.awt.Color(51, 51, 51));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText(":");

        jLabel47.setBackground(new java.awt.Color(51, 51, 51));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText(":");

        jLabel48.setBackground(new java.awt.Color(51, 51, 51));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText(":");

        jLabel49.setBackground(new java.awt.Color(51, 51, 51));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText(":");

        jLabel50.setBackground(new java.awt.Color(51, 51, 51));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText(":");

        jLabel51.setBackground(new java.awt.Color(51, 51, 51));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText(":");

        jLabel52.setBackground(new java.awt.Color(51, 51, 51));
        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText(":");

        namaLengkap.setBackground(new java.awt.Color(51, 51, 51));
        namaLengkap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        namaLengkap.setForeground(new java.awt.Color(51, 51, 51));
        namaLengkap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaLengkap.setText("Nama Lengkap");
        namaLengkap.setToolTipText("");
        namaLengkap.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nimNomor.setBackground(new java.awt.Color(51, 51, 51));
        nimNomor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nimNomor.setForeground(new java.awt.Color(51, 51, 51));
        nimNomor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nimNomor.setText("Nim");
        nimNomor.setToolTipText("");
        nimNomor.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        programStudi.setBackground(new java.awt.Color(51, 51, 51));
        programStudi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        programStudi.setForeground(new java.awt.Color(51, 51, 51));
        programStudi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        programStudi.setText("Program Studi");
        programStudi.setToolTipText("");
        programStudi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jenjangStudi.setBackground(new java.awt.Color(51, 51, 51));
        jenjangStudi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jenjangStudi.setForeground(new java.awt.Color(51, 51, 51));
        jenjangStudi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jenjangStudi.setText("Jenjang Studi");
        jenjangStudi.setToolTipText("");
        jenjangStudi.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        ipkMahasiswa.setBackground(new java.awt.Color(51, 51, 51));
        ipkMahasiswa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ipkMahasiswa.setForeground(new java.awt.Color(51, 51, 51));
        ipkMahasiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ipkMahasiswa.setText("IPK");
        ipkMahasiswa.setToolTipText("");
        ipkMahasiswa.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        kontakNomor.setBackground(new java.awt.Color(51, 51, 51));
        kontakNomor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        kontakNomor.setForeground(new java.awt.Color(51, 51, 51));
        kontakNomor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kontakNomor.setText("Kontak");
        kontakNomor.setToolTipText("");
        kontakNomor.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        angkatanTahun.setBackground(new java.awt.Color(51, 51, 51));
        angkatanTahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        angkatanTahun.setForeground(new java.awt.Color(51, 51, 51));
        angkatanTahun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        angkatanTahun.setText("Angkatan");
        angkatanTahun.setToolTipText("");
        angkatanTahun.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        semesterTahun.setBackground(new java.awt.Color(51, 51, 51));
        semesterTahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        semesterTahun.setForeground(new java.awt.Color(51, 51, 51));
        semesterTahun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semesterTahun.setText("Semester");
        semesterTahun.setToolTipText("");
        semesterTahun.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        alamatRumah.setBackground(new java.awt.Color(51, 51, 51));
        alamatRumah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        alamatRumah.setForeground(new java.awt.Color(51, 51, 51));
        alamatRumah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alamatRumah.setText("Alamat");
        alamatRumah.setToolTipText("");
        alamatRumah.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        alamatRumah.setMaximumSize(new java.awt.Dimension(100, 100));

        tempatTanggalLahir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tempatTanggalLahir.setForeground(new java.awt.Color(51, 51, 51));
        tempatTanggalLahir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempatTanggalLahir.setText("Tempat Tanggal Lahir");
        tempatTanggalLahir.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Data Diri Mahasiswa");

        acceptButton.setBackground(new java.awt.Color(255, 153, 51));
        acceptButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(255, 255, 255));
        acceptButton.setText("Accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        deniedButton.setBackground(new java.awt.Color(204, 0, 0));
        deniedButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deniedButton.setForeground(new java.awt.Color(255, 255, 255));
        deniedButton.setText("Denied");
        deniedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deniedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilPanelLayout = new javax.swing.GroupLayout(profilPanel);
        profilPanel.setLayout(profilPanelLayout);
        profilPanelLayout.setHorizontalGroup(
            profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilPanelLayout.createSequentialGroup()
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(profilPanelLayout.createSequentialGroup()
                                .addComponent(deniedButton)
                                .addGap(30, 30, 30)
                                .addComponent(acceptButton))
                            .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addGap(97, 97, 97)
                                    .addComponent(jLabel48)
                                    .addGap(27, 27, 27)
                                    .addComponent(kontakNomor))
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addGap(84, 84, 84)
                                    .addComponent(jLabel49)
                                    .addGap(27, 27, 27)
                                    .addComponent(angkatanTahun))
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addGap(83, 83, 83)
                                    .addComponent(jLabel50)
                                    .addGap(27, 27, 27)
                                    .addComponent(semesterTahun))
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addGap(98, 98, 98)
                                    .addComponent(jLabel51)
                                    .addGap(27, 27, 27)
                                    .addComponent(alamatRumah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(profilPanelLayout.createSequentialGroup()
                                            .addComponent(jLebeel)
                                            .addGap(54, 54, 54)
                                            .addComponent(jLabel45)
                                            .addGap(27, 27, 27)
                                            .addComponent(programStudi))
                                        .addGroup(profilPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel36)
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel46)
                                            .addGap(27, 27, 27)
                                            .addComponent(jenjangStudi))
                                        .addGroup(profilPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel37)
                                            .addGap(115, 115, 115)
                                            .addComponent(jLabel47)
                                            .addGap(27, 27, 27)
                                            .addComponent(ipkMahasiswa))
                                        .addGroup(profilPanelLayout.createSequentialGroup()
                                            .addComponent(jLabeel)
                                            .addGap(52, 52, 52)
                                            .addComponent(jLabel43)
                                            .addGap(27, 27, 27)
                                            .addComponent(namaLengkap))
                                        .addGroup(profilPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(111, 111, 111)
                                            .addComponent(jLabel44)
                                            .addGap(27, 27, 27)
                                            .addComponent(nimNomor))))
                                .addGroup(profilPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel42)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel52)
                                    .addGap(27, 27, 27)
                                    .addComponent(tempatTanggalLahir))))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        profilPanelLayout.setVerticalGroup(
            profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeel)
                            .addComponent(namaLengkap))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(nimNomor))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLebeel)
                            .addComponent(programStudi))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jenjangStudi))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(ipkMahasiswa))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(kontakNomor))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(angkatanTahun))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(semesterTahun))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(alamatRumah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(profilPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(tempatTanggalLahir))))
                .addGap(18, 18, 18)
                .addGroup(profilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(deniedButton))
                .addGap(40, 40, 40))
        );

        pnlCards.add(profilPanel, "card5");

        buatPanel.setBackground(new java.awt.Color(255, 255, 255));
        buatPanel.setMaximumSize(new java.awt.Dimension(960, 578));
        buatPanel.setMinimumSize(new java.awt.Dimension(960, 578));
        buatPanel.setName(""); // NOI18N
        buatPanel.setPreferredSize(new java.awt.Dimension(960, 578));
        buatPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pilihSurat.setBackground(new java.awt.Color(255, 255, 255));
        pilihSurat.setForeground(new java.awt.Color(0, 0, 0));
        pilihSurat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surat Aktif Kuliah", "Surat Keterangan Berkelakuan baik", "Surat Keterangan Kehilangan KTM", "Surat Keterangan Tugas Akhir", "Surat Rekomendasi Beasiswa", "Surat Keterangan Cuti", "Surat keterangan Pengunduran Diri", "Transkrip Nilai Sementara" }));
        pilihSurat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pilihSurat.setMaximumSize(new java.awt.Dimension(100, 100));
        pilihSurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihSuratActionPerformed(evt);
            }
        });
        buatPanel.add(pilihSurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 470, -1));

        buatSurat.setBackground(new java.awt.Color(255, 153, 51));
        buatSurat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buatSurat.setForeground(new java.awt.Color(255, 255, 255));
        buatSurat.setText("Buat Surat");
        buatSurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buatSuratActionPerformed(evt);
            }
        });
        buatPanel.add(buatSurat, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        peruntukanField.setBackground(new java.awt.Color(255, 255, 255));
        peruntukanField.setForeground(new java.awt.Color(0, 0, 0));
        peruntukanField.setText("Silahkan mengisi peruntukkan surat");
        peruntukanField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        peruntukanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peruntukanFieldActionPerformed(evt);
            }
        });
        buatPanel.add(peruntukanField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 470, 70));

        pnlCards.add(buatPanel, "card2");

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
    }// </editor-fold>//GEN-END:initComponents

    private void suratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suratActionPerformed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "pnlCard5");
        showTable();
    }//GEN-LAST:event_suratActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
        DataUpdate dataUpdate = new DataUpdate(idSuratToAccept, "Accept");
        RiwayatSurat riwayatSurat = new RiwayatSurat();
        boolean updateSuccessful = riwayatSurat.updateData(dataUpdate);

        if (updateSuccessful) {
            System.out.println("Status updated to 'accept'");
        } else {
            System.out.println("Status update failed");
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void pilihSuratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihSuratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilihSuratActionPerformed

    private void buatSuratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buatSuratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buatSuratActionPerformed

    private void peruntukanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peruntukanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peruntukanFieldActionPerformed

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
    }//GEN-LAST:event_dashboardActionPerformed

    private void suratTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suratTabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_suratTabelMouseClicked

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        // TODO add your handling code here:
        navigateToLoginScreen();
    }//GEN-LAST:event_signOutActionPerformed

    private void deniedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deniedButtonActionPerformed
        // TODO add your handling code here:
        DataUpdate dataUpdate = new DataUpdate(idSuratToAccept, "Denied");
        RiwayatSurat riwayatSurat = new RiwayatSurat();
        boolean updateSuccessful = riwayatSurat.updateData(dataUpdate);

        if (updateSuccessful) {
            System.out.println("Status updated to 'denied'");
        } else {
            System.out.println("Status update failed");
        }
    }//GEN-LAST:event_deniedButtonActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            StaffInterface staffInterface = new StaffInterface("roleChecker");
            staffInterface.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Navigation;
    private javax.swing.JButton acceptButton;
    private javax.swing.JLabel alamatRumah;
    private javax.swing.JLabel angkatanTahun;
    private javax.swing.JPanel background;
    private javax.swing.JPanel buatPanel;
    private javax.swing.JButton buatSurat;
    private javax.swing.JButton dashboard;
    private javax.swing.JButton deniedButton;
    private javax.swing.JLabel ipkMahasiswa;
    private javax.swing.JLabel jLabeel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLebeel;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jenjangStudi;
    private javax.swing.JLabel kontakNomor;
    private javax.swing.JLabel mahasiswaText;
    private javax.swing.JLabel namaLengkap;
    private javax.swing.JButton navButton;
    private javax.swing.JLabel nimNomor;
    private javax.swing.JPanel orangePanel;
    private javax.swing.JTextField peruntukanField;
    private javax.swing.JComboBox<String> pilihSurat;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel profilPanel;
    private javax.swing.JLabel programStudi;
    private javax.swing.JLabel semesterTahun;
    private javax.swing.JButton signOut;
    private javax.swing.JButton surat;
    private javax.swing.JPanel suratPanel;
    private javax.swing.JTable suratTabel;
    private javax.swing.JLabel tempatTanggalLahir;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables
}

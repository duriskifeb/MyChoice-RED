/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gwild
 */
public class buku extends javax.swing.JFrame {

    /**
     * Creates new form buku
     */
    public buku() throws SQLException {
        initComponents();
        conn = Koneksi.bukaKoneksi();
        loadKolom();
        jtBuku.setModel(model);
        loadBuku();
        loadCBGenre();
        loadCBPenulis();
        tampilBuku();
    }

    private void loadKolom() {
        model.addColumn("buku");
        model.addColumn("nama");
        model.addColumn("genre");
    }

    private void loadCBGenre() {
        if (conn != null) {
            String kueri = "SELECT * FROM genre";
            try {
                PreparedStatement ps = conn.prepareStatement(kueri);
                ResultSet rs = ps.executeQuery();
                cbKategori.removeAllItems();
                while (rs.next()) {
                    int id = rs.getInt("idgenre");
                    String genre = rs.getString("genre");
                    System.out.println("sout : " + id + "-" + genre);
                    ComboBoxData data2 = new ComboBoxData(id, genre);
                    cbKategori.addItem(data2);
                }
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadCBPenulis() {
        if (conn != null) {
            String kueri = "SELECT * FROM pengarang";
            try {
                PreparedStatement ps = conn.prepareStatement(kueri);
                ResultSet rs = ps.executeQuery();
                tfPengarang.removeAllItems();
                while (rs.next()) {
                    int id = rs.getInt("idpengarang");
                    String pengarang = rs.getString("nama");
                    System.out.println("sout : " + id + "-" + pengarang);
                    ComboBoxData data2 = new ComboBoxData(id, pengarang);
                    tfPengarang.addItem(data2);
                }
                rs.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadBuku() throws SQLException {
        if (conn != null) {
            daftarbuku = new ArrayList<>();
            String kueri = "select * from buku;";
            try {
                PreparedStatement ps = conn.prepareStatement(kueri);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("idbuku");
                    String buku = rs.getString("buku");
                    int penulis = rs.getInt("nama");
                    int genre = rs.getInt("genre");
                    buku1 buku1 = new buku1(buku, penulis, genre);
                    daftarbuku.add(buku1);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void tampilBuku() {
        // model.setRowCount(0);
        // for (int i = 0;i < daftarbuku.size();i++) {
        // model.addRow(new Object[]{daftarbuku.get(i).instring()});
        // }
        // model.addColumn("Judul");
        // model.addColumn("Penulis");
        // model.addColumn("Genre");

        try {
            model.setRowCount(0);
            String sql = ("SELECT b.buku, p.nama ,g.genre FROM `buku` b inner join `pengarang` p on b.idpengarang = p.idpengarang inner join `genre` g on b.idgenre = g.idgenre; ");
            java.sql.Connection con = (Connection) Koneksi.bukaKoneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[] {
                        res.getString(1), res.getString(2), res.getString(3)
                });

            }
            jtBuku.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void NewJFrame() throws SQLException {
        initComponents();
        jtBuku.setModel(model);
        conn = Koneksi.bukaKoneksi();
        loadBuku();
        tampilBuku();
    }

    private void reset() {
        tfjudul.setText("");
        tfPengarang.setSelectedIndex(0);
        cbKategori.setSelectedIndex(0);
        bSubmit.setText("Submit");
    }

    private void tambahData(String buku, String pengarang, String genre) {
        int idGenre = 0;
        int idpengarang = 0;

        if (conn != null) {
            try {
                String kueri = "SELECT idgenre FROM `genre` WHERE genre = ?;";
                PreparedStatement ps = conn.prepareStatement(kueri);
                ps.setString(1, genre);
                ResultSet rs = ps.executeQuery();

                // Iterate over the result set to get the idGenre
                if (rs.next()) {
                    idGenre = rs.getInt("idGenre");
                    // Now you can use the idGenre variable as needed
                    // System.out.println("idGenre: " + idGenre);
                }
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                String kueri = "SELECT idpengarang FROM `pengarang` WHERE nama = ?;";
                PreparedStatement ps = conn.prepareStatement(kueri);
                ps.setString(1, pengarang);
                ResultSet rs = ps.executeQuery();

                // Iterate over the result set to get the idGenre
                if (rs.next()) {
                    idpengarang = rs.getInt("idpengarang");
                    // Now you can use the idGenre variable as needed
                    // System.out.println("idGenre: " + idGenre);
                }
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                String kueri = "insert into buku( idgenre, idpengarang, buku) values (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(kueri);
                ps.setInt(1, idGenre);
                ps.setInt(2, idpengarang);
                ps.setString(3, buku);
                int hasil = ps.executeUpdate();
                if (hasil > 0) {
                    buku1 buku1 = new buku1(buku, idpengarang, idGenre);
                    JOptionPane.showMessageDialog(this, "input berhasil");
                    // ubah isi tabel
                    loadBuku();
                    tampilBuku();
                }
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ubahdata(int id, String buku, String nama, String genre) {
        if (conn != null)
            try {
                String kueri = "update buku set buku =?, nama =?, genre=? where id=?";
                PreparedStatement ps = conn.prepareStatement(kueri);
                ps.setString(1, buku);
                ps.setString(2, nama);
                ps.setString(3, genre);
                ps.setInt(4, id);
                int hasil = ps.executeUpdate();
                if (hasil == 1) {
                    JOptionPane.showMessageDialog(this, "update berhasil");
                    // ubah isi tabel
                    loadBuku();
                    tampilBuku();
                }
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void cariBukuByKeyboard(String keyword) {
        if (conn != null) {
            daftarbuku = new ArrayList<>();
            String kueri = "Select * from buku where nama Like ?";
            try {
                PreparedStatement ps = conn.prepareStatement(kueri);
                ps.setString(1, "%" + keyword + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String buku = rs.getString("buku");
                    int penulis = rs.getInt("nama");
                    int genre = rs.getInt("genre");
                    buku1 buku1 = new buku1(buku, penulis, genre);
                    daftarbuku.add(buku1);
                }
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private DefaultTableModel model = new DefaultTableModel();
    private Connection conn;
    private ArrayList<buku1> daftarbuku;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfjudul = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPengarang = new javax.swing.JComboBox<>();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bSubmit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBuku = new javax.swing.JTable();
        bUbah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1098, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 832, Short.MAX_VALUE));

        jLabel1.setText("Form Buku");

        jLabel2.setText("Data Buku");

        jLabel3.setText("Data Buku");

        tfjudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfjudulActionPerformed(evt);
            }
        });

        jLabel4.setText("Judul:");

        jLabel5.setText("Pengarang:");

        tfPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPengarangActionPerformed(evt);
            }
        });

        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });

        jLabel6.setText("Kategori:");

        bSubmit.setText("Submit");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(bSubmit)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addContainerGap(44, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbKategori, 0, 127, Short.MAX_VALUE)
                                        .addComponent(tfjudul)
                                        .addComponent(tfPengarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(21, 21, 21)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfjudul, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(tfPengarang, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bSubmit)
                                        .addComponent(jButton3))
                                .addContainerGap(212, Short.MAX_VALUE)));

        jLabel7.setText("Cari Pengarang:");

        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtBuku.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "Judul", "Penulis", "Genre"
                }));
        jScrollPane1.setViewportView(jtBuku);

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jLabel1))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jPanel3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(77, 77, 77)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(tfCari,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        156,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jButton1))))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jScrollPane1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(bUbah)
                                                                        .addGap(199, 199, 199))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(342, 342, 342)
                                                .addComponent(jLabel3)))
                                .addContainerGap(24, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel3)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(bUbah)))
                                .addContainerGap(16, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here
        int barisTerpilih = jtBuku.getSelectedRow();
        tfjudul.setText(model.getValueAt(barisTerpilih, 0).toString());
        tfPengarang.setSelectedItem(model.getValueAt(barisTerpilih, 1).toString());
        cbKategori.setSelectedItem(model.getValueAt(barisTerpilih, 2));
        bSubmit.setText("Edit");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            model.setRowCount(0);
            String sql = ("SELECT b.buku, p.nama ,g.genre FROM `buku` b inner join `pengarang` p on b.idpengarang = p.idpengarang inner join `genre` g on b.idgenre = g.idgenre where b.buku like '%"
                    + tfCari.getText() + "%' or p.nama like '%" + tfCari.getText() + "%' or g.genre like '%"
                    + tfCari.getText() + "%'; ");
            java.sql.Connection con = (Connection) Koneksi.bukaKoneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[] {
                        res.getString(1), res.getString(2), res.getString(3)
                });

            }
            jtBuku.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        reset();
    }

    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String buku = tfjudul.getText();
        String Pengarang = tfPengarang.getSelectedItem().toString();
        String Kategori = cbKategori.getSelectedItem().toString();
        if (buku.equals("") || tfPengarang.getSelectedIndex() == 0 || cbKategori.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "isi field yang kosong");
        } else {
            if (bSubmit.getText().equals("Submit")) {
                tambahData(buku, Pengarang, Kategori);
            } else if (bSubmit.getText().equals("Edit")) {
                int barisTerpilih = jtBuku.getSelectedRow();
                // ubahdata(daftarbuku.get(barisTerpilih).getId(), buku, Pengarang, Kategori);
            }
        }
        // reset();
    }

    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void tfPengarangActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void tfjudulActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        tfjudul.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new buku().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(buku.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bSubmit;
    private javax.swing.JButton bUbah;
    private javax.swing.JComboBox<ComboBoxData> cbKategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtBuku;
    private javax.swing.JTextField tfCari;
    private javax.swing.JComboBox<ComboBoxData> tfPengarang;
    private javax.swing.JTextField tfjudul;
    // End of variables declaration
}

class buku1 {

    private int idpengarang, idgenre;
    private String judul;

    public buku1(String judul, int idpengarang, int idgenre) {
        this.judul = judul;
        this.idpengarang = idpengarang;
        this.idgenre = idgenre;
    }

    public String getJudul() {
        return judul;
    }

    public int getPengarang() {
        return idpengarang;
    }

    public int getGenre() {
        return idgenre;
    }

    public void instring(String id) {
        id = " " + judul + " " + idpengarang + " " + idgenre;
    }
}

class ComboBoxData {

    private int id;
    private String name;

    public ComboBoxData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

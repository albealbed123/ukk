/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukk.pelapor;

import ukk.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.swing.JRViewer;
import ukk.session;


/**
 *
 * @author dppra
 */
public class pengaduan extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    String pathFoto = null;

   private void setTanggalHariIni() {
    jd_tglpengaduan.setDate(new Date());
    jd_tglpengaduan.getDateEditor().setEnabled(false);
    jd_tglpengaduan.getCalendarButton().setEnabled(false);
}
    private DefaultTableModel model;
    
    public pengaduan() {
        initComponents();
        setLocationRelativeTo(null);// membuat tengah form
        setTanggalHariIni();
        conn = Koneksi.Koneksi.KoneksiDB();
        tampilIdPengaduan();
        txt_nik.setText(session.getNik());
        txt_nik.setEditable(false);

       // getData();//javaConnect = nama file || Connection = nama method
        
        
        //memberi penamaan pada judul kolom ; 
        model = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("id pengaduan");
        model.addColumn("nik");
        model.addColumn("nama");
        model.addColumn("Tanggal Pengaduan");
        model.addColumn("Isi Laporan");
        model.addColumn("Foto");
        model.addColumn("Kategori");
        model.addColumn("lokasi");
        model.addColumn("Status");
        
        
        
        getData();//memanggil method getdata
       }
    //menampilkan data kejTabel1
    void getData() {
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
       
    
    try {
        //membuat statement pemanggilan data pada table surat_masuk dari database 
//        String sql = "select * from pengaduan";
//        pst = conn.prepareStatement(sql);
//        rs = pst.executeQuery();
        String sql = "SELECT * FROM pengaduan WHERE nik = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, session.getNik());
        rs = pst.executeQuery();

        
        //penelusuran baris pada table surat_masuk dari database
        while (rs.next()) {
            Object[] obj = new Object[9];
            obj[0] = rs.getString("id_pengaduan");
            obj[1] = rs.getString("nik");
            obj[2] = rs.getString("nama");
            obj[3] = rs.getString("tgl_pengaduan");
            obj[4] = rs.getString("isi_laporan");
            obj[5] = rs.getString("foto");
            obj[6] = rs.getString("Kategori");
            obj[7] = rs.getString("lokasi");
            obj[8] = rs.getString("status");
           
            
 
            
            model.addRow(obj);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);      
    }
} 

 //menampilkan data dr tabel ke masing-masing komponen cara 2
   void pilihData() {
       int i = jTable1.getSelectedRow();
       txt_pengaduan.setText(model.getValueAt(i, 0).toString());
       txt_nik.setText(model.getValueAt(i, 1).toString());
       txt_nama.setText(model.getValueAt(i, 2).toString());
       lokasi.setText(model.getValueAt(i, 3).toString());
       
       txt_isi.setText(model.getValueAt(i, 4).toString());
     lbl_foto.setText(model.getValueAt(i, 5).toString());
       
   } 
   
   void bersih() {
     //  txt_pengaduan.setText("");
       txt_nik.setText("");
       txt_nama.setText("");
       txt_isi.setText("");
       lokasi.setText("");
       
       // HAPUS TANGGAL
       // jd_tglpengaduan.setDate(null);
       
        // HAPUS FOTO
       lbl_foto.setIcon(null);
       pathFoto = null;
   }
   
   void tampilIdPengaduan() {
    try {
        String sql = "SELECT IFNULL(MAX(id_pengaduan), 0) + 1 AS id FROM pengaduan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();

        if (rs.next()) {
            txt_pengaduan.setText(rs.getString("id"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jd_tglpengaduan = new com.toedter.calendar.JDateChooser();
        txt_nik = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_isi = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmb_cari = new javax.swing.JComboBox<>();
        lbl_foto = new javax.swing.JLabel();
        btn_upload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kategori = new javax.swing.JComboBox<>();
        txt_pengaduan = new javax.swing.JTextField();
        lokasi = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PENGADUAN");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jd_tglpengaduan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 210, 30));

        txt_nik.setBorder(null);
        jPanel1.add(txt_nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 210, 20));

        txt_nama.setEditable(false);
        txt_nama.setBackground(new java.awt.Color(204, 204, 204));
        txt_nama.setBorder(null);
        txt_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, 23));

        txt_isi.setColumns(20);
        txt_isi.setRows(5);
        txt_isi.setBorder(null);
        jPanel1.add(txt_isi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 210, 50));

        jButton8.setBorder(null);
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 50, 20));

        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 50, 20));

        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 50, 20));

        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 50, 20));

        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 60, 20));

        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 50, 20));

        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 50, 20));

        cmb_cari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "Tanggal" }));
        cmb_cari.setBorder(null);
        cmb_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_cariActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 90, -1));

        lbl_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 100, 130));

        btn_upload.setText("UPLOAD");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });
        jPanel1.add(btn_upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 500, 170));

        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sarana", "Prasarana" }));
        jPanel1.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 210, 30));

        txt_pengaduan.setEditable(false);
        txt_pengaduan.setBackground(new java.awt.Color(204, 204, 204));
        txt_pengaduan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pengaduanActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pengaduan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 210, -1));
        jPanel1.add(lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 210, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sarana", "Prasarana" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 110, 20));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tampilan="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal=String.valueOf(fm.format(jd_tglpengaduan.getDate()));
     
        try{
          String sql = "INSERT INTO pengaduan (nik, tgl_pengaduan, isi_laporan, nama, foto, status, Kategori, lokasi) VALUES (?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_nik.getText());
            pst.setString(2, tanggal);
            pst.setString(3, txt_isi.getText());
            pst.setString(4, txt_nama.getText());
            pst.setString(5, pathFoto); // status default
            pst.setString(6, "menunggu");
            pst.setString(7, kategori.getSelectedItem().toString());
            pst.setString(8, lokasi.getText());

           pst.execute();
           JOptionPane.showMessageDialog(null, "saved");
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       getData();
       bersih();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmb_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_cariActionPerformed

    private void txt_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        String sql = "select * from masyarakat where nik='" + txt_nik.getText() + "'";  
        try {
            
            
            pst = conn.prepareStatement(sql);
            rs  = pst.executeQuery();
            
            if (rs.next()) {
                String addl = rs.getString("nama");
                txt_nama.setText(addl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        String sql = "";
//            
//         model.getDataVector().removeAllElements();
//         model.fireTableDataChanged();
//         try {
//              if (cmb_cari.getSelectedIndex() == 0) {
//                    sql = "SELECT * FROM pengaduan where id_pengaduan like '%" + txt_cari.getText() + "%' ";
//                    
//               }
//              if (cmb_cari.getSelectedIndex() == 1) {
//                    sql = "SELECT * FROM pengaduan where nik like '%" + txt_cari.getText() + "%' ";
//               }
//                
//              pst = conn.prepareStatement(sql);
//              rs = pst.executeQuery();
//                
//              while (rs.next()) {
//                  Object[] obj = new Object[5];
//                  obj[0] = rs.getString("id_pengaduan");
//                  obj[1] = rs.getString("nik");
//                  obj[2] = rs.getString("tgl_pengaduan");
//                  obj[3] = rs.getString("isi_laporan");
//                 // obj[4] = rs.getString("status");
//                    
//                    
//                  model.addRow(obj);
//                }
//              
//     } catch (Exception e) {
//          JOptionPane.showMessageDialog(null, e);
//        } 
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
       });

        
        int i = jTable1.getSelectedRow(); // Mendapatkan baris yang dipilih
        TableModel model = jTable1.getModel();

        ///txt_pengaduan.setText(model.getValueAt(i, 0).toString());
        txt_nik.setText(model.getValueAt(i, 1).toString());
        txt_nama.setText(model.getValueAt(i, 2).toString());
        txt_isi.setText(model.getValueAt(i, 4).toString());
        // Mengisi data kategori ke ComboBox
        kategori.setSelectedItem(jTable1.getValueAt(i, 6).toString());
        lokasi.setText(model.getValueAt(i, 7).toString());
        
        // TANGGAL
    try {
        String tanggal = model.getValueAt(i, 3).toString();
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
        jd_tglpengaduan.setDate(date);
    } catch (Exception e) {
        e.printStackTrace();
    }

    // ================= FOTO =================
    pathFoto = model.getValueAt(i, 5).toString();

    ImageIcon icon = new ImageIcon(pathFoto);
    Image img = icon.getImage().getScaledInstance(
        lbl_foto.getWidth(),
        lbl_foto.getHeight(),
        Image.SCALE_SMOOTH
    );
    lbl_foto.setIcon(new ImageIcon(img));
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       ukk.menu.menuPelapor menu = new ukk.menu.menuPelapor();
    
    // 2. Menampilkan Menu Admin
    menu.setVisible(true);
    
    // 3. Menutup halaman Riwayat Aspirasi saat ini
    this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int p = JOptionPane.showConfirmDialog(null,
            "Apakah benar-benar akan dihapus permanen ? ",
            " Delete",
            JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from pengaduan where id_pengaduan=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_nik.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            getData();
            bersih();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        bersih();
        getData();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        String tampilan="yyyy-MM-dd";
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
//        String tanggal=String.valueOf(fm.format(jd_tglpengaduan.getDate()));
//        try {
//            String id_pengaduan = txt_pengaduan.getText();
//            String nik = txt_nik.getText();
//            String tgl = tanggal;
//            String isi = txt_isi.getText();
//           // String status = txt_status.getText();
//
//            String sql = "UPDATE pengaduan set id_pengaduan='" + id_pengaduan + "', tgl_pengaduan='" + tgl + "', isi_laporan='" + isi +  "'";
//            pst = conn.prepareStatement(sql);
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "UPDATE SUKSES");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        getData();
//        bersih();
         String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = fm.format(jd_tglpengaduan.getDate());

        try {
            String id_pengaduan = txt_pengaduan.getText(); // field ID
            String nik = txt_nik.getText();
            String isi = txt_isi.getText();

            String sql = "UPDATE pengaduan SET nik=?, tgl_pengaduan=?, isi_laporan=? WHERE id_pengaduan=?";
            pst = conn.prepareStatement(sql);

            pst.setString(1, nik);
            pst.setString(2, tanggal);
            pst.setString(3, isi);
            pst.setString(4, id_pengaduan);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATE SUKSES");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        getData();
        bersih();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
    javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
    int hasil = chooser.showOpenDialog(null);

    if (hasil == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File file = chooser.getSelectedFile();
        pathFoto = file.getAbsolutePath();

        ImageIcon icon = new ImageIcon(pathFoto);
        Image img = icon.getImage().getScaledInstance(
                lbl_foto.getWidth(),
                lbl_foto.getHeight(),
                Image.SCALE_SMOOTH
        );
        lbl_foto.setIcon(new ImageIcon(img));
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_uploadActionPerformed

    private void txt_pengaduanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pengaduanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pengaduanActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(pengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pengaduan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_upload;
    private javax.swing.JComboBox<String> cmb_cari;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jd_tglpengaduan;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JTextField lokasi;
    private javax.swing.JTextArea txt_isi;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nik;
    private javax.swing.JTextField txt_pengaduan;
    // End of variables declaration//GEN-END:variables
    
}

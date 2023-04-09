package GUI;

import DAL.GiaoVienDAO;
import GUI.HomeformGiaoVien;
import GUI.EditGiaoVien;
import DTO.GiaoVien;
import BLL.GiaoVienBUS;
import DAL.BindingListener;
import javax.swing.JOptionPane;
//import model.Student;

/**
 *
 * @author ADMIN
 */
public class InputGiaoVien extends javax.swing.JDialog {

    /**
     * Creates new form InputFrm
     */
    private HomeformGiaoVien home;
    private GiaoVienDAO DAO;
    private GiaoVienBUS BUS;
    
    public InputGiaoVien(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (HomeformGiaoVien) parent;
        this.setTitle("Sửa thông tin sinh viên");
        BUS = new GiaoVienBUS();
        DAO = new GiaoVienDAO();
        String EMAIL_PATTERN = 
            "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        txtMaGV.getDocument().addDocumentListener(new BindingListener(txtMaGV, "[a-z0-9]*"));
        txtCCCD.getDocument().addDocumentListener(new BindingListener(txtCCCD, "[0-9]*"));
        txtDiaChi.getDocument().addDocumentListener(new BindingListener(txtDiaChi, "^[a-zA-Z0-9\\s\\/]*$"));
        txtHoTen.getDocument().addDocumentListener(new BindingListener(txtHoTen,"[a-z0-9\\s]*"));
        txtNgaySinh.getDocument().addDocumentListener(new BindingListener(txtNgaySinh,"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"));        
        txtMonHoc.getDocument().addDocumentListener(new BindingListener(txtMonHoc,"[a-z\\s]*"));
        txtGioiTinh.getDocument().addDocumentListener(new BindingListener(txtGioiTinh,"(?i)(nam|nu)"));        
        txtNoiSinh.getDocument().addDocumentListener(new BindingListener(txtNoiSinh,"[a-z\\s]*"));        
        txtQueQuan.getDocument().addDocumentListener(new BindingListener(txtQueQuan,"[a-z\\s]*"));        
        txtNoiO.getDocument().addDocumentListener(new BindingListener(txtNoiO,"^[1-zA-Z0-9\\s\\/]*$"));      
        txtSoDienThoai.getDocument().addDocumentListener(new BindingListener(txtSoDienThoai,"[0-9\\s]*"));        
        txtEmail.getDocument().addDocumentListener(new BindingListener(txtEmail,EMAIL_PATTERN));   
        txtToChuyenMon.getDocument().addDocumentListener(new BindingListener(txtToChuyenMon,"[a-z\\s]*"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMonHoc = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        txtQueQuan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtNoiO = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtToChuyenMon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       // setTitle("THÔNG TIN GIÁO VIÊN");

        jLabel2.setText("Mã giáo viên:");
        jLabel2.setSize(new java.awt.Dimension(50, 20));

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Ngày sinh:");

        jLabel5.setText("Nơi sinh:");

        txtMaGV.setText("");

        txtHoTen.setText("");
        
        txtNgaySinh.setText("");

        txtNoiSinh.setText("");

        jLabel6.setText("Môn học giảng dạy:");

        jLabel7.setText("Giới tính:");

        jLabel8.setText("Quê quán:");

        txtMonHoc.setText("");

        txtGioiTinh.setText("");

        txtQueQuan.setText("");

        jLabel9.setText("Địa chỉ thường trú:");

        jLabel10.setText("Nơi ở hiện tại:");

        jLabel11.setText("Số căn cước công dân:");

        jLabel12.setText("Số điện thoại:");

        jLabel13.setText("Tổ chuyên môn:");

        txtDiaChi.setText("");

        txtNoiO.setText("");

        txtCCCD.setText("");

        txtSoDienThoai.setText("");

        txtToChuyenMon.setText("");

        jLabel14.setText("Email:");

        txtEmail.setText("");
        
        
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        
        btnEdit.setText("Lưu");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setText("Hủy bỏ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                            .addComponent(txtNoiSinh))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtHoTen)))
                    .addComponent(txtNoiO)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtToChuyenMon))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoiO, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtToChuyenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        String MaGV = "", HoTen = "", NgaySinh = "", MonHoc = "",
               GioiTinh = "",  NoiSinh = "",  QueQuan = "", DiaChi = "" ,
               NoiO = "", CCCD = "", SoDienThoai = "",
               Email = "", ToChuyenMon = "";
          
        boolean isOK = true;
        
     
        MaGV = txtMaGV.getText();
        HoTen = txtHoTen.getText();
        NgaySinh = txtNgaySinh.getText();
        MonHoc = txtMonHoc.getText();
        GioiTinh = txtGioiTinh.getText();
        NoiSinh = txtNoiSinh.getText();
        QueQuan = txtQueQuan.getText();
        DiaChi = txtDiaChi.getText();
        NoiO = txtNoiO.getText();
        CCCD = txtCCCD.getText();
        SoDienThoai = txtSoDienThoai.getText();
        Email = txtEmail.getText();
        ToChuyenMon = txtToChuyenMon.getText();
        
        
        
//        try {
//            age = Integer.parseInt(txtAge.getText());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, 
//                    "Tuổi phải là số và ko chứa kí tự khác!");
//            isOK = false;
//        }

//        try {
//            mark = Float.parseFloat(txtAvgMark.getText());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, 
//                    "Điểm phải là số và ko chứa kí tự khác!");
//            isOK = false;
//        }
            GiaoVien giaovien = new GiaoVien(
               
               MaGV, HoTen, NgaySinh, MonHoc,
               GioiTinh,  NoiSinh, QueQuan, DiaChi,
               NoiO, CCCD, SoDienThoai,
               Email, ToChuyenMon
            );
            if (BUS.check(giaovien))
            {
                 DAO.add(giaovien);

                 home.addGiaoVienlist(giaovien);
                 JOptionPane.showMessageDialog(rootPane, 
                         "Thêm thành công!");

                 txtMaGV.setText("");
                 txtHoTen.setText("");
                 txtNgaySinh.setText("");
                 txtMonHoc.setText("");
                 txtGioiTinh.setText("");
                 txtNoiSinh.setText("");
                 txtQueQuan.setText("");
                 txtDiaChi.setText("");
                 txtNoiO.setText("");
                 txtCCCD.setText("");
                 txtSoDienThoai.setText("");
                 txtEmail.setText("");
                 txtToChuyenMon.setText("");
            }
            else 
                JOptionPane.showMessageDialog(rootPane, 
                         "Stupid");
    }                                       

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        this.dispose();
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditGiaoVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditGiaoVien dialog = new EditGiaoVien(new javax.swing.JPanel());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify  
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtNoiO;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtToChuyenMon;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtMonHoc;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtDiaChi;
    // End of variables declaration                   

    public void setEditData(GiaoVien g) {
        txtMaGV.setText(g.getMaGV());
        txtNoiO.setText(g.getNoiO());
        txtCCCD.setText(g.getCCCD());
        txtSoDienThoai.setText(g.getSoDienThoai());
        txtToChuyenMon.setText(g.getToChuyenMon());
        txtEmail.setText(g.getEmail());
        txtHoTen.setText(g.getHoTen());
        txtNgaySinh.setText(g.getNgaySinh());
        txtNoiSinh.setText(g.getNoiSinh());
        txtMonHoc.setText(g.getMonHoc());
        txtGioiTinh.setText(g.getGioiTinh());
        txtQueQuan.setText(g.getQueQuan());
        txtDiaChi.setText(g.getDiaChi());
    }
}

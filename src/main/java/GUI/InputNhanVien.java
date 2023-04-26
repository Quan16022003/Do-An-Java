/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAL.Nhan_Vien_DAO;
import BLL.Nhan_Vien_BUS;
import DAL.BindingListener;
import DTO.Nhan_Vien;
import GUI.modal.ChooseAvatarPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author apple
 */
public class InputNhanVien extends javax.swing.JDialog{
    private Nhan_Vien_GUI home;
    private Nhan_Vien_DAO DAO;
    private Nhan_Vien_BUS BUS;
    
    public InputNhanVien(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (Nhan_Vien_GUI) parent;
        BUS = new Nhan_Vien_BUS();
        DAO = new Nhan_Vien_DAO();
        
        txtMaNV.getDocument().addDocumentListener(new BindingListener(txtMaNV, "[a-z0-9]*"));
        txtMaDV.getDocument().addDocumentListener(new BindingListener(txtMaDV, "[a-z0-9]*"));
        txtCCCD.getDocument().addDocumentListener(new BindingListener(txtCCCD, "\\d{12}"));
        txtTen.getDocument().addDocumentListener(new BindingListener(txtTen,"[a-z0-9\\s]*"));
        txtNgaySinh.getDocument().addDocumentListener(new BindingListener(txtNgaySinh,"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"));        
        txtGioiTinh.getDocument().addDocumentListener(new BindingListener(txtGioiTinh,"(?i)(nam|nu)"));                   
        txtSoDienThoai.getDocument().addDocumentListener(new BindingListener(txtSoDienThoai,"\\d{10}]*")); 
        txtMaLoaiNV.getDocument().addDocumentListener(new BindingListener(txtMaLoaiNV, "[a-z0-9]*"));
        txtMaChucVu.getDocument().addDocumentListener(new BindingListener(txtMaChucVu, "[a-z0-9]*"));
        txtDuong.getDocument().addDocumentListener(new BindingListener(txtDuong,"[a-z0-9\\s]*"));
        txtPhuong_Xa.getDocument().addDocumentListener(new BindingListener(txtPhuong_Xa,"[a-z0-9\\s]*"));
        txtQuan_Huyen.getDocument().addDocumentListener(new BindingListener(txtQuan_Huyen,"[a-z0-9\\s]*"));
        txtThanhPho_Tinh.getDocument().addDocumentListener(new BindingListener(txtThanhPho_Tinh,"[a-z0-9\\s]*"));
        txtNgayCap.getDocument().addDocumentListener(new BindingListener(txtNgayCap,"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"));        
        txtNoiCap.getDocument().addDocumentListener(new BindingListener(txtNoiCap,"[a-z0-9\\s]*"));
        txtNgayVaoLam.getDocument().addDocumentListener(new BindingListener(txtNgayVaoLam,"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$"));        
        txtSoNha.getDocument().addDocumentListener(new BindingListener(txtSoNha, "^[a-zA-Z0-9\\s\\/]*$"));
    }
    private void initComponents() {
        
        
                String monhoc[] = {"tram cam"," FA", "no life"};
                String gioitinh[] = {"nu", "khong phai nu", "loai khac"};
                        String chuyenmon[] = {"thi lai", " rot mon", "helpless"};
//=======

//>>>>>>> origin/main


 



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
        
        this.setLayout(new BorderLayout(0,0));

        this.setSize(900  , 530);
        JPanel pnmain = new JPanel();
//        pnmain.setBackground(Color.blue);
        pnmain.setPreferredSize(new Dimension(950, 530));
        
        JPanel pn1 = new JPanel();
        //pn1.setBackground(Color.red);
        pn1.setPreferredSize(new Dimension(690, 250));
        
        JPanel pnl1 = new JPanel();
        pnl1.setPreferredSize(new Dimension(690,30));
        
        JLabelMaNV = new javax.swing.JLabel();
        JLabelMaNV.setText("Mã nhân viên:  ");
        txtMaNV = new javax.swing.JTextField();
        txtMaNV.setPreferredSize(new Dimension(220,25));
        JLabelMaDV = new javax.swing.JLabel();
        JLabelMaDV.setText("Mã đơn vị:   ");
        txtMaDV = new javax.swing.JTextField();
        txtMaDV.setPreferredSize(new Dimension(220,25));
        
        pnl1.add(JLabelMaNV);
        pnl1.add(txtMaNV);
        pnl1.add(JLabelMaDV);
        pnl1.add(txtMaDV);
        
        JPanel pnl2 = new JPanel();
        pnl2.setPreferredSize(new Dimension(690,30));
        
        JLabelMaLoaiNV = new javax.swing.JLabel();
        JLabelMaLoaiNV.setText("Loại nhân viên: ");
        txtMaLoaiNV = new javax.swing.JTextField();
        txtMaLoaiNV.setPreferredSize(new Dimension(220,25));
        JLabelMaChucVu = new javax.swing.JLabel();
        JLabelMaChucVu.setText("Mã chức vụ:");
        txtMaChucVu = new javax.swing.JTextField();
        txtMaChucVu.setPreferredSize(new Dimension(220,25));
        
        pnl2.add(JLabelMaLoaiNV);
        pnl2.add(txtMaLoaiNV);
        pnl2.add(JLabelMaChucVu);
        pnl2.add(txtMaChucVu);
        
        
        JPanel pnl3 = new JPanel();
        pnl3.setPreferredSize(new Dimension(690,30));
        
         
        JLabelTen = new javax.swing.JLabel();
        JLabelTen.setText("      Họ và tên:        ");
        txtTen = new javax.swing.JTextField();
        txtTen.setPreferredSize(new Dimension(525,25));
        
        JPanel pnl3gap = new JPanel();
        pnl3gap.setPreferredSize(new Dimension(20,30));
        
        pnl3.add(JLabelTen);
        pnl3.add(txtTen);
        pnl3.add(pnl3gap);
        
        JPanel pnl4 = new JPanel();
        pnl4.setPreferredSize(new Dimension(690,30));
        
        JLabelGioiTinh = new javax.swing.JLabel();
        JLabelGioiTinh.setText("Giới tính:         ");
        txtGioiTinh = new javax.swing.JTextField();
        txtGioiTinh.setPreferredSize(new Dimension(220,25));
        
        JLabelNgaySinh = new javax.swing.JLabel();
        JLabelNgaySinh.setText(" Ngày sinh:  ");
        txtNgaySinh = new javax.swing.JTextField();
        txtNgaySinh.setPreferredSize(new Dimension(220,25));
        
        pnl4.add(JLabelGioiTinh);
        pnl4.add(txtGioiTinh);
        pnl4.add(JLabelNgaySinh);
        pnl4.add(txtNgaySinh);
        
        JPanel pnl5 = new JPanel();
        pnl5.setPreferredSize(new Dimension(690,30));
        
        JPanel pnl5gap = new JPanel();
        pnl5gap.setPreferredSize(new Dimension(300,30));
        
        JLabelSoDienThoai = new javax.swing.JLabel();
        JLabelSoDienThoai.setText("Số điện thoại:   ");
        txtSoDienThoai = new javax.swing.JTextField();
        txtSoDienThoai.setPreferredSize(new Dimension(220,25));
        
        pnl5.add(JLabelSoDienThoai);
        pnl5.add(txtSoDienThoai);
        pnl5.add(pnl5gap);
        
        JPanel pnl6 = new JPanel();
        pnl6.setPreferredSize(new Dimension(690,30));
        
        JPanel pnl6gap = new JPanel();
        pnl6gap.setPreferredSize(new Dimension(300,30));
        
        JLabelNgayVaoLam = new javax.swing.JLabel();
        JLabelNgayVaoLam.setText("Ngày vào làm:  ");
        txtNgayVaoLam = new javax.swing.JTextField();
        txtNgayVaoLam.setPreferredSize(new Dimension(220,25));
        
        pnl6.add(JLabelNgayVaoLam);
        pnl6.add(txtNgayVaoLam);
        pnl6.add(pnl6gap);
        
        
        pn1.add(pnl1);
        pn1.add(pnl2);
        pn1.add(pnl3);
        pn1.add(pnl4);
        pn1.add(pnl5);
        pn1.add(pnl6);
        
  
    
        
        JPanel pn3 = new JPanel();
//        pn3.setBackground(Color.blue);
        pn3.setPreferredSize(new Dimension(200, 200));

        
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(200, 250));
//        pn2.setBackground(Color.CYAN);
        
        imagePanel = new ChooseAvatarPanel();
        imagePanel.setImage("./src/main/java/Image/Books_160px.png");
        pn2.add(imagePanel);
        
        
        
         JPanel pn5 = new JPanel();
//         pn5.setBackground(Color.gray);
        pn5.setPreferredSize(new Dimension(900, 250));
        pn5.add(pn2,BorderLayout.SOUTH);
        pn5.add(pn1,BorderLayout.SOUTH);
        pnmain.add(pn5,BorderLayout.NORTH);
        
        JPanel pn4 = new JPanel();
//        pn4.setBackground(Color.YELLOW);
        pn4.setPreferredSize(new Dimension(900, 230));   
        
        
         ///// under form here   
         
         
         JPanel pnll1 = new JPanel();
        pnll1.setPreferredSize(new Dimension(900,30));
        
        JLabelSoNha = new javax.swing.JLabel();
        JLabelSoNha.setText("Số nhà:            ");
        txtSoNha = new javax.swing.JTextField();
        txtSoNha.setPreferredSize(new Dimension(300,25));
        
        pnll1.add(JLabelSoNha);
        pnll1.add(txtSoNha);
        
        JLabelDuong = new javax.swing.JLabel();
        JLabelDuong.setText("  Đường:                  ");
        txtDuong = new javax.swing.JTextField();
        txtDuong.setPreferredSize(new Dimension(300,25));
        
        pnll1.add(JLabelDuong);
        pnll1.add(txtDuong);
        
        
         JPanel pnll2 = new JPanel();
        pnll2.setPreferredSize(new Dimension(900,30));
        
        JLabelPhuong_Xa = new javax.swing.JLabel();
        JLabelPhuong_Xa.setText("Phường/Xã:      ");
        txtPhuong_Xa = new javax.swing.JTextField();
        txtPhuong_Xa.setPreferredSize(new Dimension(300,25));
        
        pnll2.add(JLabelPhuong_Xa);
        pnll2.add(txtPhuong_Xa);
        
        JLabelQuan_Huyen = new javax.swing.JLabel();
        JLabelQuan_Huyen.setText(" Quận/Huyện:           ");
        txtQuan_Huyen = new javax.swing.JTextField();
        txtQuan_Huyen.setPreferredSize(new Dimension(300,25));
        
        pnll2.add(JLabelQuan_Huyen);
        pnll2.add(txtQuan_Huyen);
        
         JPanel pnll3 = new JPanel();
        pnll3.setPreferredSize(new Dimension(900,30));
        
        JLabelThanhPho_Tinh = new javax.swing.JLabel();
        JLabelThanhPho_Tinh.setText("    Thành phố/Tỉnh:");
        txtThanhPho_Tinh = new javax.swing.JTextField();
        txtThanhPho_Tinh.setPreferredSize(new Dimension(250,25));
        
        pnll3.add(JLabelThanhPho_Tinh);
        pnll3.add(txtThanhPho_Tinh);
        
        JLabelCCCD = new javax.swing.JLabel();
        JLabelCCCD.setText("              Căn cước công dân:");
        txtCCCD = new javax.swing.JTextField();
        txtCCCD.setPreferredSize(new Dimension(250,25));
        
        JPanel pnll3gap = new JPanel();
        pnll3gap.setPreferredSize(new Dimension(60,30));
        
        pnll3.add(JLabelCCCD);
        pnll3.add(txtCCCD);
        pnll3.add(pnll3gap);
        
        
         JPanel pnll4 = new JPanel();
        pnll4.setPreferredSize(new Dimension(900,30));
        
        JLabelNoiCap = new javax.swing.JLabel();
        JLabelNoiCap.setText("Nơi cấp:          ");
        txtNoiCap = new javax.swing.JTextField();
        txtNoiCap.setPreferredSize(new Dimension(600,25));
        
        
         JPanel pnll4gap = new JPanel();
        pnll4gap.setPreferredSize(new Dimension(130,30));
        
        pnll4.add(JLabelNoiCap);
        pnll4.add(txtNoiCap);
        pnll4.add(pnll4gap);
        
        
        JPanel pnll5 = new JPanel();
        pnll5.setPreferredSize(new Dimension(900,30));
        
        JLabelNgayCap = new javax.swing.JLabel();
        JLabelNgayCap.setText("Ngày cấp:       ");
        txtNgayCap = new javax.swing.JTextField();
        txtNgayCap.setPreferredSize(new Dimension(300,25));
        
        JPanel pnll5gap = new JPanel();
        pnll5gap.setPreferredSize(new Dimension(430,30));
        
        pnll5.add(JLabelNgayCap);
        pnll5.add(txtNgayCap);
        pnll5.add(pnll5gap);
        
        JPanel pnll6 = new JPanel();
        pnll6.setPreferredSize(new Dimension(900,30));
        
        btnEdit.setPreferredSize(new Dimension(120,25));
        btnEdit.setText("Lưu");
        pnll6.add(btnEdit);
        
        btnCancel.setPreferredSize(new Dimension(120,25));
        btnCancel.setText("Hủy bỏ");
        pnll6.add(btnCancel);
        
        pn4.add(pnll1);
        pn4.add(pnll2);
        pn4.add(pnll3);
        pn4.add(pnll4);
        pn4.add(pnll5);
        pn4.add(pnll6);
//        pn4.add(pnl6);
        
///under form end
        
        pnmain.add(pn4,BorderLayout.SOUTH);
        
        
        this.add(pnmain);
        this.revalidate();
        this.setVisible(true);
        
        
        
        
        
        
       
        
        
        
        
        
        
        this.add(pnmain);
        this.revalidate();
        this.setVisible(true);

    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        String MaNV = "", MaDV = "", MaLoaiNV = "", MaChucVu = "", Ten = "", GioiTinh = "",
                NgSinh = "", SDT = "",SoNha = "", Duong = "", Phuong_Xa = "",
                Quan_Huyen = "", TP_Tinh = "", CCCD = "", NgCap = "",
                NoiCap = "", NgVaoLam = "" , image = "";
        
        MaNV = txtMaNV.getText();
        MaDV = txtMaDV.getText();
        MaLoaiNV = txtMaLoaiNV.getText();
        MaChucVu = txtMaChucVu.getText();
        Ten = txtTen.getText();
        GioiTinh = txtGioiTinh.getText();
        NgSinh = txtNgaySinh.getText();
        SDT = txtSoDienThoai.getText();
        SoNha = txtSoNha.getText();
        Duong = txtDuong.getText();
        Phuong_Xa = txtPhuong_Xa.getText();
        Quan_Huyen = txtQuan_Huyen.getText();
        TP_Tinh = txtThanhPho_Tinh.getText();
        CCCD = txtCCCD.getText();
        NgCap = txtNgayCap.getText();
        NoiCap = txtNoiCap.getText();
        NgVaoLam = txtNgayVaoLam.getText();
        image = imagePanel.getDirectory();
        
        Nhan_Vien nhanvien = new Nhan_Vien(
                MaNV, MaDV, MaLoaiNV, MaChucVu, Ten, GioiTinh, NgSinh, SDT,
                SoNha, Duong, Phuong_Xa, Quan_Huyen, TP_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image
        );
        if (BUS.check(nhanvien))
            {
                 DAO.add(nhanvien);

                 home.addNhanVienlist(nhanvien);
                 JOptionPane.showMessageDialog(rootPane,
                         "Thêm thành công!");
                
                txtMaNV.setText("");//
                txtMaDV.setText("");//
                txtMaLoaiNV.setText("");
                txtMaChucVu.setText("");//
                txtTen.setText("");
                txtGioiTinh.setText("");
                txtNgaySinh.setText("");
                txtSoDienThoai.setText("");//
                txtSoNha.setText("");
                txtDuong.setText("");
                txtPhuong_Xa.setText("");
                txtQuan_Huyen.setText("");
                txtThanhPho_Tinh.setText("");
                txtCCCD.setText("");
                txtNgayCap.setText("");
                txtNoiCap.setText("");
                txtNgayVaoLam.setText("");
                imagePanel.setImage(null);
                 
            }
            else
                JOptionPane.showMessageDialog(rootPane,
                         "Stupid");
        
    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
    }
     public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditNhanVien dialog = new EditNhanVien(new javax.swing.JPanel());
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
     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private ChooseAvatarPanel imagePanel;
    private javax.swing.JLabel JLabelMaNV;
    private javax.swing.JLabel JLabelMaLoaiNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaLoaiNV;
    private javax.swing.JLabel JLabelMaDV;
    private javax.swing.JLabel JLabelMaChucVu;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JLabel JLabelTen;
    private javax.swing.JTextField txtTen;
    private javax.swing.JLabel JLabelGioiTinh;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JLabel JLabelNgaySinh;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JLabel JLabelSoDienThoai;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JLabel JLabelNgayVaoLam;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JLabel JLabelSoNha;
    private javax.swing.JTextField txtSoNha;
    private javax.swing.JLabel JLabelDuong;
    private javax.swing.JTextField txtDuong;
    private javax.swing.JLabel JLabelPhuong_Xa;
    private javax.swing.JTextField txtPhuong_Xa;
    private javax.swing.JLabel JLabelQuan_Huyen;
    private javax.swing.JTextField txtQuan_Huyen;
    private javax.swing.JLabel JLabelThanhPho_Tinh;
    private javax.swing.JTextField txtThanhPho_Tinh;
    private javax.swing.JLabel JLabelCCCD;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JLabel JLabelNoiCap;
    private javax.swing.JTextField txtNoiCap;
    private javax.swing.JLabel JLabelNgayCap;
    private javax.swing.JTextField txtNgayCap;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLNhanVien;

import DAL.NhanVienDAO;
import BLL.NhanVienBUS;
import DAL.BindingListener;
import DTO.NhanVien;
import GUI.modal.ChooseAvatarPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author apple
 */
public class EditNhanVien extends javax.swing.JDialog{
    private NhanVienGUI home;
    private NhanVienDAO DAO;
    private NhanVienBUS BUS;
    
    public EditNhanVien(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (NhanVienGUI) parent;
        BUS = new NhanVienBUS();
        DAO = new NhanVienDAO();
        
        
//        txtMaNV.getDocument().addDocumentListener(new BindingListener(txtMaNV, "[a-zA-Z0-9]*"));
//        txtMaLoaiNV.getDocument().addDocumentListener(new BindingListener(txtMaLoaiNV, "[a-zA-Z0-9]*"));
        txtMaDV.getDocument().addDocumentListener(new BindingListener(txtMaDV, "[a-zA-Z0-9]*"));
        txtCCCD.getDocument().addDocumentListener(new BindingListener(txtCCCD, "\\d{12}"));
//        txtTen.getDocument().addDocumentListener(new BindingListener(txtTen,"[a-zA-Z0-9\\s]*"));
        txtNgaySinh.getDocument().addDocumentListener(new BindingListener(txtNgaySinh,"^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$"));        
//        txtGioiTinh.getDocument().addDocumentListener(new BindingListener(txtGioiTinh,"(?i)(nam|nu)"));                   
        txtSoDienThoai.getDocument().addDocumentListener(new BindingListener(txtSoDienThoai,"\\d{10}]*")); 
//        txtMaLoaiNV.getDocument().addDocumentListener(new BindingListener(txtMaLoaiNV, "[a-zA-Z0-9]*"));
        txtMaChucVu.getDocument().addDocumentListener(new BindingListener(txtMaChucVu, "[a-zA-Z0-9]*"));
//        txtDuong.getDocument().addDocumentListener(new BindingListener(txtDuong,"[a-zA-Z0-9\\s]*"));
////        txtPhuong_Xa.getDocument().addDocumentListener(new BindingListener(txtPhuong_Xa,"[a-zA-Z0-9\\s]*"));
//        txtQuan_Huyen.getDocument().addDocumentListener(new BindingListener(txtQuan_Huyen,"[a-zA-Z0-9\\s]*"));
//        txtThanhPho_Tinh.getDocument().addDocumentListener(new BindingListener(txtThanhPho_Tinh,"[a-zA-Z0-9\\s]*"));
        txtNgayCap.getDocument().addDocumentListener(new BindingListener(txtNgayCap,"^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$"));        
//        txtNoiCap.getDocument().addDocumentListener(new BindingListener(txtNoiCap,"[a-zA-Z0-9\\s]*"));
        txtNgayVaoLam.getDocument().addDocumentListener(new BindingListener(txtNgayVaoLam,"^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$"));        
//        txtSoNha.getDocument().addDocumentListener(new BindingListener(txtSoNha, "^[a-zA-Z0-9\\s\\/]*$"));
    }
    private void initComponents() {
        String gioitinh[] = {"Nam", "Nữ", "Khác"};
       setSize(new Dimension(900, 530));
       setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;
//        setBackground(Color.yellow);
        gbc.gridy = 0;
        imagePanel = new ChooseAvatarPanel();
        imagePanel.setPreferredSize(new Dimension(100, 150));
        gbc.gridx = 0;
        gbc.gridheight= 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(imagePanel, gbc);
        gbc.gridheight= 1;
        
        var a =100;
        gbc.gridy = 0;
        JLabelMaNV = new JLabel("Mã nhân viên:");
        JLabelMaNV.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 1;
        add(JLabelMaNV, gbc);
        
        gbc.gridy = 1;
        JLabelMaDV = new JLabel("Mã đơn vị:");
        JLabelMaDV.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 1;
        add(JLabelMaDV, gbc);
        
//        gbc.gridy = 2;
//        JLabelMaLoaiNV = new JLabel("Loại nhân viên:");
//        JLabelMaLoaiNV.setPreferredSize(new Dimension(a, 25));
//        gbc.gridx = 1;
//        add(JLabelMaLoaiNV, gbc);
        
        gbc.gridy = 2;
        JLabelMaChucVu = new JLabel("Mã chức vụ:");
        JLabelMaChucVu.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 1;
        add(JLabelMaChucVu, gbc);
        
        gbc.gridy = 3;
        JLabelTen = new JLabel("Họ và tên:");
        JLabelTen.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 1;
        add(JLabelTen, gbc);
        
        txtMaNV = new JTextField();
        txtMaNV.setPreferredSize(new Dimension(150, 25));
        txtMaNV.setBackground(Color.yellow);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth= 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth= 1;
        add(txtMaNV, gbc);
        
        txtMaDV = new JTextField();
        txtMaDV.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(txtMaDV, gbc);
//        txtMaLoaiNV = new JTextField();
//        txtMaLoaiNV.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 2;
//        gbc.gridy = 2;
//        add(txtMaLoaiNV, gbc);
        txtMaChucVu = new JTextField();
        txtMaChucVu.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(txtMaChucVu, gbc);
        
        txtTen = new JTextField();
        txtTen.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(txtTen, gbc);
        
        
        gbc.gridy = 0;
        JLabelGioiTinh = new JLabel("Giới tính:");
        JLabelGioiTinh.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 3;
        add(JLabelGioiTinh, gbc);
        
        txtGioiTinh = new javax.swing.JComboBox(gioitinh);
        txtGioiTinh.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtGioiTinh.setBackground(new Color(195, 232, 141));
        add(txtGioiTinh, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridy = 1;
        JLabelNgaySinh = new JLabel("Ngày sinh:");
        JLabelNgaySinh.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 3;
        add(JLabelNgaySinh, gbc);
        txtNgaySinh = new JTextField();
        txtNgaySinh.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 4;
        add(txtNgaySinh, gbc);
        
        gbc.gridy = 2;
        JLabelSoDienThoai = new JLabel("Số điện thoại:");
        JLabelSoDienThoai.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 3;
        add(JLabelSoDienThoai, gbc);
        txtSoDienThoai = new JTextField();
        txtSoDienThoai.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 4;
        add(txtSoDienThoai, gbc);
        
        gbc.gridy = 3;
        JLabelNgayVaoLam = new JLabel("Ngày vào làm:");
        JLabelNgayVaoLam.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 3;
        add(JLabelNgayVaoLam, gbc);
        txtNgayVaoLam = new JTextField();
        txtNgayVaoLam.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 4;
        add(txtNgayVaoLam, gbc);
        
        
        gbc.gridy = 5;
        JLabelSoNha = new JLabel("Số nhà:");
        JLabelSoNha.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 0;
        add(JLabelSoNha, gbc);
        txtSoNha = new JTextField();
        txtSoNha.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtSoNha, gbc);
        ////
         gbc.gridy = 5;
        JLabelDuong = new JLabel("Đường:");
        JLabelDuong.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 2;
        add(JLabelDuong, gbc);
        txtDuong = new JTextField();
        txtDuong.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtDuong, gbc);
        
        gbc.gridy = 6;
        JLabelPhuong_Xa = new JLabel("Phường/Xã:");
        JLabelPhuong_Xa.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 0;
        add(JLabelPhuong_Xa, gbc);
        txtPhuong_Xa = new JTextField();
        txtPhuong_Xa.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtPhuong_Xa, gbc);
        
        gbc.gridy = 6;
        JLabelQuan_Huyen = new JLabel("Quận/Huyện:");
        JLabelQuan_Huyen.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 2;
        add(JLabelQuan_Huyen, gbc);
        txtQuan_Huyen = new JTextField();
        txtQuan_Huyen.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtQuan_Huyen, gbc);
        
        gbc.gridy = 7;
        JLabelThanhPho_Tinh = new JLabel("Thành phố/Tỉnh:");
        JLabelThanhPho_Tinh.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 0;
        add(JLabelThanhPho_Tinh, gbc);
        txtThanhPho_Tinh = new JTextField();
        txtThanhPho_Tinh.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtThanhPho_Tinh, gbc);
        
        gbc.gridy = 7;
        JLabelCCCD = new JLabel("Căn cước công dân:");
        JLabelCCCD.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 2;
        add(JLabelCCCD, gbc);
        txtCCCD = new JTextField();
        txtCCCD.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtCCCD, gbc);
        
        gbc.gridy = 8;
        JLabelNoiCap = new JLabel("Nơi cấp:");
        JLabelNoiCap.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 0;
        add(JLabelNoiCap, gbc);
        txtNoiCap = new JTextField();
        txtNoiCap.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNoiCap, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridy = 9;
        JLabelNgayCap = new JLabel("Ngày cấp:");
        JLabelNgayCap.setPreferredSize(new Dimension(a, 25));
        gbc.gridx = 0;
        add(JLabelNgayCap, gbc);
        txtNgayCap = new JTextField();
        txtNgayCap.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtNgayCap, gbc);
        

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
        


        
        btnEdit.setPreferredSize(new Dimension(120,25));
        btnEdit.setText("Lưu");

        
        btnCancel.setPreferredSize(new Dimension(120,25));
        btnCancel.setText("Hủy bỏ");

        gbc.gridx= 2;
        gbc.gridy= 10;
        add(btnEdit,gbc);
        gbc.gridx= 3;
        add(btnCancel,gbc);
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        String MaNV, MaDV, MaLoaiNV ="", MaChucVu, Ten, GioiTinh,
                NgSinh="", SDT="",SoNha="", Duong="", Phuong_Xa="",
                Quan_Huyen="", TP_Tinh="", CCCD="", NgCap="",
                NoiCap="", NgVaoLam="", image="";
        MaNV = txtMaNV.getText();
        MaDV = txtMaDV.getText();
//        MaLoaiNV = txtMaLoaiNV.getText();
        MaChucVu = txtMaChucVu.getText();
        Ten = txtTen.getText();
        GioiTinh = txtGioiTinh.getSelectedItem().toString();
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
        
        NhanVien nhanvien = new NhanVien(MaNV, MaDV, MaChucVu, Ten, GioiTinh, NgSinh, SDT,
            SoNha, Duong, Phuong_Xa, Quan_Huyen, TP_Tinh, CCCD, NgCap, NoiCap, NgVaoLam, image
        );
        if (BUS.check(nhanvien))
            {
                 if (DAO.update(nhanvien) == false)
                    {
                 JOptionPane.showMessageDialog(rootPane,
                         "Vui lòng kiểm tra lại hình ảnh, mã đơn vị hoặc mã chức vụ");  
                    }
                 else
                 {
        
                 home.updateNhanVienlist(nhanvien);
                 JOptionPane.showMessageDialog(rootPane,
                         "Thêm thành công!");  
                 this.dispose();
                 }
            }

            
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
//    private javax.swing.JLabel JLabelMaLoaiNV;
    private javax.swing.JTextField txtMaNV;
//    private javax.swing.JTextField txtMaLoaiNV;
    private javax.swing.JLabel JLabelMaDV;
    private javax.swing.JLabel JLabelMaChucVu;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtMaChucVu;
    private javax.swing.JLabel JLabelTen;
    private javax.swing.JTextField txtTen;
    private javax.swing.JLabel JLabelGioiTinh;
    private javax.swing.JComboBox txtGioiTinh;
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
     
     public void setEditData(NhanVien nv) {
         //pull out data here
         //image
        imagePanel.setImage(nv.getImage());
        txtMaNV.setText(nv.getMaNV());
        txtMaNV.setEditable(false);
        txtMaDV.setText(nv.getMaDV());
//        txtMaLoaiNV.setText(nv.getMaLoaiNV());
        txtMaChucVu.setText(nv.getMaChucVu());
        txtTen.setText(nv.getTen());
        if ("nu".equals(nv.getGioiTinh()))
            txtGioiTinh.setSelectedIndex(0);
        if ("khong phai nu".equals(nv.getGioiTinh()))
            txtGioiTinh.setSelectedIndex(1);
        else 
            txtGioiTinh.setSelectedIndex(2);
        txtNgaySinh.setText(nv.getNgSinh());
        txtSoDienThoai.setText(nv.getSDT());
        txtSoNha.setText(nv.getSoNha());
        txtDuong.setText(nv.getDuong());
        txtPhuong_Xa.setText(nv.getPhuong_Xa());
        txtQuan_Huyen.setText(nv.getQuan_Huyen());
        txtThanhPho_Tinh.setText(nv.getTP_Tinh());
        txtCCCD.setText(nv.getCCCD());
        txtNgayCap.setText(nv.getNgCap());
        txtNoiCap.setText(nv.getNoiCap());
        txtNgayVaoLam.setText(nv.getNgVaoLam());
    
     }
}

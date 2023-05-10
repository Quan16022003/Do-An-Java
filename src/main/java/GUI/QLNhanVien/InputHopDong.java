/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLNhanVien;

import DAL.HopDongDAO;
import BLL.HopDongBUS;
import DAL.BindingListener;
import DTO.HopDong;
import GUI.modal.ChooseAvatarPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author apple
 */
public class InputHopDong extends javax.swing.JDialog {
    private final HopDongGUI home;
    private final HopDongDAO DAO;
    private final HopDongBUS BUS;
   
    
    public InputHopDong(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (HopDongGUI) parent;
        BUS = new HopDongBUS();
        DAO = new HopDongDAO();
            txtMaNV.getDocument().addDocumentListener(new BindingListener(txtMaNV, "[a-zA-Z0-9]*"));
//        txtMaHD.getDocument().addDocumentListener(new BindingListener(txtMaHD, "[a-z0-9]*"));
//        txtSTK.getDocument().addDocumentListener(new BindingListener(txtSTK, "\\d{12}"));
//        txtHocVi.getDocument().addDocumentListener(new BindingListener(txtHocVi,"[a-z0-9\\s]*"));
//        txtMaSoThue.getDocument().addDocumentListener(new BindingListener(txtMaSoThue, "[a-z0-9]*"));
//        txtNganHang.getDocument().addDocumentListener(new BindingListener(txtNganHang,"[a-z0-9\\s]*"));
//        txtCongViecDuocGiao.getDocument().addDocumentListener(new BindingListener(txtCongViecDuocGiao,"[a-zA-Z0-9\\s]*"));
//        txtCucThue.getDocument().addDocumentListener(new BindingListener(txtCucThue,"[a-z0-9\\s]*"));
        txtNgayKy.getDocument().addDocumentListener(new BindingListener(txtNgayKy,"^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$"));        
        txtHanHD.getDocument().addDocumentListener(new BindingListener(txtHanHD,"^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$"));        
//        txtHang.getDocument().addDocumentListener(new BindingListener(txtHang,"[a-z0-9\\s]*"));
//        txtBac.getDocument().addDocumentListener(new BindingListener(txtBac,"[a-z0-9\\s]*"));
//        txtHeSoLuong.getDocument().addDocumentListener(new BindingListener(txtHeSoLuong,"[+-]?([0-9]*[.])?[0-9]+"));
//        txtHeSoPhuCap.getDocument().addDocumentListener(new BindingListener(txtHeSoPhuCap,"[+-]?([0-9]*[.])?[0-9]+"));

    }
    private void initComponents() {
        
//>>>>>>> origin/main
            
//>>>>>>> origin/main
         setSize(new Dimension(600, 500));


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;

        gbc.gridy = 0;
        JLabelMaHD = new JLabel("Mã hợp đồng:");
        JLabelMaHD.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelMaHD, gbc);
        txtMaHD = new JTextField();
        txtMaHD.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
//        txtMaHD.setBackground(Color.yellow);
        add(txtMaHD, gbc);
        
        gbc.gridy = 1;
        JLabelMaNV = new JLabel("Mã nhân viên:");
        JLabelMaNV.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelMaNV, gbc);
        txtMaNV = new JTextField();
        txtMaNV.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtMaNV, gbc);
        
        gbc.gridy = 2;
        JLabelNgayKy = new JLabel("Ngày ký:");
        JLabelNgayKy.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelNgayKy, gbc);
        txtNgayKy = new JTextField();
        txtNgayKy.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtNgayKy, gbc);
        
        gbc.gridy = 3;
        JLabelHanHD = new JLabel("Hạn hợp đồng:");
        JLabelHanHD.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelHanHD, gbc);
        txtHanHD = new JTextField();
        txtHanHD.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtHanHD, gbc);
        
//        gbc.gridy = 4;
//        JLabelHocVi = new JLabel("Học vị:");
//        JLabelHocVi.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 0;
//        add(JLabelHocVi, gbc);
//        txtHocVi = new JTextField();
//        txtHocVi.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 1;
//        add(txtHocVi, gbc);
        
//         gbc.gridy = 5;
//        JLabelHang = new JLabel("Xếp hạng:");
//        JLabelHang.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 0;
//        add(JLabelHang, gbc);
//        txtHang = new JTextField();
//        txtHang.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 1;
//        add(txtHang, gbc);
        
//        gbc.gridy = 5;
//        JLabelBac = new JLabel("Cấp bậc:");
//        JLabelBac.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
//        add(JLabelBac, gbc);
//        txtBac = new JTextField();
//        txtBac.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
//        add(txtBac, gbc);

//        gbc.gridy = 0;
//        JLabelMaSoThue = new JLabel("Mã số thuế:");
//        JLabelMaSoThue.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
//        add(JLabelMaSoThue, gbc);
//        txtMaSoThue = new JTextField();
//        txtMaSoThue.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
//        add(txtMaSoThue, gbc);
        
//        gbc.gridy = 1;
//        JLabelSTK = new JLabel("Số tài khoản:");
//        JLabelSTK.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
//        add(JLabelSTK, gbc);
//        txtSTK = new JTextField();
//        txtSTK.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
//        add(txtSTK, gbc);
        
//        gbc.gridy = 2;
            gbc.gridy = 4;
        CongViecDuocGiao = new JLabel("Tên hợp đồng:");
        CongViecDuocGiao.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
        gbc.gridx = 0;
        add(CongViecDuocGiao, gbc);
        txtCongViecDuocGiao = new JTextField();
        txtCongViecDuocGiao.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
        gbc.gridx = 1;
        add(txtCongViecDuocGiao, gbc);
        
//        gbc.gridy = 3;
//        JLabelCucThue = new JLabel("Thuộc cục thuế:");
//        JLabelCucThue.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
//        add(JLabelCucThue, gbc);
//        txtCucThue = new JTextField();
//        txtCucThue.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
//        add(txtCucThue, gbc);
   
        
//        gbc.gridy = 4;
//        JLabelNganHang = new JLabel("Thuộc ngân hàng:");
//        JLabelNganHang.setPreferredSize(new Dimension(200, 25));
//        gbc.gridx = 2;
//        add(JLabelNganHang, gbc);
//        txtNganHang = new JTextField();
//        txtNganHang.setPreferredSize(new Dimension(150, 25));
//        gbc.gridx = 3;
//        add(txtNganHang, gbc);
        
        
        gbc.gridy = 5;
        HeSoLuong = new JLabel("Hệ số lương:");
        HeSoLuong.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(HeSoLuong, gbc);
        txtHeSoLuong = new JTextField();
        txtHeSoLuong.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtHeSoLuong, gbc);
   
        
        gbc.gridy = 6;
        HeSoPhuCap = new JLabel("Hệ số phụ cấp:");
        HeSoPhuCap.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(HeSoPhuCap, gbc);
        txtHeSoPhuCap = new JTextField();
        txtHeSoPhuCap.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtHeSoPhuCap, gbc);

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

        gbc.gridx= 0;
        gbc.gridy= 7;
        add(btnEdit,gbc);
        gbc.gridx= 1;
        gbc.gridy= 7;
        add(btnCancel,gbc);

    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        String MaHD="", MaLoaiHD="", MaNV="", TenHD="", NgayKy="", HanHD="", HocVi="", Hang="", Bac="", MaSoThue=""
            , CucThue="", STK="", NganHang="", CongViecDuocGiao="",HeSoLuong="",HeSoPhuCap="";
        
        MaHD = txtMaHD.getText();
//        MaLoaiHD = txtMaLoaiHD.getText();
        MaNV = txtMaNV.getText();
        NgayKy = txtNgayKy.getText();
        HanHD = txtHanHD.getText();
        HocVi = txtHocVi.getText();
        Hang = txtHang.getText();
        Bac = txtBac.getText();
        MaSoThue = txtMaSoThue.getText();
        CucThue = txtCucThue.getText();
        STK = txtSTK.getText();
        NganHang = txtNganHang.getText();
        CongViecDuocGiao = txtCongViecDuocGiao.getText();
        HeSoLuong = txtHeSoLuong.getText();
        HeSoPhuCap = txtHeSoPhuCap.getText();
        HopDong hd = new HopDong(MaHD, MaNV, CongViecDuocGiao, NgayKy, HanHD, HeSoLuong, HeSoPhuCap);
        if (BUS.check(hd))
            {
                 if (DAO.insert(hd) == false)
                    {
                 JOptionPane.showMessageDialog(rootPane,
                         "Mã nhân viên không tồn tại");  
                    }
                 else {
                 
                 home.addNhanVienlist(hd);
                 JOptionPane.showMessageDialog(rootPane,
                         "Thêm thành công!");
                
                txtMaHD.setText("");//
//                txtMaLoaiHD.setText("");//
                txtMaNV.setText("");
                txtNgayKy.setText("");//
                txtHanHD.setText("");
                txtHocVi.setText("");
                txtHang.setText("");
                txtBac.setText("");//
                txtMaSoThue.setText("");
                txtCucThue.setText("");
                txtSTK.setText("");
                txtNganHang.setText("");
                txtCongViecDuocGiao.setText("");
                txtHeSoLuong.setText("");
                txtHeSoPhuCap.setText("");
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
                InputHopDong dialog = new InputHopDong(new javax.swing.JPanel());
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
    private javax.swing.JLabel JLabelMaHD;
    private javax.swing.JLabel JLabelMaLoaiHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaLoaiHD;
    private javax.swing.JLabel JLabelMaNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JLabel JLabelNgayKy;
    private javax.swing.JTextField txtNgayKy;
    private javax.swing.JLabel JLabelHanHD;
    private javax.swing.JTextField txtHanHD;
    private javax.swing.JLabel JLabelHocVi;
    private javax.swing.JTextField txtHocVi;
    private javax.swing.JLabel JLabelHang;
    private javax.swing.JTextField txtHang;
    private javax.swing.JLabel JLabelBac;
    private javax.swing.JTextField txtBac;
    private javax.swing.JLabel JLabelMaSoThue;
    private javax.swing.JTextField txtMaSoThue;
    private javax.swing.JLabel JLabelCucThue;
    private javax.swing.JTextField txtCucThue;
    private javax.swing.JLabel JLabelSTK;
    private javax.swing.JTextField txtSTK;
    private javax.swing.JLabel JLabelNganHang;
    private javax.swing.JTextField txtNganHang;
    private javax.swing.JLabel CongViecDuocGiao;
    private javax.swing.JTextField txtCongViecDuocGiao;
    private javax.swing.JLabel HeSoLuong;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JLabel HeSoPhuCap;
    private javax.swing.JTextField txtHeSoPhuCap;
}

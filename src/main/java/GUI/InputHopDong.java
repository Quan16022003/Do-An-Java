/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAL.HopDongDAO;
import BLL.HopDongBUS;
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
    private final String[] labelNames = { "Mã hợp đồng", "Mã nhân viên", "Ngày ký", "Hạn hợp đồng", "Học vị", "Hạng",
                                        "Bậc", "Hệ số lương", "Số tài khoản", "Thuộc ngân hàng", "Mã số thuế", "Thuộc cục thuế"};
    
    public InputHopDong(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (HopDongGUI) parent;
        BUS = new HopDongBUS();
        DAO = new HopDongDAO();
    }
    private void initComponents() {
        
//>>>>>>> origin/main
        setSize(new Dimension(800, 400));


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
        
        gbc.gridy = 4;
        JLabelHocVi = new JLabel("Học vị:");
        JLabelHocVi.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelHocVi, gbc);
        txtHocVi = new JTextField();
        txtHocVi.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtHocVi, gbc);
        
         gbc.gridy = 5;
        JLabelHang = new JLabel("Xếp hạng:");
        JLabelHang.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 0;
        add(JLabelHang, gbc);
        txtHang = new JTextField();
        txtHang.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(txtHang, gbc);
        
        gbc.gridy = 5;
        JLabelBac = new JLabel("Cấp bậc:");
        JLabelBac.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelBac, gbc);
        txtBac = new JTextField();
        txtBac.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtBac, gbc);

        gbc.gridy = 0;
        JLabelMaSoThue = new JLabel("Mã số thuế:");
        JLabelMaSoThue.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelMaSoThue, gbc);
        txtMaSoThue = new JTextField();
        txtMaSoThue.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtMaSoThue, gbc);
        
        gbc.gridy = 1;
        JLabelSTK = new JLabel("Số tài khoản:");
        JLabelSTK.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelSTK, gbc);
        txtSTK = new JTextField();
        txtSTK.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtSTK, gbc);
        
        gbc.gridy = 2;
        JLabelSoTietGiangDay = new JLabel("Số tiết giảng dạy:");
        JLabelSoTietGiangDay.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelSoTietGiangDay, gbc);
        txtSoTietGiangDay = new JTextField();
        txtSoTietGiangDay.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtSoTietGiangDay, gbc);
        
        gbc.gridy = 3;
        JLabelCucThue = new JLabel("Thuộc cục thuế:");
        JLabelCucThue.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelCucThue, gbc);
        txtCucThue = new JTextField();
        txtCucThue.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtCucThue, gbc);
   
        
        gbc.gridy = 4;
        JLabelNganHang = new JLabel("Thuộc ngân hàng:");
        JLabelNganHang.setPreferredSize(new Dimension(200, 25));
        gbc.gridx = 2;
        add(JLabelNganHang, gbc);
        txtNganHang = new JTextField();
        txtNganHang.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 3;
        add(txtNganHang, gbc);
        

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

        gbc.gridx= 1;
        gbc.gridy= 6;
        add(btnEdit,gbc);
        gbc.gridx= 2;
        gbc.gridy= 6;
        add(btnCancel,gbc);

    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        String MaHD="", MaLoaiHD="", MaNV="", TenHD="", NgayKy="", HanHD="", HocVi="", Hang="", Bac="", MaSoThue=""
            , CucThue="", STK="", NganHang="", SoTietGiangDay="";
        
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
        SoTietGiangDay = txtSoTietGiangDay.getText();
        HopDong hd = new HopDong(
                MaHD, MaLoaiHD, MaNV, TenHD, NgayKy, HanHD, HocVi, Hang, Bac, MaSoThue
            , CucThue, STK, NganHang, SoTietGiangDay
        );
        if (BUS.check(hd))
            {
                 DAO.insert(hd);

                 home.addNhanVienlist(hd);
                 JOptionPane.showMessageDialog(rootPane,
                         "Thêm thành công!");
                
                txtMaHD.setText("");//
                txtMaLoaiHD.setText("");//
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
                txtSoTietGiangDay.setText("");
            
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
    private javax.swing.JLabel JLabelSoTietGiangDay;
    private javax.swing.JTextField txtSoTietGiangDay;
}

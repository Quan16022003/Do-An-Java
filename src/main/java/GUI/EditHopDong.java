/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.HopDong;
import DAL.NhanVienDAO;
import BLL.NhanVienBUS;
import GUI.modal.ChooseAvatarPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author apple
 */
public class EditHopDong extends javax.swing.JDialog {
    private Nhan_Vien_GUI home;
    private NhanVienDAO DAO;
    private NhanVienBUS BUS;
    
    public EditHopDong(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (Nhan_Vien_GUI) parent;
        BUS = new NhanVienBUS();
        DAO = new NhanVienDAO();
    }
    private void initComponents() {
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
        
    }
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.dispose();
    }
     public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditHopDong dialog = new EditHopDong(new javax.swing.JPanel());
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
    public void setEditData(HopDong hd) {
         //pull out data here
         //image
        txtMaNV.setText(hd.getMaNV());
        txtMaHD.setText(hd.getMaHD());
        txtMaHD.setEditable(false);
        txtMaLoaiHD.setText(hd.getMaLoaiHD());
        txtNgayKy.setText(hd.getNgayKy());
        txtHanHD.setText(hd.getHanHD());
        txtHocVi.setText(hd.getHocVi());
        txtHang.setText(hd.getHang());
        txtBac.setText(hd.getBac());
        txtMaSoThue.setText(hd.getMaSoThue());
        txtCucThue.setText(hd.getCucThue());
        txtSTK.setText(hd.getSTK());
        txtNganHang.setText(hd.getNganHang());
        txtSoTietGiangDay.setText(hd.getSoTietGiangDay());
    
     }
}

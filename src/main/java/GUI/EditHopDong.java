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
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        //form go here
        
        
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

        this.setSize(650  , 250);
        JPanel pnmain = new JPanel();
//        pnmain.setBackground(Color.blue);
        pnmain.setPreferredSize(new Dimension(650, 250));
        JLabelMaHD = new javax.swing.JLabel();
        JLabelMaHD.setText("Mã hợp đồng:  ");
        txtMaHD = new javax.swing.JTextField();
        txtMaHD.setPreferredSize(new Dimension(150,25));
        JLabelMaNV = new javax.swing.JLabel();
        JLabelMaNV.setText(" Mã nhân viên:      ");
        txtMaNV = new javax.swing.JTextField();
        txtMaNV.setPreferredSize(new Dimension(150,25));
        JLabelNgayKy = new javax.swing.JLabel();
        JLabelNgayKy.setText(" Ngày ký:         ");
        txtNgayKy = new javax.swing.JTextField();
        txtNgayKy.setPreferredSize(new Dimension(150,25));
        JLabelHanHD = new javax.swing.JLabel();
        JLabelHanHD.setText(" Hạn hợp đồng:    ");
        txtHanHD = new javax.swing.JTextField();
        txtHanHD.setPreferredSize(new Dimension(150,25));  
        JLabelHocVi = new javax.swing.JLabel();
        JLabelHocVi.setText(" Học vị:            ");
        txtHocVi = new javax.swing.JTextField();
        txtHocVi.setPreferredSize(new Dimension(150,25));   
        JLabelHang = new javax.swing.JLabel();
        JLabelHang.setText(" Xếp hạng:            ");
        txtHang = new javax.swing.JTextField();
        txtHang.setPreferredSize(new Dimension(150,25));
        JLabelBac = new javax.swing.JLabel();
        JLabelBac.setText(" Cấp bậc:          ");
        txtBac = new javax.swing.JTextField();
        txtBac.setPreferredSize(new Dimension(150,25));
        JLabelMaSoThue = new javax.swing.JLabel();
        JLabelMaSoThue.setText(" Mã số thuê:         ");
        txtMaSoThue = new javax.swing.JTextField();
        txtMaSoThue.setPreferredSize(new Dimension(150,25));
        JLabelSTK = new javax.swing.JLabel();
        JLabelSTK.setText("Số tài khoản:    ");
        txtSTK = new javax.swing.JTextField();
        txtSTK.setPreferredSize(new Dimension(150,25));
        JLabelSoTietGiangDay = new javax.swing.JLabel();
        JLabelSoTietGiangDay.setText("Số tiết giảng dạy: ");
        txtSoTietGiangDay = new javax.swing.JTextField();
        txtSoTietGiangDay.setPreferredSize(new Dimension(150,25));
        JLabelCucThue = new javax.swing.JLabel();
        JLabelCucThue.setText("Thuộc cục thuế:");
        txtCucThue = new javax.swing.JTextField();
        txtCucThue.setPreferredSize(new Dimension(150,25));
        JLabelNganHang = new javax.swing.JLabel();
        JLabelNganHang.setText("Thuộc ngân hàng:");
        txtNganHang = new javax.swing.JTextField();
        txtNganHang.setPreferredSize(new Dimension(150,25));
        var a = 150;
        JPanel pngap1 = new JPanel();
        pngap1.setPreferredSize(new Dimension(a,30));
//        pngap1.setBackground(Color.red);
        JPanel pngap2 = new JPanel();
        pngap2.setPreferredSize(new Dimension(a,30));
//        pngap2.setBackground(Color.red);
        JPanel pngap3 = new JPanel();
        pngap3.setPreferredSize(new Dimension(a,30));
//        pngap3.setBackground(Color.red);
        JPanel pngap4 = new JPanel();
        pngap4.setPreferredSize(new Dimension(a,30));
//        pngap4.setBackground(Color.red);
        JPanel pngap5 = new JPanel();
        pngap5.setPreferredSize(new Dimension(a,30));
//        pngap5.setBackground(Color.red);
        JPanel pngap6 = new JPanel();
        pngap6.setPreferredSize(new Dimension(a+2,30));
//        pngap6.setBackground(Color.red);
        JPanel pn1 = new JPanel();
        pn1.setPreferredSize(new Dimension(750,30));
        pn1.add(JLabelMaHD);
        pn1.add(txtMaHD);
        pn1.add(JLabelMaNV);
        pn1.add(txtMaNV);
//        pn1.add(pngap1);
        pnmain.add(pn1);
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(750,30));
        pn2.add(JLabelNgayKy);
        pn2.add(txtNgayKy);
        pn2.add(JLabelHanHD);
        pn2.add(txtHanHD);
//        pn2.add(pngap2);
        pnmain.add(pn2);
        JPanel pn3 = new JPanel();
        pn3.setPreferredSize(new Dimension(750,30));
        pn3.add(JLabelHocVi);
        pn3.add(txtHocVi);
        pn3.add(JLabelHang);
        pn3.add(txtHang);
//        pn3.add(pngap3);
        pnmain.add(pn3);
        JPanel pn4 = new JPanel();
        pn4.setPreferredSize(new Dimension(750,30));
        pn4.add(JLabelBac);
        pn4.add(txtBac);
        pn4.add(JLabelMaSoThue);
        pn4.add(txtMaSoThue);
//        pn4.add(pngap4);
        pnmain.add(pn4);
        JPanel pn5 = new JPanel();
        pn5.setPreferredSize(new Dimension(750,30));
        pn5.add(JLabelSTK);
        pn5.add(txtSTK);
        pn5.add(JLabelSoTietGiangDay);
        pn5.add(txtSoTietGiangDay);
//        pn5.add(pngap5);
        pnmain.add(pn5);
        JPanel pn6 = new JPanel();
        pn6.setPreferredSize(new Dimension(750,30));
        pn6.add(JLabelCucThue);
        pn6.add(txtCucThue);
        pn6.add(JLabelNganHang);
        pn6.add(txtNganHang);
//        pn6.add(pngap6);
        pnmain.add(pn6);
        JPanel pnll6 = new JPanel();
        pnll6.setPreferredSize(new Dimension(900,30));
        
        btnEdit.setPreferredSize(new Dimension(120,25));
        btnEdit.setText("Lưu");
        pnll6.add(btnEdit);
        
        btnCancel.setPreferredSize(new Dimension(120,25));
        btnCancel.setText("Hủy bỏ");
        pnll6.add(btnCancel);
        
        pnmain.add(pnll6);
        this.add(pnmain);
        this.revalidate();
        this.setVisible(true);
        this.add(pnmain);
        this.revalidate();
        this.setVisible(true);

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

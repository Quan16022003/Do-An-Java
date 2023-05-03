/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAL.Nhan_Vien_DAO;
import BLL.Nhan_Vien_BUS;
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
public class InputHopDong extends javax.swing.JDialog {
    private Nhan_Vien_GUI home;
    private Nhan_Vien_DAO DAO;
    private Nhan_Vien_BUS BUS;
    
    public InputHopDong(javax.swing.JPanel parent) {
//        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        home = (Nhan_Vien_GUI) parent;
        BUS = new Nhan_Vien_BUS();
        DAO = new Nhan_Vien_DAO();
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

        this.setSize(900  , 450);
        JPanel pnmain = new JPanel();
        pnmain.setBackground(Color.blue);
        pnmain.setPreferredSize(new Dimension(950, 450));
        
        JPanel pn1 = new JPanel();
        //pn1.setBackground(Color.red);
        pn1.setPreferredSize(new Dimension(690, 250));
        
        JPanel pnl1 = new JPanel();
        pnl1.setPreferredSize(new Dimension(690,30));
        
        JLabelMaHD = new javax.swing.JLabel();
        JLabelMaHD.setText("Mã nhân viên:");
        txtMaHD = new javax.swing.JTextField();
        txtMaHD.setPreferredSize(new Dimension(150,25));
        JLabelMaNV = new javax.swing.JLabel();
        JLabelMaNV.setText("Mã đơn vị:");
        txtMaNV = new javax.swing.JTextField();
        txtMaNV.setPreferredSize(new Dimension(150,25));
        
        pnl1.add(JLabelMaHD);
        pnl1.add(txtMaHD);
        pnl1.add(JLabelMaNV);
        pnl1.add(txtMaNV);
        
        JPanel pnl2 = new JPanel();
        pnl2.setPreferredSize(new Dimension(690,30));
        
        JLabelMaLoaiHD = new javax.swing.JLabel();
        JLabelMaLoaiHD.setText("Loại nhân viên:");
        txtMaLoaiHD = new javax.swing.JTextField();
        txtMaLoaiHD.setPreferredSize(new Dimension(150,25));
        JLabelNgayKyHD = new javax.swing.JLabel();
        JLabelNgayKyHD.setText("Mã chức vụ:");
        txtNgayKyHD = new javax.swing.JTextField();
        txtNgayKyHD.setPreferredSize(new Dimension(150,25));
        
        pnl2.add(JLabelMaLoaiHD);
        pnl2.add(txtMaLoaiHD);
        pnl2.add(JLabelNgayKyHD);
        pnl2.add(txtNgayKyHD);
        
        
        JPanel pnl3 = new JPanel();
        pnl3.setPreferredSize(new Dimension(690,30));
        
         
        JLabelNgayKy = new javax.swing.JLabel();
        JLabelNgayKy.setText("Tên:");
        txtNgayKy = new javax.swing.JTextField();
        txtNgayKy.setPreferredSize(new Dimension(300,25));
        
        pnl3.add(JLabelNgayKy);
        pnl3.add(txtNgayKy);
        
        JPanel pnl4 = new JPanel();
        pnl4.setPreferredSize(new Dimension(690,30));
        
        JLabelHanHD = new javax.swing.JLabel();
        JLabelHanHD.setText("Giới tính:");
        txtHanHD = new javax.swing.JTextField();
        txtHanHD.setPreferredSize(new Dimension(150,25));
        
        JLabelHocVi = new javax.swing.JLabel();
        JLabelHocVi.setText("Ngày sinh:");
        txtHocVi = new javax.swing.JTextField();
        txtHocVi.setPreferredSize(new Dimension(150,25));
        
        pnl4.add(JLabelHanHD);
        pnl4.add(txtHanHD);
        pnl4.add(JLabelHocVi);
        pnl4.add(txtHocVi);
        
        JPanel pnl5 = new JPanel();
        pnl5.setPreferredSize(new Dimension(690,30));
        
        JLabelHang = new javax.swing.JLabel();
        JLabelHang.setText("Số điện thoại:");
        txtHang = new javax.swing.JTextField();
        txtHang.setPreferredSize(new Dimension(300,25));
        
        pnl5.add(JLabelHang);
        pnl5.add(txtHang);
        
        JPanel pnl6 = new JPanel();
        pnl6.setPreferredSize(new Dimension(690,30));
        
        JLabelBac = new javax.swing.JLabel();
        JLabelBac.setText("Ngày vào làm:");
        txtBac = new javax.swing.JTextField();
        txtBac.setPreferredSize(new Dimension(300,25));
        
        pnl6.add(JLabelBac);
        pnl6.add(txtBac);
        
        
        pn1.add(pnl1);
        pn1.add(pnl2);
        pn1.add(pnl3);
        pn1.add(pnl4);
        pn1.add(pnl5);
        pn1.add(pnl6);
        
  
    
        
        JPanel pn3 = new JPanel();
        pn3.setBackground(Color.blue);
        pn3.setPreferredSize(new Dimension(200, 200));

        
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(200, 250));
        pn2.setBackground(Color.CYAN);
        
        ChooseAvatarPanel imagePanel = new ChooseAvatarPanel();
        imagePanel.setImage("./src/main/java/Image/Books_160px.png");
        pn2.add(imagePanel);
        
        
        
         JPanel pn5 = new JPanel();
         pn5.setBackground(Color.gray);
        pn5.setPreferredSize(new Dimension(900, 250));
        pn5.add(pn2,BorderLayout.SOUTH);
        pn5.add(pn1,BorderLayout.SOUTH);
        pnmain.add(pn5,BorderLayout.NORTH);
        
        JPanel pn4 = new JPanel();
        pn4.setBackground(Color.YELLOW);
        pn4.setPreferredSize(new Dimension(900, 150));   
        
        
         ///// under form here   
         
         
         JPanel pnll1 = new JPanel();
        pnll1.setPreferredSize(new Dimension(900,30));
        
        JLabelMaSoThue = new javax.swing.JLabel();
        JLabelMaSoThue.setText("Số nhà:");
        txtMaSoThue = new javax.swing.JTextField();
        txtMaSoThue.setPreferredSize(new Dimension(300,25));
        
        pnll1.add(JLabelMaSoThue);
        pnll1.add(txtMaSoThue);
        
        JLabelCucThue = new javax.swing.JLabel();
        JLabelCucThue.setText("Đường:");
        txtCucThue = new javax.swing.JTextField();
        txtCucThue.setPreferredSize(new Dimension(300,25));
        
        pnll1.add(JLabelCucThue);
        pnll1.add(txtCucThue);
        
        
         JPanel pnll2 = new JPanel();
        pnll2.setPreferredSize(new Dimension(900,30));
        
        JLabelSTK = new javax.swing.JLabel();
        JLabelSTK.setText("Phường/Xã:");
        txtSTK = new javax.swing.JTextField();
        txtSTK.setPreferredSize(new Dimension(300,25));
        
        pnll2.add(JLabelSTK);
        pnll2.add(txtSTK);
        
        JLabelNganHang = new javax.swing.JLabel();
        JLabelNganHang.setText("Quận/Huyện:");
        txtNganHang = new javax.swing.JTextField();
        txtNganHang.setPreferredSize(new Dimension(300,25));
        
        pnll2.add(JLabelNganHang);
        pnll2.add(txtNganHang);
        
         JPanel pnll3 = new JPanel();
        pnll3.setPreferredSize(new Dimension(900,30));
        
        JLabelSoTietGiangDay = new javax.swing.JLabel();
        JLabelSoTietGiangDay.setText("Thành phố/Tỉnh:");
        txtSoTietGiangDay = new javax.swing.JTextField();
        txtSoTietGiangDay.setPreferredSize(new Dimension(300,25));
        
        pnll3.add(JLabelSoTietGiangDay);
        pnll3.add(txtSoTietGiangDay);
       
        
        
        
        pn4.add(pnll1);
        pn4.add(pnll2);
        pn4.add(pnll3);
//        pn4.add(pnll4);
//        pn4.add(pnl5);
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
    private javax.swing.JLabel image;
    private javax.swing.JLabel JLabelMaHD;
    private javax.swing.JLabel JLabelMaLoaiHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaLoaiHD;
    private javax.swing.JLabel JLabelMaNV;
    private javax.swing.JLabel JLabelNgayKyHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayKyHD;
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

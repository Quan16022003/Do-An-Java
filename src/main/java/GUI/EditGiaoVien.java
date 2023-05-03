package GUI;

import DAL.GiaoVienDAO;
import DTO.GiaoVien;
import BLL.GiaoVienBUS;
import DAL.BindingListener;
import DTO.ToChuyenMon;
import GUI.modal.ChooseAvatarPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import model.Student;

/**
 *
 * @author ADMIN
 */
public class EditGiaoVien extends javax.swing.JDialog {

    /**
     * Creates new form InputFrm
     */
    private HomeformGiaoVien home;
    private GiaoVienDAO DAO;
    private GiaoVienBUS BUS;
    
    public EditGiaoVien(javax.swing.JPanel parent) {
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
//        txtMonHoc.getDocument().addDocumentListener(new BindingListener(txtMonHoc,"[a-z\\s]*"));
//        txtGioiTinh.getDocument().addDocumentListener(new BindingListener(txtGioiTinh,"(?i)(nam|nu)"));        
        txtNoiSinh.getDocument().addDocumentListener(new BindingListener(txtNoiSinh,"[a-z\\s]*"));        
        txtQueQuan.getDocument().addDocumentListener(new BindingListener(txtQueQuan,"[a-z\\s]*"));        
        txtNoiO.getDocument().addDocumentListener(new BindingListener(txtNoiO,"^[1-zA-Z0-9\\s\\/]*$"));      
        txtSoDienThoai.getDocument().addDocumentListener(new BindingListener(txtSoDienThoai,"[0-9\\s]*"));        
        txtEmail.getDocument().addDocumentListener(new BindingListener(txtEmail,EMAIL_PATTERN));   
//        txtToChuyenMon.getDocument().addDocumentListener(new BindingListener(txtToChuyenMon,"[a-z\\s]*"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
               
                String monhoc[] = {"tram cam"," FA", "no life"};
                String gioitinh[] = {"nu", "khong phai nu", "loai khac"};
                        String chuyenmon[] = {"thi lai", " rot mon", "helpless"};
//=======

//>>>>>>> origin/main


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
        
        jLabelLuong = new javax.swing.JLabel();
        jLabelHeSoLuong = new javax.swing.JLabel();
        jLabelNgayVaoLam = new javax.swing.JLabel();
        jLabelThamNien = new javax.swing.JLabel();

        txtMonHoc = new javax.swing.JComboBox(monhoc);

        txtGioiTinh = new javax.swing.JComboBox(gioitinh);
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

        txtToChuyenMon = new javax.swing.JComboBox(chuyenmon);
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDanToc = new javax.swing.JTextField();
        txtTonGiao = new javax.swing.JTextField();
        txtNgayCap = new javax.swing.JTextField();
        txtNoiCap = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtHeSoLuong = new javax.swing.JTextField();
        txtNgayVaoLam = new javax.swing.JTextField();
        txtThamNien = new javax.swing.JTextField();
        

     //   setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

//        txtMonHoc.setText("");

//        txtGioiTinh.setText("");

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

//        txtToChuyenMon.setText("");

        jLabel14.setText("Email:");

        txtEmail.setText("");
        
        jLabel15.setText("Dân tộc:");
        jLabel16.setText("Tôn giáo:");
        jLabel17.setText("Ngày cấp:");
        jLabel18.setText("Nơi cấp:");

        jLabelLuong.setText("Lương:");
        jLabelHeSoLuong.setText("Hệ số lương:");
        jLabelNgayVaoLam.setText("Ngày vào làm:");
        jLabelThamNien.setText("Thâm niên:");

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
        
        
        //JFrame f = new JFrame();
        this.setLayout(new BorderLayout(0,0));

        this.setSize(900  , 500);
        JPanel pnmain = new JPanel();
//        pnmain.setBackground(Color.blue);
        pnmain.setPreferredSize(new Dimension(900, 500));
        
        JPanel pn1 = new JPanel();
//        pn1.setBackground(Color.red);
        pn1.setPreferredSize(new Dimension(690, 200));
        
        JPanel pn1_1 = new JPanel();
        pn1_1.setPreferredSize(new Dimension(690, 30));
        
        pn1_1.add(jLabel2);
        
        
        
        txtMaGV.setPreferredSize(new Dimension(150,25));
        pn1_1.add(txtMaGV);
        
//        JPanel pn1_1gap = new JPanel();
//        pn1_1gap.setPreferredSize(new Dimension(0, 0));
//        pn1_1.add(pn1_1gap);
        
        pn1_1.add(jLabel6);
        txtMonHoc.setPreferredSize(new Dimension(145,25));
        pn1_1.add(txtMonHoc);
        
        JPanel pn1_11gap = new JPanel();
        pn1_11gap.setPreferredSize(new Dimension(170, 0));
        pn1_1.add(pn1_11gap);
        
        
        
        
        
        
        JPanel pn1_2 = new JPanel();
        pn1_2.setPreferredSize(new Dimension(690, 30));            
        
        pn1_2.add(jLabel3);
        
        JPanel pn1_21gap = new JPanel();
        pn1_21gap.setPreferredSize(new Dimension(30, 10));
        pn1_2.add(pn1_21gap);
         
        txtHoTen.setPreferredSize(new Dimension(420,25));
        pn1_2.add(txtHoTen);
        
        JPanel pn1_2gap = new JPanel();
        
        pn1_2gap.setPreferredSize(new Dimension(170, 10));
        pn1_2.add(pn1_2gap);
        
        
        JPanel pn1_3 = new JPanel();
        pn1_3.setPreferredSize(new Dimension(690, 30));
        
        pn1_3.add(jLabel4);
        
        JPanel pn1_32gap = new JPanel();
        pn1_32gap.setPreferredSize(new Dimension(10, 10));
        pn1_3.add(pn1_32gap);
        
        txtNgaySinh.setPreferredSize(new Dimension(150,25));
        pn1_3.add(txtNgaySinh);
        
        pn1_3.add(jLabel7);
        
        JPanel pn1_31gap = new JPanel();
        pn1_31gap.setPreferredSize(new Dimension(55, 10));
        pn1_3.add(pn1_31gap);
        
        txtGioiTinh.setPreferredSize(new Dimension(145,25));
        pn1_3.add(txtGioiTinh);
        
        JPanel pn1_3gap = new JPanel();
        pn1_3gap.setPreferredSize(new Dimension(170, 10));
        pn1_3.add(pn1_3gap);
        
        
        JPanel pn1_4 = new JPanel();
        pn1_4.setPreferredSize(new Dimension(690, 30));
        
        pn1_4.add(jLabel5);
        
        JPanel pn1_42gap = new JPanel();
        pn1_42gap.setPreferredSize(new Dimension(20, 10));
        pn1_4.add(pn1_42gap);
        
        txtNoiSinh.setPreferredSize(new Dimension(150,25));
        pn1_4.add(txtNoiSinh);
        
        pn1_4.add(jLabel8);
        
        JPanel pn1_41gap = new JPanel();
        pn1_41gap.setPreferredSize(new Dimension(50, 10));
        pn1_4.add(pn1_41gap);
        
        txtQueQuan.setPreferredSize(new Dimension(145,25));
        pn1_4.add(txtQueQuan);
        
        JPanel pn1_4gap = new JPanel();
        pn1_4gap.setPreferredSize(new Dimension(170, 10));
        pn1_4.add(pn1_4gap);
        
        
        JPanel pn1_5 = new JPanel();
        pn1_5.setPreferredSize(new Dimension(690, 30));
        
        pn1_5.add(jLabel15);
        
        JPanel pn1_52gap = new JPanel();
        pn1_52gap.setPreferredSize(new Dimension(25, 10));
        pn1_5.add(pn1_52gap);
        
        txtDanToc.setPreferredSize(new Dimension(150,25));
        pn1_5.add(txtDanToc);
        
        pn1_5.add(jLabel16);
        
        JPanel pn1_51gap = new JPanel();
        pn1_51gap.setPreferredSize(new Dimension(55, 10));
        pn1_5.add(pn1_51gap);
        
        txtTonGiao.setPreferredSize(new Dimension(145,25));
        pn1_5.add(txtTonGiao);
        
        JPanel pn1_5gap = new JPanel();
        pn1_5gap.setPreferredSize(new Dimension(170, 10));
        pn1_5.add(pn1_5gap);
        
        
        pn1.add(pn1_1);
        pn1.add(pn1_2);
        pn1.add(pn1_3);
        pn1.add(pn1_4);
        pn1.add(pn1_5);
       
        

        
        JPanel pn3 = new JPanel();
        pn3.setBackground(Color.blue);
        pn3.setPreferredSize(new Dimension(200, 200));
        

        
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(200, 200));
//        pn2.setBackground(Color.CYAN);
        
        ChooseAvatarPanel imagePanel = new ChooseAvatarPanel();
        imagePanel.setImage("./src/main/java/Image/Books_160px.png");
        pn2.add(imagePanel);
        
        
        
        
         JPanel pn5 = new JPanel();
//         pn5.setBackground(Color.gray);
        pn5.setPreferredSize(new Dimension(900, 200));
        pn5.add(pn2,BorderLayout.SOUTH);
        pn5.add(pn1,BorderLayout.SOUTH);
        pnmain.add(pn5,BorderLayout.NORTH);
       // f.add(pn3,BorderLayout.EAST);
//        f.add(pn2,BorderLayout.WEST);
//        f.add(pn1,BorderLayout.SOUTH);
//        f.add(pn3,BorderLayout.SOUTH);
//        
        JPanel pn4 = new JPanel();
//        pn4.setBackground(Color.YELLOW);
        pn4.setPreferredSize(new Dimension(900, 250));
        
        JPanel pn4_1 = new JPanel();
        pn4_1.setPreferredSize(new Dimension(900, 30));
        
        pn4_1.add(jLabel9);
        
        JPanel pn4_1gap = new JPanel();
        pn4_1gap.setPreferredSize(new Dimension(20, 10));
        pn4_1.add(pn4_1gap);

        txtDiaChi.setPreferredSize(new Dimension(700,25));
        pn4_1.add(txtDiaChi);
        
        
        JPanel pn4_2 = new JPanel();
        pn4_2.setPreferredSize(new Dimension(900, 30));
        
        pn4_2.add(jLabel10);
        
        JPanel pn4_2gap = new JPanel();
        pn4_2gap.setPreferredSize(new Dimension(45, 10));
        pn4_2.add(pn4_2gap);
        
        
        txtNoiO.setPreferredSize(new Dimension(700,25));
        pn4_2.add(txtNoiO);
        
        
        JPanel pn4_3 = new JPanel();
        pn4_3.setPreferredSize(new Dimension(900, 30));
        
        pn4_3.add(jLabel11);
        
        txtCCCD.setPreferredSize(new Dimension(200,25));
        pn4_3.add(txtCCCD);
        
        JPanel pn4_3gap = new JPanel();
        pn4_3gap.setPreferredSize(new Dimension(80, 10));
        pn4_3.add(pn4_3gap);
        
        pn4_3.add(jLabel17);
        
        JPanel pn4_31gap = new JPanel();
        pn4_31gap.setPreferredSize(new Dimension(50, 10));
        pn4_3.add(pn4_31gap);      
        
        txtNgayCap.setPreferredSize(new Dimension(150,25));
        pn4_3.add(txtNgayCap);
        
        JPanel pn4_33gap = new JPanel();
        pn4_33gap.setPreferredSize(new Dimension(145, 10));
        pn4_3.add(pn4_33gap);
        
        
        JPanel pn4_4 = new JPanel();
        pn4_4.setPreferredSize(new Dimension(900, 30));
        
        pn4_4.add(jLabel12);
        
        JPanel pn4_43gap = new JPanel();
        pn4_43gap.setPreferredSize(new Dimension(50, 10));
        pn4_4.add(pn4_43gap);
        
        txtSoDienThoai.setPreferredSize(new Dimension(200,25));
        pn4_4.add(txtSoDienThoai);
        
        JPanel pn4_4gap = new JPanel();
        pn4_4gap.setPreferredSize(new Dimension(80, 10));
        pn4_4.add(pn4_4gap);
              
        pn4_4.add(jLabel14);
        
        JPanel pn4_42gap = new JPanel();
        pn4_42gap.setPreferredSize(new Dimension(70, 10));
        pn4_4.add(pn4_42gap);
        
        txtEmail.setPreferredSize(new Dimension(150,25));
        pn4_4.add(txtEmail);
        
        JPanel pn4_41gap = new JPanel();
        pn4_41gap.setPreferredSize(new Dimension(140, 10));
        pn4_4.add(pn4_41gap);
        
        
        JPanel pn4_5 = new JPanel();
        pn4_5.setPreferredSize(new Dimension(900, 30));
        
        pn4_5.add(jLabel13);
        txtToChuyenMon.setPreferredSize(new Dimension(145,25));
        pn4_5.add(txtToChuyenMon);
        
        pn4_5.add(jLabel13);
        txtToChuyenMon.setPreferredSize(new Dimension(145,25));
        pn4_5.add(txtToChuyenMon);
        
        btnEdit.setPreferredSize(new Dimension(120,25));
        btnEdit.setText("Lưu");
        pn4_5.add(btnEdit);
        
        btnCancel.setPreferredSize(new Dimension(120,25));
        btnCancel.setText("Hủy bỏ");
        pn4_5.add(btnCancel);
        
      
        JPanel pn4_6 = new JPanel();
        pn4_6.setPreferredSize(new Dimension(900, 30));      
        
        pn4_6.add(jLabelThamNien);
        
        JPanel pn4_64gap = new JPanel();
        pn4_64gap.setPreferredSize(new Dimension(70, 10));
        pn4_6.add(pn4_64gap);
        
        txtThamNien.setPreferredSize(new Dimension(200,25));
        pn4_6.add(txtThamNien);
        
        JPanel pn4_6gap = new JPanel();
        pn4_6gap.setPreferredSize(new Dimension(80, 10));
        pn4_6.add(pn4_6gap);
        
        pn4_6.add(jLabelNgayVaoLam);
        
        JPanel pn4_61gap = new JPanel();
        pn4_61gap.setPreferredSize(new Dimension(20, 10));
        pn4_6.add(pn4_61gap);      
        
        txtNgayVaoLam.setPreferredSize(new Dimension(150,25));
        pn4_6.add(txtNgayVaoLam);
        
        JPanel pn4_63gap = new JPanel();
        pn4_63gap.setPreferredSize(new Dimension(145, 10));
        pn4_6.add(pn4_63gap);
        
        JPanel pn4_7 = new JPanel();
        pn4_7.setPreferredSize(new Dimension(900, 30));      
        
        pn4_7.add(jLabelLuong);
        
        JPanel pn4_74gap = new JPanel();
        pn4_74gap.setPreferredSize(new Dimension(70, 10));
        pn4_7.add(pn4_74gap);
        
        txtLuong.setPreferredSize(new Dimension(200,25));
        pn4_7.add(txtLuong);
        
        JPanel pn4_7gap = new JPanel();
        pn4_7gap.setPreferredSize(new Dimension(80, 10));
        pn4_7.add(pn4_7gap);
        
        pn4_7.add(jLabelHeSoLuong);
        
        JPanel pn4_71gap = new JPanel();
        pn4_71gap.setPreferredSize(new Dimension(20, 10));
        pn4_7.add(pn4_71gap);      
        
        txtHeSoLuong.setPreferredSize(new Dimension(150,25));
        pn4_7.add(txtHeSoLuong);
        
        JPanel pn4_73gap = new JPanel();
        pn4_73gap.setPreferredSize(new Dimension(145, 10));
        pn4_7.add(pn4_73gap);
        
        JPanel pn4_3_5 = new JPanel();
        pn4_3_5.setPreferredSize(new Dimension(900, 30));
        
        pn4_3_5.add(jLabel18);
        
        JPanel pn4_3_5gap = new JPanel();
        pn4_3_5gap.setPreferredSize(new Dimension(80, 10));
        pn4_3_5.add(pn4_3_5gap);
        
        
        txtNoiCap.setPreferredSize(new Dimension(700,25));
        pn4_3_5.add(txtNoiCap);
        
        
        
        pn4.add(pn4_1);
        pn4.add(pn4_2);
        pn4.add(pn4_3);
        pn4.add(pn4_3_5);
        pn4.add(pn4_4);
        pn4.add(pn4_6);
        
                pn4.add(pn4_5);
        
        
        
        
        
        pnmain.add(pn4,BorderLayout.SOUTH);
        
        
        this.add(pnmain);
        this.revalidate();
        this.setVisible(true);



   
    }// </editor-fold>                        

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        String MaGV = "", HoTen = "", NgaySinh = "", MonHoc = "",
               GioiTinh = "",  NoiSinh = "",  QueQuan = "", DiaChi = "" ,
               NoiO = "", CCCD = "", SoDienThoai = "",
               Email = "", ToChuyenMon = "", DanToc = "", TonGiao = "", NgayCap = "", NoiCap = "";
          
        boolean isOK = true;
        
        MaGV = txtMaGV.getText();
        HoTen = txtHoTen.getText();
        NgaySinh = txtNgaySinh.getText();
        MonHoc = txtMonHoc.getSelectedItem().toString();
        GioiTinh = txtGioiTinh.getSelectedItem().toString();
        NoiSinh = txtNoiSinh.getText();
        QueQuan = txtQueQuan.getText();
        DiaChi = txtDiaChi.getText();
        NoiO = txtNoiO.getText();
        CCCD = txtCCCD.getText();
        SoDienThoai = txtSoDienThoai.getText();
        Email = txtEmail.getText();
        ToChuyenMon = txtToChuyenMon.getSelectedItem().toString();
        
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
            


        if(isOK) {
            GiaoVien giaovien = new GiaoVien(
               
               MaGV, HoTen, NgaySinh, MonHoc,
               GioiTinh,  NoiSinh, QueQuan, DiaChi,
               NoiO, CCCD, SoDienThoai,
               Email, ToChuyenMon, DanToc, TonGiao, NgayCap, NoiCap
            );
            
            if (BUS.check(giaovien))
            {
                    DAO.edit(giaovien);
                    home.updateGiaoVienlist(giaovien);
                    JOptionPane.showMessageDialog(rootPane, 
                    "Sửa thành công!");
                     this.dispose();
            }
            else 
            JOptionPane.showMessageDialog(rootPane, 
            "Stupid");
        }
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
    private javax.swing.JComboBox txtToChuyenMon;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JComboBox txtMonHoc;
    private javax.swing.JComboBox txtGioiTinh;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDanToc;
    private javax.swing.JTextField txtTonGiao;
    private javax.swing.JTextField txtNgayCap;
    private javax.swing.JTextField txtNoiCap;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtHeSoLuong;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtThamNien;
       private javax.swing.JLabel jLabelLuong;
    private javax.swing.JLabel jLabelHeSoLuong;
    private javax.swing.JLabel jLabelNgayVaoLam;
    private javax.swing.JLabel jLabelThamNien;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    // End of variables declaration                   

    public void setEditData(GiaoVien g) {
        txtMaGV.setText(g.getMaGV());
        txtNoiO.setText(g.getNoiO());
        txtCCCD.setText(g.getCCCD());
        txtSoDienThoai.setText(g.getSoDienThoai());

        if (g.getMonHoc()== "tram cam")
            txtMonHoc.setSelectedIndex(0);
        if (g.getMonHoc()== " FA")
            txtMonHoc.setSelectedIndex(1);
        else 
            txtMonHoc.setSelectedIndex(2);
        
        if (g.getGioiTinh() == "nu")
            txtGioiTinh.setSelectedIndex(0);
        if (g.getGioiTinh() == "khong phai nu")
            txtGioiTinh.setSelectedIndex(1);
        else 
            txtGioiTinh.setSelectedIndex(2);
        
        if (g.getToChuyenMon()== "thi lai")
            txtToChuyenMon.setSelectedIndex(0);
        if (g.getToChuyenMon()== " rot mon")
            txtToChuyenMon.setSelectedIndex(1);
        else 
            txtToChuyenMon.setSelectedIndex(2);
        
        txtEmail.setText(g.getEmail());
        txtHoTen.setText(g.getHoTen());
        txtNgaySinh.setText(g.getNgaySinh());
        txtNoiSinh.setText(g.getNoiSinh());


        txtQueQuan.setText(g.getQueQuan());
        txtDiaChi.setText(g.getDiaChi());
    }
}

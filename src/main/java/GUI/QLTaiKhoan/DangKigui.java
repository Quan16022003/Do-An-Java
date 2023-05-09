/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QLTaiKhoan;

/**
 *
 * @author ADMIN
 */
public class DangKigui extends javax.swing.JPanel {

    /**
     * Creates new form DangKigui
     */
    public DangKigui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_center = new javax.swing.JPanel();
        pn_nhapmanv = new javax.swing.JPanel();
        lb_nhapmanv = new javax.swing.JLabel();
        tf_nhapmanv = new javax.swing.JTextField();
        pn_nhapcccd = new javax.swing.JPanel();
        lb_nhapcccd = new javax.swing.JLabel();
        tf_nhapcccd = new javax.swing.JTextField();
        pn_nhaptaikhoan = new javax.swing.JPanel();
        lb_nhaptaikhoan = new javax.swing.JLabel();
        tf_nhaptaikhoan = new javax.swing.JTextField();
        pn_nhapmatkhau = new javax.swing.JPanel();
        lb_nhapmatkhau = new javax.swing.JLabel();
        tf_nhapmatkhau = new javax.swing.JTextField();
        pn_nhaplaimatkhau = new javax.swing.JPanel();
        lb_nhaplaimatkhau = new javax.swing.JLabel();
        tf_nhaplaimatkhau = new javax.swing.JTextField();
        pn_top = new javax.swing.JPanel();
        lb_ttdangkitaikhoan = new javax.swing.JLabel();
        pn_bot = new javax.swing.JPanel();
        pn_thongbao = new javax.swing.JPanel();
        lb_thongbao = new javax.swing.JLabel();
        pn_dangki = new javax.swing.JPanel();
        bt_dangki = new javax.swing.JButton();

        setBorder(new javax.swing.border.MatteBorder(null));
        setLayout(new java.awt.BorderLayout(0, 24));

        pn_center.setBackground(new java.awt.Color(102, 102, 102));
        pn_center.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pn_center.setLayout(new java.awt.GridLayout(5, 1, 10, 44));

        pn_nhapmanv.setLayout(new java.awt.GridLayout(1, 2));

        lb_nhapmanv.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhapmanv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nhapmanv.setText("- Nhập mã nhân viên");
        pn_nhapmanv.add(lb_nhapmanv);

        tf_nhapmanv.setBackground(new java.awt.Color(255, 255, 255));
        tf_nhapmanv.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tf_nhapmanv.setForeground(new java.awt.Color(0, 0, 0));
        tf_nhapmanv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pn_nhapmanv.add(tf_nhapmanv);

        pn_center.add(pn_nhapmanv);

        pn_nhapcccd.setLayout(new java.awt.GridLayout(1, 2));

        lb_nhapcccd.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhapcccd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nhapcccd.setText("- Nhập CCCD/CMND:");
        pn_nhapcccd.add(lb_nhapcccd);

        tf_nhapcccd.setBackground(new java.awt.Color(255, 255, 255));
        tf_nhapcccd.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tf_nhapcccd.setForeground(new java.awt.Color(0, 0, 0));
        tf_nhapcccd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pn_nhapcccd.add(tf_nhapcccd);

        pn_center.add(pn_nhapcccd);

        pn_nhaptaikhoan.setLayout(new java.awt.GridLayout(1, 2));

        lb_nhaptaikhoan.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhaptaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nhaptaikhoan.setText("- Nhập tài khoản");
        pn_nhaptaikhoan.add(lb_nhaptaikhoan);

        tf_nhaptaikhoan.setBackground(new java.awt.Color(255, 255, 255));
        tf_nhaptaikhoan.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tf_nhaptaikhoan.setForeground(new java.awt.Color(0, 0, 0));
        tf_nhaptaikhoan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_nhaptaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nhaptaikhoanActionPerformed(evt);
            }
        });
        pn_nhaptaikhoan.add(tf_nhaptaikhoan);

        pn_center.add(pn_nhaptaikhoan);

        pn_nhapmatkhau.setLayout(new java.awt.GridLayout(1, 0));

        lb_nhapmatkhau.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhapmatkhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nhapmatkhau.setText("- Nhập mật khẩu");
        pn_nhapmatkhau.add(lb_nhapmatkhau);

        tf_nhapmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        tf_nhapmatkhau.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tf_nhapmatkhau.setForeground(new java.awt.Color(0, 0, 0));
        tf_nhapmatkhau.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pn_nhapmatkhau.add(tf_nhapmatkhau);

        pn_center.add(pn_nhapmatkhau);

        pn_nhaplaimatkhau.setLayout(new java.awt.GridLayout(1, 2));

        lb_nhaplaimatkhau.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lb_nhaplaimatkhau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_nhaplaimatkhau.setText("- Nhập lại mật khẩu");
        pn_nhaplaimatkhau.add(lb_nhaplaimatkhau);

        tf_nhaplaimatkhau.setBackground(new java.awt.Color(255, 255, 255));
        tf_nhaplaimatkhau.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tf_nhaplaimatkhau.setForeground(new java.awt.Color(0, 0, 0));
        tf_nhaplaimatkhau.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pn_nhaplaimatkhau.add(tf_nhaplaimatkhau);

        pn_center.add(pn_nhaplaimatkhau);

        add(pn_center, java.awt.BorderLayout.CENTER);

        pn_top.setPreferredSize(new java.awt.Dimension(170, 34));
        pn_top.setLayout(new java.awt.GridLayout(1, 1));

        lb_ttdangkitaikhoan.setBackground(new java.awt.Color(204, 204, 255));
        lb_ttdangkitaikhoan.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lb_ttdangkitaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_ttdangkitaikhoan.setText("Đăng kí tài khoản");
        pn_top.add(lb_ttdangkitaikhoan);

        add(pn_top, java.awt.BorderLayout.PAGE_START);

        pn_bot.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        pn_thongbao.setLayout(new java.awt.GridLayout(1, 1));

        lb_thongbao.setForeground(new java.awt.Color(255, 0, 0));
        lb_thongbao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_thongbao.setText("- ");
        pn_thongbao.add(lb_thongbao);

        pn_bot.add(pn_thongbao);

        pn_dangki.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        bt_dangki.setText("Đăng kí");
        bt_dangki.setPreferredSize(new java.awt.Dimension(90, 36));
        pn_dangki.add(bt_dangki);

        pn_bot.add(pn_dangki);

        add(pn_bot, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nhaptaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nhaptaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nhaptaikhoanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_dangki;
    private javax.swing.JLabel lb_nhapcccd;
    private javax.swing.JLabel lb_nhaplaimatkhau;
    private javax.swing.JLabel lb_nhapmanv;
    private javax.swing.JLabel lb_nhapmatkhau;
    private javax.swing.JLabel lb_nhaptaikhoan;
    private javax.swing.JLabel lb_thongbao;
    private javax.swing.JLabel lb_ttdangkitaikhoan;
    private javax.swing.JPanel pn_bot;
    private javax.swing.JPanel pn_center;
    private javax.swing.JPanel pn_dangki;
    private javax.swing.JPanel pn_nhapcccd;
    private javax.swing.JPanel pn_nhaplaimatkhau;
    private javax.swing.JPanel pn_nhapmanv;
    private javax.swing.JPanel pn_nhapmatkhau;
    private javax.swing.JPanel pn_nhaptaikhoan;
    private javax.swing.JPanel pn_thongbao;
    private javax.swing.JPanel pn_top;
    private javax.swing.JTextField tf_nhapcccd;
    private javax.swing.JTextField tf_nhaplaimatkhau;
    private javax.swing.JTextField tf_nhapmanv;
    private javax.swing.JTextField tf_nhapmatkhau;
    private javax.swing.JTextField tf_nhaptaikhoan;
    // End of variables declaration//GEN-END:variables
}
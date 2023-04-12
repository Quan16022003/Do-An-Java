package GUI;

import GUI.modal.Content;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ADMIN
 */
public class ChamCong_Form extends Content implements MouseListener {

    private JPanel p, pn1;
    private JLabel lblYear, lblWeek, lblID, lblSubJect, lblClass, lblSum,
            lblMo, lblTu, lblWe, lblTh, lblFr, lblSa;
    private JTextField txtYear, txtWeek, txtID, txtSubJect, txtClass, txtSum;
    private int sum;
    private JLabel[][] lblTiet;
    private JLabel lblbreak;
    private int tongNghi = 0;
    private JButton bt1;
    
    public ChamCong_Form() {
        super();
//        JPanel p = new JPanel();
        setLayout(null);
        setBackground(Color.decode("#B3E5FC"));
        addMouseListener((MouseListener) this);
//Header: năm, tuần, mã GV
         lblYear = new JLabel();
        lblYear.setText("Năm");
        lblYear.setBounds(230, 50, 30, 20);
         txtYear = new JTextField();
        txtYear.setBackground(Color.decode("#E3F2FD"));
        txtYear.setText("2020");
        txtYear.setBounds(290, 50, 71, 22);

        lblWeek = new JLabel();
        lblWeek.setText("Tuần");
        lblWeek.setBounds(411, 50, 30, 20);
        txtWeek = new JTextField();
        txtWeek.setBackground(Color.decode("#E3F2FD"));
        txtWeek.setText("5");
        txtWeek.setBounds(451, 50, 71, 22);

        lblID = new JLabel();
        lblID.setText("Mã GV");
        lblID.setBounds(572, 50, 37, 20);
        txtID = new JTextField();
        txtID.setBackground(Color.decode("#E3F2FD"));
        txtID.setText("GV001");
        txtID.setBounds(619, 50, 71, 22);
        
        bt1 = new JButton();
        bt1.setText("Xác Nhận");
        bt1.setBounds(730, 50, 100, 20);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(pn1, "Hiển thị bảng chấm công tuần "+txtWeek.getText()+", năm "+txtYear.getText()+" của "+txtID.getText());
                
            }
        });

        add(lblYear);
        add(txtYear);
        add(lblWeek);
        add(txtWeek);
        add(lblID);
        add(txtID);
        add(bt1);
        /**
         * ****************************************************************
         */
//BODY: TKB
        pn1 = new JPanel();
        pn1.setBounds(140, 100, 800, 450);
        pn1.setLayout(new GridLayout(12, 6));

        lblMo = new JLabel("Thứ Hai", SwingConstants.CENTER);
        lblMo.setBackground(Color.decode("#29B6F6"));
        lblMo.setOpaque(true);
        pn1.add(lblMo);

        lblTu = new JLabel("Thứ Ba", SwingConstants.CENTER);
        lblTu.setBackground(Color.decode("#29B6F6"));
        lblTu.setOpaque(true);
        pn1.add(lblTu);

        lblWe = new JLabel("Thứ Tư", SwingConstants.CENTER);
        lblWe.setBackground(Color.decode("#29B6F6"));
        lblWe.setOpaque(true);
        pn1.add(lblWe);

        lblTh = new JLabel("Thứ Năm", SwingConstants.CENTER);
        lblTh.setBackground(Color.decode("#29B6F6"));
        lblTh.setOpaque(true);
        pn1.add(lblTh);

        lblFr = new JLabel("Thứ Sáu", SwingConstants.CENTER);
        lblFr.setBackground(Color.decode("#29B6F6"));
        lblFr.setOpaque(true);
        pn1.add(lblFr);

        lblTiet = new JLabel[10][5];
        for (int row = 0; row < 10; row++) {
            if (row == 5) {
                for (int i = 0; i < 5; i++) {
                    lblbreak = new JLabel();
                    lblbreak.setPreferredSize(new Dimension(50, 30));
                    lblbreak.setBackground(Color.decode("#E3F2FD"));
                    lblbreak.setOpaque(true);
                    pn1.add(lblbreak);
              
                }   
            }
            for (int col = 0; col < 5; col++) {
                lblTiet[row][col] = new JLabel("Tiết " + Integer.toString(row+1), SwingConstants.CENTER);
                lblTiet[row][col].setPreferredSize(new Dimension(50, 30));
                lblTiet[row][col].setBackground(Color.decode("#E3F2FD"));
                lblTiet[row][col].setOpaque(true);
                lblTiet[row][col].addMouseListener((MouseListener) this);
                pn1.add(lblTiet[row][col]);
            }
        }
        
 

        add(pn1);

        /**
         * ***********************************************************
         */
//FOOTER: môn, lớp , tổng ngày nghỉ
        lblClass = new JLabel();
        lblClass.setText("Lớp");
        lblClass.setBounds(230, 630, 40, 20);
        txtClass = new JTextField();
        txtClass.setBackground(Color.decode("#E3F2FD"));
        txtClass.setText("12a4");
        txtClass.setBounds(290, 630, 70, 22);

        lblSubJect = new JLabel();
        lblSubJect.setText("Môn");
        lblSubJect.setBounds(411, 630, 30, 20);
        txtSubJect = new JTextField();
        txtSubJect.setBackground(Color.decode("#E3F2FD"));
        txtSubJect.setText("Hoa hoc");
        txtSubJect.setBounds(451, 630, 64, 22);

        lblSum = new JLabel();
        lblSum.setText("Tổng ngày nghỉ");
        lblSum.setBounds(572, 630, 90, 20);
        txtSum = new JTextField();
        txtSum.setBackground(Color.decode("#E3F2FD"));
        txtSum.setText(String.valueOf(tongNghi));
        txtSum.setBounds(669, 630, 30, 22);

        add(lblSubJect);
        add(txtSubJect);
        add(lblClass);
        add(txtClass);
        add(lblSum);
        add(txtSum);
//        
//        pn1.setVisible(false);
//        lblClass.setVisible(false);
//        txtClass.setVisible(false);
//        lblSubJect.setVisible(false);
//        txtSubJect.setVisible(false);
//        lblSum.setVisible(false);
//        txtSum.setVisible(false);
//

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lb1 = (JLabel) e.getSource();

        if (lb1.getBackground().equals(Color.decode("#FF8A80"))) {
            int result = JOptionPane.showConfirmDialog(this, "Xác nhận giáo viên "+txtID.getText()+" vắng "+lb1.getText());
            if(result == JOptionPane.YES_OPTION) {
                lb1.setBackground(Color.decode("#FF5252"));
                txtSum.setText((String.valueOf(SumAbsent(lblTiet))));
            } else {
                if (lb1.getBackground().equals(Color.decode("#FF5252"))) {
            lb1.setBackground(Color.decode("#FF8A80"));
                }
            }
        } else if (lb1.getBackground().equals(Color.decode("#FF5252"))) {
            int result = JOptionPane.showConfirmDialog(this, "Xác nhận xóa tiết vắng của giáo viên "+txtID.getText());
            if(result == JOptionPane.YES_OPTION) {
                lb1.setBackground(Color.decode("#FF8A80"));
                txtSum.setText((String.valueOf(SumAbsent(lblTiet))));
            } 
//            else {
//                txtSum.setText((String.valueOf(tongTiet)));
//            }
        }
    }

//    public void init() {
//        
//
//    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            JLabel lb1 = (JLabel) e.getSource();
            if (lb1.getBackground().equals(Color.decode("#E3F2FD"))) {
                lb1.setBackground(Color.decode("#FF8A80"));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            JLabel lb1 = (JLabel) e.getSource();
            if (lb1.getBackground().equals(Color.decode("#FF8A80"))) {
                lb1.setBackground(Color.decode("#E3F2FD"));
            }
        }
    }
    
    public int SumAbsent(JLabel[][] lblTiet ) {
        int sum = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 5; col++) {
                if(lblTiet[row][col].getBackground().equals(Color.decode("#FF5252"))) {
                    sum++;
                }
            }
        }
        return sum;
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if("Xác Nhận".equals(bt1.getText())) {
//            add(pn1);
//
//        add(lblSubJect);
//        add(txtSubJect);
//        add(lblClass);
//        add(txtClass);
//        add(lblSum);
//        add(txtSum);

//        }
//    }

}

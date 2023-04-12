/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g.ult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class FormXemTKB extends JPanel {

    public int runT = 0;
    public BorderLayout bdlayout = new BorderLayout();
    private JFrame MainFrame;

    //    --------------P Top
    private JPanel jptop = new JPanel(new FlowLayout(1));

    public JLabel lxtkb;
    public JLabel showUser;
    public JButton bt_ctkb;

    //    --------------
    //    --------------P center
    private JPanel jpcenter = new JPanel(new FlowLayout(1));
    public String[] columnNames = {" Tiết ", " Thứ 2 ", " Thứ 3 ", " Thứ 4 ", " Thứ 5 ", " Thứ 6 ", " Thứ 7 "};
    public Object[][] data = {
        {"      1 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      2 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      3 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      4 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      5 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      6 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      7 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      8 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      9 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},
        {"      10 ", " -- ", " -- ", " -- ", " -- ", " -- ", " -- "},};
    public JTable table_center;// = new JTable(data, columnNames);
    public JScrollPane jsp_center;// = new JScrollPane(table_center);

    //    -------------- 
    private JPanel jpbot = new JPanel(new FlowLayout(1));
    private JLabel lbfrom = new JLabel(" Áp dụng từ ngày ");
    private JLabel lbfromtxt = new JLabel(" / / / ");
    private JLabel lbto = new JLabel(" đến ngày ");
    private JLabel lbtotxt = new JLabel(" / / / ");

    //    -------------- 
    public FormXemTKB() {
        //  --- JP Top
        lxtkb = new JLabel("Xem thời khóa biểu");
        lxtkb.setVisible(true);

        showUser = new JLabel(" Xin chào User.. ");
        showUser.setVisible(true);

        bt_ctkb = new JButton("Tạo thời khóa biểu");
//      
        boolean flag = true;
        if (flag) {
            bt_ctkb.setVisible(true);

        } else {
            bt_ctkb.setVisible(false);

        }
        jptop.add(lxtkb);
        jptop.add(showUser);
        jptop.add(bt_ctkb);
        jptop.setVisible(true);
        //  ---    

        //  --- JP Bot
        jpbot.add(lbfrom);
        jpbot.add(lbfromtxt);
        jpbot.add(lbto);
        jpbot.add(lbtotxt);
        jpbot.setVisible(true);
        //  ---   
        //  --- JP Center
        //jpcenter.setBounds(10, 10, 1000, 400);
        jsp_center.setPreferredSize(new Dimension(1000, 200));
        jpcenter.add(jsp_center, BorderLayout.CENTER);
        jpcenter.setVisible(true);

        //  ---
        //  --- Main F
        MainFrame = new JFrame("Main ..........");
        MainFrame.setSize(new Dimension(1000, 700));
        MainFrame.setBounds(240, 10, 1000, 700);
        MainFrame.setLayout(bdlayout);

        jptop.setPreferredSize(new Dimension(1000, 200));
        jpcenter.setPreferredSize(new Dimension(1000, 400));
        jptop.setPreferredSize(new Dimension(1000, 100));
        MainFrame.add(jpcenter, BorderLayout.CENTER);
        MainFrame.add(jptop, BorderLayout.NORTH);
        MainFrame.add(jpbot, BorderLayout.SOUTH);
        MainFrame.setVisible(true);

    }

    public FormXemTKB(String tuser, String textFrom, String textTo, boolean checkad, String[] NameCol, Object[][] data) {
        //  --- JP Top
        if ("".equals(tuser)) {
            tuser = "Xin chào User...";
            textFrom = "0/0/2000";
            textTo = "0/0/2000";
        }

        lxtkb = new JLabel("Xem thời khóa biểu");
        lxtkb.setVisible(true);

        showUser = new JLabel(tuser); // tuser
        showUser.setVisible(true);

        bt_ctkb = new JButton("Tạo thời khóa biểu");
//      
        checkad = true;
        if (checkad) {
            bt_ctkb.setVisible(true);
            bt_ctkb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Khoi tao form tao thoi khoa bieu
                    if (runT == 0) {
                        FormCreateSch ex = new FormCreateSch();
                        ex.setVisible(true);
                        runT++;
                    }

                }
            });

        } else {
            bt_ctkb.setVisible(false);

        }
        jptop.add(lxtkb);
        jptop.add(showUser);
        jptop.add(bt_ctkb);
        jptop.setVisible(true);
        //  ---    

        //  --- JP Bot
        jpbot.add(lbfrom);
        lbfromtxt.setText(textFrom); // ..........
        jpbot.add(lbfromtxt);
        jpbot.add(lbto);
        lbtotxt.setText(textTo);     // ..........
        jpbot.add(lbtotxt);
        jpbot.setVisible(true);
        //  ---   
        //  --- JP Center
        //

        table_center = new JTable(data, NameCol);
        jsp_center = new JScrollPane(table_center);
        jsp_center.setPreferredSize(new Dimension(1000, 200));
        jpcenter.add(jsp_center, BorderLayout.CENTER);
        jpcenter.setVisible(true);
        //  --- JP Center
        
        
        //  ---
        //  --- Main F
        MainFrame = new JFrame("Main ..........");
//        MainFrame.setSize(new Dimension(1000, 700));
        MainFrame.setBounds(120, 10, 1400, 700);
        MainFrame.setLayout(bdlayout);

        jptop.setPreferredSize(new Dimension(1000, 200));
        jpcenter.setPreferredSize(new Dimension(1000, 400));
        jptop.setPreferredSize(new Dimension(1000, 100));
        MainFrame.add(jpcenter, BorderLayout.CENTER);
        MainFrame.add(jptop, BorderLayout.NORTH);
        MainFrame.add(jpbot, BorderLayout.SOUTH);
        MainFrame.setMinimumSize(new Dimension(1300, 700));
        MainFrame.pack();
        MainFrame.setVisible(true);

    }

    static {
        // load Data in MYSQL here.

    }

}

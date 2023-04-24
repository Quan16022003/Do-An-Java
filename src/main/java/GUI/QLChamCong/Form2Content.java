/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLChamCong;

import DAL.ChamCongDAO;
import DTO.ChamCong;
import GUI.Content;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan (Master Branch)
 */
public class Form2Content extends Content {
    
    private JTabbedPane tab1,tab2 ;
    private JPanel pn1,pn2,pn3;
    private JButton btThem, btSua, btXoa, btTimKiem, btLuu;
    private JLabel lblTitle, lblMaNV , lblTenNV  ,lblNgay ,lblThang ,lblNgayNghi,lblTimeIn,lblTimeOut;
    private JTextField txtMaNV,txtTenNV,txtTimeIn,txtTimeOut,txtNgayNghi;
    private JComboBox cbNgay,cbThang;
    private JTable tbChamCong;
    DefaultTableModel dtm;
    private ArrayList<ChamCong> listChamCong ;
    
    public void setEditData(ChamCong x) {
        txtMaNV.setText(x.getMaNV());
        txtTenNV.setText(x.getHoTen());
        txtNgayNghi.setText(x.getNgayThang()+"");
        txtTimeIn.setText(x.getTimeIn()+"");
        txtTimeOut.setText(x.getTimeOut()+"");
    }
    public void showResult() {
        ChamCong x = listChamCong.get(listChamCong.size() -1);
        
        dtm.addRow(new Object[] {
            x.getMaNV(),x.getHoTen(),x.getNgayThang(),x.getTimeIn(),x.getTimeOut()
        });       
    }
    public void showData() {
        dtm.setRowCount(0);
        for (ChamCong x:listChamCong) {
            dtm.addRow(new Object[] {
                x.getMaNV(),x.getHoTen(),x.getNgayThang(),x.getTimeIn(),x.getTimeOut()
            });   
        }
    }
    public void showTable() {
        
        for (ChamCong x:listChamCong) {
            dtm.addRow(new Object[] {
                x.getMaNV(),x.getHoTen(),x.getNgayThang(),x.getTimeIn(),x.getTimeOut()
            });
        }
    }
    
    public Form2Content() {
        super();
        listChamCong = new ChamCongDAO().getListChamCong();
        
        tab1 = new JTabbedPane();
        tab2 = new JTabbedPane();
        
        pn2 = new JPanel();
        pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setPreferredSize(new Dimension(1080,688));
        pn2.setLayout(null);
        pn2.setPreferredSize(new Dimension(1080,688));
        pn3 = new JPanel();
        pn3.setLayout(null);
        pn3.setPreferredSize(new Dimension(1080,688));
        
        lblTitle = new JLabel("QUẢN LÍ CHẤM CÔNG");
        lblTitle.setBounds(475  , 0, 130, 44);
        pn1.add(lblTitle);
        
        
        lblMaNV = new JLabel("MaNV");
        lblMaNV.setBounds(50      , 110, 40, 30);
        pn1.add(lblMaNV);
        txtMaNV = new JTextField("");
        txtMaNV.setBounds(130, 110, 150, 30);
        pn1.add(txtMaNV);
        lblTenNV = new JLabel("TenNV");
        lblTenNV.setBounds(50      , 160, 50, 30);
        pn1.add(lblTenNV);
        txtTenNV = new JTextField("");
        txtTenNV.setBounds(130, 160, 150, 30);
        pn1.add(txtTenNV);
        
        lblNgayNghi = new JLabel("Ngay Nghi");
        lblNgayNghi.setBounds(50      , 210, 70, 30);
        pn1.add(lblNgayNghi);
        txtNgayNghi = new JTextField("");
        txtNgayNghi.setBounds(130, 210, 150, 30);
        pn1.add(txtNgayNghi);

        
        
        lblTimeIn = new JLabel("TimeIn");
        lblTimeIn.setBounds(50      , 260, 50, 30);
        pn1.add(lblTimeIn);
        txtTimeIn = new JTextField("");
        txtTimeIn.setBounds(130, 260, 150, 30);
        pn1.add(txtTimeIn);
        lblTimeOut = new JLabel("TimeOut");
        lblTimeOut.setBounds(50      , 310, 50, 30);
        pn1.add(lblTimeOut);
        txtTimeOut = new JTextField("");
        txtTimeOut.setBounds(130, 310, 150, 30);
        pn1.add(txtTimeOut);
        
        btThem = new JButton("Them");
        btThem.setBounds(50, 450, 100, 35);
        pn1.add(btThem);
        btThem.addActionListener(new ActionListener () {           
            @Override
            public void actionPerformed(ActionEvent e) {
                ChamCong x = new ChamCong();
                x.setMaNV(txtMaNV.getText());
                x.setHoTen(txtTenNV.getText());
                x.setTimeIn(Integer.parseInt(txtTimeIn.getText()));
                x.setTimeOut(Integer.parseInt(txtTimeOut.getText()));
                try {
                    x.setNgayThang(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNghi.getText()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                if(new ChamCongDAO().insert(x)) {
                    JOptionPane.showMessageDialog(pn1, "Insert Success!");
                listChamCong.add(x);                
                showResult();


                } else {
                    JOptionPane.showMessageDialog(pn1, "Duplicated!");

                }
                
            }
        });
        
        btXoa = new JButton("Xoa");
        btXoa.setBounds(200, 450, 100, 35);
        pn1.add(btXoa);
        btXoa.addActionListener(new ActionListener () {           
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbChamCong.getSelectedRow();
                if(listChamCong.isEmpty()) {
                    JOptionPane.showMessageDialog(pn1, "Chua co du lieu");
                }
                else if(row == -1) {
                    JOptionPane.showMessageDialog(pn1, "Chua chon");
                }
                else {
                    int result = JOptionPane.showConfirmDialog(pn1, "Are you sure?");
                    if(result == JOptionPane.YES_OPTION) {
                        listChamCong.remove(row);
                        showData();
                    }
                    
                }
            }
        });
        btLuu = new JButton("Luu");
        btLuu.setBounds(200, 500, 100, 35);
        pn1.add(btLuu);
        btLuu.setVisible(false);
        btLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChamCong x = new ChamCong();
                x.setMaNV(txtMaNV.getText());
                x.setHoTen(txtTenNV.getText());
                x.setTimeIn(Integer.parseInt(txtTimeIn.getText()));
                x.setTimeOut(Integer.parseInt(txtTimeOut.getText()));
                try {
                    x.setNgayThang(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNghi.getText()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                if(new ChamCongDAO().insert(x)) {
                    JOptionPane.showMessageDialog(pn1, "Apply Success!");                  
                    listChamCong.add(x);                                  
                    showResult();
                } else {
                    JOptionPane.showMessageDialog(pn1, "Duplicated!");

                }
                btThem.setVisible(true);
                    btXoa.setVisible(true);
                    btTimKiem.setVisible(true);
                    btLuu.setVisible(false);
            }
            
        });
        
        btSua = new JButton("Sua");
        btSua.setBounds(50, 500, 100, 35);
        pn1.add(btSua);
        btSua.addActionListener(new ActionListener () {           
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbChamCong.getSelectedRow();
                if(listChamCong.isEmpty()) {
                    JOptionPane.showMessageDialog(pn1, "Chua co du lieu");
                }
                else if(row == -1) {
                    JOptionPane.showMessageDialog(pn1, "Chua chon");
                }
                else {
                    txtMaNV.setText(listChamCong.get(row).getMaNV());
                    txtTenNV.setText(listChamCong.get(row).getHoTen());
                    txtNgayNghi.setText(listChamCong.get(row).getNgayThang()+"");
                    txtTimeIn.setText(listChamCong.get(row).getTimeIn()+"");
                    txtTimeOut.setText(listChamCong.get(row).getTimeOut()+"");
                      
                    btThem.setVisible(false);
                    btXoa.setVisible(false);
                    btTimKiem.setVisible(false);
                    btLuu.setVisible(true);
                    
                    listChamCong.remove(row);               
//                    showResult();
                }
            }
        });
        btTimKiem = new JButton("TimKiem");
        btTimKiem.setBounds(200, 500, 100, 35);
        pn1.add(btTimKiem);
        
        dtm = new DefaultTableModel();
//        dtm.addColumn("STT");
        dtm.addColumn("Ma NV");
        dtm.addColumn("Ho Ten");
        dtm.addColumn("Ngay Nghi");
        dtm.addColumn("Time In");
        dtm.addColumn("Time Out");
        showTable();
        
        
        tbChamCong = new JTable(dtm);
        
        JScrollPane sc = new JScrollPane(tbChamCong);
        sc.setBounds(360,44, 720, 640);
        pn1.add(sc);
        
        tab1.addTab("Quản lí chấm công", pn1);
        tab1.addTab("Quy định thưởng phạt", pn2);
        tab1.addTab("Thống kê Châm Công", pn3);

        add(tab1);
    }
    
}

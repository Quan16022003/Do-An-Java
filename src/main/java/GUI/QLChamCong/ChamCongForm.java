/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLChamCong;

import BLL.expDATA;
import DAL.BindingListener;
import DAL.ChamCongDAO;
import DTO.ChamCong;
import GUI.modal.Content;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luan (Master Branch)
 */
public class ChamCongForm extends Content {

    private JTabbedPane tab1;
    private JPanel pn1, pn2;
    private JButton btThem, btSua, btXoa, btTimKiem, btLuu, btHuy, btExport;
    private JLabel lblTitle, lblMaNV, lblXacNhan, lblNgay, lblThang, lblNgayNghi, lblTimeIn, lblTimeOut;
    private JTextField txtMaNV, txtXacNhan, txtTimeIn, txtTimeOut, txtNgayNghi, txtTimKiem;
    private JComboBox cbNgay, cbThang;
    private JTable tbChamCong,tbThongKe;
    DefaultTableModel dtm1,dtm2;
    private ArrayList<ChamCong> listChamCong;

    
    
    public void showResult() {
        ChamCong x = listChamCong.get(listChamCong.size() - 1);

        dtm1.addRow(new Object[]{
            x.getMaNV(), x.getNgayThang(), x.getTimeIn(), x.getTimeOut(), x.getxacNhan()
        });
    }

    public void showData() {
        dtm1.setRowCount(0);
        for (ChamCong x : listChamCong) {
            dtm1.addRow(new Object[]{
                x.getMaNV(), x.getNgayThang(), x.getTimeIn(), x.getTimeOut(), x.getxacNhan()
            });
        }
    }

    public void showTable() {
        dtm1.setRowCount(0);
        for (ChamCong x : new ChamCongDAO().find(txtTimKiem.getText())) {
            dtm1.addRow(new Object[]{
                x.getMaNV(), x.getNgayThang(), x.getTimeIn(), x.getTimeOut(), x.getxacNhan()
            });
        }

    }

    public ChamCongForm() {
        super();
        
        
        listChamCong = new ChamCongDAO().getListChamCong();

        tab1 = new JTabbedPane();
//        tab2 = new JTabbedPane();

        pn2 = new JPanel();
        pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setPreferredSize(new Dimension(1080, 688));
        pn2.setLayout(null);
        pn2.setPreferredSize(new Dimension(1080, 688));
//        pn3 = new JPanel();
//        pn3.setLayout(null);
//        pn3.setPreferredSize(new Dimension(1080, 688));

        lblTitle = new JLabel("QUẢN LÍ CHẤM CÔNG");
        lblTitle.setBounds(475, 0, 130, 44);
        pn1.add(lblTitle);

        lblMaNV = new JLabel("Mã nhân viên");
        lblMaNV.setBounds(30, 110, 100, 30);
        pn1.add(lblMaNV);
        txtMaNV = new JTextField("");
        txtMaNV.setBounds(170, 110, 150, 30);
        pn1.add(txtMaNV);
        lblXacNhan = new JLabel("Xác nhận đủ công");
        lblXacNhan.setBounds(30, 310, 100, 30);
        pn1.add(lblXacNhan);
        txtXacNhan = new JTextField("");
        txtXacNhan.setBounds(170, 310, 150, 30);
        pn1.add(txtXacNhan);

        lblNgayNghi = new JLabel("Ngày chấm công");
        lblNgayNghi.setBounds(30, 160, 100, 30);
        pn1.add(lblNgayNghi);
        txtNgayNghi = new JTextField("");
        txtNgayNghi.setBounds(170, 160, 150, 30);
        pn1.add(txtNgayNghi);

        lblTimeIn = new JLabel("Thời gian vào");
        lblTimeIn.setBounds(30, 210, 100, 30);
        pn1.add(lblTimeIn);
        txtTimeIn = new JTextField("");
        txtTimeIn.setBounds(170, 210, 150, 30);
        pn1.add(txtTimeIn);
        lblTimeOut = new JLabel("Thời gian ra");
        lblTimeOut.setBounds(30, 260, 100, 30);
        pn1.add(lblTimeOut);
        txtTimeOut = new JTextField("");
        txtTimeOut.setBounds(170, 260, 150, 30);
        pn1.add(txtTimeOut);

        btThem = new JButton("Thêm");
        btThem.setBounds(10, 400, 100, 35);
        pn1.add(btThem);
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaNV.getText().equals("") || txtXacNhan.getText().equals("") || txtNgayNghi.getText().equals("") || txtTimeIn.getText().equals("") || txtTimeOut.getText().equals("")) {
                    JOptionPane.showMessageDialog(pn1, "Cần điền đủ thông tin!");
                } else {
                    ChamCong x = new ChamCong();
                    x.setMaNV(txtMaNV.getText());
                    x.setxacNhan(txtXacNhan.getText());
                    x.setTimeIn(txtTimeIn.getText());
                    x.setTimeOut(txtTimeOut.getText());
                    try {
                        x.setNgayThang(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNghi.getText()));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    if (new ChamCongDAO().insert(x)) {
                        JOptionPane.showMessageDialog(pn1, "Thêm thành công!");
                        listChamCong.add(x);
                        showResult();

                    } else {
                        JOptionPane.showMessageDialog(pn1, txtMaNV.getText() + " đã chấm công vào " + txtNgayNghi.getText() + " rồi");

                    }
                }
            }
        });

        btXoa = new JButton("Xoa");
        btXoa.setBounds(130, 400, 100, 35);
        pn1.add(btXoa);
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbChamCong.getSelectedRow();
                if (listChamCong.isEmpty()) {
                    JOptionPane.showMessageDialog(pn1, "Chưa có dữ liệu");
                } else if (row == -1) {
                    JOptionPane.showMessageDialog(pn1, "Hãy chọn dòng cần thao tác");
                } else {
                    int result = JOptionPane.showConfirmDialog(pn1, "Are you sure?");
                    if (result == JOptionPane.YES_OPTION) {
                        listChamCong.get(row).setIs_deleted(1);
                        if (new ChamCongDAO().updateDeleted(listChamCong.get(row))) {
                            JOptionPane.showMessageDialog(pn1, "Delete Success!");

                        } else {
                            JOptionPane.showMessageDialog(pn1, "Something wrong!");

                        }
                        listChamCong.remove(row);
                        showData();

                    }

                }
            }
        });
        btLuu = new JButton("Cập Nhật");
        btLuu.setBounds(50, 400, 100, 35);
        pn1.add(btLuu);
        btLuu.setVisible(false);
        btLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMaNV.getText().equals("") || txtXacNhan.getText().equals("") || txtNgayNghi.getText().equals("") || txtTimeIn.getText().equals("") || txtTimeOut.getText().equals("")) {
                    JOptionPane.showMessageDialog(pn1, "Cần điền đủ thông tin!");
                } else {
                    ChamCong x = new ChamCong();
                    x.setMaNV(txtMaNV.getText());

                    x.setxacNhan(txtXacNhan.getText());
                    x.setTimeIn(txtTimeIn.getText());
                    x.setTimeOut(txtTimeOut.getText());
                    try {
                        x.setNgayThang(new SimpleDateFormat("dd/MM/yyyy").parse(txtNgayNghi.getText()));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                    if (new ChamCongDAO().update(x)) {
                        JOptionPane.showMessageDialog(pn1, "Apply Success!");
                        listChamCong.add(x);
                        showResult();
                    } else {
                        JOptionPane.showMessageDialog(pn1, "Duplicated!");

                    }

                    btSua.setVisible(true);
                    btHuy.setVisible(false);
                    btLuu.setVisible(false);
                    btThem.setVisible(true);
                    btXoa.setVisible(true);
                }
            }
        });

        btSua = new JButton("Sua");
        btSua.setBounds(250, 400, 100, 35);
        pn1.add(btSua);
        btSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tbChamCong.getSelectedRow();
                if (listChamCong.isEmpty()) {
                    JOptionPane.showMessageDialog(pn1, "Chưa có dữ liệu");
                } else if (row == -1) {
                    JOptionPane.showMessageDialog(pn1, "Hãy chọn dòng cần thao tác");
                } else {
                    txtMaNV.setText(listChamCong.get(row).getMaNV());
                    txtXacNhan.setText(listChamCong.get(row).getxacNhan());
                    txtNgayNghi.setText(new SimpleDateFormat("dd/MM/yyyy").format(listChamCong.get(row).getNgayThang()));
                    txtTimeIn.setText(listChamCong.get(row).getTimeIn() + "");
                    txtTimeOut.setText(listChamCong.get(row).getTimeOut() + "");
                    btSua.setVisible(false);
                    btLuu.setVisible(true);
                    btHuy.setVisible(true);
                    btThem.setVisible(false);
                    btXoa.setVisible(false);
                    txtMaNV.setEditable(false);
                    txtNgayNghi.setEditable(false);
                    
                    
//                    listChamCong.remove(row);               
//                    showResult();
                }
            }
        });
        btHuy = new JButton("Hủy");
        btHuy.setBounds(220, 400, 100, 35);
        pn1.add(btHuy);
        btHuy.setVisible(false);
        btHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaNV.setText("");
                txtNgayNghi.setText("");
                txtTimeIn.setText("");
                txtTimeOut.setText("");
                txtXacNhan.setText("");
                
                btSua.setVisible(true);
                    btHuy.setVisible(false);
                    btLuu.setVisible(false);
                    btThem.setVisible(true);
                    btXoa.setVisible(true);
                
            }
            
        });
        
        txtTimKiem = new JTextField("");
        txtTimKiem.setBounds(10, 500, 220, 35);
        pn1.add(txtTimKiem);

        btTimKiem = new JButton("TimKiem");
        btTimKiem.setBounds(250, 500, 100, 35);
        pn1.add(btTimKiem);
        btTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listChamCong.isEmpty()) {
                    JOptionPane.showMessageDialog(pn1, "Chưa có dữ liệu");
                } else {

                    if (txtTimKiem.getText().equals("")) {
                        JOptionPane.showMessageDialog(pn1, "Cần điền thông tin!");
                    } else {

                        showTable();

                    }
                }

            }

        });
        
        btExport = new JButton("Export");
        btExport.setBounds(250, 550, 100, 35);
        pn1.add(btExport);
        btExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<ChamCong> xa = null;
                String[] headera = null;
                String namefa = null;
                String patha = null;
                String sheetnamea = null;
                expDATA z = new expDATA();
                try {
                    z.exp(listChamCong, headera, namefa, patha, sheetnamea);
                } catch (IOException ex) {
                    Logger.getLogger(ChamCongForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        txtMaNV.getDocument().addDocumentListener(new BindingListener(txtMaNV,"[A-Z0-9]*"));
        txtNgayNghi.getDocument().addDocumentListener(new BindingListener(txtNgayNghi,"\\d{1,2}/\\d{1,2}/\\d{4}"));
        txtTimeIn.getDocument().addDocumentListener(new BindingListener(txtTimeIn,"\\d{1,2}:\\d{1,2}"));
        txtTimeOut.getDocument().addDocumentListener(new BindingListener(txtTimeOut,"\\d{1,2}:\\d{1,2}"));
        txtXacNhan.getDocument().addDocumentListener(new BindingListener(txtXacNhan,"[01]{1}"));
        
        dtm1 = new DefaultTableModel();
//        dtm1.addColumn("STT");
        dtm1.addColumn("Mã nhân viên");
        dtm1.addColumn("Ngày chấm công");
        dtm1.addColumn("Giờ vào");
        dtm1.addColumn("Giờ ra");
        dtm1.addColumn("Xác Nhận");

        dtm2 = new DefaultTableModel();
        dtm2.addColumn("Mã nhân viên");
        dtm2.addColumn("Tỏng ngày công");
        
        showTable();

        tbChamCong = new JTable(dtm1);
        tbThongKe = new JTable(dtm2);
        JScrollPane sc2 = new JScrollPane(tbThongKe);
        sc2.setBounds(10, 50, 1060, 650);
        pn2.add(sc2);
        

        JScrollPane sc = new JScrollPane(tbChamCong);
        sc.setBounds(360, 44, 700, 600);
        pn1.add(sc);

        tab1.addTab("Quản lí chấm công", pn1);
        tab1.addTab("Thống kê chấm công", pn2);

        add(tab1);
    }

}

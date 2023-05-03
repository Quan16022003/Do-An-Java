package GUI.QLLuong;

import BLL.QLLuongBUS;
import DTO.Luong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class XemLuongHienTai extends JPanel{
    private QLLuongBUS bus = new QLLuongBUS();
    private BangLuongPanel bangLuongPanel;
    private LocalDate date;
    private List<Luong> data;
    private JPanel funcPanel;
    public XemLuongHienTai() {
        setLayout(new BorderLayout());
        this.date = LocalDate.now();
        this.data = bus.selectAllByDate(date);
        bangLuongPanel = new BangLuongPanel(date, data);
        initFuncButtons();
        add(bangLuongPanel, BorderLayout.CENTER);
        add(funcPanel, BorderLayout.PAGE_END);
        System.out.println(data.size());
    }

    public void initFuncButtons() {
        funcPanel = new JPanel();
        funcPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        button1.setPreferredSize(new Dimension(200, 30));
        button2.setPreferredSize(new Dimension(200, 30));
        if (this.data.size() == 0) {
            button1.setText("Tạo mới bảng lương");
        } else {
            button1.setText("Xoá bảng lương");
        }
        button2.setVisible(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (button1.getText()) {
                    case "Tạo mới bảng lương" -> {
                        bus.createNew(date);
                        if (bus.selectAll().size() > 0) {
                            JOptionPane.showMessageDialog(null, "Tạo mới thành công");
                            bangLuongPanel.initTable(bus.selectAll());
                            button1.setText("Lưu xuống database");
                            button2.setText("Thay đổi lương cơ bản");
                            button2.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tạo mới không thành công");
                        }
                    }
                    case "Lưu xuống database" -> {
                        int c = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu xuống database");
                        if (c == JOptionPane.YES_OPTION && bus.insert()) {
                            JOptionPane.showMessageDialog(null, "Lưu xuống database thành công");
                            button1.setText("Đã lưu xuống database");
                            button1.setEnabled(false);
                            button2.setVisible(false);
                        }
                    }
                    case "Xoá bảng lương" -> {
                        int c = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá bảng lương");
                        if (c == JOptionPane.YES_OPTION && bus.delete()) {
                            JOptionPane.showMessageDialog(null, "Xoá bảng lương thành công");
                            bangLuongPanel.clearTable();
                            button1.setText("Tạo mới bảng lương");
                        }
                    }
                }
//                if (button1.getText().equals("Tạo mới bảng lương")) {
//                } else if (button1.getText().equals("Lưu xuống database")) {
//                    if (bus.insert()) {
//                        JOptionPane.showMessageDialog(null, "Lưu xuống database thành công");
//                        button1.setText("Cập nhật database");
//                        button1.setEnabled(false);
//                    }
//                } else {
//                    if (bus.update()) {
//                        JOptionPane.showMessageDialog(null, "Update database thành công");
//                    }
//                    button1.setEnabled(false);
//                }
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String luongCBMoi = JOptionPane.showInputDialog("Nhập lương cơ bản mới:");
                if (luongCBMoi != null) {
                    if (bus.updateLuongCB(Integer.parseInt(luongCBMoi))) {
                        bangLuongPanel.update();
                        JOptionPane.showMessageDialog(null, "Thay đổi lương cơ bản thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thay đổi lương cơ bản không thành công");
                    }
                }
            }
        });
        funcPanel.add(button1);
        funcPanel.add(button2);
    }
}



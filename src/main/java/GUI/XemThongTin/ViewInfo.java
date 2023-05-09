package GUI.XemThongTin;

import DAL.NhanVienDAO;
import DTO.NhanVien;
import GUI.Model.ChooseAvatarPanel;
import GUI.Model.Content;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class ViewInfo extends Content {
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel[] labels = new JLabel[13];
    private NhanVienDAO dao = new NhanVienDAO();
    private String _maNV;
    public ViewInfo(String maNV) {
        super();
        _maNV = maNV;
        initPanel();
        add(panel, BorderLayout.PAGE_START);
    }
    private void initPanel() {
        NhanVien nhanVien = dao.select(_maNV);
        panel = new JPanel(new GridBagLayout());
        titleLabel = new JLabel();
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setPreferredSize(new Dimension(300, 25));
            labels[i].setFont(new Font("Segoe UI", Font.PLAIN, 18));
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        titleLabel.setText("THÔNG TIN CÁ NHÂN");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        ChooseAvatarPanel chooseAvatarPanel = new ChooseAvatarPanel();
        chooseAvatarPanel.disableButton();
        chooseAvatarPanel.setImage(nhanVien.getImage());
        chooseAvatarPanel.setPreferredSize(new Dimension(150, 200));
        gbc.gridy = 1;
        gbc.gridheight = 5;
        gbc.gridwidth = 1;
        panel.add(chooseAvatarPanel, gbc);

        labels[0].setText("Mã nhân viên: " + nhanVien.getMaNV());
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        panel.add(labels[0], gbc);

        labels[1].setText("Mã đơn vị: " + nhanVien.getMaDV());
        gbc.gridy = 2;
        gbc.gridx = 1;
        panel.add(labels[1], gbc);

        labels[2].setText("Mã chức vụ: " + nhanVien.getMaChucVu());
        gbc.gridx = 2;
        panel.add(labels[2], gbc);

        labels[3].setText("Họ tên: " + nhanVien.getTen());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(labels[3], gbc);

        labels[4].setText("Giới tính: " + nhanVien.getGioiTinh());
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(labels[4], gbc);

        labels[5].setText("Ngày sinh: " + nhanVien.getNgSinh());
        gbc.gridx = 2;
        panel.add(labels[5], gbc);

        labels[6].setText("Số điện thoại: " + nhanVien.getSDT());
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(labels[6], gbc);

        labels[7].setText("Ngày vào làm: " + nhanVien.getNgVaoLam());
        gbc.gridx = 2;
        panel.add(labels[7], gbc);

        labels[8].setText("Chỗ ở hiện nay: " + nhanVien.getNoiOHienTai());
        labels[8].setPreferredSize(new Dimension(600, 25));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        panel.add(labels[8], gbc);

        labels[9].setText("CCCD: " + nhanVien.getCCCD());
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(labels[9], gbc);

        labels[10].setText("Ngày cấp: " + nhanVien.getNgCap());
        gbc.gridx = 1;
        panel.add(labels[10], gbc);

        labels[11].setText("Nơi cấp: " + nhanVien.getNoiCap());
        gbc.gridx = 2;
        panel.add(labels[11], gbc);
    }
}

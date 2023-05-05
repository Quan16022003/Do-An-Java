package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViDuGridBagLayout extends JDialog {
    private JLabel[] labels;
    private JTextField[] textFields;
    private final String[] labelNames = { "Mã hợp đồng", "Mã nhân viên", "Ngày ký", "Hạn hợp đồng", "Học vị", "Hạng",
                                        "Bậc", "Hệ số lương", "Số tài khoản", "Thuộc ngân hàng", "Mã số thuế", "Thuộc cục thuế"};

    public ViDuGridBagLayout() {
        setSize(new Dimension(800, 400));
        labels = new JLabel[labelNames.length];
        textFields = new JTextField[labelNames.length];

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;
        for (int i = 0; i < Math.ceil(labelNames.length / 2.0); i++) {
            gbc.gridy = i;
            for (int j = 0; j < 2; j++) {
                int t = i*2 + j;
                labels[t] = new JLabel(labelNames[i*2+j]);
                labels[t].setPreferredSize(new Dimension(100, 20));
                gbc.gridx = j*2;
                add(labels[t], gbc);
                textFields[t] = new JTextField();
                textFields[t].setPreferredSize(new Dimension(150, 20));
                gbc.gridx = j*2 + 1;
                add(textFields[t], gbc);
            }
        }


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViDuGridBagLayout dialog = new ViDuGridBagLayout();
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}

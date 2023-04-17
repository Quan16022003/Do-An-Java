package GUI.QLChamCong;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ThongKeForm extends JPanel {
    private JPanel leftPanel, rightPanel;
    public ThongKeForm() {
        setLayout(new BorderLayout());
        initLeftPanel();
        initRightPanel();
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }
    private void initLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 500));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Danh sách nhân viên"));
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Mã nhân viên");
        model.addColumn("Họ tên");
        model.addRow(new Object[] { "NV001", "Nguyễn Văn A"});
        model.addRow(new Object[] { "NV002", "Nguyễn Văn B"});
        model.addRow(new Object[] { "NV003", "Nguyễn Văn C"});
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        leftPanel.add(scrollPane);
    }
    private void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Thống kê"));
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ngày chấm công");
        model.addColumn("Giờ vào");
        model.addColumn("Giờ ra");
        model.addColumn("Giờ công");
        model.addColumn("Xác nhận công");
        model.addRow(new Object[] {"123", "123", "123", "123", "123"});
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        rightPanel.add(scrollPane);
    }


}

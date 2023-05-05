package GUI.QLLuong;

import DTO.Luong;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class BangLuongPanel extends JPanel {
    private JPanel titlePanel, bangLuongPanel;
    private LocalDate date;
    private List<Luong> data;
    private JScrollPane scrollPane;
    private JLabel luongCoBanLabel;
    private JTable table;
    private NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
    public BangLuongPanel(LocalDate date, List<Luong> data) {
        this.date = date;
        this.data = data;
        setLayout(new BorderLayout());
        initTitlePanel();
        initBangLuongPanel();
        add(titlePanel, BorderLayout.PAGE_START);
        add(bangLuongPanel, BorderLayout.CENTER);
        System.out.println(this.data.size());
    }

    private void initTitlePanel() {
        titlePanel = new JPanel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
        String formattedDate = formatter.format(date);
        JLabel titleLabel = new JLabel("<html><h1>Bảng lương tháng " + formattedDate + "</h1></html>");
        titlePanel.add(titleLabel);
    }
    private void initBangLuongPanel() {
        scrollPane = new JScrollPane();
        bangLuongPanel = new JPanel(new BorderLayout());
        bangLuongPanel.add(scrollPane);
        if (data.size() == 0) {
            JLabel noDataLabel = new JLabel("Không có dữ liệu");
            noDataLabel.setFont(new Font("arial", Font.BOLD, 15));
            noDataLabel.setHorizontalAlignment(JLabel.CENTER);
            noDataLabel.setVerticalAlignment(JLabel.TOP);
            scrollPane.setViewportView(noDataLabel);
        } else {
            initTable(data);
        }
    }

    public void setupHeader(JTable table) {
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setFont(c.getFont().deriveFont(Font.BOLD));
                    return c;
                }
            });
        }
    }

    // update table when lương cơ bản is changed
    public void update() {
        luongCoBanLabel.setText("* Lương cơ bản: "+ formatter.format(data.get(0).getLuongCB()) + " VNĐ");
        for (int i = 0; i < data.size(); i++) {
            data.get(i).tinhLuong();
            System.out.println(data.get(i).toString());
        }
        table.requestFocus();
    }

    // Tạo table khi có data
    public void initTable(List<Luong> data) {
        this.data = data;
        LuongTableModel model = new LuongTableModel(data);
        table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground((row % 2 == 0) ? getBackground() : new Color(245,245,245));
                }
                if (column == 0) {
                    ((JLabel) c).setHorizontalAlignment(JLabel.CENTER);
                } else if (column == 1) {
                    ((JLabel) c).setHorizontalAlignment(JLabel.LEFT);
                } else {
                    ((JLabel) c).setHorizontalAlignment(JLabel.RIGHT);
                }
                return c;
            }
        };
        setupHeader(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);

        luongCoBanLabel = new JLabel("* Lương cơ bản: "+ formatter.format(data.get(0).getLuongCB()) + " VNĐ");
        luongCoBanLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        luongCoBanLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        bangLuongPanel.add(luongCoBanLabel, BorderLayout.NORTH);
        scrollPane.setViewportView(table);
    }

    // Xoá table view khi xoá bảng lương
    public void clearTable() {
        bangLuongPanel.removeAll();
        JLabel noDataLabel = new JLabel("Không có dữ liệu");
        noDataLabel.setFont(new Font("arial", Font.BOLD, 15));
        noDataLabel.setHorizontalAlignment(JLabel.CENTER);
        noDataLabel.setVerticalAlignment(JLabel.TOP);
        scrollPane.setViewportView(noDataLabel);
        bangLuongPanel.add(scrollPane);
    }

}

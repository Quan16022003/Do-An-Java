package GUI.QLChamCong;

import DTO.ChamCong;
import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ChamCongForm extends JPanel {
    private JPanel titlePanel;
    private JPanel mainPanel;
    private JPanel footerPanel;

    private JTable table;
    private ArrayList<ChamCong> chamCongs;

    public ChamCongForm() {
        setLayout(new BorderLayout());

        initTitlePanel();
        initMainPanel();
        initFooterPanel();

        add(titlePanel, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.PAGE_END);
    }

    private void initTitlePanel() {
        titlePanel = new JPanel();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = formatter.format(currentDate);
        System.out.println();

        JLabel label = new JLabel("<html><h1>Chấm công ngày "+formattedDate+"</h1></html>");
        titlePanel.add(label);
    }

    private void initMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        chamCongs = new ArrayList<ChamCong>();
        chamCongs.add(new ChamCong("NV001", new String(), new String()));
        chamCongs.add(new ChamCong("NV002", new String(), new String()));
        chamCongs.add(new ChamCong("NV003", new String(), new String()));
        ChamCongTableModel model = new ChamCongTableModel(chamCongs);
        table = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row)) {
                    c.setBackground(row % 2 == 0 ? getBackground() : new Color(238, 238, 238));
                }
                return c;
            }
        };
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        table.getColumnModel().getColumn(0).setHeaderRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(c.getFont().deriveFont(Font.BOLD));
                return c;
            }
        });
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(tableCellRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(45);
        table.getColumnModel().getColumn(3).setPreferredWidth(45);
        table.getColumnModel().getColumn(4).setPreferredWidth(45);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);

        ChamCong chamCong = new ChamCong("NV004", new String(), new String());
        model.addRow(chamCong);
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT) {
                    System.out.println("New row inserted at " + e.getFirstRow());
                } else if (e.getType() == TableModelEvent.DELETE) {
                    System.out.println("Row deleted at " + e.getFirstRow());
                } else if (e.getType() == TableModelEvent.UPDATE) {
                    System.out.println("Row updated at " + e.getFirstRow());
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);
        chamCongs.add(new ChamCong("NV005", new String(), new String()));
    }

    private void initFooterPanel() {
        footerPanel = new JPanel();
        JButton button = new JButton("Lưu");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (var chamCong : chamCongs) {
                    System.out.println(chamCong.toString());
                }
            }
        });

        footerPanel.add(button);
    }

}

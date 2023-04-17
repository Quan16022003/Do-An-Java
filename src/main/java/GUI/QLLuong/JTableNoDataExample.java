package GUI.QLLuong;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class JTableNoDataExample extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JLabel noDataLabel;

    public JTableNoDataExample() {
        super("JTable No Data Example");

        // Create the table with a default table model
        table = new JTable(new DefaultTableModel(new Object[][]{}, new String[]{"Column 1", "Column 2"}));

        // Set the custom renderer
        TableCellRenderer renderer = new CustomTableCellRenderer(table.getDefaultRenderer(Object.class));
        table.setDefaultRenderer(Object.class, renderer);

        // Create the no data label with red foreground
        noDataLabel = new JLabel("No data", SwingConstants.CENTER);
        noDataLabel.setForeground(Color.RED);

        // Create the panel to hold the table and no data label
        JPanel panel = new JPanel(new BorderLayout());

        // Create the scroll pane and add the table to it
        scrollPane = new JScrollPane(table);

        // Add the scroll pane to the panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add the no data label to the panel and hide it
        panel.add(noDataLabel, BorderLayout.CENTER);
        noDataLabel.setVisible(true);

        // Add the panel to the frame
        add(panel);

        // Set the preferred size of the frame
        setPreferredSize(new Dimension(400, 300));

        // Pack the frame and make it visible
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JTableNoDataExample());
    }

    // Custom table cell renderer to display "No data" message
    public class CustomTableCellRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;

        public CustomTableCellRenderer(TableCellRenderer defaultRenderer) {
            this.defaultRenderer = defaultRenderer;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Check if there is no data
            if (row == 0 && table.getModel().getRowCount() == 1 && table.getModel().getColumnCount() > 0) {
                // Hide the scroll pane and show the no data label
                scrollPane.setVisible(false);
                noDataLabel.setVisible(true);
                return noDataLabel;
            } else {
                // Show the scroll pane and hide the no data label
                scrollPane.setVisible(true);
                noDataLabel.setVisible(false);
                // Use the default renderer for other cells
                return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }
    }
}

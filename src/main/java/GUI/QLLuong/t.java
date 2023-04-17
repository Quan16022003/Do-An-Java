package GUI.QLLuong;

import DTO.Luong;
import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class t {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1280, 720));
//        JTabbedPane tabbedPane = new JTabbedPane();
//        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate startDate = LocalDate.parse("12-03-2022", formatter);
//        LocalDate endDate = LocalDate.parse("23-04-2023", formatter);
//
//        YearMonth currentMonth = YearMonth.from(startDate);
//        while (!currentMonth.isAfter(YearMonth.from(endDate))) {
//            String formattedMonth = currentMonth.format(DateTimeFormatter.ofPattern("MM-yyyy"));
//            tabbedPane.addTab(formattedMonth, new JLabel(formattedMonth));
//            currentMonth = currentMonth.plusMonths(1);
//        }
//        frame.add(tabbedPane);
        List<Luong> data = new ArrayList<Luong>();
        LuongTableModel model = new LuongTableModel(data);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        if (table.getModel().getRowCount() == 0) {
            JLabel noDataLabel = new JLabel("Không có dữ liệu");
            noDataLabel.setFont(new Font("arial", Font.BOLD, 15));
            noDataLabel.setHorizontalAlignment(JLabel.CENTER);
            noDataLabel.setVerticalAlignment(JLabel.TOP);
            scrollPane.setViewportView(noDataLabel);
        }
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}

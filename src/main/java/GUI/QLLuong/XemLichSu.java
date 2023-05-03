package GUI.QLLuong;

import BLL.QLLuongBUS;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class XemLichSu extends JPanel {
    QLLuongBUS bus = new QLLuongBUS();
    private JPanel headerPanel, mainPanel;
    private JDateChooser dateChooser1, dateChooser2;

    public XemLichSu() {
        setLayout(new BorderLayout());
        initHeaderPanel();
        add(headerPanel, BorderLayout.PAGE_START);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(238,238,238));
        add(mainPanel, BorderLayout.CENTER);
    }
    private void initHeaderPanel() {
        JLabel label1 = new JLabel("Từ ngày: ");
        JLabel label2 = new JLabel("Đến ngày: ");
        dateChooser1 = new JDateChooser();
        dateChooser2 = new JDateChooser();
        dateChooser2.setDate(new Date());
        JButton xacNhanButton = new JButton("Tìm kiếm");
        xacNhanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initMainPanel();
            }
        });

        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(1,5,1));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(label1);
        headerPanel.add(dateChooser1);
        headerPanel.add(label2);
        headerPanel.add(dateChooser2);
        headerPanel.add(xacNhanButton);
    }
    private void initMainPanel() {
        mainPanel.removeAll();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

        LocalDate startDate = dateChooser1.getDate().toInstant().atZone(ZoneId.of("Asia/Singapore")).toLocalDate();
        LocalDate endDate = dateChooser2.getDate().toInstant().atZone(ZoneId.of("Asia/Singapore")).toLocalDate();

        YearMonth currentMonth = YearMonth.from(startDate);
        while (!currentMonth.isAfter(YearMonth.from(endDate))) {
            LocalDate date = LocalDate.of(currentMonth.getYear(), currentMonth.getMonth(), 1);
            String formattedMonth = currentMonth.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            System.out.println(date);
            tabbedPane.addTab(formattedMonth, new BangLuongPanel(date, bus.selectAllByDate(date)));
            currentMonth = currentMonth.plusMonths(1);
        }
        mainPanel.add(tabbedPane);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

}

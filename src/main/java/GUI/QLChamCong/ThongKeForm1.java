package GUI.QLChamCong;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import java.awt.*;

public class ThongKeForm1 extends JPanel{
    public ThongKeForm1() {
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("NV001 - Nguyễn Văn A", new JPanel().add(new JLabel("NV001")));
        tabbedPane.addTab("NV002 - Nguyễn Văn A", new JPanel().add(new JLabel("NV002")));
        tabbedPane.addTab("NV003 - Nguyễn Văn A", new JPanel().add(new JLabel("NV003")));
        tabbedPane.addTab("NV004 - Nguyễn Văn A", new JPanel().add(new JLabel("NV004")));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(2);
        TabbedPaneUI tabbedPaneUI = new TabbedPaneUI() {
            @Override
            public int tabForCoordinate(JTabbedPane pane, int x, int y) {
                return 0;
            }

            @Override
            public Rectangle getTabBounds(JTabbedPane pane, int index) {
                return new Rectangle(200,50);
            }

            @Override
            public int getTabRunCount(JTabbedPane pane) {
                return 0;
            }
        };
        tabbedPane.setUI(tabbedPaneUI);
        add(tabbedPane);
    }
}

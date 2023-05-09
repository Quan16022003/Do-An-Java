package GUI.XemThongTin;

import GUI.Model.Content;

import javax.swing.*;
import java.awt.*;

public class ViewInfo extends Content {
    private JPanel panel;
    public ViewInfo() {
        super();
        initPanel();
    }
    private void initPanel() {
        panel = new JPanel(new GridBagLayout());

    }
}

package GUI.modal;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {
    
    public RoundedLabel(String text) {
        super(text);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }
}
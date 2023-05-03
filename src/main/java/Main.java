import GUI.MainForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        
        SwingUtilities.invokeLater(() -> new MainForm("admin").setVisible(true));
    }
}

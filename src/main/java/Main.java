import GUI.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.SwingUtilities;
import GUI.MainForm;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        LOGGER.info("Starting main");
        FlatIntelliJLaf.setup();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}

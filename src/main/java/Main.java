import BLL.ToChuyenMonBLL;;
import GUI.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import GUI.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        // initialize all data
        ToChuyenMonBLL.getInstance();
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
            
        });
    }
}

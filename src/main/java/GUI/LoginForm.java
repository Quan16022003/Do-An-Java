package GUI;

import BLL.LoginBUS;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm extends JFrame implements KeyListener, ActionListener{
    private final Font font = new Font("Segoe UI", Font.PLAIN, 16);
    private final LoginBUS loginBUS = new LoginBUS();
    private JButton dangNhapButton;
    private JTextField userField;
    private JPasswordField passwordField;

    public LoginForm() throws HeadlessException {
        setSize(new Dimension(400,250));
        Color FRAME_COLOR = new Color(238, 238, 238);
        setBackground(FRAME_COLOR);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setResizable(false);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(34,40,49));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        ImageIcon icon = new ImageIcon("./src/main/java/Image/management_48px.png");
        setIconImage(icon.getImage());
        setTitle("QUẢN LÝ GIÁO VIÊN");
        setLayout(new BorderLayout());

        getContentPane().add(createForm(), BorderLayout.CENTER);

    }

    private JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;

        JLabel titleLabel = new JLabel("Đăng nhập");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridwidth = 2;
        form.add(titleLabel, gbc);

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;

        JLabel usrLabel = new JLabel("Tài khoản:");
        usrLabel.setFont(font);
        form.add(usrLabel, gbc);
        gbc.gridx = 1;
        userField = new JTextField(15);
        userField.setFont(font);
        userField.addKeyListener(this);
        form.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(font);
        form.add(passwordLabel, gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        passwordField.setFont(font);
        passwordField.addKeyListener(this);
        form.add(passwordField, gbc);

        dangNhapButton = new JButton("Đăng nhập");
        dangNhapButton.setPreferredSize(new Dimension(100, 32));
        dangNhapButton.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        form.add(dangNhapButton, gbc);

        return form;
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            dangNhapButton.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String validation = loginBUS.validateLogin(username, password);
        if (validation.equals("OK")) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            SwingUtilities.invokeLater(() -> new MainForm(username).setVisible(true));
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, validation);
            if (validation.equals("Mật khẩu không đúng"))
                passwordField.requestFocus();
            else
                userField.requestFocus();

        }
    }
}
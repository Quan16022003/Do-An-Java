/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.AccountBLL;
import BLL.ToChuyenMonBLL;
import DTO.Account;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author Nguyen Hoang Quan
 */

public class LoginForm extends JFrame implements KeyListener, ActionListener{
    private final Color FRAME_COLOR = new Color(238,238,238);
    private final Font font = new Font("Segoe UI", 0, 16);
    private final AccountBLL accountBLL = new AccountBLL();
    private HashMap<String, Account> loginInfo = accountBLL.getLoginInfo();
    private JButton dangNhapButton;
    private JTextField userField;
    private JPasswordField passwordField;
    
    public LoginForm() throws HeadlessException {
        setSize(new Dimension(400,250));
        setBackground(FRAME_COLOR);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(34,40,49));
        getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        ImageIcon icon = new ImageIcon("./src/main/java/Image/management_48px.png");
        setIconImage(icon.getImage());
        setTitle("QUẢN LÝ GIÁO VIÊN");
        setLayout(new BorderLayout());
        
        
        getContentPane().add(createForm(), BorderLayout.CENTER);
        getContentPane().add(createButtonsPanel(), BorderLayout.PAGE_END);
        
    }
    
    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        dangNhapButton = new JButton("Đăng nhập");
        dangNhapButton.setPreferredSize(new Dimension(90, 32));
        dangNhapButton.addActionListener(this);
        buttonsPanel.add(dangNhapButton);
        return buttonsPanel;
    }
    
    private JPanel createForm() {
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;
        gbc.insets.top = 5;

        JLabel usrLabel = new JLabel("Tài khoản:");
        usrLabel.setFont(font);
        form.add(usrLabel, gbc);
        gbc.gridx = 1;
        userField = new JTextField(15);
        userField.setFont(font);
        userField.addKeyListener(this);
        form.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(font);
        form.add(passwordLabel, gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        passwordField.setFont(font);
        passwordField.addKeyListener(this);
        form.add(passwordField, gbc);

        return form;
    }
    
    public static void main(String[] args) {
        FlatLightLaf.setup();
        // initialize all data
        ToChuyenMonBLL.getInstance();
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
            
        });
    }
    
    private boolean checkvalid() {
        if (userField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            return false;
        }

        return true;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (userField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
            } else {
                dangNhapButton.doClick();
            }
        }        
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userID = userField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        if (loginInfo.containsKey(userID)) {
            if (loginInfo.get(userID).getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                dispose();
                SwingUtilities.invokeLater(() -> {
                    new MainForm(userField.getText()).setVisible(true);
                });
            } else {
                JOptionPane.showMessageDialog(null, "Đăng nhập không thành công");
                passwordField.setText("");
                passwordField.requestFocus();
            }
        }
        else  {
            JOptionPane.showMessageDialog(null, "Tài khoản không tồn tại");
            userField.setText("");
            passwordField.setText("");
            userField.requestFocus();
        }
            
    }
}

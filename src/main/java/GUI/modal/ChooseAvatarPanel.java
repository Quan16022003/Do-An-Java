package GUI.modal;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ChooseAvatarPanel extends JPanel{
    private static final String imageDir = "/src/main/java/Image";

    private File imageFile;
    private Image avatarImage = null;
    private JLabel imageLabel;
    private JButton chooseButton;
    public ChooseAvatarPanel() {
        setLayout(new BorderLayout(1,0));
        setOpaque(true);
        setBackground(null);
        imageLabel = new JLabel();
        chooseButton = new JButton("Chọn ảnh");

        imageLabel.setPreferredSize(new Dimension(100,150));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice();
                imageLabel.setIcon(new ImageIcon(avatarImage));
            }
        });

        this.add(imageLabel, BorderLayout.CENTER);
        this.add(chooseButton, BorderLayout.SOUTH);
    }

    private void choice() {
        JFileChooser fileChooser = new JFileChooser();
        File currentDir = new File(System.getProperty("user.dir") + File.separator + imageDir);
        fileChooser.setCurrentDirectory(currentDir);
        // Set the file chooser to only allow selection of image files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            imageFile = fileChooser.getSelectedFile();
            // Read the image file and create a BufferedImage object
            try {
                BufferedImage img = ImageIO.read(imageFile);
                avatarImage = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDirectory() {
        return "." + imageDir + "/" + imageFile.getName();
    }
    
    public void setImage(String dir) {
        try {
            BufferedImage img = ImageIO.read(new File(dir));
            avatarImage = img.getScaledInstance(100, 150, Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(avatarImage));
           
        } catch (IOException ex) {
            Logger.getLogger(ChooseAvatarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    // EXAMPLE
    
}

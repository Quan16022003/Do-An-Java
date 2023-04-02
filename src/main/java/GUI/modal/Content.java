/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.modal;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Hoang Quan
 */
public abstract class Content extends JPanel{
    final Dimension CONTENT_SIZE = new Dimension(1080, 688);
    public Content() {
        setPreferredSize(CONTENT_SIZE);
    }
}

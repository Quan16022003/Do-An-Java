/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
/**
 *
 * @author ADMIN
 */
public class BindingListener<T> implements DocumentListener{
    private final JTextComponent parent;
    private final Pattern pattern;

    public BindingListener(JTextComponent parent, T model, Consumer<String> setFunction) {
        this(parent, ".*");
    }

    public BindingListener(JTextComponent parent, String validationPattern) {
        this.parent = parent;
        System.out.println(validationPattern);
        this.pattern = Pattern.compile(validationPattern);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        dataUpdated(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        dataUpdated(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        dataUpdated(e);
    }

    private void dataUpdated(DocumentEvent e) {
        try {
            String text = e.getDocument().getText(
                    e.getDocument().getStartPosition().getOffset(),
                    e.getDocument().getEndPosition().getOffset() - 1);
            if (text.matches(pattern.pattern())) {
                parent.setBackground(new Color(195, 232, 141));
            }
            else {
                parent.setBackground(new Color(244, 171, 171));
            }


        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

}

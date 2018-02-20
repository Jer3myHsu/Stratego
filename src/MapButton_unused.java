import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapButton_unused extends JButton implements MouseListener {//Unused
	Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.decode("#ffffff");//Unused
    Color backgroundColor = Color.decode("#000000");
    Color hoverColor = Color.decode("#FFD800");
    Color disabledColor = Color.lightGray;
    
    public MapButton_unused(String s) {
        s = s.toUpperCase();
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setText(s);
        this.setBorder(BorderFactory.createEmptyBorder(
                1, 1, 1, 1));
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(false);
        addMouseListener(this);
    }
    public MapButton_unused(ImageIcon image, ImageIcon disabledImage) {
        this.setFocusPainted(false);
        this.setDisabledIcon(disabledImage);//This prevents image going grey when disabled
        this.setIcon(image);
        this.setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, backgroundColor));       
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
        addMouseListener(this);
    }
    public void setBackgroundColor(Color color) {
        backgroundColor = color; 
    }
    public void setHoverColor(Color color) {
        hoverColor = color; 
    }
    public void setMapEnabled(boolean enable) {
    	this.setEnabled(enable);
    	if (enable) {
    		this.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, backgroundColor)); 
    	} else {
    		this.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, disabledColor)); 
    	}
    }
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) { 
        if (e.getSource()==this && this.isEnabled()) {  
            this.setBackground(this.hoverColor);
            this.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, hoverColor)); 
        } else if (e.getSource()==this) {
        	this.setBackground(this.disabledColor);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) { 
        if (e.getSource()==this && this.isEnabled()) { 
            this.setBackground(this.backgroundColor);
            this.setBorder(BorderFactory.createMatteBorder(
                    1, 1, 1, 1, backgroundColor)); 
        } else if (e.getSource()==this) {
        	this.setBackground(this.disabledColor);
        }
    }
}

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapButton extends JButton {
	int x, y;
    public MapButton(ImageIcon image) {
        this.setIcon(image);
    }
    public void setCoordinate(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    public int getXCoordinate() {
    	return x;
    }
    public int getYCoordinate() {
    	return y;
    }
}

import java.awt.*;

public class Star {
	
	public static Point position;
	private Color color;
	private int winRadius;

	public Star(int r, Color c) {
		color = c;
		winRadius = r;
	}
	
	public void setPosition(Point p) {
		position = p;
	}
	
	public void setRadius(int r) {
		winRadius = r; 
	}

	public Point getPosition() {
		return position;
	}
	
	
	
	

}

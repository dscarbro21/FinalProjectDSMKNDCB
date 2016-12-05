import java.awt.Point;

public class Wall {

	private Point pt1;
	private Point pt2;
	private char orientation;
	public static final int WALL_THICKNESS = 5;
	
	public Wall(Point p1, Point p2, char o) {
		//pt1 = p1;
		//pt2 = p2;
		setPosition(p1, p2);
		orientation = o;
	}
	
	public void setPosition(Point p1, Point p2) {
		pt1 = p1;
		pt2 = p2;
	}
	
	public Point getPoint1() {
		return pt1;
	}
	public Point getPoint2() {
		return pt2;
	}

	public char getOrientation() {
		return orientation;
	}
	
}

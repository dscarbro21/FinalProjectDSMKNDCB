import java.awt.*;

public class Ball {

	private Color color;
	private int radius;
	private int xVelocity;
	private int yVelocity;
	private Point position;
	private int life;
	
	public Ball(int r, Color c) {
		xVelocity = 0;
		yVelocity = 0;
		radius = r;
		color = c;
		life = 80;
	}
}

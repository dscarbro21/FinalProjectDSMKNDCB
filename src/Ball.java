import java.awt.*;

public class Ball {

	private Color color;
	private int radius;
	private int xVelocity;
	private int yVelocity;
	private Point position;
	private Point initPosition;
	private int hits;
	
	public final int LIFE = 80;
	
	public Ball(int r, Color c) {
		xVelocity = 0;
		yVelocity = 0;
		radius = r;
		color = c;
		hits = 0;
	}
	
	public void setRadius(int r) {
		radius = r;
	}
	
	public void setPosition(Point p) {
		position = p;
		initPosition = p;
	}
	
	public boolean checkCollision() {		// EDIT LATER
		return false;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setVelocity(int x, int y) {
		xVelocity = x;
		yVelocity = y;
	}
	
	public int getXVelocity() {
		return xVelocity;
	}
	
	public int getYVelocity() {
		return yVelocity;
	}
	
	public void update() {
		position.setLocation(position.getX()+xVelocity, position.getY()+yVelocity);
	}
	
	public int getCollisionAngle() {		// EDIT LATER
		return 45;
	}
	
	public boolean didWin() {
		return false;
	}
	
	public void launch(Launcher launcher)
	{
		
		double temp = (launcher.getAngle() * (Math.PI / 180));
		xVelocity = (int) Math.cos(temp) * launcher.getPower();
		yVelocity = (int) Math.sin(temp) * launcher.getPower();
		
	}

	public int getXPosition() {
		return position.x;
	}
	
	public int getYPosition() {
		return position.y;
	}

	public void reset() {
		position = initPosition;
		hits = 0;
		
	}
}

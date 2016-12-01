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
	
	private LevelGame level = LevelGame.getInstance();
	
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
	}
	
	public boolean checkCollision() {		// EDIT LATER
		for (Wall w : level.getWalls()) {
			if (w.getOrientation() == 'H') {
				if (w.getPoint1().getY() >= position.getY() && w.getPoint1().getY() <= position.getY() + radius*2) {
					if (position.getX() + radius*2 >= w.getPoint1().getX() && position.getX() <= w.getPoint2().getX()) {
						hits++;
						yVelocity = -yVelocity;
						if (xVelocity < 0) { xVelocity += 1; }
						else if (xVelocity > 0) { xVelocity -= 1; }
						if (yVelocity < 0) { yVelocity += 1; }
						else if (yVelocity > 0) { yVelocity -= 1; }
						return true;
					}
				}
			}
			else if (w.getOrientation() == 'V') {
				if (w.getPoint1().getX() >= position.getX() && w.getPoint1().getX() <= position.getX() + radius*2) {
					if (position.getY() + radius*2 >= w.getPoint1().getY() && position.getY() <= w.getPoint2().getY()) {
						hits++;
						xVelocity = -xVelocity;
						if (xVelocity < 0) { xVelocity += 1; }
						else if (xVelocity > 0) { xVelocity -= 1; }
						if (yVelocity < 0) { yVelocity += 1; }
						else if (yVelocity > 0) { yVelocity -= 1; }
						return true;
					}
				}
			}
		}
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
		
		if(position.equals(Star.position))
		{
			LevelGame.getInstance().nextLevel();
			return true;
		}
		
		return false;
	}
	
	public void launch(Launcher launcher)
	{
		
		double temp = (launcher.getAngle() * (Math.PI / 180));
		xVelocity = (int) (Math.cos(temp) * launcher.getPower());
		yVelocity = -(int) (Math.sin(temp) * launcher.getPower()); //Negative sign is needed to account for coordinate system of JFrame starting in top left corner
		
	}

	public int getXPosition() {
		return (int) position.getX();
	}
	
	public int getYPosition() {
		return (int) position.getY();
	}

	public void reset() {
		position = initPosition;
		hits = 0;
		
	}

	public void setStartPosition(Point point) {
		position = point;
		initPosition = new Point(point);
	}

	
	//testing purposes
	@Override
	public String toString() {
		return "Ball [radius=" + radius + ", position=" + position + ", initPosition=" + initPosition + "]";
	}
	
	
	
}

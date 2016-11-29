import java.awt.Point;

public class Launcher {
	
	private Point position;
	private int angle;
	private int power;

	public Launcher(int angle, int power) {
		this.angle = angle;
		this.power = power;
	}
	
	public void setAngle(int angle)
	{
		this.angle = angle;
	}
	
	public void setPower(int power)
	{
		this.power = power;
	}
	
	public void setPosition(Point pos)
	{
		position = pos;
	}

	public int getAngle() {
		
		return angle;
	}

	public int getPower() {
		return power;
	}

}

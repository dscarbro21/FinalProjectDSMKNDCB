import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CollisionAngle {
	private int angle;
	private int x;
	private int y;
	private int life;
	public CollisionAngle(int a, int x, int y) {
		angle = a;
		this.x = x;
		this.y = y;
		life = 10;
	}
	public void display(Graphics g) {
		life--;
		g.setColor(Color.BLACK);
		g.setFont(new Font("Impact", Font.PLAIN, 40));
		if (life > 0) {
			g.drawString(String.valueOf(angle), x, y);
		}
	}
}

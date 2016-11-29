import static org.junit.Assert.*;

import java.awt.*;

import org.junit.Test;


public class Tests {
	Ball ball = new Ball(3, Color.WHITE);
	Wall wall = new Wall(new Point(10,10), new Point(100,10));
	Star star = new Star(2, Color.BLUE);
	LevelGame game = new LevelGame();
	Launcher launcher = new Launcher(5, 5);
	int t = 0;
	
	@Test
	public void testCollisions() {
		wall.setPosition(new Point(10,10), new Point(100,10));
		ball.setRadius(20);
		ball.setPosition(new Point(60,60));
		assertFalse(ball.checkCollision());
		
		ball.setPosition(new Point(30, 30));
		assertTrue(ball.checkCollision());
		assertTrue(ball.getHits() == 1);
		
		ball.setPosition(new Point(10,60));
		ball.setVelocity(10, -10);
		while(t <= 6) {
			ball.update();
			t++;
			if (t == 3) {
				assertTrue(ball.checkCollision());
			}
			else if (t > 3) {
				assertTrue(ball.getYVelocity() > 0);
				assertTrue(ball.getXVelocity() < 10);
				assertTrue(ball.getCollisionAngle() == 315);
				assertTrue(ball.getHits() == 2);
			}
		}
	}
	
	@Test
	public void testGoal() {
		t = 0;
		game.setLevel(1);
		star.setPosition(new Point(68,45));
		star.setRadius(3);
		ball.setRadius(30);
		ball.setPosition(new Point(20,20));
		assertFalse(ball.didWin());
		
		ball.setRadius(70);
		assertTrue(ball.didWin());
		
		ball.setRadius(10);
		ball.setVelocity(48,25);
		
		while (t <= 1) {
			ball.update();
			++t;
			if (t == 1) {
				assertTrue(ball.didWin());
				assertTrue(game.getLevel() == 2);
			}
		}
	}
	
	@Test
	public void testLaunch() {
		launcher.setAngle(315);
		launcher.setPower(10);
		launcher.setPosition(new Point(10,10));
		ball.setStartPosition(new Point(10,10));
		ball.launch(launcher);
		
		t = 0;
		
		while (t <= 2) {
			ball.update();
			t++;
			System.out.println("Update \t" + ball.getYVelocity());
		}
		
		assertTrue(Math.abs(30 - ball.getXPosition()) < 2);
		assertTrue(Math.abs(30 - ball.getYPosition()) < 2);
		
	}
	
	@Test
	public void testReset() {
		ball.setStartPosition(new Point(3,1));
		ball.setVelocity(300,6);
		t = 0;
		
		while (t <= 77) {
			ball.update();
			++t;
		}
		
		ball.reset();
		
		assertEquals(ball.getXPosition(), 3);
		assertEquals(ball.getYPosition(), 1);
		assertEquals(ball.getHits(), 0);
	}
	
}

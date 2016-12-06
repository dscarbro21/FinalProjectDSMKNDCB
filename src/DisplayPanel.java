import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPanel extends JPanel {
	
	boolean hasStart, funTime, gameTime, info, launched;
	Color fun, otherFun, startBut, startButText, instBut, instButText;
	Timer t;
	LevelGame theInstance = LevelGame.getInstance();
	
	//Listeners
	StartInstListener starter;
	HomeButtonsListener homeButtons;
	AngleListener angleBar;
	PowerListener powerBar;
	ColorListener colorChooser;
	LaunchListener launchButton;
	ResetListener resetButton;
	
	Font garamond, arial, jokerman, impact;
	
	
	public DisplayPanel() {
		hasStart = true;
		funTime = true;
		gameTime = false;
		info = false;
		launched = false;
		fun = Color.YELLOW;
		otherFun = Color.RED;
		startBut = Color.BLUE;
		instBut = Color.BLUE;
		startButText = Color.WHITE;
		instButText = Color.WHITE;
		
		arial = new Font("Arial", Font.BOLD, 30);
		impact = new Font("Impact", Font.PLAIN, 40);
		jokerman = new Font("Jokerman", Font.BOLD, 75);
		garamond = new Font("Garamond", Font.BOLD, 60);
		
		//Set timer for fun time to flash
		t = new Timer(500, new TimerListener());
		t.start();
		
		//Add action listeners here to avoid stack overflow as if done in paint method
		starter = new StartInstListener();
		homeButtons = new HomeButtonsListener();
		angleBar = new AngleListener();
		powerBar = new PowerListener();
		colorChooser = new ColorListener();
		launchButton = new LaunchListener();
		resetButton = new ResetListener();
		
		addMouseMotionListener(starter);
		addMouseListener(homeButtons);

	}
	
	private class TimerListener implements ActionListener {				// "Fun Time" flashes colors, also acts as animation timer
		public void actionPerformed(ActionEvent e) {
			if (funTime == true) {
				fun = Color.RED;
				otherFun = Color.YELLOW;
				funTime = false;
				repaint();
			}
			else {
				fun = Color.YELLOW;
				otherFun = Color.RED;
				funTime = true;
				repaint();
			}
			
			if (gameTime == true) {
				repaint();
			}
		}
	}
	
	private class StartInstListener implements MouseMotionListener {				// If you hover over a button, it changes colors

		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
			if (e.getX() > 299 && e.getX() < 601 && e.getY() > 549 && e.getY() < 651) {
				startBut = Color.GREEN;
				startButText = Color.BLACK;
				repaint();
			}
			else if (e.getX() > 299 && e.getX() < 601 && e.getY() > 674 && e.getY() < 776) {
				instBut = Color.GREEN;
				instButText = Color.BLACK;
				repaint();
			}
			else {
				startBut = Color.BLUE;
				instBut = Color.BLUE;
				startButText = Color.WHITE;
				instButText = Color.WHITE;			
			}
		}

	}
	
	private class HomeButtonsListener implements MouseListener {				// If you click on a button in the home screen, you get directed to the correct area
		public void mouseClicked(MouseEvent e) {
			if (e.getX() > 299 && e.getX() < 601 && e.getY() > 549 && e.getY() < 651) {
				hasStart = false;
				gameTime = true;
				
				removeMouseMotionListener(starter);
				removeMouseListener(homeButtons);
				addMouseListener(angleBar);
				addMouseListener(powerBar);
				addMouseListener(colorChooser);
				addMouseListener(launchButton);
				addMouseListener(resetButton);
				
				t.stop();
				t = new Timer(10, new TimerListener());
				t.start();
			}
			else if (e.getX() > 299 && e.getX() < 601 && e.getY() > 674 && e.getY() < 776) {
				hasStart = false;
				info = true;
			}			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class AngleListener implements MouseListener {				// Select the angle
		public void mouseClicked(MouseEvent e) {
			if (e.getX() >= 60 && e.getX() <= 360 && e.getY() >= 665 && e.getY() <= 755) {
				theInstance.getLauncher().setAngle((int)(((double)e.getX() - 60.0)/300 * 360));
				
			}			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class PowerListener implements MouseListener {				// Select the power
		public void mouseClicked(MouseEvent e) {
			if (e.getX() >= 60 && e.getX() <= 360 && e.getY() >= 770 && e.getY() <= 810) {
				theInstance.getLauncher().setPower((int)(((double)e.getX() - 60.0)/300.0 * 50.0));
				//System.out.println((int)(((double)e.getX() - 60.0)/300.0 * 10.0));
				
			}			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class ColorListener implements MouseListener {				// Change color of ball
		public void mouseClicked(MouseEvent e) {
			if (e.getX() >= 480 && e.getX() <= 530 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.BLACK);
			}	
			else if (e.getX() >= 540 && e.getX() <= 590 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.BLUE);
			}
			else if (e.getX() >= 600 && e.getX() <= 650 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.RED);
			}	
			else if (e.getX() >= 660 && e.getX() <= 710 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.GREEN);
			}
			else if (e.getX() >= 720 && e.getX() <= 770 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.YELLOW);
			}
			else if (e.getX() >= 770 && e.getX() <= 820 && e.getY() >= 740 && e.getY() <= 790) {
				theInstance.getBall().setColor(Color.MAGENTA);
			}
			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class LaunchListener implements MouseListener {				// Launches ball
		public void mouseClicked(MouseEvent e) {
			if (e.getX() >= 460 && e.getX() <= 660 && e.getY() >= 615 && e.getY() <= 665) {
				theInstance.getBall().launch(theInstance.getLauncher());
				launched = true;
			}	
			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	private class ResetListener implements MouseListener {				// Resets ball to start position
		public void mouseClicked(MouseEvent e) {
			if (e.getX() >= 675 && e.getX() <= 875 && e.getY() >= 615 && e.getY() <= 665) {
				theInstance.getBall().reset();
				launched = false;
			}	
			
		}
		public void mouseEntered(MouseEvent e) {			
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (hasStart == true) {	// Draws Home Screen
			g.setColor(Color.WHITE);
			g.setFont(garamond);
			g.drawString("Angular Deflection of", 175, 200);
			g.drawString("Spherical Masses", 232, 290);
			g.setColor(fun);
			g.setFont(jokerman);
			g.drawString("FUN TIME", 247, 430);
			g.setColor(otherFun);
			g.drawOval(200, 330, 500, 140);
			g.drawLine(450, 310, 450, 350);
			g.drawLine(450, 450, 450, 490);
			g.drawLine(190, 400, 210, 400);
			g.drawLine(690, 400, 710, 400);
			g.setColor(startBut);
			g.fillRect(300, 550, 300, 100);
			g.setColor(instBut);
			g.fillRect(300, 675, 300, 100);
			g.setColor(startButText);
			g.setFont(impact);
			g.drawString("START GAME", 353, 615);
			g.setColor(instButText);
			g.drawString("INSTRUCTIONS", 335, 742);
		}
		
		if(gameTime == true) {
			//THESE CAUSE STACK OVERFLOW IF DONE HERE
//			addMouseListener(new AngleListener());
//			addMouseListener(new PowerListener());
//			addMouseListener(new ColorListener());
//			addMouseListener(new LaunchListener());
//			addMouseListener(new ResetListener());
			
			
			
			//Draw main screen
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 900, 600);
			//Draw bottom menus
			g.fillRect(5, 605, 440, 280);
			g.fillRect(450, 605, 440, 280);
			//Write menu 
			g.setColor(Color.BLACK);
			g.setFont(arial);
			g.drawString("Angle:", 10, 650);
			g.drawString("Power:", 10, 755);
			g.drawString("0", 30, 695);
			g.drawString("360", 365, 695);
			g.drawString("0", 30, 800);
			g.drawString("10", 365, 800);
			g.setColor(Color.BLUE);
			//Angle selector
			g.fillRect(60, 665, 300, 40);
			g.setColor(Color.GREEN);
			g.fillRect(60, 665, (int)(theInstance.getLauncher().getAngle()/360.0 * 300), 40);
			//Power Selector
			g.setColor(Color.BLUE);
			g.fillRect(60, 770, 300, 40);
			g.setColor(Color.GREEN);
			g.fillRect(60, 770, (int)(theInstance.getLauncher().getPower()/50.0 * 300), 40);
			
			g.setColor(Color.BLUE);
			//Launch button
			g.drawRect(460, 615, 200, 50);
			//Reset Button
			g.drawRect(675, 615, 200, 50);
			g.drawString("LAUNCH", 500, 655);
			g.drawString("Reset", 730, 655);
			
			//Color picker
			g.setColor(Color.BLACK);
			g.drawString("Ball Color:", 480, 720);

			g.fillOval(480, 740, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(540, 740, 50 , 50);
			g.setColor(Color.RED);
			g.fillOval(600, 740, 50, 50);
			g.setColor(Color.GREEN);
			g.fillOval(660, 740, 50, 50);
			g.setColor(Color.YELLOW);
			g.fillOval(720, 740, 50, 50);
			g.setColor(Color.MAGENTA);
			g.fillOval(780, 740, 50, 50);
			
			
			//paint ball
			if(launched == true) {
				theInstance.getBall().update();
				theInstance.getBall().checkCollision(theInstance.getWalls());
			}
			
			g.setColor(theInstance.getBall().getColor());
			g.fillOval(theInstance.getBall().getXPosition(), theInstance.getBall().getYPosition(), theInstance.getBall().getSize(), theInstance.getBall().getSize());
		
			
			//paint walls
			g.setColor(Color.BLACK);
			for(Wall w: theInstance.getWalls())
			{
				g.drawLine(w.getPoint1().x, w.getPoint1().y, w.getPoint2().x, w.getPoint2().y);
			}
			
			//draw the goal
			g.setColor(theInstance.getStar().getColor());
			g.fillRect(theInstance.getStar().getPosition().x, theInstance.getStar().getPosition().y, theInstance.getStar().getWinRadius(),theInstance.getStar().getWinRadius());
			
			//draw the launcher
			g.setColor(Color.BLACK);
			g.fillRect(theInstance.getLauncher().getPosition().x, theInstance.getLauncher().getPosition().y, 75, 100);
			
		}

	}
	
}

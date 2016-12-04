import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayPanel extends JPanel {
	
	boolean hasStart, funTime, gameTime, info;
	Color fun, otherFun, startBut, startButText, instBut, instButText;
	Timer t;
	
	public DisplayPanel() {
		hasStart = true;
		funTime = true;
		gameTime = false;
		info = false;
		fun = Color.YELLOW;
		otherFun = Color.RED;
		startBut = Color.BLUE;
		instBut = Color.BLUE;
		startButText = Color.WHITE;
		instButText = Color.WHITE;
		
		Timer t = new Timer(1000, new TimerListener());
		t.start();

	}
	
	private class TimerListener implements ActionListener {				// "Fun Time" flashes colors
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (hasStart == true) {										// Draws Home Screen
			addMouseMotionListener(new StartInstListener());
			addMouseListener(new HomeButtonsListener());
			g.setColor(Color.WHITE);
			g.setFont(new Font("Garamond", Font.BOLD, 60));
			g.drawString("Angular Deflection of", 175, 200);
			g.drawString("Spherical Masses", 232, 290);
			g.setColor(fun);
			g.setFont(new Font("Jokerman", Font.BOLD, 75));
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
			g.setFont(new Font("Impact", Font.PLAIN, 40));
			g.drawString("START GAME", 353, 615);
			g.setColor(instButText);
			g.drawString("INSTRUCTIONS", 335, 742);
		}
		
		if(gameTime == true) {
			JPanel gameScreen = new JPanel();
			gameScreen.setSize(900, 600);
			gameScreen.setBackground(Color.WHITE);
			add(gameScreen);
		}

	}
	
}

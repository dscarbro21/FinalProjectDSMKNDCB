import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelGame extends JFrame {
	private int currentLevel;
	

	public LevelGame() {
		currentLevel = 1;

		setSize(900, 900);
		setTitle("Angular Deflection of Spherical Masses fun time"); //Probably change this?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		JPanel panel = new DisplayPanel();
//		add(panel);
//		panel = new ColorChooser();
//		add(panel);
//		panel = new AngleChooser();
//		add(panel); 
	}

	public void setLevel(int l) {
		currentLevel = l;
	}
	
	public int getLevel() {
		return currentLevel;
	}

	
	public static void main(String [] args) {
		LevelGame gui = new LevelGame();
		gui.setVisible(true);
	}
}
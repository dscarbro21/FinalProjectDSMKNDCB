import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGame extends JFrame {
	private int currentLevel = 1;

	// variable used for singleton pattern
	private static LevelGame theInstance = new LevelGame();
	
	
	
	public static LevelGame getInstance() {
		return theInstance;
	}

	private LevelGame() {
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

	public void nextLevel(){
		currentLevel++;
	}
	
	public void setLevel(int i){
		currentLevel = i;
	}
	
	public int getLevel() {
		return currentLevel;
	}


	public static void main(String [] args) {
		LevelGame gui = new LevelGame();
		gui.setVisible(true);
	}
}
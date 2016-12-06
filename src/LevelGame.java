import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class LevelGame extends JFrame {
	private int currentLevel = 1;
	ArrayList<Wall> walls = new ArrayList<Wall>();
	Ball ball;
	Star star;
	Launcher launcher;
	private JPanel pane;

	// variable used for singleton pattern
	private static LevelGame theInstance = new LevelGame();



	public static LevelGame getInstance() {
		return theInstance;
	}

	private LevelGame() {
		currentLevel = 1;
		pane = new DisplayPanel();

		setSize(900, 900);
		setTitle("Angular Deflection of Spherical Masses Fun Time"); //yeah
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pane.setBackground(Color.BLACK);
		add(pane);

		//		JPanel panel = new DisplayPanel();
		//		add(panel);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());

		ball = new Ball(50, Color.BLACK);
		star = new Star(50, Color.YELLOW);
		launcher = new Launcher(0, 0);
		
		level1();
	}

	private JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.add(createSelectLevelItem());
		menu.add(createFileExitItem());
		return menu;
	}

	private JMenuItem createFileExitItem(){
		JMenuItem item = new JMenuItem("Exit");

		class MenuItemListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			} 
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	private JMenuItem createSelectLevelItem(){
		JMenuItem i = new JMenuItem("Select Level");

		// MAKE THIS DO THINGS
		return i;
	}

	public void nextLevel(){
		currentLevel++;
		levelChange();
		ball.reset();
	}

	public void setLevel(int i){
		currentLevel = i;
		levelChange();
	}

	public void levelChange()
	{
		walls.clear();
		
		//congrats for advancing to next level splash screen
		
		switch(currentLevel)
		{
		case 1: 
			level1();
			break;
		case 2: 
			level2();
			break;
		case 3: 
			level3();
			break;
		case 4:
			level4();
			break;
		case 5:
			level5();
			break;
		case 6:
			level6();
			break;
		case 7:
			level7();
			break;
		case 8:
			level8();
			break;
		case 9:
			level9();
			break;
		case 10:
			level10();
			break;
		default:
			//BEAT THE GAME CONGRATS SCREEN
			//TELL THE PLAYER THE LEVEL WILL BE RESET TO 1
			level1();
			
		}
	}

	public int getLevel() {
		return currentLevel;
	}

	public ArrayList<Wall> getWalls() {
		return walls;
	}
	public void addWall(Wall w) {
		walls.add(w);
	}

	public Ball getBall() {
		return ball;
	}
	
	public Star getStar() {
		return star;
	}

	public Launcher getLauncher() {
		return launcher;
	}

	public static void main(String [] args) {
		LevelGame gui = new LevelGame();
		gui.setVisible(true);
	}

	
	
	public void level1()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));
		
		//goal
		star.setPosition(new Point(750,300));
				
	}

	public void level2()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(100,50));
		ball.setStartPosition(new Point(100, 50));
		ball.reset();
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls
		addWall(new Wall( new Point(50,250), new Point (600, 250), 'H'));

		//goal
		star.setPosition(new Point(100, 400));

		//ball size
		ball.setRadius(25);
	}

	public void level3()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size
	}

	public void level4()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size

	}

	public void level5()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size

	}

	public void level6()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size

	}

	public void level7()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size

	}

	public void level8()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size
	}

	public void level9()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size
	}

	public void level10()
	{
		//launcher and ball start position
		launcher.setPosition(new Point(300,300));
		ball.setStartPosition(new Point(300, 300));
		
		//bounding walls
		addWall(new Wall( new Point(50,25), new Point (850,25), 'H'));
		addWall(new Wall( new Point(50,25), new Point (50, 550), 'V'));
		addWall(new Wall( new Point(50,550), new Point (850, 550), 'H'));
		addWall(new Wall( new Point(850,25), new Point (850, 550), 'V'));

		//interior walls

		//goal

		//ball size
	}
}
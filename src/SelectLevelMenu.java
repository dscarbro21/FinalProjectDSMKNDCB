import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SelectLevelMenu extends JDialog{
	private JComboBox<String> levels;
	LevelGame game;
	private boolean isValid;

	public SelectLevelMenu() {
		isValid = true;
		setTitle("Select a Level");
		setSize(200,100);
		setLayout(new GridLayout(2,1));
		game = LevelGame.getInstance();
		
		levels = ComboMaker();
		add(levels);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isValid == true) {
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "You must pick a level you completed already, or have started", "Invalid Level!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(button);
	}
	
	private JComboBox<String> ComboMaker() {
		JComboBox<String> j = new JComboBox<String>();
		String str;
		for (int i = 1; i <= LevelGame.MAX_LEVELS; ++i) {
			str = Integer.toString(i);
			j.addItem(str);
		}
		
		j.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	int k = Integer.parseInt(j.getSelectedItem().toString());
		    	if (k > game.getHighestLevel()) {
		    		isValid = false;
		    	}
		    	else {
		    		game.setLevel(k);
		    		isValid = true;
		    	}
		    }
		});
		
		return j;
	}

}

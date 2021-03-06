package frame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import menu.Menu;

public class Frame {
	
	public JFrame frame;
	
	private MainPanel panel;
	private Menu menu;
	
	public Frame(String title, int width, int height) {
		frame = new JFrame(title);
		
		setBounds(width, height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new MainPanel();
		frame.setContentPane(panel);
		
		menu = new Menu();
		Menu.initMenu1(menu);
		menu.addMenus();
		frame.setJMenuBar(menu.menuBar);
		
		this.frame.setVisible(true);
	}
	
	private void setBounds(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (int) ((screenSize.width - width)*0.5);
		int y = (int) ((screenSize.height - height)*0.5);
		
		frame.setBounds(x, y, width, height);
	}
	
}

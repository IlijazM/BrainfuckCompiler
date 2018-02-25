package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import compile.Command;
import frame.Frame;

public class Main {
	
	static Frame frame;
	
	public static void main(String[] args) {
		setLookAndFeel();
		
		Command.Init();
		
		frame = new Frame("Brainfuck compiler", 800, 500);
	}
	
	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
}

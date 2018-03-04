package menu.menubar;

import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import compile.Command;
import menu.MenuHandler;

class Help_Commands extends MenuHandler {

	@Override
	public String name() {
		return "Command";
	}

	@Override
	public MenuHandler[] getItems() {
		MenuHandler[] menus = new MenuHandler[Command.commands.size()];
		
		for (int i = 0; i < menus.length; i++) {
			final int index = i;
			
			menus[i] = new MenuHandler() {
				@Override
				public String name() {
					return Command.commands.get(index).name();
				}
				
				@Override
				public MenuHandler[] getItems() {
					return null;
				}
				
				@Override
				public void action() {
					JOptionPane.showMessageDialog(null, Command.commands.get(index).description(), Command.commands.get(index).name(), JOptionPane.INFORMATION_MESSAGE);
				}
			};
		}
		
		return menus;
	}

	@Override
	public void action() {
	}
	
}

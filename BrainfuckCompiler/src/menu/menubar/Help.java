package menu.menubar;

import menu.MenuHandler;

public class Help extends MenuHandler {

	@Override
	public String name() {
		return "Help";
	}

	@Override
	public MenuHandler[] getItems() {
		return new MenuHandler[] {
				new Help_Commands(),
		};
	}

	@Override
	public void action() {
	}
	
}

package menu.menubar;

import menu.MenuHandler;
import menu.Separator;

public class File extends MenuHandler {

	@Override
	public String name() {
		return "File";
	}

	@Override
	public MenuHandler[] getItems() {
		return new MenuHandler[] {
				new Separator(),
				new File_Exit(),
		};
	}

	@Override
	public void action() {
	}
	
	
	
}

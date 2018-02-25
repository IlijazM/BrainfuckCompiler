package menu;

public class Separator extends MenuHandler {

	@Override
	public String name() {
		return "Separator";
	}

	@Override
	public MenuHandler[] getItems() {
		return null;
	}

	@Override
	public void action() {
	}

}

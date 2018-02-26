package compile;

import java.util.ArrayList;

public abstract class Command {
	
	public static ArrayList<Command> commands;
	
	public static void Init() {
		commands = new ArrayList<>();
		
		commands.add(new Add());
	}
	
	public static void executeAll(String string) {
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);
			
			command.execute(string);
		}
	}
	
	public void execute(String string) {
		int index = string.indexOf(' ');
		
		System.out.println(index);
		
		if (index >= 0) {
			String begin = string.substring(0, index);
			
			if (begin.equalsIgnoreCase(name())) {
				String[] args = string.split(" ");
				
				convert(args);
			}
		}
	}
	
	public abstract String name();
	
	public abstract String convert(String[] args);
}

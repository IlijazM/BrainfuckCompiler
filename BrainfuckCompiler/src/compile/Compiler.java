package compile;

public class Compiler {
	
	public static int pointer;
	public static int[] mem;
	
	private static String out;
	
	public static String compileCode(String code) {
		out = "";
		
		pointer = 0;
		mem = new int[256];
		
		String[] lines = code.split(System.lineSeparator());
		
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			Command.executeAll(line);
		}
		
		return out;
	}
	
	public static void appendCode(String string) {
		out += string;
	}
	
}

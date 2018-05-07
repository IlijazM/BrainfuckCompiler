package compile;

import java.util.ArrayList;

public abstract class Command {
	
	static ArrayList<String> vars;
	static ArrayList<Integer> mode;
	static ArrayList<String> functions;
	static ArrayList<Integer> functionsPointer;
	public static ArrayList<Command> commands;
	
	public static void Init() {
		vars = new ArrayList<>();
		mode = new ArrayList<>();
		functions = new ArrayList<>();
		functionsPointer = new ArrayList<>();
		commands = new ArrayList<>();
		
		commands.add(new Comment());
		commands.add(new Set());
		commands.add(new Move());
		commands.add(new Add());
		commands.add(new Sub());
		commands.add(new Print());
		commands.add(new Log());
		commands.add(new Txt());
		commands.add(new Sum());
		commands.add(new Input());
		commands.add(new _Equals());
		commands.add(new Invert());
		commands.add(new Not());
		commands.add(new While());
		commands.add(new For());
		commands.add(new If());
		commands.add(new End());
	}
	
	public static void append(String s) {
		Compiler.appendCode(s);
	}
	
	public static void executeAll(String string) {
		for (int i = 0; i < commands.size(); i++) {
			Command command = commands.get(i);
			
			command.execute(string, i + 1);
		}
		
		String a = "";
		
		for (int i = 0; i < vars.size(); i++) {
			a += "  |  " + vars.get(i);
		}
		
		// System.out.println("[" + Compiler.pointer + "] " + string);
		// System.out.println(a);
	}
	
	static int getPointer(String s) {
		try {
			for (int i = 0; i < vars.size(); i++) {
				if (vars.get(i).equals(s)) {
					return i;
				}
			}
			
			vars.add(s);
			Compiler.mem[vars.size() - 1] = 1;
			return vars.size() - 1;
		} catch (Exception e) {
			
		}
		
		return -1;
	}
	
	static void gotoc(int i) {
		int j = Compiler.pointer - i;
		
		if (j > 0) {
			for (int k = 0; k < j; k++) {
				append("<");
			}
		} else {
			j = -j;
			
			for (int k = 0; k < j; k++) {
				append(">");
			}
		}
		
		Compiler.pointer = i;
	}
	
	static int findTempMem() {
		for (int i = 0; i < Compiler.mem.length; i++) {
			if (Compiler.mem[i] == 0) {
				Compiler.mem[i] = 2;
				return i;
			}
		}
		
		return -1;
	}
	
	static void add(int amount) {
		if (amount > 15) {
			int p = Compiler.pointer;
			
			Compiler.mem[p] = 1;
			
			int m1 = (int) Math.sqrt(amount);
			int m2 = (int) (amount / m1);
			int a = amount - m1 * m2;
			
			int t = findTempMem();
			
			gotoc(t);
			
			for (int i = 0; i < m1; i++) {
				append("+");
			}
			
			append("[");
			gotoc(p);
			
			for (int i = 0; i < m2; i++) {
				append("+");
			}
			
			gotoc(t);
			append("-]");
			gotoc(p);
			
			for (int i = 0; i < a; i++) {
				append("+");
			}
			
			Compiler.mem[p] = 1;
			
		} else {
			for (int i = 0; i < amount; i++) {
				append("+");
			}
		}
	}
	
	static void sub(int amount) {
		if (amount > 15) {
			int p = Compiler.pointer;
			
			Compiler.mem[p] = 1;
			
			int m1 = (int) Math.sqrt(amount);
			int m2 = (int) (amount / m1);
			int a = amount - m1 * m2;
			
			int t = findTempMem();
			
			gotoc(t);
			
			for (int i = 0; i < m1; i++) {
				append("+");
			}
			
			append("[");
			gotoc(p);
			
			for (int i = 0; i < m2; i++) {
				append("-");
			}
			
			gotoc(t);
			append("-]");
			gotoc(p);
			
			for (int i = 0; i < a; i++) {
				append("-");
			}
			
			Compiler.mem[p] = 1;
			
		} else {
			for (int i = 0; i < amount; i++) {
				append("-");
			}
		}
	}
	
	static void set(int i, int j) {
		int p = Compiler.pointer;
		int t = findTempMem();
		
		gotoc(t);
		append("[-]");
		
		gotoc(j);
		append("[-");
		gotoc(i);
		append("+");
		gotoc(t);
		append("+");
		gotoc(j);
		append("]");
		gotoc(t);
		append("[");
		gotoc(j);
		append("+");
		gotoc(t);
		append("-]");
		gotoc(p);
		
		// return gotoc(j) + "[-" + gotoc(i) + "+" + gotoc(t) + "+" + gotoc(j) + "]" + gotoc(t) + "[" + gotoc(j) + "+" + gotoc(t) + "-]" + gotoc(p);
	}
	
	static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			
			return true;
		} catch (NumberFormatException e) {
		}
		
		return false;
	}
	
	public void execute(String string, int line) {
		int index = string.indexOf(' ');
		
		if (index >= 0) {
			String begin = string.substring(0, index);
			
			if (begin.equalsIgnoreCase(name())) {
				String[] args = string.split(" ");
				
				try {
					convert(args);
					append(System.lineSeparator());
				} catch (IndexOutOfBoundsException e1) {
					System.out.println("index out of bounds exception at line " + line + ": " + string);
					System.out.println(description());
				} catch (NumberFormatException e2) {
					System.out.println("Number format exception at line " + line + ": " + string);
					System.out.println(description());
				}
				
				// System.out.println(Arrays.toString(Compiler.mem));
			}
		}
		
		for (int i = 0; i < Compiler.mem.length; i++) {
			if (Compiler.mem[i] == 2) {
				Compiler.mem[i] = 0;
			}
		}
	}
	
	public String description() {
		return "no description available for " + name();
	}
	
	public abstract String name();
	
	public abstract void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException;
}

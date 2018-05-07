package compile;

class For extends Command {

	@Override
	public String name() {
		return "for";
	}
	
	@Override
	public String description() {
		return "for var startvalue endvalue loopname";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int pointer = getPointer("|" + args[4] + "|");
		gotoc(pointer);
		append("[-]+");
		
		if (isNumber(args[3])) {
			add(Integer.parseInt(args[3]));
		} else {
			set(pointer, getPointer(args[3]));
		}
		
		if (isNumber(args[2])) {
			sub(Integer.parseInt(args[2]));
		} else {
			int t = findTempMem();
			
			set(t, getPointer(args[2]));
			gotoc(t);
			append("[");
			gotoc(pointer);
			append("-");
			gotoc(t);
			append("-]");
			gotoc(pointer);
		}
		
		Command.mode.add(0);
		Command.functions.add(args[4]);
		Command.functionsPointer.add(pointer);
		
		append("[-");
		
		int var = getPointer(args[1]);
		
		gotoc(var);
		append("[-]");
		
		if (isNumber(args[3])) {
			add(Integer.parseInt(args[3]));
		} else {
			append("[-]");
			set(var, getPointer(args[3]));
		}
		
		int t = findTempMem();
		gotoc(t);
		
		set(t, pointer);
		
		gotoc(t);
		append("[");
		gotoc(var);
		append("-");
		gotoc(t);
		append("-]");
		
		gotoc(var);
	}
	
}

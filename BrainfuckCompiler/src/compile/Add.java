package compile;

class Add extends Command {

	@Override
	public String name() {
		return "add";
	}
	
	@Override
	public String description() {
		return "add var amount";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		String var = args[1];
		int pointer = getPointer(var);
		
		if (isNumber(args[2])) {
			int amount = Integer.parseInt(args[2]);
			
			gotoc(pointer);
			add(amount);
			
			return;
		}
		
		String var2 = args[2];
		int pointer2 = getPointer(var2);
		
		int t = findTempMem();
		
		set(t, pointer2);
		gotoc(t);
		append("[");
		gotoc(pointer);
		append("+");
		gotoc(t);
		append("-]");
	}

}

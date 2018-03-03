package compile;

class Not extends Command {

	@Override
	public String name() {
		return "not";
	}
	
	@Override
	public String description() {
		return "not var var";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int pointer = getPointer(args[1]);
		int x = getPointer(args[2]);
		
		int t = findTempMem();
		
		gotoc(pointer);
		append("[-]");
		set(pointer, x);
		
		gotoc(t);
		append("[-]");
		gotoc(pointer);
		append("[");
		gotoc(t);
		append("+");
		gotoc(pointer);
		append("[-]]+");
		gotoc(t);
		append("[");
		gotoc(pointer);
		append("-");
		gotoc(t);
		append("-]");
		gotoc(pointer);
	}

}

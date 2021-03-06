package compile;

class Invert extends Command {

	@Override
	public String name() {
		return "inv";
	}
	
	@Override
	public String description() {
		return "inv boolean";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int t = findTempMem();
		int x = getPointer(args[1]);
		
		gotoc(t);
		append("[-]");
		gotoc(x);
		append("[");
		gotoc(t);
		append("+");
		gotoc(x);
		append("[-]]+");
		gotoc(t);
		append("[");
		gotoc(x);
		append("-");
		gotoc(t);
		append("-]");
		gotoc(x);
	}

}

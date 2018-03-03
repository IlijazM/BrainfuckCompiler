package compile;

class _Equals extends Command {

	@Override
	public String name() {
		return "equ";
	}
	
	@Override
	public String description() {
		return "equ out_var var var";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int p = Compiler.pointer;
		
		int x = getPointer(args[1]);
		int y = findTempMem();
		
		set(x, getPointer(args[2]));
		set(y, getPointer(args[3]));
		
		gotoc(x);
		append("[-");
		gotoc(y);
		append("-");
		gotoc(x);
		append("]+");
		gotoc(y);
		append("[");
		gotoc(x);
		append("-");
		gotoc(y);
		append("[-]]");
		gotoc(x);
	}

}
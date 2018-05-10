package compile;

class Mul extends Command {

	@Override
	public String name() {
		return "mul";
	}
	
	@Override
	public String description() {
		return "mul var factor";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int t1 = findTempMem();
		int t2 = findTempMem();
		
		int x = getPointer(args[1]);
		int y = 0;
		
		if (isNumber(args[2])) {
			y = findTempMem();
			gotoc(y);
			clear();
			add(Integer.parseInt(args[2]));
		} else {
			y = getPointer(args[2]);
		}
		
		gotoc(t1);
		clear();
		gotoc(t2);
		clear();
		gotoc(x);
		append("[");
		gotoc(t2);
		add(1);
		gotoc(x);
		append("-]");
		gotoc(t2);
		append("[");
		gotoc(y);
		append("[");
		gotoc(x);
		add(1);
		gotoc(t1);
		add(1);
		gotoc(y);
		append("-]");
		gotoc(t1);
		append("[");
		gotoc(y);
		add(1);
		gotoc(t1);
		append("-]");
		gotoc(t2);
		append("-]");
	}
	
}

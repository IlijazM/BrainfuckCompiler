package compile;

class Print extends Command {

	@Override
	public String name() {
		return "out";
	}
	
	@Override
	public String description() {
		return "out var";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		String var = args[1];
		int pointer = getPointer(var);
		
		gotoc(pointer);
		append(".");
	}
	
}

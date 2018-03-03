package compile;

class Move extends Command {

	@Override
	public String name() {
		return "mov";
	}
	
	@Override
	public String description() {
		return "mov current_var target_var";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int target = getPointer(args[2]);
		int pointer = getPointer(args[1]);
		
		gotoc(target);
		append("[-]");
		gotoc(pointer);
		append("[");
		gotoc(target);
		append("+");
		gotoc(pointer);
		append("-]");
	}

}

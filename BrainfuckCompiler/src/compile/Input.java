package compile;

class Input extends Command {

	@Override
	public String name() {
		return "inp";
	}
	
	@Override
	public String description() {
		return "inp var";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		gotoc(getPointer(args[1]));
		append(",");
	}

}

package compile;

class Set extends Command {

	@Override
	public String name() {
		return "set";
	}
	
	@Override
	public String description() {
		return "set var value";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		String var = args[1];
		int pointer = getPointer(var);
		
		int amount = Integer.parseInt(args[2]);
		
		gotoc(pointer);
		append("[-]");
		add(amount);
	}

}
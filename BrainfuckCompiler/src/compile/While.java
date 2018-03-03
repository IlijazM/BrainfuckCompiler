package compile;

class While extends Command {

	@Override
	public String name() {
		return "whl";
	}
	
	@Override
	public String description() {
		return "whl var loopname";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int pointer = getPointer(args[1]);
		gotoc(pointer);
		
		Command.functions.add(args[2]);
		Command.functionsPointer.add(pointer);
		
		append("[");
	}
	
}

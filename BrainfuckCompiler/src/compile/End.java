package compile;

class End extends Command {

	@Override
	public String name() {
		return "end";
	}
	
	@Override
	public String description() {
		return "end loopname";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int i = Command.functions.indexOf(args[1]);
		
		Command.functions.remove(i);
		
		gotoc(Command.functionsPointer.get(i));
		
		Command.functionsPointer.remove(i);
		
		append("]");
	}

}

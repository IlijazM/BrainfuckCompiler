package compile;

class Sub extends Command {

	@Override
	public String name() {
		return "sub";
	}
	
	@Override
	public String description() {
		return "sub var amount";
	}
	
	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		String var = args[1];
		int pointer = getPointer(var);
		
		int amount = Integer.parseInt(args[2]);
		
		gotoc(pointer);
		sub(amount);
	}

}

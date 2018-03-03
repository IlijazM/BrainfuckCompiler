package compile;

class Sum extends Command {

	@Override
	public String name() {
		return "sum";
	}
	
	@Override
	public String description() {
		return "sum result_var int1 int2";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int sum = getPointer(args[1]);
		
		if (isNumber(args[2]) && isNumber(args[3])) {
			gotoc(sum);
			append("[-]");
			add(Integer.parseInt(args[2]) + Integer.parseInt(args[3]));
			
			return;
		}
		
		if (isNumber(args[2]) && !isNumber(args[3])) {
			set(sum, getPointer(args[3]));
			gotoc(sum);
			add(Integer.parseInt(args[2]));
			
			return;
		}
		
		if (!isNumber(args[2]) && isNumber(args[3])) {
			set(sum, getPointer(args[2]));
			gotoc(sum);
			add(Integer.parseInt(args[3]));
			
			return;
		}
		
		if (!isNumber(args[2]) && !isNumber(args[3])) {
			set(sum, getPointer(args[2]));
			set(sum, getPointer(args[3]));
			
			return;
		}
	}
	
}

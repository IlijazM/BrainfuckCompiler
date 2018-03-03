package compile;

class Comment extends Command {

	@Override
	public String name() {
		return "#";
	}
	
	@Override
	public String description() {
		return "# comment";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		String str = "";
		
		for (int i = 1; i < args.length; i++) {
			str += (i == 1 ? "" : " ") + args[i];
		}
		
		append(str);
	}

}
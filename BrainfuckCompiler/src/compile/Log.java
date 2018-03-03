package compile;

class Log extends Command {

	@Override
	public String name() {
		return "log";
	}
	
	@Override
	public String description() {
		return "log var";
	}

	@Override
	public void convert(String[] args) throws IndexOutOfBoundsException, NumberFormatException {
		int t = findTempMem();
		
		gotoc(t);
		append("[-]");
		
		if (isNumber(args[1])) {
			add(Integer.parseInt(args[1]));
		} else {
			int pointer = getPointer(args[1]);
			
			set(t, pointer);
		}
		
		append(System.lineSeparator());
		gotoc(t);
		append(System.lineSeparator());
		append("[>>+>+<<<-]>>>[<<<+>>>-]<<+>[<->[>++++++++++<[->-[>+>>]>[+[-<+>]>+>>]<<<<<]>[-]++++++++[<++++++>-]>[<<+>>-]>[<<+>>-]<<]>]<[->>++++++++[<++++++>-]]<[.[-]<]<[-]");
	}

}

/*
set a 10
set b 20
log a
set c 5
log c
log b
*/
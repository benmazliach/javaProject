package controller;

public class MyCommand implements Command {
	
	String s;
	
	public MyCommand(String s) {
		this.s = s;
	}
	
	@Override
	public void doCommand() {
		System.out.println(s);
	}
	
	@Override
	public String toString() {
		return "Print "+s;
	}

}

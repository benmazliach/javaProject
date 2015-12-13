package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI extends Thread{
	
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> hashMap;
	
	public CLI(BufferedReader in,PrintWriter out,HashMap<String, Command> hashMap)
	{
		this.in = in;
		this.out = out;
		this.hashMap = hashMap;
	}
	
	@Override
	public void run()
	{
		new Thread(new Runnable() {
			public void run() {
				try {
					String s = null;
					s=in.readLine();
					System.out.println(s);
					while(s.equals("exit")!=true)
					{
						if(hashMap.containsKey(s)==true)
						{
							hashMap.get(s).doCommand();
						}
						else
						{
							out.write("error");
							System.out.println("error");
						}
						s=in.readLine();
						System.out.println(s);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public BufferedReader getIn() {
		return in;
	}
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	public PrintWriter getOut() {
		return out;
	}
	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public HashMap<String, Command> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Command> hashMap) {
		this.hashMap = hashMap;
	}

}

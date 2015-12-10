package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream{

	private InputStream in;
	public MyDecompressorInputStream(){}
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}
	
	@Override
	public int read(byte[] b) throws IOException{
		int num = super.read(b);
		System.out.println(num);
		/*byte[] temp = new byte[10];
		if(num==-1)
			return -1;
		for(int i=0;i<b.length;i++)
		{
			
		}*/
		return 0;
	}
	
	@Override
	public int read() throws IOException {
		int num = 0;
		if((num=in.read())!=-1)
			return num;
		return -1;
		
		/*if((num=in.read())!=-1 && (num>=0 && num<65535))
		{
			return num;
		}*/
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

}

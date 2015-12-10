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
	public int read() throws IOException {
		int num = 0;
		int temp = in.read();
		int i=1;
		while(temp!=-1)
		{
			if(temp>='0' &&temp<='9')
			{
				num = num * i + (temp-48);//48('0')<=temp<=57('9')
				i = i*10;
				temp = in.read();
			}
			else
			{
				return num;
			}
		}
		if(num!=0)
			return num;
		return -1;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

}

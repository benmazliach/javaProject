package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream{

	private OutputStream out;
	private Integer count;
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
		this.count = new Integer(0);
	}
	
	@Override
	public void write(byte[] b) throws IOException
	{
		this.count = 0;
		int temp = -1;
		if(b.length==1)
		{
			this.write(b[0]);
		}
		else
		{
			for(int i=0;i<b.length;i++)
			{
				if(temp!=b[i])
				{
					if(temp!=-1)
					{
						this.write(temp);
						out.write(",".getBytes());
					}
					temp=b[i];
					count=1;
				}
				else
				{
					count++;
				}
				if(i+1==b.length)
					this.write(temp);
			}
			this.count = 1;
		}
	}
	
	@Override
	public void write(int b) throws IOException {
		out.write(b+48);
		out.write(",".getBytes());
		out.write(count.toString().getBytes());
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

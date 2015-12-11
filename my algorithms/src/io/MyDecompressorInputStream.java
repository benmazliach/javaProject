package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyDecompressorInputStream extends InputStream{

	private InputStream in;
	private byte[] arrayByte;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
		this.arrayByte = null;
	}
	
	@Override
	public int read(byte[] b)
	{
		int size=0;
		ArrayList<Byte> temp = new ArrayList<Byte>();
		try {
			int num = 0;
			int i = 0;
			while((num = this.read())!=-1)
			{
				temp.add((byte)num);
				if(i%2==1)
					size+=temp.get(i);
				i++;
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int countOfByte = 0;
		byte numByte = 0;
		int z = 0;//array b index
		for (int i = 0; i < temp.size(); i++) {
			numByte = temp.get(i);
			i++;
			countOfByte = temp.get(i);
			for(int j = 0;j<(countOfByte);j++)
			{
				b[z] = numByte;
				z++;
			}
		}
		if(b!=null || size!=0)
			return size;
		return -1;
	}
	
	public int readFile() throws IOException {
		int size=0;
		ArrayList<Byte> temp = new ArrayList<Byte>();
		try {
			int num = 0;
			int i = 0;
			while((num = this.read())!=-1)
			{
				temp.add((byte)num);
				if(i%2==1)
					size+=temp.get(i);
				i++;
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		arrayByte = new byte[size];
		int countOfByte = 0;
		byte numByte = 0;
		int z = 0;//array b index
		for (int i = 0; i < temp.size(); i++) {
			numByte = temp.get(i);
			i++;
			countOfByte = temp.get(i);
			for(int j = 0;j<(countOfByte);j++)
			{
				arrayByte[z] = numByte;
				z++;
			}
		}
		if(arrayByte!=null || size!=0)
			return size;
		return -1;
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

	public byte[] getArrayByte() {
		return arrayByte;
	}

	public void setArrayByte(byte[] arrayByte) {
		this.arrayByte = arrayByte;
	}

}

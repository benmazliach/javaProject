package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Run {
		
		public static void main(String[] args) { 
			OutputStream out = null;
			byte[] b = {'5','5','1','1','1','0','0','1'};
			try {
				out= new FileOutputStream("ben.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MyCompressorOutputStream Cout = null;
			Cout = new MyCompressorOutputStream(out);
			try {
				Cout.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Cout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			InputStream in = null;
			try {
				in= new FileInputStream("ben.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			byte[] ben = null;
			MyDecompressorInputStream Cin = null;
			Cin = new MyDecompressorInputStream(in);
			try {
				Cin.readFile();
				ben = Cin.getArrayByte();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println(ben.length);
			for(int i=0;i<ben.length;i++)
				System.out.println(ben[i]);
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Cin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
		}
}

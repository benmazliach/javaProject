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
			//byte[] b = {1,1,1,1,0,0,0,1,0,0,1,0,0,0};
			try {
				out= new FileOutputStream("ben.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MyCompressorOutputStream Cout = null;
			Cout = new MyCompressorOutputStream(out);
			try {
				Cout.write("1111111000001111111111111100".getBytes());
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
			
			
			MyDecompressorInputStream Cin = null;
			Cin = new MyDecompressorInputStream(in);
			try {
				int num = 0;
				while((num = Cin.read())!=-1)
					System.out.println(num);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
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

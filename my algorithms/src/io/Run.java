package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;

public class Run {
		
		public static void main(String[] args) { 
			/*OutputStream out = null;
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
			
			
			char c = '0';
			byte x = (byte)c;
			System.out.println((int)x);*/
			
			MyMaze3dGenerator m = new MyMaze3dGenerator(3, 1, 3);
			// save it to a file   
			OutputStream out = null;
			try {
				out = new MyCompressorOutputStream( new FileOutputStream("1.maz"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				out.write(m.getMaze().toByteArray());  
				out.flush();   
				out.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
			InputStream in = null;
			try {
				in = new MyDecompressorInputStream( new FileInputStream("1.maz"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			byte b[]=new byte[m.getMaze().toByteArray().length];   
			try {
				in.read(b);
				in.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
			 
			Maze3d loaded=new Maze3d(b);     
			System.out.println(loaded.equals(m.getMaze())); 
			
			
			
			
			
		}
}

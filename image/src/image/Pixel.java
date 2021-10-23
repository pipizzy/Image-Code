package image;

import java.io.*;
import java.util.*;  
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Pixel {
  public static void main(String args[]) throws IOException{
	  
		 List<String> list=new ArrayList<String>(); 
		 
		 list.add("a");
		 list.add("b");
		 list.add("c");
		 list.add("d");
		 list.add("e");
		 list.add("f");
		 list.add("g");
		 list.add("h");
		 list.add("i");
		 list.add("j");
		 list.add("k");
		 list.add("l");
		 list.add("m");
		 list.add("n");
		 list.add("o");
		 list.add("p");
		 list.add("q");
		 list.add("r");
		 list.add("s");
		 list.add("t");
		 list.add("u");
		 list.add("v");
		 list.add("w");
		 list.add("x");
		 list.add("y");
		 list.add("z");
		 list.add(" ");
		 list.add(",");
		 list.add(".");
		 list.add("!");
		 list.add("?");
		 list.add("(");
		 list.add(")");
		 list.add("0");
		 list.add("1");
		 list.add("2");
		 list.add("3");
		 list.add("4");
		 list.add("5");
		 list.add("6");
		 list.add("7");
		 list.add("8");
		 list.add("9");
		 	 
		 
		 String output = "";
	  
	  
	  String pathname = "image.txt"; 
		File filename = new File(pathname); 
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(filename)); // 建立一个输入流对象reader
		BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
		String line = " ";
		line = br.readLine();
		System.out.print(line);
		
		String pathname2 = "sentence.txt"; 
		File filename2 = new File(pathname2); 
		InputStreamReader reader2 = new InputStreamReader(
				new FileInputStream(filename2)); // 建立一个输入流对象reader
		BufferedReader br2 = new BufferedReader(reader2); // 建立一个对象，它把文件内容转成计算机能读懂的语言
		String line2 = " ";
		line2 = br2.readLine();
		System.out.print(line2);

	  File file = new File(line);
	  BufferedImage image = ImageIO.read(file);
	  int wid = image.getWidth();
	  int hei = image.getHeight();
	  System.out.println(wid + " " + hei);
	 		 
		 System.out.print("text: ");
		 String input = line2;
		 String LowerCase = input.toLowerCase();
		 System.out.print(LowerCase);
		 
		 System.out.print("number: ");
		 int number = LowerCase.length();
		 int i = 0;
		 while ( i <= number-1) {
			 int ranwid = 1 + (int)(Math.random() * (wid-1));
			  int ranhei = 1 + (int)(Math.random() * (hei-1));
			  int  clr   =  image.getRGB(ranwid,ranhei);
			  int  red   = (clr & 0x00ff0000) >> 16;
			  int  green = (clr & 0x0000ff00) >> 8;
			  int  blue  =  clr & 0x000000ff;
			  //System.out.println("Red Color value = "+ red);
			  //System.out.println("Green Color value = "+ green);
			  //System.out.println("Blue Color value = "+ blue);  
			  int total = red + green+ blue;
			 String a = list.get(total%43);
			 char a1 = a.charAt(0);
			 char b = LowerCase.charAt(i);
			 if(a1 == b ) {
				 System.out.println(ranwid); 
				 System.out.println(ranhei); 
				 if (ranwid < 10) {
					 output = output + "000" + ranwid;
				 }
				 else if(ranwid < 100){
					 output = output + "00" + ranwid;
				 }
				 else if(ranwid < 1000){
					 output = output + "0" + ranwid;
				 }
				 else {
					 output = output + ranwid;
				 }
				 if (ranhei < 10) {
					 output = output + "000" + ranhei;
				 }
				 else if(ranhei < 100){
					 output = output + "00" + ranhei;
				 }
				 else if(ranhei < 1000){
					 output = output + "0" + ranhei;
				 }
				 else {
					 output = output + ranhei;
				 }
				 i+=1;
			 }
		 }
		 System.out.print(output);
		 
		 File writename = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(output); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
  }
}
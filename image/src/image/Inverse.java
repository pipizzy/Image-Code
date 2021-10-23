package image;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Inverse {
	public static void main(String[] args) throws IOException {
		
		 List<String> letter=new ArrayList<String>(); 
		 
		 letter.add("a");
		 letter.add("b");
		 letter.add("c");
		 letter.add("d");
		 letter.add("e");
		 letter.add("f");
		 letter.add("g");
		 letter.add("h");
		 letter.add("i");
		 letter.add("j");
		 letter.add("k");
		 letter.add("l");
		 letter.add("m");
		 letter.add("n");
		 letter.add("o");
		 letter.add("p");
		 letter.add("q");
		 letter.add("r");
		 letter.add("s");
		 letter.add("t");
		 letter.add("u");
		 letter.add("v");
		 letter.add("w");
		 letter.add("x");
		 letter.add("y");
		 letter.add("z");
		 letter.add(" ");
		 letter.add(",");
		 letter.add(".");
		 letter.add("!");
		 letter.add("?");
		 letter.add("(");
		 letter.add(")");
		 letter.add("0");
		 letter.add("1");
		 letter.add("2");
		 letter.add("3");
		 letter.add("4");
		 letter.add("5");
		 letter.add("6");
		 letter.add("7");
		 letter.add("8");
		 letter.add("9");		
		// 上面是字母集合
		
		List<Integer> list=new ArrayList<Integer>(); 
		
		String pathname1 = "output.txt"; 
		File filename1 = new File(pathname1); 
		InputStreamReader reader1 = new InputStreamReader(
				new FileInputStream(filename1)); // 建立一个输入流对象reader
		BufferedReader br1 = new BufferedReader(reader1); // 建立一个对象，它把文件内容转成计算机能读懂的语言
		String line1 = " ";
		line1 = br1.readLine();
		System.out.print(line1);
		
		String pathname = "image.txt"; 
		File filename = new File(pathname); 
		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(filename)); // 建立一个输入流对象reader
		BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
		String line = " ";
		line = br.readLine();
		System.out.print(line);
		
		
		int z = 0;
		for(int i=0;i<line1.length()/4;i++){
		String a = line1.substring(z,z+4);
		int k = Integer.parseInt(a);
		list.add(k);
		System.out.println(k);
		z = z+4;
		}
		
		System.out.println(list.size());
		
		File file = new File(line);
		BufferedImage image = ImageIO.read(file);
		int wid = image.getWidth();
		int hei = image.getHeight();
		System.out.println(wid + " " + hei);
		
		String output="";
		
		for(int i = 0; i < list.size(); i = i+2) {
			int  clr   =  image.getRGB(list.get(i),list.get(i+1));
			int  red   = (clr & 0x00ff0000) >> 16;
			int  green = (clr & 0x0000ff00) >> 8;
			int  blue  =  clr & 0x000000ff;
			int total = red + green + blue;
			output = output + letter.get(total%43);
		}
		
		System.out.println(output);
		
		 File writename = new File("sentence.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(output); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
		
	}
}

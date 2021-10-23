package image;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView; 
import java.io.*;
import java.util.*;  
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InsertSentence {
	
	public static void main(String[] args) throws IOException {
		
		String info = JOptionPane.showInputDialog(null,"plz enter your secret","enter",JOptionPane.WARNING_MESSAGE);	
		
		File writename = new File("sentence.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
		writename.createNewFile(); // 创建新文件
		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		out.write(info); // \r\n即为换行
		out.flush(); // 把缓存区内容压入文件
		out.close(); // 最后记得关闭文件
		
	}
	

}

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
		
		File writename = new File("sentence.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
		writename.createNewFile(); // �������ļ�
		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		out.write(info); // \r\n��Ϊ����
		out.flush(); // �ѻ���������ѹ���ļ�
		out.close(); // ���ǵùر��ļ�
		
	}
	

}

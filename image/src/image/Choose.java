package image;
import javax.swing.JFileChooser;  
import javax.swing.filechooser.FileSystemView; 
import java.io.*;

public class Choose {
	
		public static String main(String[] args) {
		FileSystemView fsv = FileSystemView.getFileSystemView();  
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
		fileChooser.setDialogTitle("choose a image as encryption sourse");
		fileChooser.setApproveButtonText("select");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(null);
		String path = null;
		if (JFileChooser.APPROVE_OPTION == result) {
		    path=fileChooser.getSelectedFile().getPath();
		    System.out.println("path: "+path);
		}
		 try {
	            BufferedWriter out = new BufferedWriter(new FileWriter("image.txt"));
	            out.write(path);
	            out.close();
	            System.out.println("文件创建成功！");
	        } catch (IOException e) {
	        }
		return path;
	}
}

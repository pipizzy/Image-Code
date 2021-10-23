package image;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.*;

public class TestInput {
   public static void main(String[] args) {
      createWindow();
   }

   private static void createWindow() {    
      JFrame frame = new JFrame("image encryption program");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame);
      frame.setSize(600, 130);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }

   private static void createUI(final JFrame frame){  
      JPanel panel = new JPanel();
      LayoutManager layout = new FlowLayout();  
      panel.setLayout(layout);       

      JButton button1 = new JButton("Step 2: text sentence");
      button1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
        	 InsertSentence a = new InsertSentence();
        	 try {
				a.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
      });

      JButton button2 = new JButton("Step 1: upload jpg image");
      button2.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	Choose a = new Choose();
        	a.main(null);
          }
       });
      
      JButton button3 = new JButton("Step 3: get your key");
      button3.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	  Pixel a = new Pixel();
        	  try {
				a.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
        	  JOptionPane.showConfirmDialog(null,"Successed, you can find it in the foder","",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
        	  
          }
       });
      
      JButton button4 = new JButton("translate key and image (worning: U must have image.txt and output.txt in foder!!!!!)");
      button4.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	  Inverse a = new Inverse();
        	  try {
				a.main(null);;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	  JOptionPane.showConfirmDialog(null,"Successed, you can find it in the foder","",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框  
          }
       });
            
      panel.add(button2);
      panel.add(button1);
      panel.add(button3);
      panel.add(button4);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }  
}
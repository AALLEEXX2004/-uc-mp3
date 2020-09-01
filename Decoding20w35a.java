import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Decoding20w35a {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		JFileChooser chooser = new JFileChooser();//导入文件选择
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//允许文件和文件夹
		chooser.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("uc，uc!文件", "uc","uc!");
	    chooser.setFileFilter(filter);//过滤器
	    Component parent = null;
			chooser.showOpenDialog(parent);
			 JFileChooser chooser2 = new JFileChooser();//导出文件夹选择
			 chooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			 Component parent2 = null;
				chooser2.showOpenDialog(parent2);
		     File[] Name =  chooser.getSelectedFiles();
		     File path =chooser2.getSelectedFile();
		     for(int p = 0;p < Name.length;p++ ) {
			      String musicName = Name[p].getName();//名字变为String类型
			      String delimiter = "\\.";
			      String[] array;
			      array = musicName.split(delimiter);
			      DataInputStream dis = null;
			      DataOutputStream dos = null;
			      System.out.println(""+  array[0]);
			      try {
					     File outFile = new File( path+ "\\"+array[0] +".mp3");
					     dis = new DataInputStream(new FileInputStream(Name[p]));
					     dos = new DataOutputStream(new FileOutputStream(outFile));
					     byte[] b = new byte[1024];
					     int len;
					     while ((len = dis.read(b)) != -1) {
					          for (int a = 0; a < len; a++) {
							     b[a] ^= 0xa3;
						         }
						      dos.write(b, 0, len);
					          }
				         } 
				      catch (IOException e) {
					        e.printStackTrace();
				           } finally {
					                if (dos != null) {
						              try {
							             dos.close();
						                 } 
						              catch (IOException e) {
							               e.printStackTrace();
						                   }
					                  }
					                if (dis != null) {
						              try {
							             dis.close();
						                 } catch (IOException e) {
							                    e.printStackTrace();
						                        }
					                  }
				                     }
	    
		     }
		}
	}
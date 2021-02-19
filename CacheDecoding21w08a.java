import java.awt.Component;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CacheDecoding21w08a {

	public static void main(String[] args)throws IOException {
		CacheDecoding21w08a CD = new CacheDecoding21w08a();
		File[] InputFiles  = CD.InputFileChooser();
		File OutputDirectories = CD.OutputFileChooser();
		for(int t = 0;t<InputFiles.length;t++) {
			String FileName = InputFiles[t].getName();
			 String delimiter = "\\.";
		      String[] array;
		      array = FileName.split(delimiter);
		      DataInputStream dis = null;
		      DataOutputStream dos = null;
		      System.out.println(""+  array[0]);
		      try {
				     File outFile = new File( OutputDirectories+ "\\"+array[0] +".mp3");
				     dis = new DataInputStream(new FileInputStream(InputFiles[t]));
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
			         } 
		      finally {
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
	public File[] InputFileChooser() throws IOException{
		JFileChooser InputChooser = new JFileChooser();
		InputChooser.setMultiSelectionEnabled(true);
		InputChooser.setFileSelectionMode(0x2);//0x2:files and DIRECTORIES
		FileNameExtensionFilter filter = new FileNameExtensionFilter("uc£¬uc!ÎÄ¼þ", "uc","uc!");
		InputChooser.setFileFilter(filter);//¹ýÂËÆ÷
			Component parent = null;
			InputChooser.showOpenDialog(parent);
	     File[] Input =  InputChooser.getSelectedFiles();	    
		return Input;
	}
	public File OutputFileChooser() throws IOException {
		JFileChooser OutputChooser = new JFileChooser();
		OutputChooser.setMultiSelectionEnabled(true);
		OutputChooser.setFileSelectionMode(0x1);
			Component parent = null;
			OutputChooser.showOpenDialog(parent);
			File Output = OutputChooser.getSelectedFile();	
		return Output;
	}
}

package storyboard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgressIO {
	
	public ProgressIO(){}
	
	public void saveUnlockedNum(int num) throws IOException{
		File outFile = new File("progress.txt");
		outFile.createNewFile();
		FileOutputStream out = new FileOutputStream(outFile, false);
		System.out.print("Test TEst");
		out.write(num);
		out.close();
	}
	
	public int loadUnlockedNum() throws IOException{
		FileInputStream in = new FileInputStream("progress.txt");
		int num = (int)in.read();
		in.close();
		return num;
	}
}

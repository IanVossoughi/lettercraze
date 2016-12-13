package playerBoundary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProgressIO {
	
	public ProgressIO(){}
	
	public static void saveUnlockedNum(int num){
		try{
		File outFile = new File("progress.txt");
		outFile.createNewFile();
		FileOutputStream out = new FileOutputStream(outFile, false);
		out.write(num);
		out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static int loadUnlockedNum(){
		FileInputStream in;
		int num = -1; // Error if this returns
		try {
			in = new FileInputStream("progress.txt");
			num = (int)in.read();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
}

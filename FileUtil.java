package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

 

public class FileUtil {
	
	
	public static PrintStream getFile() throws FileNotFoundException{
		File file = new File("H:\\JDUrlList.txt");
		PrintStream ps = new PrintStream(file);
		return ps;
	
	}
}

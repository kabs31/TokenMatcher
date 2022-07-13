import java.io.*;
import java.util.*;

public class wordPicker {
	static List<String> pickWordsInFiles(String fileDirectory){
			List<String> globalSentList = new ArrayList<>(); 
			File file  = new File(fileDirectory);
			File[] fileArray = file.listFiles();
			for(File f:fileArray) {
				
				try {
					
					FileReader fReader = new FileReader(f);
					BufferedReader bReader = new BufferedReader(fReader);
					try {
						String str = bReader.readLine();
						String[] sentArray;
						while(str!=null) {
							    sentArray = str.split("[.,]");
								for(String s:sentArray) {
									globalSentList.add(s);
								}
								str = bReader.readLine();
						}
						bReader.close();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
					
				} 
				
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			List<String> globalWordList = new ArrayList<>();
			String[] wordArray;
			for(String sent:globalSentList) {
				wordArray = sent.split(" ");
				for(String word:wordArray) {
					if(word!=" ")
					   globalWordList.add(word.trim());
				}
			}
			return globalWordList;
			
	}
	static List<String> pickTokensinFiles(String fileDirectory){
		List<String> globalWordList = new LinkedList<>(); 
		File file  = new File(fileDirectory);
		try {
			
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);
			try {
				String str = bReader.readLine();
				while(str!=null) {
						globalWordList.add(str.trim());
						str = bReader.readLine();
				}
				bReader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return globalWordList;
	}
}

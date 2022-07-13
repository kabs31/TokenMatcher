import java.util.*;
public class SearchTokenTask implements Runnable{
	static Map<String,Integer> ThreadTimeMap = new HashMap<>();
	static List<String> wordList = new ArrayList<>();
	String token;
	public SearchTokenTask(String token) {
		this.token = token;
	}
	@Override
	public void run() {
		boolean notFound=true;
		for(String word:wordList) {
			if(this.token.equals(word)) {
				System.out.println(this.token+" --Match");
				notFound=false;
				break;
			}
		}
		if(notFound)
			System.out.println(this.token+" --Not Match");
		
	}
	
	static void updateWordList(List<String> wordList) {
		SearchTokenTask.wordList = wordList;
	}
	
}
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordSearcher {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		List<String> wordList;
		List<String> tokenList;
		// BELOW CODE IS TO EXTRACT WORDS FROM searchtextfile TOKEN FROM tokenfile
		wordList = wordPicker.pickWordsInFiles("C:\\Users\\HP\\Desktop\\fileToBeSearched");
		tokenList = wordPicker.pickTokensinFiles("C:\\Users\\HP\\Desktop\\sample-search-tokenfile.txt");
		
		SearchTokenTask.updateWordList(wordList);  	//UPDATE WORDLIST TO TASK'S CLASS
		int tokenSize = tokenList.size();
		SearchTokenTask[] taskList = new SearchTokenTask[tokenSize];     
		
		//CONVERTING EACH TOKEN TO TASKS AND STORING IN A ARRAY
		for(int idx=0;idx<tokenSize;idx++) {
			SearchTokenTask task = new SearchTokenTask(tokenList.get(idx));
			taskList[idx] = task;
		}
		
		System.out.println("Enter number of threads");
		int n = sc.nextInt();
		sc.nextLine(); 
		//CREATING THREAD POOL WITH NUMBER OF THREADS
		ExecutorService executorService = Executors.newFixedThreadPool(n); 
		long startTime = System.currentTimeMillis();
		
		for(SearchTokenTask t:taskList) {
			executorService.submit(t);  //SUBMITING TASKS TO THE THREAD POOL
		}
		
		executorService.shutdown();
		try {
			executorService.awaitTermination(2, TimeUnit.MINUTES);   //MAKING MAIN THREAD TO WAIT UNTIL ALL TASKS TO BE COMPLETED
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println();
		System.out.println(System.currentTimeMillis()-startTime+" milliseconds");
	}

}

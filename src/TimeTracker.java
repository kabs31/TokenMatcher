import java.util.*;
public class TimeTracker {
	static Map<String,Integer> threadTimeMap = new HashMap<>();
    static  void updateTime(String threadName,int timetaken) {
		threadTimeMap.put(threadName, timetaken);
	}
    static String getOverallTime() {
    	return threadTimeMap.toString();
    }
}

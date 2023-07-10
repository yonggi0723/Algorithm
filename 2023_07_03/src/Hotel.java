import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class Hotel {

    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] times = new int[book_time.length][book_time[0].length];
        
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        

        for (int i=0; i<book_time.length; i++) {
        	times[i][0] = parseTime(book_time[i][0]);
        	times[i][1] = parseTime(book_time[i][1]);
        }
        
        Arrays.sort(times,(o1,o2)->{
        	if (o1[0] == o2[0]) return o1[1]-o2[1];
        	return o1[0]-o2[0];
        });
        
        for (int[] time : times) {
        	if (endTime.isEmpty() || endTime.peek() > time[0]) 
        		answer++;
        	else
        		endTime.poll();
        	
    		endTime.add(time[1]+10);
        }
        
        return answer;
    }
    
    private int parseTime(String time) {
    	String[] str = time.split(":");  	
    	return (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
    }
    
	@Test
	void test() {
		Assert.assertEquals(3, solution(new String[][] {{"15:00", "17:00"},{"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}}));
		Assert.assertEquals(1, solution(new String[][] {{"09:10", "10:10"},{"10:20", "12:20"}}));
		Assert.assertEquals(3, solution(new String[][] {{"10:20", "12:30"},{"10:20", "12:30"},{"10:20", "12:30"}}));
	}

}

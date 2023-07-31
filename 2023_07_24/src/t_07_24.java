import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_07_24 {
	

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int pos = 0, time = 0;
        
        Stack<Job> stack = new Stack<>();
        
        PriorityQueue<Job> que = new PriorityQueue<>();
        
        for (String[] plan : plans)
        	que.add(new Job(plan));
  
        Job job;
       
        while (!que.isEmpty()) {
        	
        	job = que.poll();
        	
        	System.out.print(job.name + " 작업시작 : " + job.startTime + " ");
        	
        	if (!que.isEmpty() && job.endTime > que.peek().startTime) {
        		
        		time = que.peek().startTime - job.startTime;
        		job.remain -= time;
        		stack.add(job);
        		time = 0;
        		System.out.println("작업 미완료");
        	} else {
        		time = que.isEmpty() ?  Integer.MAX_VALUE:que.peek().startTime - job.endTime;
        		answer[pos++] = job.name;
        		System.out.println("작업 완료 남은 작업 시간 : " + time);
        		
        		while (!stack.empty()) {
                	System.out.print(stack.peek().name + " 남은 작업시작 : " + stack.peek().remain + " ");
            		stack.peek().remain -= time;
                	
            		if (stack.peek().remain <= 0) {
            			job = stack.pop();
            			time = job.remain * -1;
            			answer[pos++] = job.name;
                    	System.out.println("작업완료");
            		} else {
            			time = 0;
            			System.out.println("작업 미완료 " + stack.peek().remain);
            			break;
            		}
        		}
        	}
        }
        
        
        
        return answer;
    }
    
    class Job implements Comparable<Job> {
    	
    	private String name;
    	
    	private int startTime;
    	
    	private int endTime;
    	
    	private int cal;
    	
    	private int remain;
    	
    	public Job(String[] arr) {
    		name = arr[0];
    		startTime = getTime(arr[1]);
    		cal = Integer.parseInt(arr[2]);
    		endTime = startTime + cal;
    		remain = cal;
    	}

		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			return startTime - o.startTime;
		}
		
	    private int getTime(String time) {
	    	String[] str = time.split(":");
	    	return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
	    }
    }
    
    
	@Test
	void test() { 
		Assert.assertArrayEquals(new String[] {"korean", "english", "math"}, solution(new String[][] {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}));
		Assert.assertArrayEquals(new String[] {"science", "history", "computer", "music"}, solution(new String[][] {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}));
		Assert.assertArrayEquals(new String[] {"bbb", "ccc", "aaa"}, solution(new String[][] {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}}));
	}

}

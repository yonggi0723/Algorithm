import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_0801 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        
        for (int i=0; i<queue1.length; i++) {
        	sum1 += queue1[i];
        	sum2 += queue2[i];
        	que1.add(queue1[i]);
        	que2.add(queue2[i]);
        }
        
        int num = 0;
        
        while (sum1 != sum2) {
        	
        	num = sum1 > sum2 ? que1.poll():que2.poll();
        	
        	if (sum1 > sum2) {
        		sum1 -= num;
        		sum2 += num;
        		que2.add(num);
        	} else  {
        		sum2 -= num;
        		sum1 += num;
        		que1.add(num);
        	}
        	
        	if (answer > (queue1.length * 2 + 1)) {
        		answer = -1;
        		break;
        	}
        	
        	answer++;
        }

        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
		Assert.assertEquals(7, solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
		Assert.assertEquals(-1, solution(new int[] {1, 1}, new int[] {1, 5}));
		Assert.assertEquals(12, solution(new int[] {1,1,1,1,1}, new int[] {1,1,1,9,1}));
	}

}

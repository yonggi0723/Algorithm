import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_0728 {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for (int army : enemy) {
        	n -= army;
        	que.add(army);
        	answer++;
        	
        	if (n >= 0) continue;
        	
        	if (k == 0)
        		return answer-1;
        	
        	n += que.poll();
        	k--;
        }

        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(0, solution(3, 0, new int[] {4,4,3,3,20}));
		
		Assert.assertEquals(4, solution(9, 1, new int[] {3,4,3,3,20}));

		
		Assert.assertEquals(6, solution(7, 3, new int[] {1, 2, 4, 5, 7,3,4,20, 30, 20}));
		Assert.assertEquals(5, solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1}));
		Assert.assertEquals(4, solution(2, 4, new int[] {3, 3, 3, 3}));
	}

}

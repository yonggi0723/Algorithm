import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_0804 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();
        
        for (int i=0; i<deliveries.length; i++) {
        	if (deliveries[i] > 0) stack1.push(new int[] {i+1, deliveries[i]});
        	if (pickups[i] > 0) stack2.push(new int[] {i+1, pickups[i]});
        }   

        int move = 0 , space = 0;
        int[] box;
        
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
        	// 충전 
        	move = 0;
        	space = cap;
        	
        	// 배달
        	while (!stack1.isEmpty() && space > 0) {
        		box = stack1.pop();
        		space -= box[1];
        		move = Math.max(move, box[0]);
        		
        		if (space < 0) {
        			box[1] = Math.abs(space);
        			stack1.push(box);
        		}
        	}
        	
        	space = 0;
        	// 수거
        	while (!stack2.isEmpty() && space < cap) {
        		box = stack2.pop();
        		space += box[1];
        		move = Math.max(move, box[0]);
        		
        		if (space > cap) {
        			box[1] = Math.abs(space-cap);
        			stack2.push(box);
        		}
       
        	}

        	answer += (move * 2);
        }
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(8, solution(2, 2, new int[] {0,0}, new int[] {0,4}));
		Assert.assertEquals(16, solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int[] {0, 3, 0, 4, 0}));
		Assert.assertEquals(30, solution(2, 7, new int[] {1, 0, 2, 0, 1, 0, 2}, new int[] {0, 2, 0, 1, 0, 2, 0}));
	}

	//
}

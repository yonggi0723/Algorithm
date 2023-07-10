import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BackNumber {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        

        for (int i=0; i<numbers.length; i++) {
        	while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        		answer[stack.pop()] = numbers[i];
        	}
        	
        	stack.push(i);       	
        }
        
        while (!stack.isEmpty()) {
        	answer[stack.pop()] = -1;
        }
       
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {3, 5, 5, -1}, solution(new int[] {2,3,3,5}));
		Assert.assertArrayEquals(new int[] {-1, 5, 6, 6, -1, -1}, solution(new int[] {9, 1, 5, 3, 6, 2}));
	}

}

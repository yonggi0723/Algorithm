import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 2/7 (화)
 * 햄버거 만들기 Lv1
 * @author kim-yong-gi
 *
 */
class hamburger {
    
	public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        for (int num : ingredient) {
        	basket.add(num);
        	if (basket.size() < 4) continue;
        	int size = basket.size();
    
        	if (basket.get(size-1) == 1 
        			&& basket.get(size-2) == 3
        			&& basket.get(size-3) == 2
        			&& basket.get(size-4) == 1) {
         		basket.pop();
         		basket.pop();
         		basket.pop();
         		basket.pop();
         		answer++;
        	}
        }

        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
//		Assert.assertEquals(0, solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

}

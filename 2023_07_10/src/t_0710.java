import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 lv2 택배 상자
 * @author gim-yong-gi
 *
 */
class t_0710 {
	
    public int solution(int[] order) {
        int answer = 0, pos = 0;
        
        Stack<Integer> sub = new Stack();
        
        for (int i=1; i<=order.length; i++) {
        	if (order[pos] == i) {
        		answer++;
        		pos++;
        	} else if (sub.isEmpty() || sub.peek() != order[pos]) {
        		sub.push(i);
        		continue;
        	} 
        	
        	while(!sub.isEmpty() && sub.peek() == order[pos]) {
        		sub.pop();
        		pos++;
        		answer++;
        	}
        }
        
        return answer;
    }

	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[] {4, 3, 1, 2, 5}));
		Assert.assertEquals(5, solution(new int[] {5, 4, 3, 2, 1}));
	}

}
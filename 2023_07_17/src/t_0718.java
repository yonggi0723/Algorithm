import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 투포인터 알고리즘
 * 프로그래머스 lv2 
 * 연속된 부분수열의 합 
 * @author gim-yong-gi
 *
 */

class t_0718 {

    public int[] solution(int[] sequence, int k) {
    	int[] answer = new int[2];
    	
    	int sum = sequence[0] , cnt = Integer.MAX_VALUE, left = 0, right = 1;
    	
    	while (left < right ) {
        	if (sum == k && cnt > (right-left)) {
        		cnt = right - left;
        		answer[0] = left;
        		answer[1] = right-1;
        	}

        	if (sum >= k)
        		sum -= sequence[left++];	
        	else if (right < sequence.length)
        		sum += sequence[right++];
        	else 
        		break;
    	}
    	
    	
    	return answer;
    }

    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {2,3}, solution(new int[] {1, 2, 3, 4, 5}, 7));
		Assert.assertArrayEquals(new int[] {6,6}, solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5));
		Assert.assertArrayEquals(new int[] {0,2}, solution(new int[] {2, 2, 2, 2, 2}, 6));
	}

}

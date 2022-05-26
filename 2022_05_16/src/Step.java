import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *  프로그래머스 징검다리 건너기 (카카오 겨울 인턴쉽)
 * @author kim-yong-gi
 */
class Step {

    public int solution(int[] stones, int k) {
        return search(0, 200000000, k, stones);
    }
    
    private int search(int start, int end, int k, int[] stones) {
    	int mid = (start + end) / 2;
    	int cnt = 0;
    	while (start < end) {
    		
    		if (check(mid, k, stones))
    			end = mid;
    		else 
    			start = mid +1;    		

    		mid = (start + end) / 2;
    	}
    	return mid;
    }
    
    private boolean check(int val, int k,int[] stones) {
    	int hide = 0;
    	for (int stone : stones) {
    		hide = stone > val ? 0:hide+1;
    		
    		if (hide >= k)
    			break;
    	}
    	return hide >= k;
    }
    
	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[] {2}, 1));
		Assert.assertEquals(3, solution(new int[] {2,3}, 2));
		Assert.assertEquals(2, solution(new int[] {2,3,4,1,2,2,4,6}, 2));
		Assert.assertEquals(3, solution(new int[] {2,4,5,3,2,1,4,2,5,1}, 3));
	}

}
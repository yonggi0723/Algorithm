import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class Choice {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        
        for (int size : tangerine)
        	basket.put(size, basket.getOrDefault(size, 0)+1);
        
        List<Integer> list = new ArrayList<>(basket.values());
        list.sort((i1,i2)->i2-i1);
        
        for (int val : list) {
        	answer++;
        	k-=val;
        	if (k<=0) break;
        }

        return answer;
    }
    

    
	@Test
	void test() {
		Assert.assertEquals(3, solution(6, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		Assert.assertEquals(2, solution(4, new int[] {1, 3, 2, 5, 4, 5, 2, 3}));
		Assert.assertEquals(1, solution(2, new int[] {1, 1, 1, 1, 2, 2, 2, 3}));
	}

}

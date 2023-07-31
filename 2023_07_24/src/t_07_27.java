import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_07_27 {

    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        HashMap<Double, Integer> map = new HashMap<>();
        
        for (int i=0; i<weights.length; i++) {
        	answer += map.getOrDefault(weights[i] * 1.0, 0);
        	answer += map.getOrDefault(weights[i] * 1.0 / 2.0, 0);
          	answer += map.getOrDefault(weights[i] * 2.0 / 3.0, 0);
          	answer += map.getOrDefault(weights[i] * 3.0 / 4.0, 0);

        	map.put(weights[i] * 1.0, map.getOrDefault(weights[i] * 1.0, 0)+1);
        }

        return answer;
    }
    
    
	@Test
	void test() {
		Assert.assertEquals(4, solution(new int[] {100,180,360,100,270}));
	}

}

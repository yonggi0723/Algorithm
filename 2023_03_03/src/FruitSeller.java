//import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FruitSeller {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        
        // 7 - 4 = 3
        for (int i = score.length; i>=m; i-=m) {
        	answer += score[i-m] * m;
        }
        
        return answer;
    }
   

	@Test
	void test() {
		Assert.assertEquals(8, solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
//		Assert.assertEquals(33, solution(4, 3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
	}

}

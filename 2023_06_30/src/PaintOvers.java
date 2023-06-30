import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PaintOvers {

    public int solution(int n, int m, int[] section) {
        int answer = 0, max = 0;
        
        for (int sec : section) {
        	if (max <= sec) {
        		max = sec + m;
        		answer++;
        	}
        }
        
        return answer;
    }
    
	@Test
	public void test() {
		Assert.assertEquals(2, solution(8, 4, new int[] {2,3,6}));
		Assert.assertEquals(1, solution(5, 4, new int[] {1,3}));
		Assert.assertEquals(4, solution(4, 1, new int[] {1,2,3,4}));
		Assert.assertEquals(3, solution(12, 3, new int[] {1,3,9,12}));
	}

}

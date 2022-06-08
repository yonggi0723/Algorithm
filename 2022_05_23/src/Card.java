import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class Card {

    public int solution(int[][] board, int r, int c) {
        int answer = 0;
        
        

        return answer;
    }

    
	@Test
	void test() {
		Assert.assertEquals(14, solution(new int[][] {
			{1,0,0,6},
			{2,0,0,0},
			{0,0,0,2},
			{6,0,1,0}
		}, 1, 0));
		
		Assert.assertEquals(16, solution(new int[][] {
			{3,0,0,2},
			{0,0,1,0},
			{0,1,0,0},
			{2,0,0,3}
		}, 0, 1));
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv 1 푸드파이
 * @author kim-yong-gi
 *
 */
class FoodFighter {

    public String solution(int[] food) {
    	StringBuilder sb1 = new StringBuilder();
    	StringBuilder sb2 = new StringBuilder();
    	
    	for (int i=1; i<food.length; i++) 
			sb1.append(Integer.toString(i).repeat(food[i]));

    	sb2.append(sb1);
    	sb2.append(0);
    	sb2.append(sb1.reverse());
    		
        return sb2.toString();
    }
	
	
	@Test
	void test() {
		Assert.assertEquals("1223330333221", solution(new int[] {1, 3, 4, 6}));
//		Assert.assertEquals("111303111", solution(new int[] {1, 7, 1, 2}));
	}

}

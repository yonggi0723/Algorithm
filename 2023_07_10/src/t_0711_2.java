import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 연속 부분 수열 합의 갯수 
 * @author gim-yong-gi
 *
 */
class t_0711_2 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int sum = 0;
        // 조합의 갯수 
        for (int i=1; i<=elements.length; i++) {
            for (int j=0; j<elements.length; j++) {
            	sum = 0;
            	for (int k=0; k<i; k++) 
            		sum += elements[(j+k) % elements.length];
            	set.add(sum);
            }
        }

        return set.size();
    }

    
	@Test
	void test() {
        Assert.assertEquals(18,solution(new int[] {7,9,1,1,4}));
	}

}

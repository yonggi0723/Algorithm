import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 단속 카메라 
 * @author kim-yong-gi
 */
class CCTV {
	
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2)->{
        	return o1[1] - o2[1];
        });

        int pos = 0, camera = 0;
        
        while (pos != routes.length) {
        	camera = routes[pos][1];
        	
        	for (; pos<routes.length; pos++) 
        		if (routes[pos][0] > camera || routes[pos][1] < camera)
        			break;
        	        	
        	answer++;
        }

        return answer;
    }

	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[][] {
			{-20,-15},
			{-14,-5},
			{-18,-13},
			{-5,-3}
		}));
		
		Assert.assertEquals(2, solution(new int[][] {
			{2,2},
			{0,1},
			{-10,9}
		}));
	}

}

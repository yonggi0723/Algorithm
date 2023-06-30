import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 lv2 요격 시스
 * @author gim-yong-gi
 *
 */
class InterceptSystem {

    public int solution(int[][] targets) {
        int answer = 0, end = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            
            return o1[1]-o2[1];
        });
        
        for (int[] target : targets) {
        	if (target[0] >= end) {
        		end = target[1];
        		answer++;
        	}
        }

        return answer;
    }
    
    // {1,4} {3,7} {4,5}, {4,8}, {5,12}, {10,14}, {11,13} 
    
	@Test
	void test() {
		Assert.assertEquals(3, solution(new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 마법의 엘리베이터 lv2 탐욕법
 * @author gim-yong-gi
 */

class t_0713_1 {

    public int solution(int storey) {
        int answer = 0, remainder = 0;
        
        while (storey != 0) {
        	remainder = storey % 10;
        	
        	if ((remainder == 5 && (storey % 100 > 50)) || remainder > 5 ) {
        		answer += 10-remainder;
        		storey += 10-remainder;
        	} else { 
        		answer += remainder;
        		storey -= remainder;
        	}
        	
        	storey /= 10;
        }

        return answer;
    }
	
	
	@Test
	void test() {
        Assert.assertEquals(5,solution(17));
        Assert.assertEquals(16,solution(2554));
        Assert.assertEquals(4, solution(2999));
        Assert.assertEquals(4, solution(2990));
        Assert.assertEquals(4, solution(2900));
        Assert.assertEquals(6, solution(95));
	}

}

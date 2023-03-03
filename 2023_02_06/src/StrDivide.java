import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 2/7 (확)
 * 햄버거 만들기 LV1
 * @author kim-yong-gi
 *
 */
class StrDivide {

    public int solution(String s) {
        int answer = 0, r1 = 0, r2 = 0;        
        char ch = 0;
        
        for (char tmp : s.toCharArray()) {
        	if (r1 == 0) {
        		ch = tmp;
        		answer ++;
        		r1 = 1;
        	} else if (ch == tmp )
        		r1++;
        	else 
        		r2++;
        	
        	if (r1 == r2) {
        		r1 = 0;
        		r2 = 0;
        	}
        }
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(6, solution("abracadabra"));
		Assert.assertEquals(3, solution("banana"));
		Assert.assertEquals(3, solution("aaabbaccccabba"));
		
	}

}

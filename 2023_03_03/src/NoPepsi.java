import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv1 콜라 문제
 * @author kim-yong-gi
 *
 */
class NoPepsi {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
        	answer += (n / a) * b;
        	n = (n / a * b) + (n % a);
        }
        
        return answer;
    }
    
	@Test
	void test() {
//		Assert.assertEquals(19, solution(2, 1, 20));
		Assert.assertEquals(9, solution(3, 1, 20));
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 2/7 (화)
 * 기사 단원 무기 Lv1
 * @author kim-yong-gi
 *
 */
class KnightWeapon {

    public int solution(int number, int limit, int power) {
        int answer = 0, weapon = 0;
        
        for (int i=0; i<number; i++) {
        	weapon = getMeasure(i+1);   
        	answer += weapon > 3 ? power:weapon;
        }      
        
        return answer;
    }
    
    private int getMeasure(int n) {
    	int cnt = 0;
    	
        for (int i=1; i<=Math.sqrt(n); i++) {
        	if (i%Math.sqrt(n) == 0) cnt += 1;
        	else if (n%i==0) cnt += 2;
        }
        return cnt;
    }
    
    
	@Test
	void test() {
//		Assert.assertEquals(10, solution(5, 3, 2));
		Assert.assertEquals(21, solution(10, 3, 2));
	}

}

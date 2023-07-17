import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv2 점찍기 
 * @author gim-yong-gi
 *
 */
class t_0714_1 {
	
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int x=0; x<=d; x+=k) {
            int y = (int) Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
            answer += y/k+1;
        }

        return answer;
    }
    
    private void distance(int x, int k,int d) {
        int y = (int) Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
        for (int i=0; i<=y/k; i++)
        	System.out.println(String.format("(%d,%d)", x, i*k));
    }

	@Test
	void test() {
		Assert.assertEquals(6, solution(2, 4));
		Assert.assertEquals(26, solution(1, 5));
	}

}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class t_0717_2 {

    public long solution(int r1, int r2) {
        long answer = 0;
        
        long y1 = 0, y2 = 0;
        long m1 = (long) Math.pow(r1, 2);
        long m2 = (long) Math.pow(r2, 2);
        
        for (int i=1; i<=r2; i++) {
        	y1 = (long) Math.ceil(Math.sqrt(m1-Math.pow(i, 2)));
        	y2 = (long) Math.floor(Math.sqrt(m2-Math.pow(i, 2)));

        	answer += y2 - y1 + 1;
        }
        
        return answer * 4;
    }
    
    public void calculate(int r1, int r2) {
    	
    }
    
    
	@Test
	void test() {
		Assert.assertEquals(20, solution(2 , 3));
		Assert.assertEquals(40, solution(2 , 4));
	}

}
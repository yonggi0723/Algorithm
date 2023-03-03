import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class StrSize {

    public int solution(String t, String p) {
        int answer = 0, size = t.length()-p.length()+1;
        
        long cnt = Long.parseLong(p);
        
        System.out.println(size);
        for (int i=0; i<size; i++) {
        	long num = Long.parseLong(t.substring(i,i+p.length()));

        	if (cnt >= num) {
        		answer ++;
        	}
        }
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(2, solution("3141592","271"));
		Assert.assertEquals(8, solution("500220839878","7"));
		Assert.assertEquals(3, solution("10203","15"));
		Assert.assertEquals(1, solution("15","16"));
	}

}

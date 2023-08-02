import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 Lv2 줄서는 방q
 * @author gim-yong-gi
 *
 */
class t_0731 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] dp = new long[n+1]; 
        
        List<Integer> list = new ArrayList<>();
        
        for (int i=1; i<=n; i++)
        	list.add(i);
        
        factorial(n, dp);
        
        long num = 0;
        
        for (int i=n-1; i>0; i--) {
        	num = k / dp[i];

        	if (k % dp[i] != 0)
        		num += 1;

        	if (num > list.size()) {
        		num = num % list.size();
        		
        		if (num % list.size() == 0)
        			num = list.size();
        	}

        	answer[n-1-i] = list.get((int)num-1);
        	list.remove((int)num-1);
        }
        
        answer[n-1] = list.get(0);
     
        return answer;
    }
    
    public long factorial(int n, long[] dp) {
    	if (n <= 1)
    		return dp[n] = n;
    	
    	if (dp[n] != 0)
    		return dp[n] * n;
    	else 
    		return dp[n] = factorial(n-1, dp) * n;
    }
    
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {3,1,2}, solution(3, 5));
		Assert.assertArrayEquals(new int[] {2,1,3,4}, solution(4, 7));
		Assert.assertArrayEquals(new int[] {2,3,4,1}, solution(4, 10));
	}

}

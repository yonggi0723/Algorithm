import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ConvertNumber {

    public int solution(int x, int y, int n) {  
    	int[] dp = new int[y+1];
    	
    	Arrays.fill(dp, -1);
    	
    	dp[x] = 0;
    	
    	for (int i=x; i<y+1; i++)  {
    		if (dp[i] == -1)
    			continue;
    		
    		if(i+n <= y)
    			dp[i+n] = calculate(dp[i]+1, dp[i+n]);			
    		if(i*2 <= y)
    			dp[i*2] = calculate(dp[i]+1, dp[i*2]);		
    		if(i*3 <= y)
    			dp[i*3] = calculate(dp[i]+1, dp[i*3]);		
    	}
    	
    	return dp[y];    	
    }
    
    private int calculate(int num1, int num2) {
    	return num2 == -1 ? num1:Math.min(num1, num2);
    }
    
   
    
	@Test
	void test() {
		Assert.assertEquals(2, solution(10, 40, 5));
		Assert.assertEquals(1, solution(10, 40, 30));
		Assert.assertEquals(-1, solution(2, 5, 4));
	}

}

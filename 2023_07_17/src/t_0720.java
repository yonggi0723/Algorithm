import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class t_0720 {

    public int solution(int n) {
    	if (n % 2 != 0)
    		return 0;
    	
    	int[] dp = new int[n+1];
    	
    	dp[1] = 2;
    	dp[2] = 3;
    	
    	for (int i=3; i<=n; i++) {
    		if (i % 2 != 0)
    			dp[i] = (dp[i-1] * 2) + dp[i-2]; 
    		else 
    			dp[i] = dp[i-1] + dp[i-2];
    	}

    	
    	return dp[n];    
    }
    
	@Test
	void test() {
		Assert.assertEquals(0, solution(3));
		Assert.assertEquals(41, solution(6));
		Assert.assertEquals(11, solution(4));
	}

}

// 1 2 3
// 0 3 5

//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_0802_1 {
	
	private int[] discounts = {10,20,30,40};
	
	int[] answer = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
    	dfs(0,emoticons,new int[emoticons.length],users);
    	
    	return answer;
    }
    
    private void dfs(int depth , int[] emoticons, int[] rates, int[][] users) {
    	if (depth == emoticons.length) {
    		findAnswer(emoticons,rates, users);
    		return;
    	}
    	
    	for (int i=0; i<discounts.length; i++) {
    		rates[depth] = discounts[i];
    		dfs(depth+1, emoticons, rates, users);
    	}
    }
    
    private void findAnswer(int[] emoticons,int[] rates, int[][] users) {
    	int cost = 0, join = 0, money = 0;
    	
    	for (int[] user : users) {
    		money = 0;
    		for (int i=0; i<emoticons.length; i++) {
    			if (user[0] <= rates[i]) 
    				money += emoticons[i] * ((double) (100-rates[i]) / 100);
    		}
    		
    		if (user[1] <= money)
    			join++;
    		else 
    			cost += money;
    	}
    	
    	if (answer[0] < join) {
    		answer[0] = join;
    		answer[1] = cost;
    	} else if (answer[0] == join && answer[1] < cost)
    		answer[1] = cost;
    }

	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {1, 5400}, solution(new int[][] {{40, 10000},{25, 10000}}, new int[] {7000, 9000}));
		Assert.assertArrayEquals(new int[] {4, 13860}, solution(new int[][] {{40, 2900},{23, 10000},{11, 5200},{5, 5900},{40, 3100},{27, 9200},{32, 6900}}, new int[] {1300, 1500, 1600, 4900}));
	}

}

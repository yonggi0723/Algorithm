import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 GPS (카카오 본선)
 * @author kim-yong-gi
 */
class GPS {

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
    	int answer = 0;
    	
    	int[][] map = new int[n+1][n+1];
    	int[][] dp = new int[k][n+1];
    	
    	for (int[] edge : edge_list) {
    		
    		int x = edge[0];
    		int y = edge[1];
    		
    		map[x][y] = 1;
    		map[y][x] = 1;
    	}
   
    	for (int i=0; i<k; i++)
    		for (int j=0; j<n+1; j++)
    			dp[i][j] = k;
    	
    	dp[0][gps_log[0]] = 0; 
    	
    	for (int i=1; i<k; i++) {
    		for (int j=1; j<n+1; j++) {
    			dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
    			
    			for (int l=1; l<n+1; l++) {
    				if (map[j][l] == 1)
    					dp[i][j] = Math.min(dp[i][j], dp[i-1][l]);
    			}
    			
    			if (j != gps_log[i])
    				dp[i][j]++;
    		}
    		
    		
    	}
    	answer = dp[k-1][gps_log[k-1]];
    	
    	return answer >= k ? -1:answer;
    }
    
    
    private void print(int[][] matrix) {
    	for (int[] row : matrix) {
    		for (int col : row) 
    			System.out.print(col + " ");
    		System.out.println();
    	}
    	System.out.println();
    }

	@Test
	void test() {
		Assert.assertEquals(1, solution(7, 10, new int[][] {
			{1,2}, {1,3}, {2,3},{2,4},{3,4}, {3,5}, {4,6}, {5,6}, {5,7}, {6,7}
		}, 6, new int[] {1, 2, 3, 3, 6, 7}));
	}

}


// 0 
// 1 
// 2 
// 3
// 4
// 5
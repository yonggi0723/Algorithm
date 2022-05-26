import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 섬연결하기
 * 크루스칼 알고리즘 : 가장 적은 비용으로 모든 노드를 연결하기 위해 사용되는 알고리즘
 * @author kim-yong-gi
 *
 */
class Island {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] table = new int[n];
        
        for (int i=0; i<n; i++)
        	table[i] = i;
        
        Arrays.sort(costs, (o1,o2)->{return o1[2]-o2[2];});
        
        int x = 0, y = 0;
        
        for (int[] cost : costs) {
        	x = find(cost[0], table);
        	y = find(cost[1], table);
        	
        	if (x != y) {
            	table[x] = y;
            	answer += cost[2];
        	} 
        }

        return answer;
    }
    
    private int find(int x, int[] table) {
    	if (x == table[x])
    		return x;
    	return find(table[x], table);
    }
    
	@Test
	void test() {
		Assert.assertEquals(4, solution(4, new int[][] {
			{0,1,1},
			{0,2,2},
			{1,2,5},
			{1,3,1},
			{2,3,8}
		}));
		
		Assert.assertEquals(15, solution(5, new int[][] {
			{0,1,5},
			{1,2,3},
			{2,3,3},
			{3,1,2},
			{3,0,4},
			{2,4,6},
			{4,0,7}
		}));
	}

}

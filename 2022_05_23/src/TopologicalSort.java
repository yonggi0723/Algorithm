import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 모두 0으로 만들기 
 * Topological sort (위상정렬) 
 * 방향성이 있으며 사이클이 없는 그래프에서 사용가능 
 * @author kim-yong-gi
 *
 */
class TopologicalSort {

    public long solution(int[] a, int[][] edges) {
    	long answer = 0, sum = 0;
    	
    	long[] a_tmp = new long[a.length];
    	int[] indegree = new int[a.length];
    	
    	List<List<Integer>> info = new ArrayList<>();
    	
    	Queue<Integer> que = new LinkedList<>();
    	
    	for (int i=0; i<a.length; i++) {
    		a_tmp[i] = a[i];
    		sum += a[i];
    		info.add(new ArrayList<>());
    	}
    	
    	if (sum != 0)
    		return -1;
    	
    	int x = 0, y = 0, node = 0;
    	
    	for (int i=0; i<edges.length; i++) {
    		x  = edges[i][0];
    		y  = edges[i][1];
    		
    		info.get(x).add(y);
    		info.get(y).add(x);
    		
    		indegree[x]++;
    		indegree[y]++;
    	}
    	
    	for (int i=0; i<indegree.length; i++) 
    		if (indegree[i] == 1)
    			que.offer(i);
    	
    	while (!que.isEmpty()) {	
    		node = que.poll();
    		
    		indegree[node]--;
    		answer += Math.abs(a_tmp[node]);
    		
    		for (int val : info.get(node)) {
        		
        		if (indegree[val] == 0 )
        			continue;
        		
        		indegree[val]--;
        		
        		a_tmp[val] += a_tmp[node];
        		a_tmp[node] = 0;

        		if (indegree[val] == 1)
        			que.offer(val);
    		}
    	}
    	
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(9, solution(new int[] {-5,0,2,1,2}, new int[][] {{0,1},{3,4},{2,3},{0,3}}));
		Assert.assertEquals(-1, solution(new int[] {0,1,0}, new int[][] {{0,1},{1,2}}));
	}

}

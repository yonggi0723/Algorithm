import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class t_0721 {

    public int[][] solution(int n) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>(); 
        
        move(1, 2, 3, n, list);
        
        answer = new int[list.size()][2];
        
        for (int i=0; i<list.size(); i++)
        	answer[i] = list.get(i);
       
        return answer;
    }
    
    private void move(int start , int mid, int dest, int num, List<int[]> list) {
    	if (num == 1) {
    		list.add(new int[] {start,dest});
    		return;
    	}
    	
    	move(start, dest, mid, num-1,list);
		list.add(new int[] {start,dest});
		move(mid, start, dest, num-1,list);
    }
    
    
	@Test
	void test() {
//		Assert.assertArrayEquals(new int[][] {{1,3}}, solution(1));
		Assert.assertArrayEquals(new int[][] {{1,2},{1,3},{2,3}}, solution(3));
	}

}


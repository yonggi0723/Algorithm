import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/*
 * 프로그래머스 lv2 혼자놀기 개고수 
 * @author gim-yong-gi
 *
 */
class t_0717 {

    public int solution(int[] cards) {
        int pos = 0, cnt = 0;
        
        boolean[] visited = new boolean[cards.length];

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<cards.length; i++) {
        	if (visited[i]) continue;
        	pos = i;
        	cnt = 0;
        	
        	while (!visited[pos]) {
        		cnt++;
        		visited[pos] = true;
        		pos = cards[pos]-1;
        	}
        	que.add(cnt);
        }

        return que.size() < 2 ? 0:que.poll()*que.poll();
    }
    
	@Test
	void test() {
		Assert.assertEquals(12, solution( new int[] {8,6,3,7,2,5,1,4}));
	}

}


// 2 5 6

// 8 4 7 1

// 3

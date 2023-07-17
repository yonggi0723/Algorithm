import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 lv2 광물캐기 
 * @author gim-yong-gi
 *
 */
class t_0711_1 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0, size = 0;
        
        // 곡갱이의 최대 갯수 
        for (int pick : picks)
        	size += pick;
        
        // 각 광물 피로도를 담을 맵 
        int[][] map = new int[size][3];
        
        int pos = 0, cnt = 0;
        
        // 곡괭이 별 광물피로도 계산 
        for (String mineral : minerals) {
        	if (++cnt > 5) {
        		pos++;
        		cnt = 1;
        	}
        	
        	if (pos >= size) break;
        	
        	if (mineral.equals("diamond")) {
        		map[pos][0] += 1;
        		map[pos][1] += 5;
        		map[pos][2] += 25;
        	} else if (mineral.equals("iron")){
        		map[pos][0] += 1;
        		map[pos][1] += 1;
        		map[pos][2] += 5;
        	} else { 
        		map[pos][0] += 1;
        		map[pos][1] += 1;
        		map[pos][2] += 1;
        	}
        }
        
        // 돌곡괭이로 캤을 때 가장 높은 피로도로 정
        Arrays.sort(map, (o1,o2)->{
        	return o2[2]-o1[2];
        });
        
       
        for (int i=0; i<size; i++) {
        	if (picks[0] != 0) {
        		answer += map[i][0];
        		picks[0] -=1;
        	} else if (picks[1] != 0) {
            	answer += map[i][1];
        		picks[1] -=1;
        	} else if (picks[2] != 0){
            	answer += map[i][2];
        		picks[2] -=1; 
        	}
        }

        return answer;
    }
    
    // 1 1 5 1 25  25 25 25 25 25
	@Test
	void test() {
		Assert.assertEquals(14, solution(new int[] {1, 1, 0}, new String[] {"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"}));
		Assert.assertEquals(12, solution(new int[] {1, 3, 2}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
		Assert.assertEquals(50, solution(new int[] {0, 1, 1}, new String[] {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
	}
	

}

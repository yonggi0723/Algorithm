import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * 프로그래머스 보석 쇼핑 
 * 투포인트 알고리즘 
 * @author kim-yong-gi
 */
class GemStone {

    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();

        for (String gem : gems) 
        	map.put(gem, map.getOrDefault(gem, 0)+1);
        	
        int total = map.size(), start = 0, len = gems.length, temp = 0;
        
        map.clear();

        for (int i=0; i<gems.length; i++) {
        	map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
        	que.offer(gems[i]);
        	
        	while (map.get(que.peek()) > 1) {
        		String tmp = que.peek();
        		
        		if (map.get(tmp) > 1) {
        			map.put(tmp, map.get(tmp)-1);
        			que.poll();
        			temp++;
        		}
        	}
        	
        	if (map.size() == total) {
        		if ( len > que.size()) {
        			len = que.size();
        			start = temp;
        		}
        	}
        }
        
        return new int[] {start + 1, start + len};
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {1,1}, solution(new String[] {"XYZ", "XYZ", "XYZ"}));
		Assert.assertArrayEquals(new int[] {3,7}, solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
		Assert.assertArrayEquals(new int[] {1,3}, solution(new String[] {"AA", "AB", "AC", "AA", "AC"}));
		Assert.assertArrayEquals(new int[] {1,5}, solution(new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
		Assert.assertArrayEquals(new int[] {8,10}, solution(new String[] {"A","B","B","B","B","B","B","C","B","A"}));
		Assert.assertArrayEquals(new int[] {3,4}, solution(new String[] {"A","A","A","B","B"}));
	}

}

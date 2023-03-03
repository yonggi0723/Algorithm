import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 
 * 프로그래머스 LV1 2/7 (화)
 * 가장 가까운 글자
 * @author kim-yong-gi
 *
 */
class NearStr {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int pos = 0;
        
        for (char ch : s.toCharArray()) {
        	answer[pos] = pos - map.getOrDefault(ch, pos+1);
        	map.put(ch, pos++);
        	
        }
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {-1,-1,-1,2,2,2}, solution("banana"));
		Assert.assertArrayEquals(new int[] {-1,-1,1,-1,-1,-1}, solution("foobar"));
	}

}

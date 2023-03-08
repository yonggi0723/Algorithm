import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv1
 * @author kim-yong-gi
 *
 */
class Keyboard {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i=0; i< targets.length; i++) {
        	for (char ch : targets[i].toCharArray()) {
        		int num = getIndex(keymap, ch);

        		if (num == -1) {
        			answer[i] = -1;
        			break;
        		} else {
        			answer[i] += num;
        		}

        	}
        	
        }
        
        return answer;
    }
    
    public int getIndex(String[] keymap, char ch) {
    	int min = 101;
   
    	for (String key : keymap) {
    		int tmp = key.indexOf(ch);
    		if (tmp == 0 ) {
    			return 1;
    		} else if (tmp != -1) 
    			min = Math.min(min, tmp);
    	}

    	return min == 101 ? -1:min+1;
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {9,4}, solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"}));
		Assert.assertArrayEquals(new int[] {-1}, solution(new String[] {"AA"}, new String[] {"B"}));
		Assert.assertArrayEquals(new int[] {4,6}, solution(new String[] {"AGZ", "BSSS"}, new String[] {"ASA","BGZ"}));
	}

}

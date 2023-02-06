import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * 프로그래머스 lv 1 둘만의 암호
 * @author kim-yong-gi
 *
 */
class password {
	
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
        	int idx = index;
        	char tmp = ch;
        	
        	for (int i=0; i<idx; i++) {
        		tmp = tmp >= 'z' ? 'a':(char) (tmp + 1);
        		idx += skip.contains(String.valueOf(tmp)) ? 1:0;
        	}

        	answer.append(tmp);
        }
        
        return answer.toString();
    }
    
    
	@Test
	void test() {
		Assert.assertEquals("hello", solution("dziil", "ascf", 3));
	}
}

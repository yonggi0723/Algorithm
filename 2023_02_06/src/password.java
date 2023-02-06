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
        String answer = "";
        
        char[] skip_arr = skip.toCharArray();
        
        Arrays.sort(skip_arr);
        
        for (char ch : s.toCharArray()) {
        	
        }
        
        return answer;
    }
    

	@Test
	void test() {
		Assert.assertEquals("hello", solution("dziil", "ascf", 3));

	}
}

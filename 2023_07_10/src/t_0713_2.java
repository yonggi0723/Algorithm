import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class t_0713_2 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> w_map = new HashMap<>();
        
        int num = 10;
        
        // 내 장바구니 원하는 품목 설정 
        for (int i=0; i<want.length; i++) {
        	map.put(want[i], number[i]);
        	w_map.put(want[i], number[i]);
        }
        

        for (int i=0; i<discount.length; i++) {
        	int value = w_map.getOrDefault(discount[i],0);
        	
        	if (value > 0) {
        		value = map.getOrDefault(discount[i],0);
        		map.put(discount[i], value-1);
        		if (value > 0) num -=1;
        	}
  
        	if (i<9) continue;
        	
        	if (num == 0) {
        		answer++;
        	}

        	
        	if ( w_map.getOrDefault(discount[i-9],0) != 0) {
        		value = map.getOrDefault(discount[i-9],0);
        		map.put(discount[i-9], value+1);
        		if (value >= 0) num+=1;
        	}
        	
        }
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(3, solution(new String[] {"banana", "apple", "rice", "pork", "pot"}, new int[] {3, 2, 2, 2, 1}, new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
		Assert.assertEquals(0, solution(new String[] {"apple"}, new int[] {10}, new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
	}

}

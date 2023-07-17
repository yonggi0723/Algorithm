import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class t_0714_2 {

    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        
        
        for (int i=0; i<topping.length; i++) { 	
        	map.put(topping[i], map.getOrDefault(topping[i], 0)+1);
        	set1.add(topping[i]);
        }
        
        int cnt = 0;
        
        for (int i=topping.length-1; i>=0; i--) {
        	set2.add(topping[i]);
        	
        	cnt = map.getOrDefault(topping[i],0);
        	map.put(topping[i], cnt-1);
        	
        	if (cnt-1 == 0)
        		set1.remove(topping[i]);
        	
        	if (set1.size() == set2.size()) {
        		answer++;
        	}
        }
        
        
        return answer;
    }
    
	@Test
	void test() {
		Assert.assertEquals(2, solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
		Assert.assertEquals(0, solution(new int[] {1, 2, 3, 1, 4}));
	}

}

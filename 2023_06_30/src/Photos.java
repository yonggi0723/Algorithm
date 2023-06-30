import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Photos {
	
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for (int i=0; i<name.length; i++) 
        	map.put(name[i], yearning[i]);
        
        for (int i=0; i<photo.length; i++) 
        	for (String man : photo[i]) 
        		answer[i] += map.getOrDefault(man, 0);
   
        
        return answer;
    }

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {19, 15, 6}, solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3}, new String[][] {
			{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}
		}));
		Assert.assertArrayEquals(new int[] {67, 0, 55}, solution(new String[] {"kali", "mari", "don"}, new int[] {11, 1, 55}, new String[][] {
			{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}
		}));
		Assert.assertArrayEquals(new int[] {5, 15, 0}, solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3}, new String[][] {
			{"may"},{"kein", "deny", "may"}, {"kon", "coni"}
		}));
	}

}

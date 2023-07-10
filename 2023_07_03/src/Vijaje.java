import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class Vijaje {
	
    public int[] solution(String[] maps) {
    	int[][] memo = new int[maps.length][maps[0].length()];
    	
        List<Integer> list = new ArrayList<>();
        
    	for (int i=0; i<maps.length; i++) {
    		for (int j=0; j<maps[i].length(); j++) {
      			if (maps[i].charAt(j) == 'X') {
      				memo[i][j] = -1;
      				continue;
      			}
      			
      			if (memo[i][j] == -1) continue;
      			list.add(check(i, j, maps, memo));
    		}	
    	}

    
        Collections.sort(list);
        
        if (list.size() == 0) return new int[] {-1};
        
        int[] answer = new int[list.size()];
        
        for (int i=0; i<list.size(); i++)
        	answer[i] = list.get(i);
        
        
        return answer;
    }
    
    private int check(int x, int y, String[] maps, int[][] memo) { 
    	if ( x < 0 
    			|| y < 0 
    			|| y > maps[0].length()-1
    			|| x > maps.length-1
    			|| maps[x].charAt(y) == 'X'
    			|| memo[x][y] == -1
    			) {
    		return 0;
    	}

    	memo[x][y] = -1;
   
    	return Character.getNumericValue(maps[x].charAt(y)) + 
    			check(x,y-1 ,maps, memo) + 
    			check(x-1,y ,maps, memo) + 
    			check(x+1,y ,maps, memo) + 
    			check(x,y+1 ,maps, memo);
    }
    
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {1, 1, 27}, solution(new String[] {"X591X","X1X5X","X231X", "1XXX1"}));
//		Assert.assertArrayEquals(new int[] {-1}, solution(new String[] {"XXX","XXX","XXX"}));
	}

}

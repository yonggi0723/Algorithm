import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_07_26 {

    public int solution(String[] board) {
        int answer = 1;

        Map<Character, Integer> map = new HashMap<>();

        String str = "";
        for (int i=0; i<board.length; i++) {
        	check(board[i], map);
        	str = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);
        	map.put(board[i].charAt(0), map.getOrDefault(board[i].charAt(0), 0)+1);
        	map.put(board[i].charAt(1), map.getOrDefault(board[i].charAt(1), 0)+1);
        	map.put(board[i].charAt(2), map.getOrDefault(board[i].charAt(2), 0)+1);
        	check(str,map);
        }
        
        check("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2),map);
        check("" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0),map);

        int o = map.getOrDefault('O', 0);
        int x = map.getOrDefault('X', 0);
        
        int wX = map.getOrDefault('x', 0);
        int wO = map.getOrDefault('o', 0);
        
        if (x > o || x+1 < o) return 0;
       
        if (wX >= 1 && wO >= 1) return 0;
        
        if (wO == 1 && o != x+1) return 0;
        
        if (wX == 1 && o != x) return 0;

        return answer;
    }
    
    private void check(String str, Map<Character, Integer> map) {
    	if (str.equals("OOO"))
    		map.put('o', map.getOrDefault('o', 0)+1);
    	else if(str.equals("XXX"))
    		map.put('x', map.getOrDefault('x', 0)+1);
    }
    
	@Test
	void test() {
		Assert.assertEquals(1, solution(new String[] {"O.X", ".O.", "..X"}));
		Assert.assertEquals(1, solution(new String[] {"XOX", "XO.", ".OO"}));
		Assert.assertEquals(0, solution(new String[] {"OOO", "...", "XXX"}));
		Assert.assertEquals(1, solution(new String[] {"...", ".O.", "..."}));
		Assert.assertEquals(0, solution(new String[] {"...", ".X.", "..."}));
		Assert.assertEquals(1, solution(new String[] {"...", "...", "..."}));
	}

}

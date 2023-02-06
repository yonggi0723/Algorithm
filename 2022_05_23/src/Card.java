import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class Card {

    public int solution(int[][] board, int r, int c) {
        int answer = 0, v = 0;
        
        boolean[] table = new boolean[7];
        
        for (int i=0; i<board.length; i++)
        	for (int j=0; j<board[i].length; j++) {
        		v = board[i][j];
        		
        		if (v != 0 )
        			table[v] = true;
        		answer++;
        	}

        
        per(0, answer/2, table);
        
        return answer;
    }
    
    private void per( int depth, int count, boolean[] table) {
    	if (depth == count) 
    		return;

    	for (int i=0; i<table.length; i++)
    		if ( table[i] == true) {
    			table[i] = false;
    			per(depth+1, count, table);
    			table[i] = true;
    		}
    }
    
	@Test
	void test() {
		Assert.assertEquals(14, solution(new int[][] {
			{1,0,0,6},
			{2,0,0,0},
			{0,0,0,2},
			{6,0,1,0}
		}, 1, 0));
		
		Assert.assertEquals(16, solution(new int[][] {
			{3,0,0,2},
			{0,0,1,0},
			{0,1,0,0},
			{2,0,0,3}
		}, 0, 1));
	}

}

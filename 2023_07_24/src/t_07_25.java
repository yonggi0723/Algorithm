import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;

class t_07_25 {

    public int solution(String[] board) {
        int answer = -1;
        
    	int[] dx = {-1,0,1,0};
    	int[] dy = {0,-1,0,1};
    	
    	boolean[][] visited = new boolean[board.length][board[0].length()];
    	
        int sX = 0, sY = 0, eX = 0, eY = 0;
        
        int[][] map = new int[board.length][board[0].length()];

        for (int i=0; i<board.length; i++) {
        	for (int j=0; j<board[i].length(); j++) {
        		
        		if (board[i].charAt(j) == 'D' )
        			map[i][j] = -1;
        		else 
        			map[i][j] = 0;
        		
        		if (board[i].charAt(j) == 'G') {
        			eX = i;
        			eY = j;
        		} 
        		
        		if (board[i].charAt(j) == 'R') {
        			sX = i;
        			sY = j;
        		}
        	}
        }
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {sX, sY, 0});
        visited[sX][sY] = true;
        
        int[] node;
        int x = 0, y =0;
        
        while(!que.isEmpty()) {
        	node =  que.poll();
        	x = node[0];
        	y = node[1];
        	
        	if (x == eX && y == eY)
        		answer = node[2];
        	
        	for (int i=0; i<4; i++) {
        		int[] val = search(x, y, dx[i], dy[i], map);
        		
        		if (visited[val[0]][val[1]]) 
        			continue;
        		
        		visited[val[0]][val[1]] = true;
        		
        		que.add(new int[] {val[0], val[1], node[2]+1});
        		System.out.println(val[0] + " " + val[1] + " " + (node[2]+1));
        	}
        	
        	
        }
        
        
        return answer;
    }
    
    private int[] search(int x, int y, int dx, int dy, int[][] map) {
    	if (x < 0 || y < 0 || x > map.length-1 || y > map[0].length-1 || map[x][y] == -1) 
    		return new int[] {Math.max(0, x-dx), Math.max(0,y-dy)};
    	return search(x+dx, y+dy, dx, dy, map);
    }    
    
	@Test
	void test() {
		Assert.assertEquals(7, solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
//		Assert.assertEquals(-1, solution(new String[] {".D.R", "....", ".G..", "...D"}));
	}

}

// ...D..R
// .D.G...
// ....D.D
// ..D....

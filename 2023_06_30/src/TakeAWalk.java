import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TakeAWalk {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int[][] def = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        		
        boolean start = false;
        
        // 시작위치 찾기 
        for (int i=0; i<park.length; i++)  {
        	if (start) break;
        	
        	for (int j=0; j<park[i].length(); j++)  
        		if (park[i].charAt(j) == 'S') {
        			answer[0] = i;
        			answer[1] = j;
        			break;
        		}
        }
        
        int x = 0, y = 0, distance = 0, idx = 0;
        boolean move = true;
        
        for (String route : routes) {
        	String[] str = route.split(" ");
        	
        	distance = Integer.parseInt(str[1]);
        	
        	x = answer[1];
        	y = answer[0];
        	
        	// 방위 설정 
        	if (str[0].equals("N"))
        		idx = 0;
        	else if (str[0].equals("E"))
        		idx = 1;
        	else if (str[0].equals("S"))
        		idx = 2;
        	else if (str[0].equals("W"))
        		idx = 3;
        
        	// 범위 및 장애물 탐지 
        	move = true;
        	for (int i=0; i<distance; i++) {
        		x += def[idx][1];
        		y += def[idx][0];
        		
        		if (x < 0 || y < 0 || x >= park[0].length()|| y >= park.length || park[y].charAt(x) == 'X') {
        			move = false;
        			break;
        		}
        	}
        	
        	// 이동 
        	if (move) {
        		answer[0] = y;
        		answer[1] = x;
        	}
        }

        return answer;
    }
    
	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {2,1}, solution(new String[] {"SOO","OOO","OOO"}, new String[] {"E 2","S 2","W 1"}));
		Assert.assertArrayEquals(new int[] {0,1}, solution(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"}));
		Assert.assertArrayEquals(new int[] {0,0}, solution(new String[] {"OSO","OOO","OXO","OOO"}, new String[] {"E 2","S 3","W 1"}));
	}

}



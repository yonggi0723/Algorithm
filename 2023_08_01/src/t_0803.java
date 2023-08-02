import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;


class t_0803 {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<int[]> list = new ArrayList<>();
        
        collaz(0, k, list);
        
        double[] area = new double[list.size()];

        // 각 구간별 넓이 구하기 
        for (int i=1; i<area.length; i++) 
        	area[i] = area[i-1] + ((list.get(i-1)[1]+list.get(i)[1]) * 0.5);

        int x1 = 0, x2 = 0;
        
        // 범위 계산 
        for (int i=0; i<answer.length; i++) {
        	x1 = ranges[i][0];
        	x2 = list.size()- 1 + ranges[i][1];
        	
        	answer[i] = x1 > x2 ? -1.0:area[x2] - area[x1];
        }
        
        return answer;
    }
    
    private void collaz(int depth, int num,List<int[]> list) {
    	list.add(new int[] {depth, num});
    	if (num == 1)return;
    	collaz(depth + 1, num % 2 == 0 ? num/2:num*3+1, list);
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new double[] {33.0,31.5,0.0,-1.0},solution(5, new int[][] {{0,0},{0,-1},{2,-3},{3,-3}}),0.001);
	}

}


// 5.5 + 5 = 10.5
// 4 + 8 = 12
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class HomeClean {

    public int[] solution(String[] wallpaper) {
        int lux = wallpaper[0].length(), luy = wallpaper.length, rdx = -1, rdy = -1;

        for (int i=0; i<wallpaper.length; i++) {
        	for (int j=0; j<wallpaper[i].length(); j++) {

        		if (wallpaper[i].charAt(j) != '#') continue;
    
    			lux = Math.min(j, lux);
    			luy = Math.min(i, luy);
    			rdx = Math.max(j+1, rdx);
    			rdy = Math.max(rdy, i+1);
        	}
        }
        
        return new int[] {luy,lux,rdy,rdx};
    }
    
	@Test
	void test() {
		Assert.assertArrayEquals(new int[] {0,1,3,4}, solution(new String[] {".#...", "..#..", "...#."}));
		Assert.assertArrayEquals(new int[] {1,3,5,8}, solution(new String[] {
				"..........", 
				".....#....", 
				"......##..", 
				"...##.....", 
				"....#....."}));
//		Assert.assertArrayEquals(new int[] {0,0,7,9}, solution(new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}));
//		Assert.assertArrayEquals(new int[] {1,0,2,1}, solution(new String[] {"..", "#."}));
	}

}

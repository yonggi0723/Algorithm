import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv2 숫자카드 나누기
 * @author gim-yong-gi
 *
 */
class t_0719 {
    
	public int solution(int[] arrayA, int[] arrayB) {        
        return Math.max(check(getGCD(arrayA),arrayB), check(getGCD(arrayB),arrayA));
    }
	
	private int check(int gcd, int[] array) {
		if (gcd == 1)
			return 0;
		
		for (int num : array)
			if (num % gcd == 0)
				return 0;
		return gcd;
	}
	
	private int getGCD(int[] array) {
		int gcd = array[0];
		
		for (int i=1; i<array.length; i++)
				gcd = gcd(gcd,array[i]);
		
		return gcd;
	}
 	
	private int gcd(int a, int b) { //최대공약수 - 재귀함수 사용
		if(a%b ==0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
    
	@Test
	void test() {
		Assert.assertEquals(8, solution(new int[] {5}, new int[] {8}));
//		Assert.assertEquals(0, solution(new int[] {10, 17}, new int[] {5, 20}));
//		Assert.assertEquals(10, solution(new int[] {10, 20}, new int[] {5, 17}));
//		Assert.assertEquals(7, solution(new int[] {14, 35, 119}, new int[] {18, 30, 102}));
	}

}

//
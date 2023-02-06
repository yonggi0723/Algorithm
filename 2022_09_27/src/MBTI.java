import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class MBTI {

    public String solution(String[] survey, int[] choices) {
    	char[] arr = new char[4];
         
    	char[][] type = new char[][] {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	int score = 0;
    	
    	for (int i=0; i<survey.length; i++) {
    		score = Math.abs(choices[i]-4);
    		
    		if (choices[i] < 4) 
    			map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0),0) + score);
    		else if (choices[i] > 4) 
    			map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1),0) + score);
    		
    	}
    	
    	for (int i=0; i<arr.length; i++) 
    		arr[i] = getChar(type[i][0],type[i][1],map);
    	
    
        return new String(arr);
    }
    
    
    private char getChar(char left, char right, Map<Character,Integer> map) {   
    	return map.getOrDefault(left, 0) < map.getOrDefault(right, 0) ? right:left;
    }
    
	@Test
	void test() {
		Assert.assertEquals("TCMA",solution(new String[] {"AN","CF","MJ","RT","NA"}, new int[] {5,3,2,7,5}));
		Assert.assertEquals("RCJA", solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
	} 

}

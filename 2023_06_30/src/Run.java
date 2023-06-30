import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

public class Run {

    public String[] solution(String[] players, String[] callings) {
    	
    	HashMap<String, Integer> rank = new HashMap<String, Integer>();

    	
    	int idx = 0;
    	String loser = "";
    	
    	for (String player : players) 
    		rank.put(player, idx++); 

        for (String calling : callings) {
        	idx = rank.get(calling);
        	loser = players[idx-1] ;
        	
        	players[idx-1] = calling;
        	players[idx] = loser;
        	rank.put(calling, idx-1);
        	rank.put(loser, idx);
        }
        
        return players;
    }
    
	@Test
	public void test() {
		Assert.assertArrayEquals(
				new String[] {"mumu", "kai", "mine", "soe", "poe"}, 
				solution(
						new String[] {"mumu", "soe", "poe", "kai", "mine"}, 
						new String[] {"kai", "kai", "mine", "mine"}));
	}

}


//5,4,3,2,1

//0,0,0,2,2

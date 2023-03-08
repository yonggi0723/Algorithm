import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 lv1 카드뭉
 * @author kim-yong-gi
 *
 */
class CardDeck {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        Queue<String> que2 = new LinkedList<>();
        
        for (String card : cards1) 
        	que1.add(card);
        
        for (String card : cards2)
        	que2.add(card);

        for (String word : goal) {
        	
        	if (que1.size() != 0 && que1.peek().equals(word)) 
        		que1.poll();
        	else if (que2.size() != 0 && que2.peek().equals(word))
        		que2.poll();
        	else 
        		return "No";    			
        }

        return "Yes";
    }
    
	@Test
	void test() {
		Assert.assertEquals("Yes", solution(new String[] {"i", "drink", "water"}, new String[] {"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
		Assert.assertEquals("No", solution(new String[] {"i", "water", "drink"}, new String[] {"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
	}

}

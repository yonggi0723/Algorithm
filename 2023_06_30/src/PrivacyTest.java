import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class PrivacyTest {

    public int[] solution(String today, String[] terms, String[] privacies) {
    	List<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String term :terms) {
        	String[] str = term.split(" ");
        	map.put(str[0], Integer.parseInt(str[1]));
        }
        
        long info = 0 , end = calculate(today, 0);
        
        for (int i=0; i<privacies.length; i++) {
        	String[] str = privacies[i].split(" ");
        	info = calculate(str[0], map.getOrDefault(str[1],0));
        	
        	
        	if (info <= end) list.add(i+1);
        }
        
        int[] array = new int[list.size()];
        
        for (int i=0; i<list.size(); i++) 
        	array[i] = list.get(i);
        
        return array;
    }
    
    public long calculate(String str, int month) {
    	try {
        	SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(format.parse(str));
        	cal.add(Calendar.MONTH, month);
        	return cal.getTimeInMillis();
    	} catch(Exception e) {
    		return 0;
    	}
    }
    
	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] {1,3}, solution("2022.05.19", new String[] {
				"A 6", "B 12", "C 3"
		}, new String[] {
				"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
		}));
		Assert.assertArrayEquals(new int[] {1,4,5}, solution("2020.01.01", new String[] {
				"Z 3", "D 5"
				}, new String[] {
						"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}));
	}

}

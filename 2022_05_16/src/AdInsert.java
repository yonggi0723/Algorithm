import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 광고 삽입 (카카오 블라인드 2021)
 * @author kim-yong-gi
 */
class AdInsert {

    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        
        int ply = getTime(play_time+1);

        int[] div = new int[ply];
       
        for (String log : logs) {
        	String[] arr = log.split("-");
        	
        	int st = getTime(arr[0]);
        	int ed = getTime(arr[1]);
        	
        	div[st]++;
        	div[ed]--;
        }
        
        int start = 0, end = getTime(adv_time);
        long sum = 0, max = 0;
        
        for (int i=1; i<ply; i++) 
        	div[i] += div[i-1];
        
        for (int i=start; i<end; i++)
        	sum += div[i];
        
        max = sum;
        
        for (int i=end; i<ply; i++) {
        	sum -= div[start + i - end];
        	sum += div[i];
        	
        	if (sum > max) {
        		answer = start + i - end + 1;
        		max = sum;
        	}
        }
    
        return getTime(answer);
    }
    
    private int getTime(String time) {
    	String[] arr = time.split(":");
    	return Integer.parseInt(arr[0]) * 3600 
    			+ Integer.parseInt(arr[1]) * 60
    			+ Integer.parseInt(arr[2]);
    }
    
    private String getTime(int time) {
    	int hour = time / 3600;
    	int minute = (time % 3600) / 60;
    	int sec = (time % 3600) % 60;
    	
    	return String.format("%02d:%02d:%02d", hour, minute, sec);
    }
	
	@Test
	void test() {
		Assert.assertEquals("01:30:59", solution("02:03:55", "00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
		Assert.assertEquals("01:00:00", solution("99:59:59", "25:00:00", new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"}));
		Assert.assertEquals("00:00:00", solution("50:00:00", "50:00:00", new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"}));
	}

}

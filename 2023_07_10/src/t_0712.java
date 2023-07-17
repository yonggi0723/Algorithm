import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.*;
import java.util.*;

class t_0712 {
   
    public int solution(String[] maps) {
        int answer = 0;

        int sX=0, sY=0, eX = 0, eY = 0, lX =0, lY=0;
        boolean[][] visited1 = new boolean[maps.length][maps[0].length()];
        boolean[][] visited2 = new boolean[maps.length][maps[0].length()];

        for (int i=0; i<maps.length; i++)
            for (int j=0; j<maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    sX = i;
                    sY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    eX = i;
                    eY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                } else if (maps[i].charAt(j) == 'X') {
                    visited1[i][j] = true;
                    visited2[i][j] = true;
                }
            }

        answer = bfs(sX, sY, lX, lY, visited1);
        if (answer != -1)
            answer += bfs(lX, lY, eX, eY, visited2);

        return answer;
    }

    private int bfs(int startX, int startY, int endX, int endY, boolean[][] visited) {
        int value = -1;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        int x = 0, y = 0, z =0, mX = 0, mY = 0;
        int[] node;

        while (!que.isEmpty()) {
            node = que.poll();

            x = node[0];
            y = node[1];
            z = node[2];

            if (x == endX && y == endY )
                value = z;

            for (int i=0; i<4; i++) {
                mX = x + dx[i];
                mY = y + dy[i];

                // 범위를 넘은 경우
                if (mX < 0
                    || mY < 0
                    || mX >= visited.length
                    || mY >= visited[0].length
                    || visited[mX][mY] == true)
                    continue;

                visited[mX][mY] = true;
                que.add(new int[] {mX, mY, z+1});
            }
        }

        return value;
    }
	@Test
	void test() {
//		Assert.assertEquals(16, solution(new String[] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
//		Assert.assertEquals(-1, solution(new String[] {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
		Assert.assertEquals(6, solution(new String[] {"SXL","OOO","XXE"}));
	}

}

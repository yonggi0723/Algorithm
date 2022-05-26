import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 프로그래머스 길 찾기 게임 (카카오 블라인드 2019)
 * @author kim-yong-gi
 */
class GetDirection {
	
	int pre;
	
	int post;

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        pre = 0;
        post = 0;
        
        Node[] node = new Node[nodeinfo.length];
        
        for (int i=0; i<nodeinfo.length; i++)
        	node[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1],null,null);
        	
        
        Arrays.sort(node,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int val = o2.y  - o1.y;
				if ( val == 0 )
					return o1.x - o2.x;
				return val;
			}
		});

        for (int i=1; i<node.length; i++)
        	insert(node[0],node[i]);
        
        preOrder(node[0],answer[0]);

        postOrder(node[0],answer[1]);
        
        return answer;
    }
    
    private void insert(Node parent, Node child) {
    	if (parent.x > child.x)
    		if (parent.left == null)
    			parent.left = child;
    		else
    			insert(parent.left, child);
    	else 
    		if (parent.right == null)
    			parent.right = child;
    		else 
    			insert(parent.right, child);
    }
    
    private void preOrder( Node root, int[] node) {
    	node[pre++] = root.num;
    	if (root.left != null)
    		preOrder(root.left, node);
    	if (root.right != null)
    		preOrder(root.right, node);
    }
    
    private void postOrder(Node root, int[] node) {
    	if (root.left != null)
    		postOrder(root.left, node);
    	if (root.right != null)
    		postOrder(root.right, node);
    	node[post++] = root.num; 
    }

    @Test
	void test() {
		Assert.assertArrayEquals(new int[][] {{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}}, solution(new int[][] {
			{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}
		}));
	}
    
    class Node {
    	
    	int num;
    	
    	int x;
    	
    	int y;
    	
    	Node left;
    	
    	Node right;

		public Node(int num, int x, int y, GetDirection.Node left, GetDirection.Node right) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.left = left;
			this.right = right;
		}
    }

}

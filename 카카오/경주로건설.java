package 카카오;

import java.util.ArrayDeque;

public class 경주로건설 {

	public static void main(String[] args) {
		System.out.println(
					solution(new int[][] {
						{0,0,1,0},
						{0,0,0,0},
						{0,1,0,1},
						{1,0,0,0}
					})
				);
		
	}
		public static class node {
			int dir;
		
			int codi;
			public node(int dir,int codi) {
				super();
				this.dir = dir;
			
				this.codi = codi;
			}
		
		}
	  public static int solution(int[][] board) {
		  int dir[][] = { {-1,0},{0,1},{1,0},{0,-1}  };
	    
	        int size = board.length;
	        int dp[][] = new int[size][size];
	        for(int i = 0 ; i < size ; i++) {
	        	for(int j = 0 ; j < size ; j ++) {
	        		dp[i][j] = 2147000000;
	        	}
	        }
	        ArrayDeque<node> dq = new ArrayDeque<>();
	        dp[0][0] = 0;
	        dq.add(new node(1,0));
	        dq.add(new node(2,0));
	        while(!dq.isEmpty()) {
	        	node now = dq.poll();
	        	int y = now.codi / size;
	        	int x = now.codi % size;
	        	if(y==size-1 && x ==size-1) continue;
	        	for(int i = 0 ; i < 4 ; i ++) {
	        		int ny = y + dir[i][0];
	        		int nx = x + dir[i][1];
	        		if(ny >= 0 && nx >= 0 && ny < size && nx <size) {
	        			int cost = i==now.dir ? 100 : 600;
	        			if(board[ny][nx] !=1 && dp[ny][nx] >= dp[y][x] + cost)  {
	        				dp[ny][nx] = dp[y][x] + cost;
	        				dq.add(new node(i, ny*size +nx));
	        			}
	        		}
	        	}
	        }
	        return dp[size-1][size-1];
	    }
}

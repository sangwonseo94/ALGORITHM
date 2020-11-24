package algorithm;

import java.util.ArrayDeque;

public class 블록이동하기 {

	public static void main(String[] args) {
		System.out.println(
				//
		solution(new int[][] {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}})		
		);
		
		
	}
	public static boolean isrange(int y,int x ,int yy, int xx, int n) {
		return y>=1 && x>=1 && y <=n && x<=n && yy >=1 && xx>=1 && yy<=n && xx <= n;
	}
	 public static int solution(int[][] oldboard) {
	        int size = oldboard.length;
	        
	        int board[][] = new int[size+1][size+1];
	        for(int i=1;i<=size;i++) {for(int j=1;j<=size;j++) {board[i][j] = oldboard[i-1][j-1];} }
	        int visit[][][] = new int[2][size+1][size+1];
	        int dir[][] = {
	        		{-1,0,-1,0}, // 상 하 좌 우 
	        		{1,0,1,0},
	        		{0,-1,0,-1},
	        		{0,1,0,1},
	        		{1,1,0,0}, // ㄴ >
	        		{0,0,1,-1}, // ㄴ <
	        		{0,0,-1,-1}, // ㄴ ㅗ
	        		{-1,1,0,0}, // ㄴ ㅓ
	        };
	        ArrayDeque<int[]> dq = new ArrayDeque<>();
	        dq.add(new int[] {1,1,1,2,1,1}); // 1 은 가로 0 은 세로
	        visit[1][1][1] = 1;
	        visit[1][1][2] = 1;
	        while(!dq.isEmpty()) {
	        	int now[] = dq.poll();
	        	for(int i=0;i<4;i++) {
	        		int ny = now[0] + dir[i][0];
	        		int nx = now[1] + dir[i][1];
	        		int nny = now[2] + dir[i][2];
	        		int nnx = now[3] + dir[i][3];
	        		if(isrange(ny, nx, nny, nnx, size)) {
	        			if(board[ny][nx]==0 && board[nny][nnx]==0) {
	        				if(visit[now[4]][ny][nx] ==0 || visit[now[4]][nny][nnx] ==0 ) {
	        					visit[now[4]][ny][nx] =now[5]+1 ;
	        					visit[now[4]][nny][nnx] = now[5]+1;
	        					dq.add(new int[] {ny,nx,nny,nnx,now[4],now[5]+1});
	        					if(visit[0][size][size]!=0) return visit[0][size][size]+1;
	        					if(visit[1][size][size]!=0) return visit[1][size][size]+1;
	        				} 
	        			}
	        		}
	        	}
	        	for(int i=4;i<8;i++) {
	        		int ny = now[0] + dir[i][0];
	        		int nx = now[1] + dir[i][1];
	        		int nny = now[2] + dir[i][2];
	        		int nnx = now[3] + dir[i][3];
	        		if(isrange(ny, nx, nny, nnx, size)) {
	        			if(i==4 && board[ny][nx-1]==1) continue;
	        			if(i==5 && board[nny][nnx+1]==1) continue;
	        			if(i==6 && board[nny][nnx+1]==1) continue;
	        			if(i==7 && board[ny][nx-1]==1) continue;
	        			if(board[ny][nx]==0 && board[nny][nnx]==0) {
	        				if(visit[(now[4]+1)%2][ny][nx] ==0 || visit[(now[4]+1)%2][nny][nnx] ==0 ) {
	        					visit[(now[4]+1)%2][ny][nx] =now[5]+1 ;
	        					visit[(now[4]+1)%2][nny][nnx] = now[5]+1;
	        					dq.add(new int[] {ny,nx,nny,nnx,(now[4]+1)%2,now[5]+1});
	        					if(visit[0][size][size]!=0) return visit[0][size][size]+1;
	        					if(visit[1][size][size]!=0) return visit[1][size][size]+1;
	        					
	        				} 
	        			}
	        		}
	        	}
	        }
	        return 0;
	    }
}

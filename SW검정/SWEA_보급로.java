package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_보급로 {
	
	static class node{
		int y,  x ,  cost;
		public node(int y, int x , int cost) {
			this.cost = cost;
			this.y = y;
			this.x = x;
		
		}
	}
	static int answer= 0;
	
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,-1},
			{0,1}
	};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("answer/보급로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc= 1 ; tc<=T ; tc++) {
			st = new  StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			for(int y= 0 ; y < n ; y++) {
				String t = br.readLine();
				for(int x = 0 ; x < n ; x++) {
					map[y][x] = t.charAt(x) - '0';
				}
			}
			boolean visit[][] = new boolean[n][n];
			PriorityQueue<node> pq = new PriorityQueue<>(1,new  Comparator<node>() {
				
				public int compare(node n1 , node n2) {
					if( n1.cost < n2 .cost ) return -1;
					else return 1;
				}
			});
			
			
			pq.add(new node(0,0,0));
			
			while(!pq.isEmpty()) {
				
				node now = pq.poll();
				if(now.y == n-1 && now.x == n-1) {
					answer = now.cost;
					break;
				}
				
				for(int index = 0 ; index < 4 ; index++) {
					int ny = now.y + dir[index][0];
					int nx = now.x + dir[index][1];
					if(ny >= 0 && nx >=0 && nx < n && ny < n && !visit[ny][nx]) {
						visit[ny][nx] = true;
						pq.add(new node(ny,nx,now.cost+map[ny][nx]));
					}
				}
				
				
			}
			
			
			
			sb.append("#"+tc + " " + answer +"\n");
			answer= 0;
		}
		System.out.println(sb);
		
	}

}

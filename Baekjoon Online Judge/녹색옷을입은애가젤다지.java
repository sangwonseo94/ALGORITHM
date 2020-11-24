package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷을입은애가젤다지 {
	public static class node{
		int y,x,cost;

		public node(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws Exception {
		int cnt= 0;
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			cnt++;
			int map[][] = new int[n][n];
			for(int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j= 0 ; j <n ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean visit[][] = new boolean[n][n];
			visit[0][0] = true;
			PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
				@Override
				public int compare(node o1, node o2) {
					return o1.cost - o2.cost;
				}
			});
			pq.add(new node(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				node now = pq.poll();
				if(now.y==n-1&&now.x==n-1){
					sb.append("Problem "+cnt+": "+now.cost+"\n");
					break;
				}
				
				for(int i = 0 ; i < 4 ; i ++) {
					int ny = now.y+dir[i][0];
					int nx = now.x+dir[i][1];
					if(ny>=0&&nx>=0&&nx<n&&ny<n&&!visit[ny][nx]) {
						visit[ny][nx] = true;
						pq.add(new node(ny,nx,now.cost+map[ny][nx]));
					}
				}
				
			}
		}System.out.println(sb);
	}

}

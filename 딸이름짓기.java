package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 딸이름짓기 {
	static class node{
		int y, x;
		String str;
		public node(int y, int x , String str) {
			this.y= y;
			this.x =x;
			this.str= str;
		}
	}
	public static void main(String[] args)throws Exception {
		String answer = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.str.compareTo(o2.str);
			}
		});
		int n,m;char[][] map;boolean visit[][];
		for(int tc= 1; tc<=t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visit = new boolean[n][m];
			for(int y= 0 ; y < n ; y++) map[y] = br.readLine().toCharArray();
			visit[0][0] = true;
			pq.add(new node(0,0,String.valueOf(map[0][0])));
			while(!pq.isEmpty()) {
				node now = pq.poll();
				int nowy = now.y, nowx = now.x;
				String nows = now.str;
				if(nowy == n-1 && nowx == m-1) {
					answer =now.str;
					break;
				}
				if(nowy +1 < n && !visit[nowy+1][nowx]) {
					visit[nowy+1][nowx] = true;
					pq.add(new node(nowy+1 , nowx, nows.concat(String.valueOf(map[nowy+1][nowx]))));
				}
				if(nowx+1 < m && !visit[nowy][nowx+1]) {
					visit[nowy][nowx+1] = true;
					pq.add(new node(nowy , nowx+1, nows.concat(String.valueOf(map[nowy][nowx+1]))));
				}	
			}
			pq.clear();
			sb.append("#"+tc+" "+answer+"\n");
			answer ="";
		}
		System.out.print(sb);
	}

}

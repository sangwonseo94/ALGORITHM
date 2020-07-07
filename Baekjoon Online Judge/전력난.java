package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전력난 {
	public static void make() {
		for(int i = 0 ; i < parent.length ; i++) {
			parent[i] = i;
		}
	}
	public static int findp(int x) {
		if(parent[x] == x) return x;
		else return findp(parent[x]);
	}
	
	public static boolean union(int x , int y) {
		x = findp(x); y = findp(y);
		if( x==y  )return false;
		if(x < y) {parent[y] = x;}
		else parent[x] = y;
		return true;
	}
	
	public static int[] parent;
	public static class node{
		int s ,e ,c;

		public node(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		while(true) {
			PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
				@Override
				public int compare(node o1, node o2) {
					return o1.c - o2.c;
				}
			});
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(n==0 && k==0) break;
			int total=0 , answer =0;
			parent = new int[n]; make();
			for(int i = 0 ; i < k ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new node(s,e,c));
				total +=c;
			}
			int time = 1;
			while(time != n) {
				node now = pq.poll();
				if(union(now.s , now.e)) {
					time++;
					answer +=now.c;
				}
			}
			sb.append(total - answer + "\n");
		}
		System.out.println(sb);
	}
}

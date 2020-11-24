package 풀문제;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로 {
	static class node{
		int start,end;
		double len;
		public node(int start , int end , double len) {
			this.start = start; this.end = end; this.len = len;
		}
	}
	static int root[];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<node> pq = new PriorityQueue	<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.len > o2.len) return 1;
				else return -1;
			}
		}); 
		
		for(int tc= 1 ; tc<= t ; tc++) {
			int n = sc.nextInt();
			int map[][] = new int[n][2]; // y x
			
			for(int x = 0 ; x < n ; x++) {map[x][1] = sc.nextInt();} 
			for(int x = 0 ; x < n ; x++) {map[x][0] = sc.nextInt();}
			
			double e = sc.nextDouble();
			
			for(int y = 0 ; y< n ; y++) {
				for(int x = y +1 ; x < n ; x++) {
					double len = ComputeLen(map[y][0] , map[x][0] , map[y][1] , map[x][1]);
					pq.add(new node(y,x,len*e));
				}
			}
			
			root = new int[n];
			for(int index = 0 ; index < n ; index++) {root[index]= index;}
			double ans = 0;
			while(!pq.isEmpty()) {
				node now = pq.poll();
				if( find(now.start) ==find(now.end )) continue;
				union(now.start,now.end);
				ans += now.len;
			}
			System.out.printf("#%d %.0f\n",tc,ans);
		}
	}
	
	public static double ComputeLen(int i, int j, int k, int l) {
		return (long) ((long)Math.abs(i-j) * (long) Math.abs(i-j) + (long)Math.abs(k-l) * (long)Math.abs(k-l));
	}
	public static int find(int a) {
		if(a==root[a]) return a;
		return find(root[a]);
	}
	public static void union(int a,int b) {
		if(find(a) != find(b)) {root[find(a)]=b;}
		else return;
	}

}

package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 네트워크연결 {
	static class node{
		int s,e,c;
		public node(int s,int e , int c) {
		 this.s = s; this.e = e ; this.c = c;
		}
	}
	public static int findparent(int a) {
		if(parent[a] == a) return a;
		return findparent(parent[a]);
	}
	public static void union(int a, int b) {
		int pa = findparent(a);
		int pb = findparent(b);
		if( pa== pb) return;
		if( pa < pb) parent[ pa ] = pb;
		else parent[pb] = pa;
		return;
	}
	public static int parent[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		node map[] = new node[m];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		parent = new int[n+1];
		for (int i = 1; i < parent.length; i++) {	parent[i] = i; }
		Arrays.sort(map , new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.c > o2.c) return 1;
				else if (o1.c < o2.c) return -1;
				else return 0;
			}
		});
		int answer =0;
		for (int i = 0; i < map.length; i++) {
			int sp = findparent(map[i].s);
			int ep = findparent(map[i].e);
			if(sp==ep) continue;
			union(map[i].s , map[i].e);
			answer += map[i].c;
		}
		System.out.println(answer);
	}
}

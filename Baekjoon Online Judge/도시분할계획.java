package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획 {
	public static class node{
		int s , e ,c ;

		public node(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
	
	}
	public static int [] parent;
	public static void main(String[] args) throws Exception {
		// kruskal algorithm
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		PriorityQueue<node> pq= new PriorityQueue<>(new Comparator<node>() {
				@Override
				public int compare(node o1, node o2) {
					if(o1.c > o2.c) {
						return 1;
					} else if(o1.c == o2.c) {
						return 0;
					} else {
						return -1;
					}
				}
		});
		
		for(int i = 0 ; i < k ; i++) {
			st = new StringTokenizer(br.readLine());
			int s,e,c;
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			pq.add(new node(s-1, e-1, c));
		}
		parent= new int[n];
		int answer =0;
		make();
		// union이 성공적으로 된다면 , n--해준다.
		while(n > 2) {
			node now = pq.poll();
			if(union(now.s , now.e)) {
				n--;
				answer += now.c;
			}
		} System.out.println(answer);
	}
	private static boolean union(int ps, int pe) {
		 ps = findp(ps);
		 pe = findp(pe);
		 if(ps==pe) return false;
		 if(ps > pe) {
			 parent[ps] = pe;
		 } else {
			 parent[pe] = ps;
		 }
		// 항상 ps가 작다.
		
		 return true;
	}
	private static void make() {
		for(int i = 0 ; i < parent.length ; i++) {
			parent[i] = i;
		}
	}
	private static int findp (int x) {
		if(parent[x] ==x ) return x;
		else {	return findp(parent[x]);}
	}

}

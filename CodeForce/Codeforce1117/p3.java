package Codeforce1117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p3 {

	public class node {
		int y,x;

		public node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
		@Override
		public int compare(node o1, node o2) {
			if(o1.y==)
			return 0;
		}
		});
		while(T-->0) {
			
		}
		System.out.println(sb);
	}

}

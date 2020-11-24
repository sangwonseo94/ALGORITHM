package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크게만들기 {

	public static class node{
		char ch;
		int pos;
		public node(char ch, int pos) {
			super();
			this.ch = ch;
			this.pos = pos;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String num = br.readLine();
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return (int)o1.ch - (int)o2.ch;
			}
		});
		HashMap<Integer, Boolean> hm = new HashMap<>();
		for(int i = 0 ; i < n ; i ++) {
			pq.add(new node(num.charAt(i),i));
			hm.put(i, false);
		}
		for(int i = 0 ; i < m ; i ++) {
			hm.put(pq.poll().pos, true);
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			if(hm.get(i)) continue;
			else {
				sb.append(num.charAt(i));
			}
		}
		
		System.out.println(sb);
	}
}

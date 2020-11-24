package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 국영수 {
	public static class node{
		String name;
		int korean,math,english;
		public node(String name, int korean, int english , int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.math = math;
			this.english = english;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.korean==o2.korean) {
					if(o1.english == o2.english) {
						if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						} else {
							return o1.math - o2.math;
						}
					} else {
						return - (o1.english - o2.english);
					}
				} else {
					return o1.korean - o2.korean; 
				}
			}
		});
		
		for(int i= 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new node(st.nextToken() , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll().name+"\n");
		}System.out.println(sb);
	}

}

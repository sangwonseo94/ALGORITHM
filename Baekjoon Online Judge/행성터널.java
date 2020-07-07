package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성터널 {
	public static class node{
		int number,x,y,z;

		public node(int number, int x, int y, int z) {
			
			this.number = number;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	public static int parent[];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<node> al = new ArrayList<>();
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			al.add(new node(i,x,y,z));
		}
		//  start , end ,cost
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2] > o2[2]) {return 1;}
				else if(o1[2] == o2[2]) {return 0;}
				else return -1;
			}
		});
		Collections.sort(al, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				//x를 기준으로 정렬
				return o1.x - o2.x;
			}
		});
		for(int i = 0 ; i < n ; i ++) {
			// 인접한 노드끼리 최단거리 계산
			if( i-1 >=0) {// i-1 에서 i 까지의 최단거리 계산
				pq.add(new int[] {al.get(i-1).number , al.get(i).number , compute(al.get(i-1).x , al.get(i).x ,   al.get(i-1).y , al.get(i).y , al.get(i-1).z , al.get(i).z )});} 
			if( i+1 <n ) {pq.add(new int[] {al.get(i).number , al.get(i+1).number , compute(al.get(i).x , al.get(i+1).x ,   al.get(i).y , al.get(i+1).y , al.get(i).z , al.get(i+1).z )});}
		}
		
		Collections.sort(al, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				//y를 기준으로 정렬
				return o1.y - o2.y;
			}
		});
		for(int i = 0 ; i < n ; i ++) {
			// 인접한 노드끼리 최단거리 계산
			if( i-1 >=0) {// i-1 에서 i 까지의 최단거리 계산
				pq.add(new int[] {al.get(i-1).number , al.get(i).number , compute(al.get(i-1).x , al.get(i).x ,   al.get(i-1).y , al.get(i).y , al.get(i-1).z , al.get(i).z )});} 
			if( i+1 <n ) {pq.add(new int[] {al.get(i).number , al.get(i+1).number , compute(al.get(i).x , al.get(i+1).x ,   al.get(i).y , al.get(i+1).y , al.get(i).z , al.get(i+1).z )});}
		}
		
		Collections.sort(al, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				//z를 기준으로 정렬
				return o1.z - o2.z;
			}
		});
		for(int i = 0 ; i < n ; i ++) {
			// 인접한 노드끼리 최단거리 계산
			if( i-1 >=0) {// i-1 에서 i 까지의 최단거리 계산
				pq.add(new int[] {al.get(i-1).number , al.get(i).number , compute(al.get(i-1).x , al.get(i).x ,   al.get(i-1).y , al.get(i).y , al.get(i-1).z , al.get(i).z )});} 
			if( i+1 <n ) {pq.add(new int[] {al.get(i).number , al.get(i+1).number , compute(al.get(i).x , al.get(i+1).x ,   al.get(i).y , al.get(i+1).y , al.get(i).z , al.get(i+1).z )});}
		}
		int time = 0 , answer = 0;
		
		parent= new int[n];
		make();
		while(time!=n-1) {
			int [] now = pq.poll();
			if(union(now[0] , now[1])) {
				time++;
				answer +=now[2];
			}
		}System.out.println(answer);
	}
	private static void make() {
		for(int i =0 ; i < parent.length; i++) {
			parent[i] =i ;
		}
	}
	private static int findp(int x) {
		if(parent[x] ==x ) return x;
		else return findp(parent[x]);
	}
	
	private static boolean union(int x , int y) {
		x = findp(x); y = findp(y);
		if(x==y) return false;
		if(x > y) parent[x] =y;
		else parent[y] = x;
		return true;
	}
	
	private static int compute(int x, int x2, int y, int y2, int z, int z2) {
		return Math.min(Math.min(Math.abs(x-x2), Math.abs(y - y2)), Math.abs(z-z2));
	}

}

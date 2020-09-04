package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
	
	
	
	private static int n,e;
	private static int v1,v2;
	private static ArrayList<int[]> map[];
	private static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			// 간선이 짧은? 것들만 앞에 정렬
			return o1[0] - o2[0];
		}
	});
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		for(int i = 1 ; i <= n ; i++) {map[i]= new ArrayList<>();}
		for(int i = 0 ; i < e ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a].add(new int[] {b,c});
			map[b].add(new int[] {a,c});
		}
		st = new StringTokenizer(br.readLine());
		
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		long answer = Math.min(Dijkstra(1,v1) + Dijkstra(v1,v2) + Dijkstra(v2,n) , Dijkstra(1,v2) + Dijkstra(v2,v1) + Dijkstra(v1,n));
		System.out.println(answer = answer >20000000 ? -1 : answer);
		
	}
	private static long Dijkstra(int s ,int e) {
		// s에서부터 e까지의 short path값을 리턴
		pq.clear();
		long path[] = new long[n+1];
		for(int i = 1 ; i <=n ; i++) path[i] = 2000000000;
		// 자기자신은 0
		path[s] =0;
		pq.add(new int[] {s,0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			for (int[] node : map[now[0]]) {
				if(path[node[0]] > node[1]+path[now[0]]) {
					path[node[0]] = node[1]+path[now[0]];
					pq.add(node);
				}
			}
			
		}
		
		return path[e];
	}
}

package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 트리의지름2 {
	
	public static ArrayList<int []> node[];
	public static int n;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		node = new ArrayList[n+1];
		for(int i= 1 ;i<=n;i++)node[i] = new ArrayList<>();
		for(int i= 1 ; i<= n;i++){
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			boolean isContinue = true;
			while(isContinue) {
				int e = Integer.parseInt(st.nextToken());
				if(e==-1) {
					isContinue = false;
					continue;
				}
				int w = Integer.parseInt(st.nextToken());
				node[now].add(new int[] {e,w});
			}
		}
		int index = djistra(1)[1];
		System.out.println(djistra(index)[0]);
	}

	private static int[] djistra(int start) {
		int cost[] = new int[n+1];
		for(int i = 0 ; i <=n; i++)cost[i] = 987654321;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		cost[start] = 0;
		pq.add(new int[] {start,0});
		while(!pq.isEmpty()) {
			int now[] = pq.poll();
			if(cost[now[0]] < cost[start] + now[1]) continue;
			int size = node[now[0]].size();
			for(int i = 0 ; i < size; i++) {
				int next[] = node[now[0]].get(i);
				if(cost[next[0]] > cost[now[0]] + next[1]) {
					cost[next[0]] = cost[now[0]] + next[1];
					pq.add(new int[] {next[0] , cost[next[0]]});
				}
			}
		}
		int residx = 0;
		int res = 0;
		for(int i =1 ; i <= n; i ++) {
			if(i!=start && res < cost[i]) {
				residx = i;
				res = cost[i];
			}
		}
		return new int[] {res , residx};
	}

}

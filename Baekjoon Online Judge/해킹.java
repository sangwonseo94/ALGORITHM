package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 해킹 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i< tc;i++) {
			int answer=0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken())-1;
			ArrayList<int[]> node[] = new ArrayList[n];
			for(int j=0;j<n;j++) {node[j] = new ArrayList<>();}
			for(int j=0;j<d;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				node[b].add(new int[] {a,c});
			}
			int cost[] = new int[n];
			for(int j=0;j<n;j++) cost[j] = 2147000000;
			cost[s] =0;
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
			pq.add(new int[] {s,0});
			while(!pq.isEmpty()) {
				int now[] = pq.poll();
				if( cost[now[0]] < now[1]) continue;
				int size = node[now[0]].size();
				for(int j=0 ; j < size ; j++) {
					int next[] = node[now[0]].get(j);
					if(cost[next[0]] > cost[now[0]] + next[1]) {
						cost[next[0]] = cost[now[0]] + next[1];
						pq.add(new int[] {next[0] , cost[next[0]]});
					}
				}
			}
			int cnt=0;
			for(int j=0; j<n ; j++) {
				if( j != s && cost[j]!= 2147000000) answer = answer > cost[j] ? answer : cost[j];
				if( cost[j]!= 2147000000) cnt++;
			}
			sb.append(cnt +" "+answer+"\n");
		}System.out.println(sb);
	}

}

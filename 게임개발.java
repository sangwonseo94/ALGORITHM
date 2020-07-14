package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게임개발 {
	
	public static void main(String[] args) throws Exception {
		ArrayDeque<Integer> zerodq = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n =Integer.parseInt(st.nextToken());
		ArrayList<Integer> map[] = new ArrayList[n];
		for(int i = 0 ;i < n ; i++) map[i] = new ArrayList<>();
		int indegree[] = new int[n];
		int origin[] = new int[n];
		int new_cost[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			origin[i] = cost;
			while(true) {
				int val = Integer.parseInt(st.nextToken());
				if(val == -1) break;
				val -=1;
				map[val].add(i);
				indegree[i]++;
			}
			if(indegree[i] ==0) {
				zerodq.add(i);
				new_cost[i] = origin[i];
			}
		}
		while(!zerodq.isEmpty()) {
			int now = zerodq.poll();
			int val = new_cost[now];
			for(int i = 0 ; i < map[now].size() ; i++) {
				int next = map[now].get(i);
				if(origin[next] + val > new_cost[next]) {
					new_cost[next]= origin[next] + val;
				}
				indegree[next]--;
				if(indegree[next]==0) {
					origin[next] = new_cost[next];
					zerodq.add(next);
				}
			}
		}
		for(int i = 0 ; i < n ; i++) {
			sb.append(origin[i]+"\n");
		}System.out.println(sb);
	}

}

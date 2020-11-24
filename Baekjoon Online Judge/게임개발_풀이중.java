package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게임개발_풀이중 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cost[] = new int[n];
		int indegree[] = new int[n];
		ArrayList<Integer> al[]; al = new ArrayList[n];
		for(int i = 0 ; i < n ; i++) al[i] = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] =Integer.parseInt(st.nextToken());
			int now =Integer.parseInt(st.nextToken())-1;
			while(now != -2) {
				al[now].add(i);
				indegree[i]++;
				now = Integer.parseInt(st.nextToken())-1;
			}
		}
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0 ; i < n ; i ++) {
			if(indegree[i] ==0) {
				dq.add(i); res.add(i);
			}
		}
		
		while(!dq.isEmpty()) {
			int now = dq.poll();
			for(int i = 0 ; i < al[now].size() ; i++) {
				int cur = al[now].get(i);
				indegree[cur]--;
				if(indegree[cur]==0) {
					dq.add(cur);
					res.add(cur);
				}
			}
		}
		
		for(int i = 0 ; i < n ; i ++) {
			int now = res.get(i);
			
		}
		
	}

}

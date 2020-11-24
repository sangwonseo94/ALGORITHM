package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int now =0 , cur =0;
		int indegree[] = new int[n];
		ArrayList<Integer> al[] = new ArrayList[n];
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0 ; i < n ; i ++) {
			al[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			al[s].add(e);
			indegree[e]++;
		}
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 0 ; i < n ; i ++){
			if(indegree[i]==0) {
				dq.add(i);
			
			}
		}
		
		while(!dq.isEmpty()) {
			now = dq.poll();
			result.add(now);
			for(int i = 0 ; i < al[now].size(); i++) {
				cur = al[now].get(i);
				indegree[cur]--;
				if(indegree[cur] ==0) {
					dq.add(cur);
				
				}
			}
		}
		
		for (Integer integer : result) {
			System.out.print((integer+1) +" ");
		}
	}
}

package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 음악프로그램 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> al[];
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		al = new ArrayList[n];
		int indegree[] = new int[n];
		for(int i = 0 ; i < n ; i ++) al[i] = new ArrayList<>();
		for(int i = 0 ; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken())-1;
			for(int j = 0 ; j < size-1 ; j ++) {
				int second = Integer.parseInt(st.nextToken())-1;
				al[first].add(second);
				indegree[second]++;
				first = second;
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i = 0 ; i < n ; i ++) {
			if(indegree[i] == 0) {
				dq.add(i);
				res.add(i);
			}
		}
		
		while(!dq.isEmpty()) {
			int now = dq.poll();
			for(int i = 0 ; i < al[now].size(); i++) {
				int cur = al[now].get(i);
				indegree[cur]--;
				if(indegree[cur] == 0) {
					dq.add(cur);
					res.add(cur);
				}
			}
		}
		
		boolean isAns = true;
		for(int i = 0 ; i  < n ; i++) {
			if(indegree[i] != 0) isAns = false;
		}
		if(isAns) {
			for(int i = 0 ; i < n;i++) {
				System.out.println(res.get(i)+1);
			}
		}else {
			System.out.println(0);
		}
		
	}
}

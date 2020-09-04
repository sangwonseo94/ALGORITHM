package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 음악프로그램인접행렬 {
	static int map[][],indegree[],n,m;
	static boolean visit[];
	static boolean finish[];
	static boolean isAns= true;
	static Stack<Integer> s = new Stack<Integer>();
	
	private static void dfs(int i) {
		visit[i] = true;
		for(int j = 0 ; j < n ; j++) {
			if(map[i][j] ==1 && !visit[j]) {
				dfs(j);
			}else if(map[i][j]==1 &&!finish[j]) {
				isAns = false;
			}
		}
		finish[i] = true;
		s.push(i+1);
	}
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n];
		finish = new boolean[n];
		indegree = new int[n];
		for(int i = 0 ; i < m ; i++) {
			st =new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken())-1;
			for(int j = 0 ; j < size -1 ; j++) {
				int e = Integer.parseInt(st.nextToken())-1;
				map[f][e] =1; // f에서 e로가는 길이있다.
				f= e;
				indegree[e]++;
			}
		}
		for(int i = 0 ; i < n ; i ++) {
			if(indegree[i]==0) dfs(i);
		}
		if(isAns) {
			while(!s.isEmpty()) {
				System.out.println(s.pop());
			}
		}else {
			System.out.println(0);
		}
	}
	
}

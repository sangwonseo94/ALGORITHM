package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 책나눠주기 {
	private static int n,m,book[];
	private static boolean visit[];
	private static ArrayList<Integer> node[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			// n은 책수, m은 학생수
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			book = new int[n+1];
			node = new ArrayList[m+1];
			for(int i =1 ; i<=m ; i++) node[i] = new ArrayList<>();
			for(int i =1 ; i<=m ; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				for(; s<=e; s++) {node[i].add(s);}
			}
			int answer =0;
			for(int i = 1 ; i<=m ; i++) {
				visit = new boolean[n+1];
				if(dfs(i)) {
					answer++;
				}
			}sb.append(answer+"\n");
		}System.out.println(sb);
	}
	private static boolean dfs(int x) {

		for(int i = 0 ; i <node[x].size(); i++) {
			int now = node[x].get(i);
			if(!visit[now]) {
				visit[now] = true;
				if(book[now]== 0 || dfs(book[now])) {
					book[now]=x;
					return true;
				}
			}
		}
		return false;
	}
}

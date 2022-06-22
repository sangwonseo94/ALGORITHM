package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11657 {

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[n][n];
		int INF = 987654321;
		for(int i=0;i<n;) {
			
			for(int j=0;j<n;) {
				map[i][j] = INF;
				++j;
			}
			++i;
		}
		
		ArrayList<int[]> al[] = new ArrayList[n];
		for(int i=0;i<n;) {al[i] = new ArrayList<>();++i; }
		for(int i=0;i<m;) {
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			al[s].add(new int[] {e,c});
			++i;
		}
		
		boolean InQ[] = new boolean[n];
		int cnt[] = new int[n];
		long cost[] = new long[n];
		
		InQ[0] = true;
		
		for(int i=0;i<n;) {
			cost[i] = INF;
			++i;
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.add(0);
		cost[0] = 0;
		cnt[0]=1;
		boolean infinite=false;
		end:
		while(!dq.isEmpty()) {
			int now = dq.poll();
			InQ[now] =false;
			int size = al[now].size();
			for(int i=0;i<size;) {
				int next = al[now].get(i)[0];
				int pathcost = al[now].get(i)[1];
				if(cost[next] > cost[now]+pathcost) {
					// 더 작은 값으로 이동이 가능하다면,
					cost[next] = cost[now] + pathcost;
					if(!InQ[next]) {
						// 다음 노드가 큐에 없으면
						InQ[next] = true;
						if(++cnt[next]>=n ){
							infinite = true;
							break end;
						}
						dq.add(next);
					}
				}
				++i;
			}
		}
		
		if(infinite) {
			System.out.print("-1");
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<n;) {
				sb.append((cost[i] == INF ? -1 : cost[i])+"\n");
				++i; 
			}
			System.out.print(sb.toString());
		}
		
	}

}

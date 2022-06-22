package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			ArrayList<int []> nodes[] = new ArrayList[N];
 			for(int j=0;j<N;) {
 				nodes[j] = new ArrayList<>();
 				++j;
 			}
			
 			for(int j=0;j<M;) {
 				st = new StringTokenizer(br.readLine());
 				int S = Integer.parseInt(st.nextToken())-1;
 				int E = Integer.parseInt(st.nextToken())-1;
 				int TI = Integer.parseInt(st.nextToken());
 				nodes[S].add(new int[] {E,TI});
 				nodes[E].add(new int[] {S,TI});
 				++j;
 			}
 			
 			for(int j=0;j<W;) {
 				st = new StringTokenizer(br.readLine());
 				int S = Integer.parseInt(st.nextToken())-1;
 				int E = Integer.parseInt(st.nextToken())-1;
 				int TI = Integer.parseInt(st.nextToken());
 				nodes[S].add(new int[] {E,-TI});
 				++j;
 			}
 			
 			boolean infinite = false;
 			ArrayDeque<Integer> dq = new ArrayDeque<>();
 			top:
 			for(int j=0;j<N;) {
 			    // 모든 노드를 시작점으로 SPFA를 실행하여 음수 사이클이 존재하는지 파악
 				
 			  	int cnt[] = new int[N];
 			  	int cost[] = new int[N];
 			  	Arrays.fill(cost, 987654321);
 			  	boolean InQ[] = new boolean[N];
 				
 				dq.add(j);
 				cnt[j]=1;
 				InQ[j]=true;
 				
 				while(!dq.isEmpty()) {
 					int now = dq.poll();
 					InQ[now] = false;
 					int size = nodes[now].size();
 					for(int k=0;k<size;) {

 						int next = nodes[now].get(k)[0];
 						int pathValue = nodes[now].get(k)[1];
 						if(cost[next] > cost[now] + pathValue) {
 							cost[next] = cost[now] + pathValue;
 							if(!InQ[next]) {
 								InQ[next] = true;
 								if(++cnt[next]>N) {
 									infinite=true;
 									break top;
 								}
 								dq.add(next);
 							}
 						}
 						k++;
 					}
 				}
 				++j;
 			}
 			if(infinite) {
 				sb.append("YES\n");
 			} else {
 				sb.append("NO\n");	
 			}
 			++i;
		}
		System.out.println(sb.toString());
		
	}

}

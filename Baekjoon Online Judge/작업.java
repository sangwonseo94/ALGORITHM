package 알고리즘공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 작업 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cost[] = new int[N+1];
		int degree[] = new int[N+1];
		int sum[] = new int[N+1];
		ArrayList<Integer> node[] = new ArrayList[N+1]; 
		for(int i=0;i<N;i++) {
			
			node[i+1] = new ArrayList<>(); 
			st = new StringTokenizer(br.readLine());
			cost[i+1] = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			if(next>=1) {
				for(int j=0;j<next;j++) {
					int connect = Integer.parseInt(st.nextToken());
					degree[i+1]++;
					node[connect].add(i+1);
					}
				}
		}
		// int[] 첫번째는 번호 뒤에는 누적합
		ArrayDeque<int []> dq = new ArrayDeque<>();
		
		for(int i=1;i<N+1;i++) {
			sum[i]=cost[i];
			if(degree[i]==0) {
				dq.add(new int[] {i,cost[i]});
			}
		}
		
		while(!dq.isEmpty()) {
			int now[] = dq.poll();
			int size = node[now[0]].size();
		
			for(int i=0;i<size;i++) {
				int next = node[now[0]].get(i);
				int next_cost = sum[now[0]] + cost[next];
				if(sum[next] < next_cost) {
					sum[next] = next_cost;
				}
				if( (--degree[next]) ==0) {
					dq.add(new int[] {next,next_cost});
				}
			}
		}
		int answer = -1;
		for(int i=1;i<N+1;i++) {if(sum[i] > answer) {answer =sum[i];}}
		System.out.println(answer);
	}
}

package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack {
	static int answer= 0 , N , Limit;
	static int map[][];
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <=T ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Limit = Integer.parseInt(st.nextToken());
			map=new int[N][2];//  0은 부피 1은 가치
			for(int y= 0 ; y < N ; y++) {
				st = new StringTokenizer(br.readLine());
				map[y][0] = Integer.parseInt(st.nextToken());
				map[y][1] = Integer.parseInt(st.nextToken());
			}
			DFS(0,0,0);
			sb.append("#"+tc + " " + answer+"\n");
			answer =0;
		}
		System.out.println(sb);
	}
	public static void DFS(int index, int V_Sum, int C_Sum) {
		if(V_Sum > Limit) return;
		else answer = Math.max(answer, C_Sum);
		if(index == N) return;
		DFS(index+1 , V_Sum + map[index][0] , C_Sum + map[index][1]);
		DFS(index+1,  V_Sum , C_Sum );
		
	}

}

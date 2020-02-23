package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
	static int answer =Integer.MAX_VALUE,n;
	static int info[][];
	static boolean visit[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int t= Integer.parseInt(st.nextToken());
		for(int tc = 1;  tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			info= new int[n+2][2]; 
			visit = new boolean[n+2];
			// 0은 y좌표 1은 x좌표
			// 0은 집 n+1은 회사 나머지는 고객
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < n+2  ;index++) {
				if(index == 0) {
					info[0][0] = Integer.parseInt(st.nextToken()); 
					info[0][1] = Integer.parseInt(st.nextToken()); 
				}
				else if(index == 1) {
					info[n+1][0] = Integer.parseInt(st.nextToken()); 
					info[n+1][1] = Integer.parseInt(st.nextToken()); 
				}
				else {
					info[index-1][0] = Integer.parseInt(st.nextToken()); 
					info[index-1][1] = Integer.parseInt(st.nextToken()); 
				}
			}
			DFS(0,0,0); // 현재위치 , 현재 누적거리, 몇번 들어갔는지
			sb.append("#"+tc+" "+answer+"\n");
			answer = Integer.MAX_VALUE;
		}
		System.out.println(sb);
		
	}
	public static void DFS(int pos, int len , int depth) {
		if(len > answer) return;
		if(depth == n) {
			int home = distance(info[pos][0] , info[pos][1] , info[n+1][0] , info[n+1][1]);
			answer = answer > (len + home) ? len+home : answer;
			return;
		}
		
		for(int index =1 ; index <= n ; index++) {
			if(!visit[index]) {
				visit[index] = true;
				int dist = distance(info[pos][0] , info[pos][1] , info[index][0] , info[index][1]);
				len += dist;
				DFS(index , len , depth +1);
				len -= dist;
				visit[index] = false;
			}
		}
	
	}
	public static int distance(int posy, int posx, int targety, int targetx) {
		return Math.abs((posx-targetx)) + Math.abs(posy - targety);
	}

}
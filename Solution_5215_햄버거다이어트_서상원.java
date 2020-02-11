package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_서상원 {
	static class Hamburger{
		int kcal , score;
		public Hamburger(int score , int kcal) {
			this.score = score;
			this.kcal = kcal;
		}
	}
	static int answer =0;
	static int limit=0 , N;
	static ArrayList<Hamburger> AL = new ArrayList<>();
	
	public static void DFS(int score_sum,int limit_sum , int index) {
		if( limit_sum > limit ) {
			return;
		}
		else{
			answer = Math.max( answer , score_sum);
		}
		if(index == N) return ;
		else{
			DFS(score_sum + AL.get(index).score , limit_sum + AL.get(index).kcal , index+1);
			DFS(score_sum , limit_sum , index +1);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc= 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			for(int index = 0 ; index < N  ; index++) {
				st = new StringTokenizer(br.readLine());
				AL.add(new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			DFS(0,0,0);
			sb.append("#"+tc + " " + answer + "\n");
			answer =0; AL.clear();
		}
		System.out.println(sb);
	}



	

}

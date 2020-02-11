package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_sum {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		
		for(int tc = 1; tc<= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[][] = new int[100][100];
			for(int y = 0 ;y < 100 ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0 ; x < 100 ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = Integer.MIN_VALUE;
			for(int y = 0 ;y < 100 ; y++) {
				int sum =0;
				for(int x = 0 ; x < 100 ; x++) {
					sum += map[y][x];
				}
				answer = Math.max(answer, sum);
				
			}
			
			for(int x = 0 ;x < 100 ; x++) {
				int sum =0;
				for(int y = 0 ; y < 100 ; y++) {
					sum += map[y][x];
				}
				answer = Math.max(answer, sum);	
			}
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		System.out.println(sb);
	}

}

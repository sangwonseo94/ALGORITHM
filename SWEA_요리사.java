package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_요리사 {
	static int answer= 2147000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			for(int y = 0 ; y< n ;y ++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x< n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			int cnt[] = new int[n]; 
			for(int index =0 , size = (1<<n) ; index < size ; index++) {
				count=0;
				for(int j = 0 ; j < n ; j++) {
					
					if((index & (1<<j)) !=0) {
						cnt[j] = 1;
						count++;
					}
					else cnt[j]=0;
				}
				if(count== n/2) {
					int a=0 , b=0;
					for(int y= 0; y < n ; y++) {
						for(int x = 0 ;x < n ; x++) {
							if(cnt[x] ==1 && cnt[y]== 1) {
								a += map[y][x];
							}
							if(cnt[y]==0 && cnt[x]==0) {
								b +=map[y][x];
							}
							
						}
					}
					answer = Math.min(answer, Math.abs(a-b));
				}
				
			}
			
			sb.append("#"+tc +" "+answer+"\n");
			answer=2147000000;
		}
		System.out.println(sb);
	}





}

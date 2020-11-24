package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_벌꿀채취 {
	static int res = 0 , res1=0, res2=0,c;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int map[][] = new int[n][n];
			for(int y= 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x= 0 ; x< n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int y = 0 ; y < n ; y++) {
				for(int x = 0 ; x < n ; x++) {
					if(x + m -1 < n) {
						if(x+m + ( m-1 ) < n) {
							for(int t = x+m; t < n ; t++) {
								if(t+m-1>=n )break;
								DFS1(Arrays.copyOfRange(map[y], x, x+m),0,0,0);
								DFS2(Arrays.copyOfRange(map[y], t, t+m),0,0,0);
								res = res1+res2;
								ans = ans > res ? ans : res;
								res =0; res1=0 ; res2=0;
							}
						}
						
						
						for(int i = y+1 ; i < n ; i++) {
							for(int j = 0 ; j < n ; j++) {
								if(j + m-1 >= n) break;
								DFS1(Arrays.copyOfRange(map[y], x, x+m),0,0,0);
								DFS2(Arrays.copyOfRange(map[i], j, j+m),0,0,0);
								res = res1+res2;
								ans = ans > res ? ans : res;
								res =0; res1=0 ; res2=0;
							}
						}
						
					}
					
					else break;
				}
			}
			sb.append("#"+tc+" "+ans+"\n");
			ans = 0;
		}
		System.out.print(sb);

	}
	
	public static void DFS2(int[] copyOfRange, int i, int sum , int midres) {
		if(sum > c ) return;
		if(i == copyOfRange.length) {
			res2 = res2 > midres ? res2 : midres;
			return;
		}
		DFS2(copyOfRange , i+1 , sum ,midres);
		DFS2(copyOfRange , i+1 , sum+copyOfRange[i] , midres+(copyOfRange[i] * copyOfRange[i]));
	}
	
	public static void DFS1(int[] copyOfRange, int i, int sum , int midres) {
		if(sum > c ) return;
		if(i == copyOfRange.length) {
			res1 = res1 > midres ? res1 : midres;
			return;
		}
		DFS1(copyOfRange , i+1 , sum ,midres);
		DFS1(copyOfRange , i+1 , sum+copyOfRange[i] , midres+ (copyOfRange[i] * copyOfRange[i]));
		
	}

	

}

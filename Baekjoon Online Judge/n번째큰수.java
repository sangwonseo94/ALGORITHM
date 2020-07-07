package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n번째큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][n];
		int index[] = new int[n];
		for(int i = 0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == n-1) {
					index[j] = n-1;
				}
			}
		}
		int tc= n;
		int  max_row=0 , max_col =0;
		while(tc-->0) {
			int max = 0;
			for(int i = 0 ; i < n ; i++) {
				if( max < map[index[i]][i]  ) {
				    max = map[index[i]][i];
					max_row = index[i];
					max_col = i;
				}
			}
			index[max_col]--;
		}System.out.println(map[max_row][max_col]);
	}
}

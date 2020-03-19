package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무재테크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][n];
		for(int y= 0 ; y < n ; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x< n ;x ++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}

}

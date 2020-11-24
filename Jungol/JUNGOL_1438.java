package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1438 {
	static int n ;
	static int map[][] = new int[100][100];
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		for(int index = 0 ; index < n ; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			check(y,x);
		}
	}
	
	public static void check(int b, int a) {
		for(int y = b ; y < b +10 ; y++) {
			for(int x =a ; x < a +10 ; x ++) {
				map[y][x] = 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		input();
		int cnt= 0;
		for(int y = 0 ; y < 100 ; y++) {
			for(int x =0 ; x < 100 ; x ++) {
				if(map[y][x]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}

}

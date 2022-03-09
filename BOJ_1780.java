package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    public static int plus,zero,minus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,N,map);
		System.out.println(minus+"\n"+zero+"\n"+plus);
	}
	private static void go(int y, int x, int len, int[][] map) {
		 int now = map[y][x];
		 boolean isAllsame = true;
		 top :
		 for(int i=y;i<y+len;i++) {
			 for(int j=x;j<x+len;j++) {
				 if(map[i][j]!=now) {
					 isAllsame =false;
				 } 
				 if(!isAllsame) {
					 break top;
				 }
			 }
		 }
		
		 
		 if(isAllsame) {
			 if(now==1)   plus++;
			 if(now==0)   zero++;
			 if(now==-1) minus++;
		 } else {
			 for(int i=y;i<y+len;i+=len/3) {
				 for(int j=x;j<x+len;j+=len/3) {
					 go(i,j,len/3,map);
				 }
		     }
		 }
		
	}

}

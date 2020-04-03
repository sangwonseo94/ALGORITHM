package 풀문제;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA3차원농부 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for(int tc = 1 ;tc<=t ;tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			int zn[] = new int[n];
			int zm[] = new int[m];
			for(int i = 0 ; i < n ; i ++) {zn[i] = sc.nextInt();}
			for(int i = 0 ; i < m ; i ++) {zm[i] = sc.nextInt();}
			Arrays.sort(zn);
			Arrays.sort(zm);
			int min = 987564321; int cnt = 0;
			for(int i = 0 ; i < n ; i ++) {
				for(int j = 0 ; j < m ; j ++) {
					int com = Math.abs(zn[i] - zm[j]);
					if(com == min) cnt++;
					else if(com > min) continue;
					else if(com < min) {
						min = com; cnt=1;
					}
 				}
			}
			int comp = Math.abs(c1-c2);
			sb.append("#"+tc+" "+(min+comp) + " " +cnt+'\n');
		}
		System.out.print(sb);
	}
}

package 풀문제;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA3차원농부_이분탐색 {
	static public int dist(int a,int b) {
		return Math.abs(a-b);
	}
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
			int min = 987564321; int cnt = 0 , cntz=0;
			for(int i = 0 ; i < n ; i ++) {
				int target = zn[i];
				int startidx = 0; 
				int endidx =m-1;
				int mididx = (startidx + endidx) / 2; 
				while(startidx <= endidx) {
					
					int v = zm[mididx];
					if(v == target) { 
					min =0;
					cntz++;
					break;} 
					else if( v < target) {
						startidx = mididx+1;
						mididx = ( startidx + endidx) /2;
					} else if(v > target) {
						endidx = mididx -1;
						mididx = ( startidx + endidx) /2;
					}
				}
				if(min>0) {
					int temp1=987654321,temp2=987654321;
					if(endidx <0 && endidx +1 != startidx) {
						endidx ++;
					}  
					if(startidx >=m && startidx -1 !=endidx) {
						startidx =m-1;
					} 
					if(startidx >=0 && startidx <m) temp1 =dist(zm[startidx], target);
					if(endidx >=0 && endidx <m)temp2 =dist(zm[endidx], target);
					if(min > temp1) {
						min = temp1 ; cnt=1;
					} else if(min==temp1) cnt++;
					if(min > temp2) {
						min = temp2; cnt=1;
					} else if(min==temp2) cnt++;
				}
			}
			int comp = Math.abs(c1-c2);
			if(min==0) cnt=cntz;
			sb.append("#"+tc+" "+(min+comp) + " " +cnt+'\n');
		}
		System.out.print(sb);
	}
}

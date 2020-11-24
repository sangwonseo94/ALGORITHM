package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class connectprocess {
	static int map[][], n , index , ans = 987654321, mid , maxi=0 , ans2 =-1;
	static int coordination[][];
	static boolean allcover[] ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc=1 ; tc<= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			index = 0;
			for(int y = 0 ; y < n ; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0 ; x < n ; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					if(map[y][x] ==1 && y != 0 && x != 0 && y != (n-1) && x != (n-1)) {
						index++;
					}
				}
			}
			coordination = new int[index][2];
			allcover = new boolean[index];
			index =0;
			for(int y = 0 ; y < n ; y++) {
				for(int x = 0 ; x< n ; x++) {
					if(map[y][x] ==1 && y != 0 && x != 0 && y != (n-1) && x != (n-1)) {
						coordination[index][0] = y;
						coordination[index][1] = x;
						index++;
					}
				}
			}
			
			Dfs(0,0);
			if(ans==987654321) ans = ans2;
			System.out.println("#"+tc+" "+ans );
			ans =987654321;
		}
		System.out.print(sb);
	}
	private static void Dfs(int i , int res) {
		if(res > ans) return;
		
		if(i == index && allcovercheck()) {
			ans = res;
			return;
		}
		if(i == index ) return;
		boolean pass = true;
		
		for(int index = 2 ; index < 6 ; index++) {
			if(check(i, index)) {
				pass = false;
				cover(i,1,index);
				allcover[i] = true;
				int j = 0 ;
				for (boolean b : allcover) {if(b)j++;}
				if(maxi <= j) {
					if(maxi == j) {
						if(ans2 > res+mid) {
							ans2 = res+mid;
						}
					}else {
						ans2 = res+mid;
						maxi = j;
					}
				}
				
				Dfs(i+1,res+mid);
				allcover[i] = false;
				cover(i,0,index);
			}
		}
		if(pass) Dfs(i+1,res);
	}
	private static boolean allcovercheck() {
		for (boolean b : allcover) {
			if(!b) return false;
		}
		return true;
	}
	private static void cover(int i, int cover , int dir) {
		int y = coordination[i][0];
		int x = coordination[i][1];
		mid =0;
		if(cover ==0) {
			if(dir ==2) {for(int a = x -1 ; a >=0 ; a--) {map[y][a]= cover; }}
			else if(dir==3) {for(int a = x +1 ; a < n ; a++) {map[y][a]= cover;}}
			else if(dir==4) {for(int a = y -1 ; a >=0 ; a--) {map[a][x]= cover;}}
			else if(dir==5) {for(int a = y +1 ; a <n ; a++) {map[a][x]= cover;}}
		}
		if(dir ==2) {for(int a = x -1 ; a >=0 ; a--) {map[y][a]= cover; mid++;}}
		else if(dir==3) {for(int a = x +1 ; a < n ; a++) {map[y][a]= cover;mid++;}}
		else if(dir==4) {for(int a = y -1 ; a >=0 ; a--) {map[a][x]= cover;mid++;}}
		else if(dir==5) {for(int a = y +1 ; a <n ; a++) {map[a][x]= cover;mid++;}}
		
	}
	private static boolean check(int i, int cover) {
		int y = coordination[i][0];
		int x = coordination[i][1];
		boolean ret = true;
		if(cover ==2) {
			for(int a = x -1 ; a >=0 ; a--) {
				if(map[y][a]!= 0) ret =false; 
			}
			return ret;
		}else if(cover==3) {
			for(int a = x +1 ; a < n ; a++) {
				if(map[y][a]!= 0) ret =false; 
			}
			return ret;
		}else if(cover==4) {
			for(int a = y -1 ; a >=0 ; a--) {
				if(map[a][x]!= 0) ret =false; 
			}
			return ret;
		}else if(cover==5) {
			for(int a = y +1 ; a <n ; a++) {
				if(map[a][x]!= 0) ret =false; 
			}
			return ret;
		}else return false;
		
		
	}

}

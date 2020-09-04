package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 비숍_gold {
	public static int map[][] ;
	public static int res = -1,n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		DFSUptoBottom(0,0,map);
		DFSLefttoRight(0,0,map);
		System.out.println(res);
	
	
	}
	
	
	
	
	private static void DFSLefttoRight(int row, int cnt, int[][] map2) {
		if(row == n) {
			res = res  > cnt ? res : cnt;
			return;
			
		}
		int Copy_cnt = cnt;
		int Copy_Map[][] = new int[n][n];
		for(int i= 0 ; i < n ; i ++) Copy_Map[i] = map2[i].clone();
		// 해당 row를 선택 Or 비선택
		// 선택하는 경우
		for(int i = 0 ; i < n ; i ++) {
			if(Copy_Map[i][row] ==1) {
				cover(i,row,Copy_Map,0); Copy_cnt++;
			}
		}
		DFSUptoBottom(row+1,Copy_cnt,Copy_Map);
		// 비선택하는 경우
		DFSUptoBottom(row+1,cnt,map2);
		
	}


	private static void DFSUptoBottom(int row, int cnt, int[][] map2) {
		if(row == n) {
			res = res  > cnt ? res : cnt;
			return;
			
		}
		int Copy_cnt = cnt;
		int Copy_Map[][] = new int[n][n];
		for(int i= 0 ; i < n ; i ++) Copy_Map[i] = map2[i].clone();
		// 해당 row를 선택 Or 비선택
		// 선택하는 경우
		for(int i = 0 ; i < n ; i ++) {
			if(Copy_Map[row][i] ==1) {
				cover(row,i,Copy_Map,1); Copy_cnt++;
			}
		}
		DFSUptoBottom(row+1,Copy_cnt,Copy_Map);
		// 비선택하는 경우
		DFSUptoBottom(row+1,cnt,map2);
		
	}


	private static void cover(int y, int x, int[][] copy_Map , int dir) {
		// 왼쪽 아래
		if( dir ==1 ) {
			for(int i = y , j = x ; i < n && j >= 0 ; i++, j--) {
				if(copy_Map[i][j]==1) {
					copy_Map[i][j]=0;
				}
			}
			for(int i = y , j = x ; j < n && i < n ; i++, j++) {
				if(copy_Map[i][j]==1) {
					copy_Map[i][j]=0;
				}
			}
		}
		else {
			for(int i = y , j = x ; i >=0 && j < n ; i--, j++) {
				if(copy_Map[i][j]==1) {
					copy_Map[i][j]=0;
				}
			}
			for(int i = y , j = x ; j < n && i < n ; i++, j++) {
				if(copy_Map[i][j]==1) {
					copy_Map[i][j]=0;
				}
			}
		}
	}
}

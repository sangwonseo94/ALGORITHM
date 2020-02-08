package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class array_transform {
	static int n,m,k;
	static int map[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String rotate[] ;
		
	public static void input() throws Exception {
		String nmk = br.readLine();
		String arr[] = nmk.split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		k = Integer.parseInt(arr[2]);
		map = new int[n +1 ][m +1 ];
		for(int y = 1 ; y < n +1 ; y++) {
			String number = br.readLine();
			String number_[] = number.split(" ");
			for(int x = 1 ; x < m+1 ; x++) {
				map[y][x] = Integer.parseInt(number_[x-1]);
			}
		}
		rotate = new String[k];
		for(int index = 0 ; index < k ; index ++) {
			rotate[index] = br.readLine();
		}
	
	}
	
	public static void Matrix_Rotate(int r, int c , int s) {
		Deque<Integer> Q = new ArrayDeque<Integer>();
		int start_row = r-s ;
		///int end_row = r +s;
		int start_col = c-s;
		///int end_col = c+s;
		for (;start_col < c+s +1 ; start_col++) Q.add(map[start_row][start_col]);
		start_col--;
		start_row++;
		for (;start_row < r+s +1 ; start_row++) Q.add(map[start_row][start_col]);
		start_row--;
		start_col--;
		for (; start_col> c-s ;  start_col--) Q.add(map[start_row][start_col]);
		
		for( ; start_row > r-s ; start_row--) Q.add(map[start_row][start_col]);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		input();
		Matrix_Rotate(3,4,2);
	
	}
	

}

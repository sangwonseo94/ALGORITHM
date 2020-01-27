package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CrossMap_Route {
	
	public static int compute(int end_x , int end_y) {
		
		int map[][] = new int[end_y+1][end_x+1];
		
		for(int index = 0 ; index < end_x+1 ; index++) map[0][index] =1;
		for(int index = 0 ; index < end_y+1 ; index++) map[index][0] =1;
		
		for(int y = 1; y <end_y+1 ; y++) {
			for( int x = 1 ; x < end_x+1 ; x++) {
				map[y][x] = map[y-1][x] + map[y][x-1];
			}
		}
		
		return map[end_y][end_x];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arg = br.readLine();
		String arg_[] = arg.split(" ");
		int N = Integer.parseInt(arg_[0]); 
		int M = Integer.parseInt(arg_[1]); 
		int K = Integer.parseInt(arg_[2]); 
		if(K == 0) {
			System.out.println(compute(N-1,M-1));
		}
		else {
			int x =K%M;
			if(x ==0) x = M-1;
			int y = K/M;
			if(K%M ==0) y--;
			System.out.println(compute(x,y) * compute(M-x-1,N-y-1));
		}
		
	}

}

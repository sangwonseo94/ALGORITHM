package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_비밀이메일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		int size = t.length(); int r = 0;
		for(int index = 1 ; index <= Math.sqrt(size) ; index++) {
			if(size % index == 0) r= Math.max(r, index);
		}
		int c = size / r;
		char map[][] = new char[r][c];
		//System.out.println( r + " " + c);
		for(int x = 0 ; x < c ; x++) {
			for(int y= 0 ; y < r ; y++) {
				map[y][x] = t.charAt(x*r + y);
			}
		}
		
		for(int y = 0 ; y < r ; y++) {
			for(int x= 0 ; x <c ; x++) {
				System.out.print(map[y][x]); 
			}
		}
		
	}

}

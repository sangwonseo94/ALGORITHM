package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS {

	public static void main(String[] args) throws Exception {
	
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String strA = br.readLine();
		String strB = br.readLine();
		int map[][] = new int[strA.length()+1][strB.length()+1];
		for(int i = 1 ; i < strA.length()+1 ; i++) {
			for(int j = 1 ; j < strB.length()+1 ; j++) {
				if(  strA.charAt(i-1) ==	 strB.charAt(j-1)  ) {
					map[i][j] = map[i-1][j-1]+1;
				} else {
					map[i][j] = max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(map[strA.length()][strB.length()] + "\n");
		
		int y = strA.length();
		int x = strB.length();
		String Answer ="";
		while(map[y][x] != 0) {
			if(map[y-1][x] == map[y-1][x-1] && map[y-1][x-1] == map[y][x-1] && map[y-1][x-1] < map[y][x]) {
				// 저장하고 
				Answer +=  strA.charAt(y-1);
				y--;x--;
			} else {
				// 큰쪽으로 이동, 가장 큰값의 y,x를 대입
				if(map[y-1][x] < map[y-1][x-1]) {
					if(map[y-1][x-1] < map[y][x-1]) {
						x--;
					} else {
						y--;x--;
					}
				} else {
					if(map[y-1][x] > map[y][x-1]) {
						y--;
					} else {
						x--;
					}
				}
			}
		}
		for(int i =  Answer.length()-1 ; i >=0 ; i--) {
			sb.append(Answer.charAt(i));
		}
		System.out.println(sb);
	
	}

	private static int max(int i, int j) {
		return i = i > j ? i : j ;
	}
}

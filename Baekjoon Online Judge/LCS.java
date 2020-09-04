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
		System.out.println(sb);
	
	}

	private static int max(int i, int j) {
		return i = i > j ? i : j ;
	}
}

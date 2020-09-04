package 푼문제;

import java.util.Scanner;

public class ������ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test_case = 1; test_case <tc +1 ; test_case ++) {
			
			int n = sc.nextInt(); int m = sc.nextInt();
			
			int map[][] = new int[n+1][n+1];
			map[n/2][n/2] = 2; map[n/2 +1][n/2 +1] =2;
			map[n/2 +1][n/2] =1; map[n/2][n/2+1] =1;
			
			
			
			
			
		}

	}

}

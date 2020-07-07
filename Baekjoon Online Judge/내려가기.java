package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int A[][] = new int[3][2];
		int B[] = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 3 ; i ++) {A[i][0] = Integer.parseInt(st.nextToken()); A[i][1] = A[i][0];}
		for(int i = 1 ; i < n  ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// max 
			B[0] = a + Math.max(A[0][0], A[1][0]);
			B[1] = b + Math.max(A[1][0], Math.max(A[0][0],A[2][0]));
			B[2] = c + Math.max(A[2][0], A[1][0]);
			A[0][0] = B[0];
			A[1][0] = B[1];
			A[2][0] = B[2];
			// min
			B[0] = a + Math.min(A[0][1], A[1][1]);
			B[1] = b + Math.min(A[1][1], Math.min(A[0][1],A[2][1]));
			B[2] = c + Math.min(A[2][1], A[1][1]);
			A[0][1] = B[0];
			A[1][1] = B[1];
			A[2][1] = B[2];
		}
		int min = Math.min(Math.min(A[0][1], A[1][1]) , A[2][1]);
		int max = Math.max(Math.max(A[0][0], A[1][0]) , A[2][0]);
		System.out.println(max);
		System.out.println(min);
	}
}

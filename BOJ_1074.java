package algorithm_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	public static int answer =0;
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		recursion(r, c, 0, n);
		System.out.println(answer);
	}
	private static void recursion(int y, int x, int score, int N) {
		if(N==1) {
			if(y==0&&x==0)answer =score;
			else if(y==0&&x==1)answer =score+1;
			else if(y==1&&x==0)answer =score+2;
			else if(y==1&&x==1)answer =score+3;
			return;
		}
		int len = (int) Math.pow(2, N-1);
		if(y<len&&x<len) {
			recursion(y, x, score, N-1);
		} else if(y<len&&x>=len) {
			recursion(y, x-len, score+(int)Math.pow(2, 2*N-2), N-1);
		} else if(y>=len&&x<len) {
			recursion(y-len,x, score+(int)Math.pow(2, 2*N-2)*2, N-1);
		} else {
			recursion(y-len,x-len, score+(int)Math.pow(2, 2*N-2)*3, N-1);
		}
		
		
	}

}

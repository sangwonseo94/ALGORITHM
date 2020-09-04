package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeforce0326_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < t ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			 {
			int j = a/2;
			while(true) {
				if(j*(j-1)/2 < b ) {
					if(b<=j*(j+1)/2) {break;}
				j++;
				} else j--;
			}
			
			int s = b % (((j*(j-1))/2)+1) ;
				int f = a-j;
				int se =a-s;
				for(int k = 1 ; k <= a ; k++) {
					if(k == f || k == se) sb.append("b");
					else sb.append("a");
				}
				sb.append("\n");
			}
		}System.out.println(sb);
	}

}

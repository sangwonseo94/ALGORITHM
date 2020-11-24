package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_홀수중간값피라미드1 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<= t ; tc++) {
			int answer =0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if( 2*n -1 ==x || x ==1) answer =0;
			if( x >=2 ||  x<=2*n-2) answer =1;
			sb.append("#" +tc +" "+ answer +"\n");
		}
		System.out.println(sb);
	}

}

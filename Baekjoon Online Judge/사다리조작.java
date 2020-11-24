package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작 {
	public static int n,m,h,c;
	public static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
		 map=new int[h][n];
		 for(int i=0;i<m;i++)
			 {st=new StringTokenizer(br.readLine());int y=Integer.parseInt(st.nextToken());
			 int x=Integer.parseInt(st.nextToken());map[y-1][x-1]=1;map[y-1][x+1-1]=1;}
		System.out.println("12");
	}
}

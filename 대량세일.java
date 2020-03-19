package 푼문제;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �뷮���� {
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ans/�뷮����.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<= t ; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			int n = Integer.parseInt(st.nextToken());
			int num[] = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < n ; index++){
				num[index] = Integer.parseInt(st.nextToken());
				sum+= num[index];
			}
			Arrays.sort(num);
			int sub =0;
			for(int index =n-3 ; index >=0 ; index-=3){
				sub += num[index];
			}
			answer = sum - sub;
			sb.append("#"+tc+" "+ answer+"\n");
			answer= 0;
		}
		System.out.println(sb);
	}

}

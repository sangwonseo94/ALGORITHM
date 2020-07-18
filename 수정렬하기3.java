package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수정렬하기3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num[] = new int[10001];
		for(int i = 0 ; i < n ; i ++) {num[Integer.parseInt(br.readLine())]++;}
		for(int i = 0 ; i < 10001; i++) {
			if(num[i] !=0) {
				for(int ii = 0 ; ii < num[i]; ii++) {
					sb.append(i+"\n");
				}
			}
		}System.out.println(sb);
	}

}

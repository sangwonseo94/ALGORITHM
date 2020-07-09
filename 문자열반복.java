package solvedClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < t ; i++) {
			st= new StringTokenizer(br.readLine());
			int loop = Integer.parseInt(st.nextToken());
			char ch[] = st.nextToken().toCharArray();
			for(int j = 0 ; j < ch.length; j++) {
				for(int k = 0 ; k < loop; k++) {
					sb.append(ch[j]);
				}
			}
			sb.append("\n");
		}System.out.println(sb);
	}

}

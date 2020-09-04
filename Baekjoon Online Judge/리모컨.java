package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨 {
	private static int impossible[] , answer = 2147000000;
	private static String target;
	private static void DFS(String number) {
		
		if(number.length() != 0 && Integer.parseInt(number) < 500000) {
			int differ = Math.abs(Integer.parseInt(number) - Integer.parseInt(target));
			answer = answer > (differ +number.length()) ? (differ +number.length()) : answer;
			
		} else {
			return;
		}
		for(int i = 0 ; i <=9 ; i ++) {
			if(number.length() == 0 && i==0) continue;
			boolean isContinue = true;
			for(int j = 0 ; j < impossible.length ; j ++) {
				if(impossible[j]==i) {
					isContinue = false;
					break;
				}
			}
			if(!isContinue)continue;
			DFS(number+Integer.toString(i));
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		target = st.nextToken();
		int m = Integer.parseInt(br.readLine());
		if( m == 0) {
			// 고장난 버튼이 없는경우 그냥 바로이동하면 된다.
			System.out.println(target.length());
		} else if ( m==10 ) {
			st = new StringTokenizer(br.readLine());
			System.out.println(Math.abs(Integer.parseInt(target) - 100));
		} else  {
			if(target.equals("100")) {
				st = new StringTokenizer(br.readLine());
				System.out.println("0");
			} else {
				impossible = new int[m];
				st = new StringTokenizer(br.readLine());
				for(int i = 0 ; i < m ; i++) {
					impossible[i] = Integer.parseInt(st.nextToken());
				}
				DFS("");
				if(impossible[0] != 0) {
					int tozero = 1 + target.length();
					answer = answer > tozero? tozero : answer ;
					
				}
				answer = answer > Math.abs(Integer.parseInt(target) - 100) ? Math.abs(Integer.parseInt(target) - 100) : answer;
				System.out.println(answer);
			}
		}
	}
}

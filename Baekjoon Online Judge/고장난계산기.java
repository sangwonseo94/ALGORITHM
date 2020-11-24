package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 고장난계산기 {
	static boolean Number[] = new boolean[10];
	static int max = Integer.MAX_VALUE;
	static int res = max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T ;tc++) {
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index<10; index++) {if(st.nextToken().toCharArray()[0] =='1') Number[index] = true;else Number[index] = false;} 
			st = new StringTokenizer(br.readLine());
			String target = st.nextToken();
			solution(target,1);
			res = res == max ? -1 : res;
			sb.append("#"+tc+" "+res+"\n");
			res= max;
		}
		System.out.print(sb);
	}

	public static void solution(String target, int answer) {
		if(judge(target)) {
			res = res > answer+target.length() ? answer+target.length() : res;
			return;
		}
		int temp = Integer.parseInt(target);
		for(int num = 2 ; num <= Math.sqrt(temp); num++) {
			if(temp % num ==0 && judge(String.valueOf(num))) {
				solution(String.valueOf(temp/num), answer+1+(String.valueOf(num)).length());
			}
		}
		
		
	}

	public static boolean judge(String target) {
		char[] temp = target.toCharArray();
		int size = temp.length;
		for(int index = 0 ; index < size ; index++) {
			if(Number[temp[index]-'0']) continue;
			else return false;
		}
		return true;
	}

}

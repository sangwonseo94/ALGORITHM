package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class 사칙연산{
	static String tree[][];
	public static void main(String args[]) throws Exception{
		int T=10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= T; test_case++){
			int n = Integer.parseInt(br.readLine())+1;
			tree = new String[n][4];
			for(int index = 1 ; index < n ; index++) {tree[index] = br.readLine().split(" ");}
			if(check(1)) System.out.println("#"+ test_case+" 1");
			else System.out.println("#"+ test_case+" 0");	
		}
	}

	public static boolean check(int i) {
		if(tree[i].length==4) {
		char ch =tree[i][1].charAt(0);
		boolean op =  ch=='+' || ch=='/' || ch=='*' || ch=='-';
		return op && check(trim(tree[i][2])) && check(trim(tree[i][3]));
		}
		else return tree[i][1].charAt(0) >='0' && tree[i][1].charAt(0) <= '9' ? true :false;
	}
	public static int trim(String str) {
		return Integer.parseInt(str.trim());
	}
}
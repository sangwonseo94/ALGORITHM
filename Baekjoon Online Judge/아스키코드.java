package solvedClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 아스키코드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		char c = br.readLine().charAt(0);
		System.out.printf("%d",(int)c);
	}
}

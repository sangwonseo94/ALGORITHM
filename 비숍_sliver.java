package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 비숍_sliver {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(n+(n-2));
	}

}
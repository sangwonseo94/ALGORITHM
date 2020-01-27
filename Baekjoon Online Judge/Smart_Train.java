package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Smart_Train {
	static int poplutation  = 0;
	public static int compute(int down, int up) {
		return up-down;
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int index = 0 ; index < 4 ; index++) {
			String str = br.readLine();
			String str_list[]= str.split(" ");
			poplutation = Math.max(poplutation + compute(stoi(str_list[0]),stoi(str_list[1])), poplutation);
			poplutation += compute(stoi(str_list[0]),stoi(str_list[1]));
		}
		
		System.out.println(poplutation);
	}

}

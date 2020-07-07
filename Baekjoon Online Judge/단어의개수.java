package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 단어의개수 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer [] = str.split(" ");
		int size = answer.length;
		for(int i = 0 ; i < answer.length ; i++) {
			if(answer[i].equals("")) {
				size -=1;
			}
		}
		System.out.println(size);
	}
}

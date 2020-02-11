package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_수2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int number[] = new int[L];
		st= new StringTokenizer(br.readLine());
		for(int index = 0 ; index < L ; index++) {
			number[index] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		Arrays.sort(number);
		int start = 0;
		if(check(number , target)) {
			System.out.println(0);
		}
		else {
			if(target <number[0]) {
				System.out.println( );
			}
			else {
			for(int index = 0 ; index < number.length-1; index++) {
				if(number[index] < target && number[index+1] > target) {
					start = index;
				}
			}
			System.out.println((number[start+1]-target)*(target-number[start] )-1);
			}
		}
	}

	private static boolean check(int[] number, int target) {
		for (int i : number) {
			if(i == target) return true;
		}
		return false;
	}

}

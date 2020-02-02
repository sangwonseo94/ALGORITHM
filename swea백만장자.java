package practice;

import java.util.Arrays;
import java.util.Scanner;

public class swea백만장자 {

	public static boolean down(int arr[]) {
		int f = arr[0];
		for(int index = 0; index < arr.length ; index++) {
			if(f < arr[index]) return false;
		}
		return true;
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while(tc> 0) {
			int n = sc.nextInt();
			int arr [] = new int [n];
			long res =0;
			for(int index =0 ; index < n ; index++) {
				arr[index] = sc.nextInt();
			}
			if(down(arr)) {
				System.out.println(res);
			}
			else {
				while(arr.length > 0) {
				int index = cut(arr);
				for(int i = 0 ; i < index ; i++) {
					res += (arr[index] - arr[i]);
				} // 이윤계산
				
				arr = Arrays.copyOfRange(arr, index + 1, arr.length);
				
				}
				System.out.println(res);
			}
			
			
			tc--;
		}
	}



	private static int cut(int[] arr) {
		int max = Integer.MIN_VALUE;
		int re = 0;
		for(int index = 0; index < arr.length;index++) {
			if(max < arr[index]) {
				max = arr[index];
				re = index;
			} 
		}
		return re;
	}

}

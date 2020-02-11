package practice;

import java.util.Scanner;

public class SWEA_상원이의연속합 {
	static int sum[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp =0; 
		int idx=0;
		sum = new int[100001]; boolean t = true;
		for(int index = 1; index< n/2+2 ; index++) {
			temp +=index;
			sum[index] = temp;
			if(sum[index] >=n && t) {
				idx = index; t = !t;	
			}
		}
		int cnt= 0;
		for(int index = 0 ; index <= n/2+1 ;index++) {
			
			if(sum[idx] - sum[index] == n ) {
				cnt++; idx++;continue;
			} 
			if(sum[idx] - sum[index] < n ) {
				idx ++;
				continue;
			}
		}
		System.out.println(++cnt);
	}

}

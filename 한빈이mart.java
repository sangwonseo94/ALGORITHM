package practice;

import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int mg[] = new int[n];
			for(int index = 0; index < n ; index++) {
				mg[index] = sc.nextInt();
			}
			int sum =0;
			
			for(int j =0 ; j < n ; j ++) {
				for(int i = j+1 ; i < n ; i++ ){
					int temp = mg[j] + mg[i];
					if(temp > m) continue;
					sum = sum > temp ? sum : temp;
				}
			}
			if(sum == 0) System.out.println("#" + test_case +" "+ (sum-1));
			else System.out.println("#" + test_case +" "+ sum);
			 
		}
	}
}
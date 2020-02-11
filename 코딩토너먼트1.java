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
			int size = (int)Math.pow(2, n);
			int coding[] = new int[size];
			int ans =0;
			for(int index = 0 ; index <size ; index++ ) {
				coding[index] = sc.nextInt();
			}
			
			while(!(size ==1)) {
				
				for(int index =0; index < size ; index+=2) {
					
					ans += Math.abs((coding[index] - coding[index+1]));
					coding[index/2] = Math.max(coding[index], coding[index+1]);
					
				}
				size /=2;
			}
			System.out.println("#" + test_case +" " + ans);
			ans =0;
		}
	}
}
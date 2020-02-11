package practice;

import java.util.Scanner;

public class Stick {

	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		int size = 0 ;
		int now = 64;
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		while(! (0 == target)) {
		
			
			if( now / 2  > target) {
				now /=2;
			}
			else if(now == target || now/2 == target) {
				size++;
				break;
			}
			else if( now/ 2 < target) {
				now /=2;
				size ++;
				target -= now;
			}
			
		}
		System.out.println(size);
	}

}

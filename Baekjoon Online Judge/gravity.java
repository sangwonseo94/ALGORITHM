package 푼문제;

import java.io.FileInputStream;
import java.util.Scanner;

public class gravity {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input/tc.txt"));
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int num[] = new int[x];
		for(int index = 0; index < x ; index++) {
			num[index] = sc.nextInt();
		}
		
		int height =0, ans = 0 , max_col = num[0];
		int before_max_col =0 , before_height =0;
		for(int index =0 ; index < x ; index ++) {
			if(max_col < num[index]) {
				before_max_col = max_col;
				max_col = num[index];
				
				if( before_height + ans < ans +height) {
					 ans += height;
				 }
				 else {
					 ans += before_height;
				 }
				
				before_height =0;
				height = 0;
				
			}
			else if(max_col == num[index]) {
				
				continue;
			} 
			else if(num[index] < max_col) {
				height+=1;	
				if(num[index] < before_max_col) {
					before_height +=1;
				}
			}
			else if(index == x-1) {
				 if( before_height <  height) {
					 ans += height;
				 }
				 else {
					 ans += before_height;
				 }
			}
			}
		
		
		System.out.println(ans);
	}

}

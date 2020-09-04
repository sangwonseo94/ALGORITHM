package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ����ġ {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int bomb[] = new int [t+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 1; index<=t ; index++) {
			bomb[index] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int person_num = Integer.parseInt(st.nextToken());
		for(int index = 0 ; index < person_num ; index++) {
		 st = new StringTokenizer(br.readLine());
		 int gender = Integer.parseInt(st.nextToken());
		 int action = Integer.parseInt(st.nextToken());
		 if(gender == 1) {
			 for(int jump = action ; jump < t+1 ; jump += action ) {
				 bomb[jump] = bomb[jump] == 1? 0 : 1 ;
			 }
		 }
			
		 else if (gender == 2) {
			 
			 int jump = 1;
			 bomb[action] = bomb[action] == 1? 0 : 1;
			 
			 while(true) {
				 if(action -jump >=1 &&  action+jump <t +1) {
					 if(bomb[action -jump] == bomb[action+jump]) {
						 bomb[action-jump] = bomb[action-jump] == 1? 0 :1;
						 bomb[action+jump] = bomb[action+jump] == 1? 0 :1;
					 }
					 else
						 break;
					 }
				 else break;
				 jump +=1;
			 }
			 
		 }
			
		}	
		
		for(int index = 1 ; index < bomb.length ; index++) {
			System.out.print(bomb[index] + " ");
			if(index %20 == 0) System.out.println();
		}
		
	}

}

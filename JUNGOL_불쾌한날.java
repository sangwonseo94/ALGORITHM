package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class JUNGOL_불쾌한날 {

	public static void main(String[] args) throws Exception {
		Use_stack();
	}
	
	public static void Use_stack() throws Exception {
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		 int height[]= new int [80001];
		 int N ; 
		 long ans =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim()) +1;
		dq.addLast(Integer.parseInt(br.readLine().trim()));
		
		for(int index = 2 ; index < N ; index++) {
			int temp = Integer.parseInt(br.readLine().trim());
			
			while(dq.peekLast() <= temp){
				dq.pollLast();
				if(dq.isEmpty())break;
			}
			
			ans+=dq.size();
			dq.addLast(temp);
		}
		System.out.println(ans);
	}

}

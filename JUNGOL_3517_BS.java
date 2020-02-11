package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_3517_BS {
	static int N,Q;
	static int numbers[];
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("answer/jungol3517.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int index = 0 ; index < N ; index++){
			numbers[index] = Integer.parseInt(st.nextToken());
		}
		Q = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine()," ");
		for(int index = 0 ; index < Q ;index++) {
			int find = Integer.parseInt(st.nextToken());
			boolean f = true;
			int start = 0, end = numbers.length-1; 
			while(start <= end) {
				int mid = (start + end)>>1;
				
				if(find == numbers[mid]) {
					sb.append(mid +" ");
					f = false;
					break;
				}
				else if(numbers[mid] < find) {
					start = mid +1;
				}
				else {
					end = mid -1;
				}
					
			}
			
			if(f) {
				sb.append(-1 + " ");
			}
		}
		
		System.out.println(sb);
		
		
	}

}

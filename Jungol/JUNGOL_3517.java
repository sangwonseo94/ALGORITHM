package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_3517 {
	static int N,Q;
	static int numbers[];
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("answer/jungol3517.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			int j = 0;
			for(;j < N ; j++){
				if(find == numbers[j]) {
					System.out.print( j+" ");
					break;	
				}
			}
			if(j == N) {
				System.out.print(-1 + " ");
			}
		}
		
		
		
		
	}

}

package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class codeforce2 {
	static int array[],n;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new  StringBuilder();
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc< t ; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			array = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int index = 0 ; index < n ; index++) array[index] = Integer.parseInt(st.nextToken());
				
			Arrays.sort(array);
			if(n==1) {
				sb.append(array[0] +"\n");
			}else {
				boolean conti = true;
				while(conti) {
					if(check()) {
						for(int arr : array) {
							sb.append(arr+" ");
						}
						sb.append("\n");
						conti= false; continue;
					}
					np();
				}
			}
		}
		System.out.print(sb);
	}
	public static void np() {
		int i = n-1 ;
		while(i > 0 && array[i-1] > array[i]) i--;
		if(i==0) return ;
		int j = n-1;
		while(array[i-1] >= array[j]) j--;
		
		int tmp = array[i-1];
		array[i-1] = array[j];
		array[j] =tmp;
		int k = n-1;
		while(i<k) {
			tmp =array[i];
			array[i]= array[k];
			array[k] =tmp;
			i++;--k;
		}
		
	}
	public static boolean check() {

		for(int i = 0 ; i < n ; i++) {
			for(int j = i+1 ; j < n ; j ++) {
				if(i-array[i] == j-array[j]) return false;
			}
		}
		return true;
	}

}

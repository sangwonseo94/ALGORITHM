package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeforece0326_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc=0 ; tc<t ; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			char[] arr = br.readLine().toCharArray();
			
			char[]a = new char[n];
			char[]b = new char[n];
			boolean flag = true;
			for(int i = 0 ; i < n ; i ++) {
				if(arr[i]=='2') {
					if(flag) { a[i] ='1'; b[i]='1';}
					else {a[i] ='0'; b[i]='2';}
				} else if(arr[i]=='0') {
					a[i] ='0' ; b[i]='0';
				} else if(arr[i]=='1'){
					if(flag) {
						a[i]='1'; b[i]='0'; 
						flag= false;
					} else {
						a[i]='0'; b[i]='1';
					}
				}
			}
			for(int i = 0 ; i < n ; i ++) {
				System.out.print(a[i]);
			}System.out.println();
			for(int i = 0 ; i < n ; i++) {
				System.out.print(b[i]);
			}System.out.println();
		}
	}

}

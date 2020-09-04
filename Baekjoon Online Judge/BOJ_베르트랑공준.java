package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj����Ʈ������ {
	
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		boolean com = false;
		while(n != 0) {
		int cnt = 0;
		if(n == 1) System.out.println(1);
			else{
				for(int index = n +1 ; index <= 2*n ; index++) {
					com = true;
					for(int i = 2 ; i <=(int)Math.sqrt(index) ; i ++) {
						if(index%i==0) {
							com = false;
							break;	
						}
					}
					if(com) cnt++;
				}
				System.out.println(cnt);
			}
		 st = new StringTokenizer(br.readLine());
		 n= Integer.parseInt(st.nextToken());
		}
	}

}

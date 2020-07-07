package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 유레카이론 {

	public static void main(String[] args) throws Exception {
	
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 1 ; ;i++) {
			int res = ((i*( i+1))>>1);
			if(res <=1000) {
				al.add(res);
			} else {
				break;
			}
		}
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			boolean isCan = false;
			int tar = Integer.parseInt(br.readLine());
			top :
			for(int a = 0 ; a < al.size() ; a++) {
				for(int b = a  ; b < al.size() ; b++) {
					for(int c = b ; c < al.size() ; c++) {
						int sum = al.get(a) + al.get(b) + al.get(c);
						if(sum == tar) {
							sb.append("1\n");
							isCan = true;
							break top;
						}
					}
				}
			}
			if(!isCan) {
				sb.append("0\n");
			}
		}System.out.println(sb);
		
		
	}
}

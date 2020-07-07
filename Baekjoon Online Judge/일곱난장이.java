package 풀문제2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난장이 {

	static int num[] = new int[9]; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ;  i <  9 ; i ++) {num[i] = Integer.parseInt(br.readLine().trim());}
		sol();
	}
	
	private static void sol() {
		for(int a = 0 ; a < 9 ; a++) {
			for(int b = a +1 ; b < 9 ; b++) {
				for(int c = b +1 ; c < 9 ; c++) {
					for(int d = c+ 1 ; d <9 ; d++) {
						for(int e = d+1  ; e < 9 ; e++) {
							for(int f = e + 1 ; f < 9 ; f++) {
								for(int g = f+ 1 ; g < 9 ; g++) {
									if(num[a]+num[b]+num[c]+num[d]+num[e]+num[f]+num[g] == 100) {
										int answer[] = new int[7];
										answer[0] = num[a];
										answer[1] = num[b];
										answer[2] = num[c];
										answer[3] = num[d];
										answer[4] = num[e];
										answer[5] = num[f];
										answer[6] = num[g];
										Arrays.sort(answer);
										for(int i = 0 ; i  < 7 ; i++) {
											System.out.println(answer[i]);
										}
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		
	}

}

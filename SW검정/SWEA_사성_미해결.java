package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_사성_미해결 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= tc ; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int score[] = new int[t]; int person_info[][] = new int[n][3]; int res=0; int ans = 0;
			int [][]map = new int[n][t];
			
			 for(int y = 0 ; y < n ; y ++) {
					st = new StringTokenizer(br.readLine());
					for(int x = 0 ; x <t ; x++) {
						map[y][x] = Integer.parseInt(st.nextToken());
					}
				}	
			
			for(int index = 0 ; index < t; index++){
				int cnt = 0;
				for(int j = 0 ; j < n ; j++) {
					cnt += map[j][index] == 0 ? 1 : 0;
				}
				score[index] = cnt;
			}
			
			// 첫번째 정보는 점수 , 두번째는 문제수, 세번째는 번호가 더 작은 참가자 수
			for(int index = 0 ; index < t ; index++) {
				res += score[index]*map[c-1][index];
			}
			
			for(int index = 0 ; index < n ; index++) {
				for(int pro =0; pro < t ; pro++) {
					person_info[index][0] += ( score[pro] * map[index][pro] );
				}
			
				for(int sol = 0 ; sol < t ; sol++) {
					if(map[index][sol] == 1) person_info[index][1]+=1;
				}
				person_info[index][2] = (index+1);
			}
			
			
			for(int index = 0; index < n ; index++) {
				if(index == c-1) continue;
				
				if(person_info[c-1][0] > person_info[index][0]) {
					ans+=1;
				}
				else if(person_info[c-1][0] == person_info[index][0]) {
					if(person_info[c-1][1] < person_info[index][0]) {
						ans+=1;
					}
					else if(person_info[c-1][1] == person_info[index][1]) {
						if(person_info[c-1][2] < person_info[index][2]) ans+=1;
					}
				}
			}
			
			System.out.println("#" +test_case +" "+res + " " +(ans+1));
		}
	}

}

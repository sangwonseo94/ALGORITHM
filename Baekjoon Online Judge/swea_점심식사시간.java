package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_점심식사시간 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tt=1;tt <=T ;tt++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int map[][] = new int[t][t];
			int hole[][]= new int[2][2];
			int user =0;
			boolean first = true;
			for(int i=0;i<t;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<t;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] ==1) {
						user++;
					} else if(map[i][j]>1) {
						if(first) {
							hole[0][0] = i;
							hole[0][1] = j;
							first=false;
						} else {
							hole[1][0] = i;
							hole[1][1] = j;
						}
					} 
				}
			}
			int answer = 987654321;
			int userXY[][] = new int[user][2];
			int index =0;
			tt:
			for(int i=0;i<t;i++) {
				for(int j=0;j<t;j++) {
					if(map[i][j] ==1) {
						userXY[index][0] = i;
						userXY[index][1] = j;
						index++;
						if(index==user) break tt;
					} 
				}
			}
			ArrayList<Integer> Down1 = new ArrayList<>();
			ArrayList<Integer> Down2 = new ArrayList<>();
			for(int s = (1<<user), e = (1<<(user+1)) ; s<e ; s++) {
				// 각 거리 계산 + 1 하고 줌
				Down1.clear();
				Down2.clear();
				for(int i=0; i <user ; i++) {
					if( (s & (1<<i)) !=0) {
						Down1.add(1+dist(userXY[i][0],hole[0][0],userXY[i][1],hole[0][1]));
					} else {
						Down2.add(1+dist(userXY[i][0],hole[1][0],userXY[i][1],hole[1][1]));
					}
				}
				// 3명 갈수있으니 계산후 가장 큰값의 큰값중 작은값이 답
				Collections.sort(Down1);
				Collections.sort(Down2);
				
				int dsize1 = Down1.size();
				int dsize2 = Down2.size();
				int max1 = -1, max2= -1;
				int cost1 = map[hole[0][0]][hole[0][1]];
				int cost2 = map[hole[1][0]][hole[1][1]];
				for(int ii =0; ii < dsize1 ; ii++) {
					if(ii+3 < dsize1) {
						if(Down1.get(ii)+cost1 > Down1.get(ii+3)) {
							Down1.add(ii+3, Down1.get(ii)+cost1);
							Down1.remove(ii+4);
						}
					}
					int now =  Down1.get(ii) + cost1;
					if(now > max1) {
						max1= now;
					}
				}
				
				for(int ii =0; ii < dsize2 ; ii++) {
					if(ii+3 < dsize2) {
						if(Down2.get(ii)+cost2 > Down2.get(ii+3)) {
							Down2.add(ii+3, Down2.get(ii)+cost2);
							Down2.remove(ii+4);
						}
					}
					int now =  Down2.get(ii) + cost2;
					if(now > max2) {
						max2= now;
					}
				}
				
				max1 = max1> max2 ? max1: max2;
				answer = answer > max1 ? max1 : answer;
			}sb.append("#" +tt +" "+ answer+"\n");
		}
		System.out.println(sb);
	}
	public static int dist(int y1,int y2,int x1,int x2) {
		return Math.abs(y2-y1) + Math.abs(x2-x1);
	}
}

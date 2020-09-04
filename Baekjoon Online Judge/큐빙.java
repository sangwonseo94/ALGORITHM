package 푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐빙 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		char temp[] = new char[3];
		char temp2[][] = new char[3][3];
		char cube[][][] = new char[6][3][3];
		char fill[] = {'w','y','r','o','g','b'};
		int rolling_time;
		int c=0;
		for(int tc = 0 ; tc < T ; tc++) {
			st = new StringTokenizer(br.readLine());
			rolling_time = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String methods[] = new String[rolling_time];
			for(int index = 0 ; index < rolling_time ; index++) {methods[index] = st.nextToken();}
			// 0은 위 : 흰색 , 1은 아래 노랑색, 2는 앞 빨강색, 3은 뒷 오렌지색, 4는 왼쪽초록색 ,5는 오른쪽 파란색
			for(int color = 0 ; color < 6 ; color++) {
				for(int y = 0 ; y < 3 ; y ++) {
					for(int x=  0 ; x< 3 ; x++) {
						cube[color][y][x] = fill[color];
						// 큐브 초기화
					}
				}
			}
			for(int index = 0 ; index < rolling_time ; index++) {
				if(methods[index].equals("U+")) {
					c=0;
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[2][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[2][0][i] = cube[5][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[5][0][i] = cube[3][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[3][0][i] = cube[4][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[4][0][i] = temp[i];
					
					temp2[1][1] = cube[c][1][1];
					
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("U-")){
					c = 0;
					for(int i = 0 ; i < 3 ; i++) temp[2-i] = cube[2][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[2][0][2-i] = cube[4][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[4][0][2-i] = cube[3][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[3][0][2-i] = cube[5][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[5][0][2-i] = temp[2-i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("D+")){
					
					c = 1;
					for(int i = 0 ; i < 3 ; i++) temp[2-i] = cube[2][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[2][2][2-i] = cube[4][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[4][2][2-i] = cube[3][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[3][2][2-i] = cube[5][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[5][2][2-i] = temp[2-i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
					
				}else if(methods[index].equals("D-")){
					c=1;
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[2][2][i];
					for(int i = 0 ; i < 3 ; i++) cube[2][2][i] = cube[5][2][i];
					for(int i = 0 ; i < 3 ; i++) cube[5][2][i] = cube[3][2][i];
					for(int i = 0 ; i < 3 ; i++) cube[3][2][i] = cube[4][2][i];
					for(int i = 0 ; i < 3 ; i++) cube[4][2][i] = temp[i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("F+")){
					c=2;
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					temp2[1][1] = cube[c][1][1];
					
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[0][2][2-i] = cube[4][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[4][i][2] = cube[1][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[1][0][i] = cube[5][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[5][2-i][0] = temp[i];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("F-")){
					c=2;
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][2][i];
					
					for(int i = 0 ; i < 3 ; i++) cube[0][2][i] = cube[5][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[5][i][0] = cube[1][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[1][0][2-i] = cube[4][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[4][2-i][2] = temp[i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("B+")){
					c=3;
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					temp2[1][1] = cube[c][1][1];
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][0][i];
					for(int i = 0 ; i < 3 ; i++) cube[0][0][i] = cube[5][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[5][i][2] = cube[1][2][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[1][2][2-i] = cube[4][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[4][2-i][0] = temp[i];
					
					
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("B-")){
					c=3;
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][0][2-i];
					for(int i = 0 ; i < 3 ; i++) cube[0][0][2-i] = cube[4][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[4][i][0] = cube[1][2][i];
					for(int i = 0 ; i < 3 ; i++) cube[1][2][i] = cube[5][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[5][2-i][2] = temp[i];
					 
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				}else if(methods[index].equals("L+")){
					
					c=4;
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					temp2[1][1] = cube[c][1][1];
					
					for(int i = 0 ; i < 3 ; i++) temp[2-i] = cube[0][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[0][2-i][0] = cube[3][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[3][i][2] = cube[1][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[1][2-i][0] = cube[2][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[2][2-i][0] = temp[2-i];
					
					
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				}else if(methods[index].equals("L-")){
					c=4;
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[0][i][0] = cube[2][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[2][i][0] = cube[1][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[1][i][0] = cube[3][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[3][2-i][2] = temp[i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				
				}else if(methods[index].equals("R+")){
					c=5;
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][2] = cube[c][0][i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][2-i] = cube[c][i][2];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][0] = cube[c][2][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][i] = cube[c][2-i][0];
					temp2[1][1] = cube[c][1][1];
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[0][i][2] = cube[2][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[2][i][2] = cube[1][i][2];
					for(int i = 0 ; i < 3 ; i++) cube[1][i][2] = cube[3][2-i][0];
					for(int i = 0 ; i < 3 ; i++) cube[3][2-i][0] = temp[i];
					
					
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
					
				}else if(methods[index].equals("R-")){
					c=5;
					
					for(int i = 0 ; i < 3 ; i++) temp[i] = cube[0][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[0][2-i][2] = cube[3][i][0];
					for(int i = 0 ; i < 3 ; i++) cube[3][i][0] = cube[1][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[1][2-i][2] = cube[2][2-i][2];
					for(int i = 0 ; i < 3 ; i++) cube[2][2-i][2] = temp[i];
					
					for(int i = 0 ; i < 3 ; i++) temp2[i][0] = cube[c][0][2-i];
					for(int i = 0 ; i < 3 ; i++) temp2[2][i] = cube[c][i][0];
					for(int i = 0 ; i < 3 ; i++) temp2[2-i][2] = cube[c][2][i];
					for(int i = 0 ; i < 3 ; i++) temp2[0][2-i] = cube[c][2-i][2];
					temp2[1][1] = cube[c][1][1];
					for(int y=  0 ; y < 3 ; y ++) {for(int x = 0 ; x< 3 ; x++) {cube[c][y][x] = temp2[y][x];}}
				}
			}
			for(int y = 0 ;  y< 3 ; y++) {
				for(int x = 0 ; x < 3 ; x++) {
					sb.append(cube[0][y][x]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}

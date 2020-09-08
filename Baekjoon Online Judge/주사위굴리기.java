package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		for(int i=0;i<n;i++) {st=new StringTokenizer(br.readLine());for(int j=0;j<m;j++) {map[i][j] =Integer.parseInt(st.nextToken());	}}
		int move[] = new int[k]; st = new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++)move[i]=Integer.parseInt(st.nextToken()); //end of input
		int dir[][]= {{0,1},{0,-1},{-1,0},{1,0}};
		int dice[]=new int[7];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<k;i++) {
			int d=move[i];
			int nx =x+dir[d-1][1]; int ny=y+dir[d-1][0];
			if(ny>=0&&nx>=0&&nx<m&&ny<n) {
			x=nx;y=ny;
			if(d==1) {dice[0]=dice[6];dice[6]=dice[3];dice[3]=dice[5];dice[5]=dice[1];dice[1]=dice[0];}
			else if(d==2) {dice[0]=dice[3];dice[3]=dice[6];dice[6]=dice[1];dice[1]=dice[5];dice[5]=dice[0];}
			else if(d==3) {dice[0]=dice[2];dice[2]=dice[1];dice[1]=dice[4];dice[4]=dice[3];dice[3]=dice[0];}
			else if(d==4) {dice[0]=dice[2];dice[2]=dice[3];dice[3]=dice[4];dice[4]=dice[1];dice[1]=dice[0];}
			if(map[ny][nx]==0) {
				map[ny][nx]=dice[1];sb.append(dice[3]+"\n");
			} else {
				dice[1]=map[ny][nx];map[ny][nx]=0;sb.append(dice[3]+"\n");
			}}
		}System.out.println(sb);
	}
}

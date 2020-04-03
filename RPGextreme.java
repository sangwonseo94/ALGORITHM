package 풀문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RPGextreme {
	
	static int n,m,step,startx,starty,nextx,nexty;
	static char 						 action[];
	static char 			 			  map[][];
	static int   			  monster_field[][][];
	static String	       monster_name_field[][];
	static String			accessory_field[][][];
   
	public static void main(String[] args) throws Exception {
		
		input();
		System.out.println(12);
		for(step = 0 ; step < action.length ; step++) {
			
			
			
		}
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n+1][m+1];
		for(int i = 1 ; i <= n ; i ++) {
			char []temp = br.readLine().toCharArray();
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = temp[j-1];
				if(map[i][j] =='@') {
					starty = i ;
					startx = j ;
				}
			}
		}
		monster_field = new int[n+1][m+1][4];
		monster_name_field = new String[n+1][m+1];
		accessory_field = new String[n+1][m+1][2];
		action = br.readLine().toCharArray();
		
		boolean isContinue = true;
		while(isContinue) {
		 {
				String temp[] = br.readLine().split(" ");
				
				int y = Integer.parseInt(temp[0]);
				int x = Integer.parseInt(temp[1]); 
				if(temp.length==7) {
					monster_name_field[y][x]= temp[2];
					monster_field[y][x][0] = Integer.parseInt(temp[3]);
					monster_field[y][x][1] = Integer.parseInt(temp[4]);
					monster_field[y][x][2] = Integer.parseInt(temp[5]);
					monster_field[y][x][3] = Integer.parseInt(temp[6]);
				}else {
					accessory_field[y][x][0] = temp[2];
					accessory_field[y][x][1] = temp[3];
				}
				
			} 
		}
		
	}
}

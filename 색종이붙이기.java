package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이붙이기 {
	static int map[][] = new int[11][11];
	static int color_square[] = {5, 5, 5, 5, 5, 5};
	static int ans = Integer.MAX_VALUE;
	static boolean visit[][] = new boolean[11][11];
	
	public static void input()throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int y = 0;y < 10 ;y ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x <10 ; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		input();
		square(0,0);
		if(ans != Integer.MAX_VALUE)System.out.println(ans);
		else System.out.println(-1);
	}

	public static void square(int pos, int cnt) {
		int y = pos/10;
		int x = pos%10;
		if(ans <= cnt) return;
		if(pos ==100) {
			if(check()){
				int res = 0;
				for (int i : color_square)res += (5-i);
				ans = Math.min(ans, res);
				return;
			}
		}
		
		if(map[y][x] == 1) {
			for(int color = 5; color > 0 ; color-=1 ) {
				if(color_simul(y,x,color) && color_square[color] > 0) { // 채울수 있으면?
					color_fill(y,x,color,0); // 1로 채우고
					color_square[color]--;   // color번째 요소를 감소 시킨다.
					square(pos+1,cnt+1);
					color_fill(y,x,color,1); // 갔다왔으니 0으로 채우고 
					color_square[color]++;   // 다시 증가시킨다.
				}
			}	
		}
		
		else square(pos+1,cnt);
		
	}
	public static boolean check() {
		for(int y = 0; y <10  ; y++) {
			for(int x = 0; x <10; x++) {
				if(map[y][x] == 1) return false;
			}
		}
		return true;
	}

	public static void color_fill(int y, int x, int color, int i) {
		for(int y_ = y; y_ < y+color ; y_++) {
			for(int x_ = x; x_ <x+color; x_++) {
				if(y_ < 10 && x_<10) map[y_][x_] = i;
			}
		}
	}

	public static boolean color_simul(int y, int x, int color) {
		if(y + color > 10 || x + color > 10) return false;
		for(int y_ =y ; y_ < y+color ; y_++) {
			for(int x_=x ; x_ < x+color ; x_++) {
				if(y_ < 10 && x_< 10 && map[y_][x_] ==0) return false;
			}
		}
		return true;
	}

}

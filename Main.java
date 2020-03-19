package 푼문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class coordi {
	int x;
	int y;
	public coordi(int x, int y){
		this.x = x;
		this.y = y;
		
	}
}
public class Main {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static char map[][];
	static boolean visit[][];
	static int size;
	
	public static int BFS() {
		Queue<coordi> Q = new LinkedList<coordi>();
		int cnt =0;
		for(int y = 0 ; y < size ; y ++) {
			for(int x = 0; x < size ; x++) {
				if(!visit[y][x]) {
					cnt +=1;
					Q.add( new coordi(x,y));
					visit[y][x]= true;
					while(!Q.isEmpty()) {
						
						coordi now = Q.poll();
						for(int index =0 ; index < 4 ; index ++) {
							
							int nx = now.x + dx[index];
							int ny = now.y + dy[index];
							
							if(nx >=0 && ny >= 0 && nx <size && ny <size) {
								if(!visit[ny][nx] && map[ny][nx] == map[now.y][now.x]) {
									visit[ny][nx] = true;
									Q.add(new coordi(nx,ny));
								}
							}
							
						}
					}
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		map = new char[size][size];
		visit= new boolean[size][size];
		for(int i=0; i<size; i++) {
            char[] str = sc.next().toCharArray();
            for(int j=0; j<str.length; j++) {
                map[i][j] = str[j];
            }
        }
		System.out.print(BFS());
		
		for(int y = 0 ; y < size ; y ++) {
			for(int x =0; x < size ; x ++) {
				if(map[y][x]== 'R') {
					map[y][x] = 'G';
				}
				visit[y][x] = false;
			}
		}
		
		System.out.println(" " + BFS());
		
	}
	
}


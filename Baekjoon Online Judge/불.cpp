#include <iostream>
#include <queue>
#define end '\n'
using namespace std;
int N, w, h;
int dx[] = { 0,0,+1,-1 };
int dy[] = { 1,-1,0,0 };

char map[1002][1002] = { {'0',}, };
bool visit[1002][1002] = { {false,}, };

typedef struct {
	int y, x;
	char pos;
	int time;
}coordi;


int BFS(void) {

	for (int index = 0; index < h; index++) {
		for (int index_ = 0; index_ < w; index_++) {
			map[index][index_] = '0';
			visit[index][index_] = false;
		}
	}
	cin >> w >> h;
	for (int y = 0; y < h; y++) {
		cin >> map[y];
	}
	queue < coordi > Q;
	coordi start;
	for (int y = 0; y < h; y++) {
		for (int x = 0; x < w; x++) {
			
			if (map[y][x] == '@') {
				start.y = y;
				start.x = x;
				start.pos = '@';
				start.time = 0;
				if (y == h - 1 || y == 0 || x == w - 1 || x == 0) {
					return 0;
				}
			}
			else if (map[y][x] == '*') {
				Q.push({ y ,x,'*',0 });
				visit[y][x] = true;
			}
			
		}
	}
	Q.push(start);
	while (!Q.empty()) {

		char now_pos = Q.front().pos;
		int now_x = Q.front().x;
		int now_y = Q.front().y;
		int time = Q.front().time;

		
		Q.pop();

		if (now_pos == '*') {

			for (int index = 0; index < 4; index++) {
				int nx = now_x + dx[index];
				int ny = now_y + dy[index];
				if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
					if (!visit[ny][nx]) {
						if (map[ny][nx] != '#' && map[ny][nx] != '*') {
							visit[ny][nx] = true;
							map[ny][nx] = '*';
							Q.push({ ny, nx, '*' , 0 });
						}
					}
				}
			}
		}
		else if (now_pos == '@') {

			for (int index = 0; index < 4; index++) {
				int nx = now_x + dx[index];
				int ny = now_y + dy[index];
				if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
					if (!visit[ny][nx]) {
						if (map[ny][nx] == '.') {
							if (nx == 0 || nx == w - 1 || ny == 0 || ny == h - 1) return time + 1;
							visit[ny][nx] = true;
							map[ny][nx] = '@';
							Q.push({ ny, nx, '@',time + 1 });
						}
					}
				}
			}
		}
	}
	return -1;
}


int main(void) {
	cin >> N;
	int a[102];
	for (int index = 0; index < N; index++) {
		a[index] = BFS();
	}
	for (int index = 0; index < N; index++) {
		if (a[index]== -1) cout << "IMPOSSIBLE" << "\n";
		else cout << a[index]+1 << "\n";
	}


	return 0;
}
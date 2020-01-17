#include <iostream>
#include <queue>

using namespace std;
char map[51][51];
bool visit[51][51];
int a, b;
void input() {
	cin >> a >> b;
	for (int y = 0; y < a; y++) {
		cin >> map[y];
	}
}
int dx[] = { 0,0,+1,-1 };
int dy[] = { +1,-1,0,0 };

typedef struct {
	int x, y, time;
}coordi;
int ans = -1;

int main(void) {
	cin.tie(0); ios_base::sync_with_stdio(NULL);
	input();
	
	for (int y = 0; y < a; y++) {
		for (int x = 0; x < b; x++) {
			int res = 0;
			if (map[y][x] == 'W') continue;

			else if(map[y][x]== 'L'){
				
				queue < coordi > Q;
				coordi start = { x ,y,0 };
				Q.push(start);
				while (!Q.empty()) {

					int x = Q.front().x;
					int y = Q.front().y;
					int time = Q.front().time;
					Q.pop();
					res > time ? res = res : res = time;
					for (int index = 0; index < 4; index++) {
						int nx = x + dx[index];
						int ny = y + dy[index];
						if (nx >= 0 && ny >= 0 && nx < b && ny < a) {
							if (!visit[ny][nx] && map[ny][nx] =='L') {
								visit[ny][nx] = true;
								Q.push({ nx,ny,time + 1 });
							}
						}
					}

				}


			}
			ans < res ? ans = res : ans = ans;
			for (int y = 0; y < a; y++) {
				for (int x = 0; x < b; x++) {
					visit[y][x] = false;
				}
			}

		}
	}

	cout << ans;
	return 0;
}
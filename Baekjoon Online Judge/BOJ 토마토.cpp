#include <iostream>
#include <queue>

using namespace std;
int N, M;
int map[1001][1001];
bool visit[1001][1001];
typedef struct {
	int x, y, time;
}coordi;
queue < coordi> Q;
void input() {
	cin >> N >> M;
	for (int y = 0; y < M; y++) {
		for (int x = 0; x < N; x++) {
			cin >> map[y][x];
			if (map[y][x] == 1) {
				Q.push({ x,y,0 });
				visit[y][x] = true;
			}
		}
	}

}

int dx[] = { 0,0, -1, +1 };
int dy[] = { 1, -1,0,0 };
int res;

bool check() {
	for (int y = 0; y < M; y++) {
		for (int x = 0; x < N; x++) {
			if (!map[y][x]) return false;
		}
	}
	return true;
}
int main(void) {
	input();

	while (!Q.empty()) {

		int x = Q.front().x;
		int y = Q.front().y;
		int time = Q.front().time;
		Q.pop();
		res > time ? res = res : res = time;
		for (int index = 0; index < 4; index++) {

			int nx = x + dx[index];
			int ny = y + dy[index];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (!visit[ny][nx] && map[ny][nx] != -1) {
					visit[ny][nx] = true;
					map[ny][nx] = 2;
					Q.push({ nx,ny,time + 1 });
				}
			}
		}


	}
	if (check()) {
		cout << res;
	}
	else {
		cout << -1;
	}
	return 0;
}
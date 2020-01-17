#include <iostream>
#include <queue>

using namespace std;
int L , TC;
int start_x, start_y, end_x, end_y;
int map[301][301];
int ans[301];
bool visit[301][301];
void input() {
	cin >> TC;
}




typedef struct {
	int x, y, step;
}coordi;

int dx[] = {2,1,-1,-2,-2,-1,1,2};
int dy[] = {1,2,2,1,-1,-2,-2,-1};

int main(void){
	input();
	for (int i = 0 ; i < TC; i ++) {
		cin >> L;
		for (int y = 0; y < L; y++) {
			for (int x = 0; x < L; x++) {
				map[y][x] = 0;
				visit[y][x] = false;
			}
		}
		int res = 0;
		cin >> start_x >> start_y;
		cin >> end_x >> end_y;
		coordi start = { start_x, start_y, 0 };

		queue <coordi> Q;
		Q.push(start);
		while (!Q.empty()){

			int x = Q.front().x;
			int y = Q.front().y;
			int step = Q.front().step;
			if (x == end_x && y == end_y) {
				res = step;
				break;
			}
			Q.pop();

			for (int index = 0; index < 8; index++) {
				int nx = x + dx[index];
				int ny = y + dy[index];

				if (nx >= 0 && ny >= 0 && nx < L && ny < L) {
					if (!visit[ny][nx]) {
						visit[ny][nx] = true;
						Q.push({ nx,ny,step + 1 });
					}
				}
			}
		}
		
		ans[i] = res;
	}
	for (int index = 0; index < TC; index++) {
		cout << ans[index] << "\n";
	}

	return 0;
}
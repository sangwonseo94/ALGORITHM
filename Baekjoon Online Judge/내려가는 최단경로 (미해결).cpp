#include <iostream>

using namespace std;

int map[501][501] = { 0, };
bool visit[501][501] = { false, };
int path; 	int m, n;
int dx[] = { 1 , 0 , -1 , 0 };
int dy[] = { 0 , 1 , 0 , -1 };
void dfs(int x, int y) {
	/// 갔던길이 보이면 바로 path ++

	for (int i = 0; i < 4; i++) {
		if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < m && visit[x +dx[i]][y + dy[i]] && (map[x][y] > map[x + dx[i]][y + dy[i]])) {
			visit[x][y] = true;
			path += 1;
			return;
		}
	}
	/// 한번갔던길 체크 완료 / 새로 길찾는것
	for (int i = 0; i < 4; i++) {
	
		if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < m &&  (map[x][y] > map[x +dx[i]][y + dy[i]])) {
			if (x + 1 == n - 1 && y + 1 == m - 1) {
				visit[x + 1][y + 1] = true;
				path += 1;
				return;
			}
			visit[x + dx[i] ][y + dy[i]] = true;
			dfs(x + dx[i], y + dy[i]);
		}

	}
}

int main(void) {

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}
	dfs(0, 0);

	int a; cin >> a; 
	cout << path;
}
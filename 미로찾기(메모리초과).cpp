#include <iostream>
#include <queue>
#include <vector>
#include <string>
using namespace std;
int dx[] = { 0 , 0 , -1 , 1 };
int dy[] = { 1 , -1, 0 , 0 };
int map[101][101] = { 0 , };
bool visit[101][101] = { false, };
int n, m , res;
typedef struct {
	int x;
	int y;
	int path;
}coordi;
int main(void) {

	cin.tie(0); ios_base::sync_with_stdio(NULL);
	cin >> n >> m; 
	string g; getline(cin, g);
	vector < string > temp;
	for (int i = 0; i < n; i++) {
		string a;
		getline(cin, a);
		temp.push_back(a);
	}
	for (int index = 0; index < n; index++) {
		for (int len = 0; len < temp[index].length(); len++) {
			map[index][len] = temp[index][len] - '0';
			if (!map[index][len]) visit[index][len] = true;
		}
	}
	coordi first = { 0,0,0 };
	queue < coordi > q;
	q.push(first);
	while (!q.empty()){

		coordi now = q.front(); q.pop();
		int x = now.x;
		int y = now.y;
		int path = now.path;
		if (x == (m - 1) && y == (n - 1)) {
			res = now.path;
			break;
		}
		visit[y][x] = true;

		for (int index = 0; index < 4; index++) {

			int ny = y + dy[index];
			int nx = x + dx[index];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
				if (!visit[ny][nx]) {
					coordi next = { nx, ny ,path+1};
					q.push(next);
				}
			}
		}
		
	}

	cout << res + 1;
	return 0;
}
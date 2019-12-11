#include <iostream>
#include <vector>

using namespace std;
int res[101][101] = { {0,}, };
vector<bool> v(101, false);
vector<vector<int>> map(101);
void dfs(int node,int start) {
	if (v[node]){
		if (node == start) {
			res[start][node] = 1;
		}
		return; 
	}
	else {
		v[node] = true;
		
		for (int i = 0; i < map[node].size(); i++) {
		
			dfs(map[node][i], start);
			res[start][map[node][i]] =1;
		}
	}
}
int main(void) {

	int N; cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int x; cin >> x;
			if (x == 1) {
				map[i].push_back(j);
			}
		}
	}

	for (int i = 0; i < N; i++) {
		dfs(i,i );
		v.clear();
		v.assign(101, false);
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << res[i][j] << " ";
		}
		cout << endl;
	}
}
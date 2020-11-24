#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector< vector < int >> node;
vector < bool > visit;

void dfs(int start) {
	visit[start] = true;
	cout << start << " ";
	for (int arr = 0; arr < node[start].size(); arr++) {
		int value = node[start][arr];
		if (!visit[value]) {
			visit[value] = true;
			dfs(value);
		}

	}


}
void bfs(int start) {
	queue < int > q;
	q.push(start);
	visit[start] = false;
	while (!q.empty()) {
		int a = q.front(); q.pop();
		cout << a << " ";
		for (int arr = 0; arr < node[a].size(); arr++) {
			int value = node[a][arr];
			if (visit[value]) {
				q.push(value);
				visit[value] = false;
			}
		}

	}

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, m, v;
	cin >> n >> m >> v;
	node = vector< vector < int >>(1001);
	visit = vector < bool >(1001, false);
	for (int i = 0; i < m; i++) {
		int a, b; cin >> a >> b;
		node[a].push_back(b);
		node[b].push_back(a);
	}

	for (int a = 0; a < node.size(); a++) {
		sort(node[a].begin(), node[a].end());
	}
	dfs(v);
	cout << endl;
	bfs(v);
	return 0;
}
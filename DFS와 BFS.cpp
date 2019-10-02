#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, V;
vector <vector <int>> number_for_dfs;
vector <vector <int>> number_for_bfs;
vector < bool > visit_dfs;
vector < bool > visit_bfs;
void dfs() {


}

void bfs(int V) {
	queue < int > q;
	q.push(number_for_bfs[V][0]);
	visit_bfs[V] = true;
	while (!q.empty()) {
		int x = q.front();
		cout << x << ' ';
		q.pop();
		for (int i = 0; i < number_for_bfs[x].size(); i++) {
			int temp = number_for_bfs[x][i];
			if (!visit_bfs[temp]) {
				q.push(number_for_bfs[x][i]);
				visit_bfs[temp] = true;
			}
		}
	}

}

void dfs(int V) {
	if (visit_dfs[V]) return;
	visit_dfs[V] = true;
	cout << V << ' ';
	for (int arr = 0; arr < number_for_dfs[V].size(); arr++) {
		int temp = number_for_dfs[V][arr];
		dfs(temp);
	}


}


int main(void) {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(NULL);
	cin >> N >> M >> V;
	for (int arr = 0; arr <= N; arr++) {
		vector < int > temp;
		temp.push_back(arr);
		number_for_bfs.push_back(temp);
		number_for_dfs.push_back(temp);
	}
	for (int index = 0; index < M; index++) {
		int x, y; cin >> x >> y;
		number_for_dfs[x].push_back(y);
		number_for_dfs[y].push_back(x);
		number_for_bfs[x].push_back(y);
		number_for_bfs[y].push_back(x);
	}
	for (int i = 0; i < number_for_dfs.size(); i++) {
		sort(number_for_dfs[i].begin() + 1, number_for_dfs[i].end());
	}
	for (int i = 0; i < number_for_bfs.size(); i++) {
		sort(number_for_bfs[i].begin() + 1, number_for_bfs[i].end());
	}
	visit_bfs = vector <bool>(N + 1, false);
	visit_dfs = vector <bool>(N + 1, false);


	dfs(number_for_dfs[V][0]);
	cout << '\n';
	bfs(V);
}
#include <algorithm>
#include <vector>
#include <deque>
#include <iostream>
#include <tuple>
using namespace std;


int main(void) {

	vector < tuple <int, int, int>> path;
	cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(NULL);
	int V, M; cin >> V >> M;
	int start; cin >> start;
	for (int arr = 0; arr < M; arr++) {
		int a, b, c;
		cin >> a >> b >> c;
		path.push_back({ a,b,c });
	}

	vector < int > result(V + 1, 999999);
	result[start] = 0;

	for (int index = 1; index < V; index++) {
		for (auto a : path) {
			int u, v, w;
			tie(u, v, w) = a;
			result[v] = min(result[v], result[u] + w);
		}
	}

	for (int arr = 1; arr <= V; arr++) {
		if (result[arr] == 999999) cout << "INF" << '\n';
		else cout << result[arr] << '\n';
	}
}
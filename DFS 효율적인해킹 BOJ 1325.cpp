#include <iostream>
#include <vector>
#include <string>
#include <stack>
#include <deque>
#include <set>
#include <queue>
#include <algorithm>
#include <limits>
#include <tuple>


using namespace std;
const int infinity = numeric_limits<int>::max();

vector < vector < int >> node;
vector < bool > visit;
int g_depth = 0;
void dfs(int now, int depth) {
	if (visit[now]) return;
	
	depth += 1;
	for (auto arr : node[now]) {
		
		dfs(arr, depth);
		visit[now] = true;
		g_depth = max(g_depth, depth);
	}
}
int main(void) {
	cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(NULL);
	int N, M; cin >> N >> M;
	node = vector < vector < int >>(N + 1);
	visit = vector < bool >(N + 1, false);
	vector < int > depth(N + 1);
	for (int arr = 0; arr < M; arr++) {
		int a, b; cin >> a >> b;
		node[b].push_back(a);
	}
	for (int arr = 1; arr < N + 1; arr++) {
		dfs(arr, 0);
		depth[arr] = g_depth;
		g_depth = -1;
	}
	auto maxi = *max_element(depth.begin(), depth.end());
	for (int index = 1; index < N + 1; index++) {
		if (depth[index] == maxi) cout << index << " ";
	}

}

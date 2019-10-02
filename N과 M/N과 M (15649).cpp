#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector <int> numbers;
vector <vector<int>> results;
vector <int> compute;
vector <bool> visit;
void dfs() {
	if (compute.size() == M) {
		vector <int> temp;
		for (int arr = 0; arr < M; arr++)temp.push_back(compute[arr]);
		results.push_back(temp);
		return;
	}
	for (int arr = 0; arr < N; arr++) {
		if (!visit[arr]) {
			visit[arr] = true;
			compute.push_back(numbers[arr]);
			dfs();
			visit[arr] = false;
			compute.pop_back();
		}
	}
}
int main(void) {
	ios::sync_with_stdio(NULL);
	cin.tie(0); cout.tie(0);

	cin >> N >> M;
	for (int arr = 1; arr <= N; arr++) numbers.push_back(arr);
	visit = vector<bool>(N, false);
	dfs();
	for (int i = 0; i < results.size(); i++) {
		for (int j = 0; j < M; j++) {
			cout << results[i][j] << " ";
		}
		cout << "\n";
	}

}
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, M;
vector <int> numbers;
vector <int> dfs_factor;
vector <vector <int>> result;
vector <bool> visit;
void dfs() {
	if (dfs_factor.size() == M) {
		result.push_back(dfs_factor);
		return;
	}
	for (int arr = 0; arr < N; arr++) {
		if (!visit[arr]) {
			visit[arr] = true;
			dfs_factor.push_back(numbers[arr]);
			dfs();
			dfs_factor.pop_back();
			visit[arr] = false;
		}
	}
}


int main(void) {
	cin.tie(0); cout.tie(0);
	ios::sync_with_stdio(NULL);
	cin >> N >> M;
	int Loop_number = N;
	while (Loop_number) {
		int temp; cin >> temp;
		numbers.push_back(temp);
		Loop_number--;
	}
	visit = vector <bool>(N, false);
	sort(numbers.begin(), numbers.end());
	dfs();
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[i].size(); j++) {
			cout << result[i][j] << " ";
		}
		cout << "\n";
	}


}
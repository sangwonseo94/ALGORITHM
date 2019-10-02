#include <iostream>
#include <vector>

using namespace std;
int N, M;
vector <int> numbers;
vector <int> dfs_factor;
vector <vector <int>> result;
void dfs() {
	if (dfs_factor.size() == M) {
		result.push_back(dfs_factor);
		return;
	}
	for (int arr = 0; arr < N; arr++) {
		if (!dfs_factor.empty())if (dfs_factor.back() > numbers[arr]) continue;
		dfs_factor.push_back(numbers[arr]);

		dfs();
		dfs_factor.pop_back();

	}
}


int main(void) {
	cin.tie(0); cout.tie(0);
	ios::sync_with_stdio(NULL);
	cin >> N >> M;
	for (int num = 1; num <= N; num++)numbers.push_back(num);
	dfs();
	for (int i = 0; i < result.size(); i++) {
		for (int j = 0; j < result[i].size(); j++) {
			cout << result[i][j] << " ";
		}
		cout << "\n";
	}


}
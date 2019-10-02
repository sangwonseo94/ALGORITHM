#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <string>
using namespace std;
int N, M;

vector <int> numbers, dfs_factor;
vector <bool> visit;
set <vector < int>> result;
void dfs() {
	if (dfs_factor.size() == M) {
		result.insert(dfs_factor);
		return;
	}

	for (int arr = 0; arr < N; arr++) {

		if (!dfs_factor.empty()) if (dfs_factor.back() > numbers[arr]) continue;
		///if (!visit[arr]) {

			///visit[arr] = true;
		dfs_factor.push_back(numbers[arr]);

		dfs();

		dfs_factor.pop_back();
		///visit[arr] = false;

	///}
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

	for (auto e : result) {
		for (int arr = 0; arr < e.size(); arr++) {
			cout << e[arr] << " ";
		}
		cout << "\n";
	}



}
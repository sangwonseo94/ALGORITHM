#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, M;
vector < vector <int>> numbers;
vector <bool> visit;
bool decision = false;
void dfs(int x) {
	if (!visit[x]) {
		visit[x] = true;
		decision = true;
		for (int i = 1; i < numbers[x].size(); i++) {
			int temp = numbers[x][i];
			dfs(temp);
		}
	}
}

int main(void) {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(NULL);
	int result = 0;
	cin >> N >> M;
	for (int arr = 0; arr <= N; arr++) {
		vector <int > temp;
		temp.push_back(arr);
		numbers.push_back(temp);
	}
	visit = vector <bool>(N + 1, false);
	visit[0] = true;
	for (int arr = 0; arr < M; arr++) {
		int x, y;
		cin >> x >> y;
		numbers[x].push_back(y);
		numbers[y].push_back(x);
	}

	for (int arr = 1; arr <= N; arr++) {
		dfs(arr);

		if (decision) {
			result++;
			decision = false;

		}
	}
	cout << result;


}
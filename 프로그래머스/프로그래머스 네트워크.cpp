#include <iostream>
#include <vector>
using namespace std;

int N; int path; bool on = false;
vector < int > com[200];
bool visit[200] = { false, };
void dfs(int node) {
	if (visit[node]) return;
	visit[node] = true;
	on = true;
	for (int arr = 0; arr < com[node].size(); arr++) {
		if (visit[com[node][arr]]) continue;
		dfs(com[node][arr]);
		///visit[com[node][arr]] = false;
	}
}

int solution(int n, vector<vector<int>> computers) {
	int answer = 0;
	N = n;
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {

			if (computers[i][j]) {
				com[i].push_back(j);
				com[j].push_back(i);
			}
		}
	}
	for (int arr = 0; arr < n; arr++) {
		dfs(arr);
		if (on) {
			on = false;
			answer += 1;
		}
	}
	return answer;
}

int main(void) {
	vector < vector <int >> a = { {1,1,0},{1,1,0},{0,0,1} };
	vector < vector <int >> b = { {1,1,0},{1,1,1},{0,1,1} };

	cout << solution(3, a) << endl;
	

	cout << solution(3, b) << endl;
}
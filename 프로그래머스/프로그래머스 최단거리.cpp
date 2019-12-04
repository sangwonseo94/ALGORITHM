#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;
vector <int> node[20000];
vector <int> nodedistance(20000, -1);
bool visit[20000] = { false, };
int solution(int n, vector<vector<int>> edge) {
	int answer = 0; int max_length = -1;
	queue <int> q;
	for (auto a : edge) {
		node[a[0]].push_back(a[1]);
		node[a[1]].push_back(a[0]);
	}
	q.push(1);
	visit[0] = true;
	visit[1] = true;
	nodedistance[1] = 0;
	nodedistance[0] = 0;
	while (!q.empty()) {
		int a = q.front(); q.pop();
		for (int i = 0; i < node[a].size(); i++) {
			if (visit[node[a][i]]) continue;
			int b = node[a][i];
			visit[b] = true;
			nodedistance[b] = nodedistance[a] + 1;

			if (nodedistance[b] > max_length) {
				max_length = nodedistance[b];
				answer = 0;
			}
			if (nodedistance[b] == max_length) answer += 1;


			q.push(b);
		}
	}



	return answer;
}

int main(void) {
	vector<vector<int >> a = { {3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2} };
	
	cout << solution(6, a);
}
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int map[101][101] = { {0,}, };
bool v[101][101] = { {false,}, };
int solution(int m, int n, vector<vector<int>> puddles) {
	
	for (int i = 0; i < puddles.size(); i++) {
		v[puddles[i][0] - 1][puddles[i][1] - 1] = true;
	}
	for (int i = 0; i < m; i++) {
		if (v[0][i]) break;
		map[0][i] = 1;
	}
	for (int i = 0; i < n; i++) {
		if (v[i][0]) break;
		map[i][0] = 1;
	}

	for (int i = 1; i < n; i++) {
		for (int j = 1; j < m; j++) {
			if (v[i][j]) continue;
			map[i][j] = map[i - 1][j] + map[i][j - 1];
		}
	}
	
	return map[n - 1][m - 1] % 1000000007;


}
int main(void) {
	
	vector<vector<int>> ta;
	vector<int> tempa;
	tempa.push_back(2);
	tempa.push_back(1);
	ta.push_back(tempa);
	vector<int> tempb;
	tempb.push_back(2);
	tempb.push_back(3);
	ta.push_back(tempb);
	vector<int> tempc;
	tempc.push_back(3);
	tempc.push_back(2);
	ta.push_back(tempc);
	cout << solution(4, 4, ta) << endl;


}
#include <iostream>
#include <vector>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, m, v;
	cin >> n >> m >> v;
	vector< vector < int >> node;
	for (int i = 0; i < m; i++) {
		int a, b;
		node[a].push_back(b);
		noed[b].push_back(a);
	}

	for (auto a : node) {
		for (auto k : a) cout << k; 
		cout << endl; 
	}


}
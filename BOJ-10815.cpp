#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;
#define Max 100000;

int main() {
	ios_base::sync_with_stdio(false); 
	cin.tie(0);

	int Case_N, Case_M, temp;
	vector<int> N,M;
	cin >> Case_N;
	while (N.size() < Case_N ){
		cin >> temp;
		N.push_back(temp);
	}
	cin >> Case_M;
	while (M.size() < Case_M ){
		cin >> temp;
		M.push_back(temp);
	}
	sort(N.begin(), N.end());
	for (int loop = 0; loop < Case_M; loop++ ){
		int a = 0, b = N.size() - 1, k;
		while (a <= b) {
			k = ((a + b) / 2);
			if (N[k] == M[loop]) {
				cout << "1" << "\n"; break;
			}
			if (N[k] < M[loop]) a = k + 1;
			else b = k - 1;
			if (a >b) {
				cout << "0" << "\n";
				break;
			}
		}
	}
}


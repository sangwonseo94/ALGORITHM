#include <iostream>

using namespace std;

int main(void) {
	cin.tie(0); cout.tie(0);


	int n; cin >> n;
	int DP[1001][10] = { {0,}, };
	for (int i = 0; i < 10; i++) {
		DP[1][i] = 1;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= 9; j++) {
			for (int k = j; k <= 9; k++) {
				DP[i][k] += DP[i - 1][j];
				DP[i][k] %= 10007;
			}
		}

	}
	int sum = 0;
	for (auto arr : DP[n]) {
		sum += arr;
	}
	cout << sum % 10007;
}
#include <iostream>
#include <algorithm>
using namespace std;
const int INF = numeric_limits<int>::max();
int min_value = INF;
int map[3][4] = {
		{1,3,5,8},
		{4,2,1,7},
		{4,3,2,3}
};
void cost(int cost_value, int i, int j) {
	cost_value += map[i][j];
	if (i == 2 && j == 3) {
		if (cost_value < min_value) {
			min_value = cost_value;
		}
	}
	else {
		if (i + 1 <= 2) cost(cost_value, i + 1, j);
		if (j + 1 <= 3) { cost(cost_value, i, j + 1); }
	}
}

int main(void) {
	int copymap[3][4] = { {0, }, };


	copymap[0][0] = map[0][0];
	for (int i = 1; i < 4; i++) {
		copymap[0][i] = copymap[0][i - 1] + map[0][i];
	}
	for (int i = 1; i < 3; i++) {
		copymap[i][0] = copymap[i - 1][0] + map[i][0];
	}

	for (int i = 1; i < 3; i++) {
		for (int j = 1; j < 4; j++) {
			copymap[i][j] = min({ copymap[i - 1][j], copymap[i][j - 1], copymap[i - 1][j - 1] }) + map[i][j];
		}
	}
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 4; j++) {
			cout << copymap[i][j] << " ";
		}
		cout << endl;
	}

}
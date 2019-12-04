#include <iostream>
#include <vector>
#include <ctime>
using namespace std;

int min_v = 21000000;
vector < vector <int > > cost_color;
int tc;
void cost(int profit, int index, int row) {
	row += 1;
	if (row == tc) {
		if (profit < min_v) min_v = profit;
		return;
	}
	else
		for (int i = 0; i < 3; i++) {
			if (index == i) continue;
			else cost(profit + cost_color[row][i], i, row);
		}
}

int main(void) {
	cin.tie(0); ios::sync_with_stdio(NULL); cout.tie(0);
	cin >> tc;
	for (int i = 0; i < tc; i++) {
		vector < int > temp;
		for (int i = 0; i < 3; i++) {
			int t; cin >> t;
			temp.push_back(t);
		}
		cost_color.push_back(temp);
	}
	for (int i = 0; i < 3; i++) cost(cost_color[0][i], i, 0);
	cout << min_v << " ";

}
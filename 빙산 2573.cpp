#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector <vector <int >> map;
vector <vector <bool >> visit;
vector <vector <int>> copy_map;
vector < bool > temp_visit;
int number_of_rows, number_of_cols, year = 0;
bool visit_number_flag = false;
int total_visit_number = 0;

bool checkzero() {
	for (int i = 0; i < number_of_rows; i++) {
		for (int j = 0; j < number_of_cols; j++) {
			if (map[i][j] != 0) return false;
		}
	}
	return true;
}

void dfs(int nowstate, int row, int col) {

	if (!visit[row][col] && (map[row][col] != 0)) {
		visit_number_flag = true;
		visit[row][col] = true;

		if ((row - 1) >= 0) { dfs(map[row - 1][col], row - 1, col); } ///위쪽검사
		if ((row + 1) < number_of_rows) { dfs(map[row + 1][col], row + 1, col); } /// 아래쪽
		if ((col - 1) >= 0) { dfs(map[row][col - 1], row, col - 1); } /// 왼쪽
		if ((col + 1) < number_of_cols) { dfs(map[row][col + 1], row, col + 1); } /// 오른쪽
	}

}

int main(void) {
	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(NULL);

	cin >> number_of_rows >> number_of_cols;

	for (int i = 0; i < number_of_rows; i++) {
		vector <int > temp;

		for (int j = 0; j < number_of_cols; j++) {
			int x; cin >> x;
			temp.push_back(x);
		}
		map.push_back(temp);

	}



	while (true) {

		if (checkzero()) {
			cout << 0; break;
		}
		copy_map.clear();
		visit.clear();
		for (int i = 0; i < number_of_rows; i++) {
			vector <int > temp(number_of_cols, 0);
			vector <bool >visit_temp(number_of_cols, false);
			visit.push_back(visit_temp);
			copy_map.push_back(temp);
		}
		for (int i = 0; i < number_of_rows; i++) {
			for (int j = 0; j < number_of_cols; j++) {
				dfs(map[i][j], i, j);
				if (visit_number_flag) {
					total_visit_number++;
					visit_number_flag = false;
				}
			}
		}

		for (int row = 0; row < number_of_rows; row++) {
			for (int col = 0; col < number_of_cols; col++) {
				if (map[row][col] == 0)continue;
				int cnt = 0;
				if ((row - 1) >= 0) { if (map[row - 1][col] == 0) cnt++; }
				if ((row + 1) < number_of_rows) { if (map[row + 1][col] == 0) cnt++; }
				if ((col - 1) >= 0) { if (map[row][col - 1] == 0) cnt++; }
				if ((col + 1) < number_of_cols) { if (map[row][col + 1] == 0) cnt++; }
				copy_map[row][col] = cnt;
			}
		}

		for (int row = 0; row < number_of_rows; row++) {
			for (int col = 0; col < number_of_cols; col++) {
				map[row][col] = max(map[row][col] - copy_map[row][col], 0);
			}
		}

		if (total_visit_number >= 2) {
			cout << year;
			break;
		}
		else {

			total_visit_number = 0;
			year++;
		}



	}

}
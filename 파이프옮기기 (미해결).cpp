#include <iostream>

using namespace std;


int map[17][17] = { 0, };
int n;
int ans;
int pos = 0;
void move(int head_x, int head_y) {
	
	/// 현재상태가 가로일 경우
	// 오른쪽으로 밀기 // 대각선으로 45도밀기
	if (pos == 0) {
		if (!map[head_x][head_y + 1] && (head_y + 1 < n)) {
			if (head_x == n - 1 && head_y + 1 == n - 1) {
				ans++;
			
			}
			else {
			pos = 0;
			move(head_x, head_y + 1);
			}
	}
		if (!map[head_x][head_y + 1] && !map[head_x + 1][head_y + 1] && !map[head_x + 1][head_y] && (head_x + 1 < n) && (head_y + 1 < n)) {
			if (head_x + 1 == n - 1 && head_y + 1 == n - 1) {
				ans++;
		
			}
			else {
			pos = 1;
			move(head_x + 1, head_y + 1);
			}
		}
	}


	/// 현재상태가 대각선일경우
	if (pos == 1) {
		if (!map[head_x][head_y + 1] && (head_y + 1 < n)) {
			if (head_x == n - 1 && head_y + 1 == n - 1) {
				ans++;
			
			}
			else {
			pos = 0;
			move(head_x, head_y + 1);
			}
		}

		if (!map[head_x + 1][head_y] && (head_x + 1 < n)) {
			if (head_x +1 == n - 1 && head_y == n - 1) {
				ans++;
			
			}
			else {
			pos = 2;
			move(head_x + 1, head_y);
			}
		}
		if (!map[head_x][head_y + 1] && !map[head_x + 1][head_y + 1] && !map[head_x + 1][head_y] && (head_x + 1 < n) && (head_y + 1 < n)) {
			if (head_x + 1 == n - 1 && head_y + 1 == n - 1) {
				ans++;
				
			}
			else {
			pos = 1;
			move(head_x + 1, head_y + 1);
			}
		}

	}
	/// 현재상태가 세로일 경우
// 아래로밀기 대각선으로 45도 밀기
	if (pos == 2) {
		if (!map[head_x + 1][head_y] && (head_x + 1 < n)) {
			if (head_x  +1 == n - 1 && head_y == n - 1) {
				ans++;
				
			}
			else {
			pos = 2;
			move(head_x + 1, head_y);
			}
		}
		if (!map[head_x][head_y + 1] && !map[head_x + 1][head_y + 1] && !map[head_x + 1][head_y] && (head_x + 1 < n) && (head_y + 1 < n)) {
			if (head_x + 1 == n - 1 && head_y + 1 == n - 1) {
				ans++;
				
			}
			else {
			pos = 1;
			move(head_x + 1, head_y + 1);
			}
		}
	}
}

int main(void) {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];		
		}
	}

	map[0][1] = 1;
	map[0][0] = 1;

	move(0,1);
	cout << ans; 
}
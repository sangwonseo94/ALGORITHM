#include <iostream>

using namespace std;


int map[17][17] = { 0, };
int n;
int ans;
int pos = 0;
void move(int head_x, int head_y) {
	
	/// ������°� ������ ���
	// ���������� �б� // �밢������ 45���б�
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


	/// ������°� �밢���ϰ��
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
	/// ������°� ������ ���
// �Ʒ��ιб� �밢������ 45�� �б�
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
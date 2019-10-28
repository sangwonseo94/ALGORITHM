#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector <vector < vector << <char>>> map;

int X, Y, Z;
int main(void) {

	cin.tie(0); cout.tie(0);
	ios_base::sync_with_stdio(NULL);

	cin >> X >> Y >> Z;
	for (int arr = 0; arr < X; arr++) {
		vector <vector <char>> temp2;
		for (int i = 0; i < Y; i++)
		{
			vector <char> temp;
			for (int j = 0; j < Z; j++)
			{
				char c; cin >> c;
				temp.push_back(c);
			}
			temp2.push_back(temp);
		}
		map.push_back(temp2);
	}


}
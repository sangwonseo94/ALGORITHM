#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int N,Budget,mid,res;
vector < int > want;
void input(){
	cin >> N;
	for(int index = 1 ; index <= N ; index ++){
		int t; cin>> t;
		want.push_back(t);
	}
	cin >> Budget;
}

int main(int argc, char** argv) {
	input(); 
	sort(want.begin() , want.end());
	if(want[N-1]*N <= Budget){
		cout<< want[N-1];
		return 0;
	}
	else if(want[0]*N > Budget){
		cout << Budget/N;
		return 0;
	}
	else{
		int left = want[0] , right = want[N-1];
		while(left <= right){
			
			 mid = (left + right) / 2 ;
			int total =0;
			for(int index =0 ; index < N ; index++){
				if(want[index] >= mid){
					total += mid;
				}
				else total += want[index];
			}
			
			if( total > Budget){
				right = mid -1;
			}
			else {
				res = max(res,mid);
				left = mid +1;
			}
			
		}
	}
	cout << res;
	return 0;
}

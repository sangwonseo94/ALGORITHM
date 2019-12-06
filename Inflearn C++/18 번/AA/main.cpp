#include <iostream>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
using namespace std;
int main(int argc, char** argv) {
	//freopen('input.txt','rt', stdin);
	int n,m,time=0,max= -1 ;
	cin >> n >> m;

	while(n){
		int temp; cin >> temp;
		if(temp > m){
			time +=1;
			if( time > max){
				max = time;
			}
		}
		else{
			time =0;
		}
		n--;
	}
	cout << max ;

	return 0;
}

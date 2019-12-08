#include <iostream>
#include <algorithm>
#include <vector>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

int main(int argc, char** argv) {
	int n; cin>>n;
	vector<int> num(n+1);
	for(int i=2 ; i <=n ; i++){
	
		int temp=i;
		while(temp >1){
			
			for (int j = 2; j <= i ; j ++){
				if( temp%j ==0){
					num[j] +=1;
					temp/=j;
					j =1;
				}
			}		
		}
	}	
	cout << n <<"! = ";
	for(int index = 0 ; index<num.size() ; index++){
		
		if(num[index] == 0) continue;
		cout << num[index]<<" ";
	}
		
	return 0;
}

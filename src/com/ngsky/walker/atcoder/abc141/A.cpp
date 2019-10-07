#include <iostream>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int main(){
  string s;
  cin >> s;
  string str[]={"Sunny", "Cloudy", "Rainy"};
  for(int i=0;i<3;i++){
  	if(s==str[i]){
    	if(i==2) cout << str[0] << endl;
        else cout << str[i+1] << endl;
    }
  }
  return 0;
}
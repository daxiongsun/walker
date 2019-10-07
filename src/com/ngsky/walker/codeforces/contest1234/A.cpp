#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int main(){
    int T=0,n=0;
    // freopen("a.txt","r", stdin);
    cin >> T;
    while(T--){
        cin >> n;
        int sum=0,res=0;
        for(int i=0;i<n;i++){
            int gp;
            cin >> gp;
            sum+=gp;
        }
        res=sum/n;
        res=res*n<sum?res+1:res;
        cout << res << endl;
    }
    return 0;
}
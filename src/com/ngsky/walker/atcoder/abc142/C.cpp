#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

int main(){
    int n;
    cin >> n;
    int res[n+1];
    for(int i=1;i<=n;i++){
        int st;
        cin >> st;
        res[st]=i;
    }
    for(int i=1;i<=n;i++){
        cout << res[i] << endl;
    }
    return 0;
}
#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

int main(){
    // freopen("b1.txt","r", stdin);
    int n=0,k=0,s=0,e=0;
    cin >> n >> k;
    int li[n+1];
    for(int i=0;i<n;i++){
        li[i]=0;
        int x=0;
        cin >> x;
        bool used=false;
        for(int j=s;j>=e;j--){
            if(li[j]==x) {
                used=true; 
                break;
            }
        }
        if(!used){
            if((s-e)>=k){
                // 尾移头补
                e++;
            }
            // 头补
            li[s++]=x;
        }
    }
    cout << (s-e) << endl;
    for(int i=s-1;i>=e;i--){
        cout << li[i] << " ";
    }
    cout << endl;
    return 0;
}
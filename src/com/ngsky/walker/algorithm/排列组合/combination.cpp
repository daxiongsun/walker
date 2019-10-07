#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

void combina(int pos,int cn,int n,int k,int visit[]){
    if(cn==k){
        for(int i=0;i<n;i++){
            if(visit[i]==1){
                cout << i << " ";
            }
        }
        cout << endl;
        return;
    }
    if(pos==n) return;
    // 1.选择当前pos
    if(visit[pos]!=1){
        // 标记
        visit[pos]=1;
        combina(pos+1,cn+1,n,k,visit);
        // 回溯
        visit[pos]=0;
    }
    // 2.不选择当前pos
    combina(pos+1,cn,n,k,visit);
}

int main(){
    int n=7;
    int k=6;
    int visit[n];
    combina(0,0,n,k,visit);
    return 0;
}
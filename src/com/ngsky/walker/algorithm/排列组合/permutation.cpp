#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

// 选中排列
int res=0;
void choosePerm(int pos,int cn,int n,int k,int visit[],int nums[]){
    if(cn==k){
        for(int i=0;i<k;i++){
            cout << nums[i] << " ";
            
        }
        cout << endl;
        res+=1;
        return;
    }
    if(pos == n) return;
    
    for(int i=0;i<n;i++){
        if(visit[i]==0){
            visit[i]=cn+1;
            nums[cn]=i;
            choosePerm(i,cn+1,n,k, visit, nums);
            visit[i]=0;
        }
    }
}

int main(){
    // N: 0-(N-1)
    // M: 从 0-(n-1)个数中选择M个，进行全排列(跟顺序有关) 
    // 4!/(4-2)! = 12
    // 7!/(7-4)!=7*6*5*4=840
    int n=4,k=3;
    int visit[n];
    int nums[k];
    for(int i=0;i<n;i++){
        visit[i]=0;
        if(i<k){
            nums[i]=-1;
        }
    }
    choosePerm(0,0,n,k, visit, nums);
    cout << "res-count:" << res << endl;
    return 0;
}
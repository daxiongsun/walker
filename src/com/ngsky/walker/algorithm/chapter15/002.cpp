#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

using namespace std;

// 切钢条
// 带备忘的自顶向下 动态规划
// 时间复杂度： O(n)
int memoized_cut_rod(int p[],int n,int visit[]){
    // 检查标记
    if(visit[n]>=0) return visit[n];
    if(n==0) return 0;
    int q=-1;
    for(int i=1;i<=n;i++){
        q=max(q, p[i]+memoized_cut_rod(p,n-i, visit));
    }
    visit[n]=q;
    return q;
}

int main(){
    int p[]={0,1,5,8,9,10,17,17,20,24,30};
    int n=4;
    int visit[n+1];
    for(int i=0;i<n+1;i++){
        visit[i]=-1;
    }
    int res=memoized_cut_rod(p,n,visit);
    cout << res << endl;
    return 0;
}

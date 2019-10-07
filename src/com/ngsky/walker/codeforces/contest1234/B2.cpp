#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <map>
#include <deque>

using namespace std;

int main(){
    // freopen("b2.txt","r",stdin);

    int n=0,k=0;
    map<int,int> visit;
    deque<int> res;
    cin >> n >> k;
    for(int i=0;i<n;i++){
        int x=0;
        cin >> x;
        if(visit[x]!=1){
            visit[x]=1;
            if(res.size()>=k){
                int s=res.front();
                res.pop_front();
                visit[s]=0;
            }
            res.push_back(x);
        }
    }
    int size=res.size();
    cout << size << endl;
    for(int i=0;i<size;i++){
        int s=res.back();
        cout << s << " ";
        res.pop_back();
    }
    cout << endl;
    return 0;
}
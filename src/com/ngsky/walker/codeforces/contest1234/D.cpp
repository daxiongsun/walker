#include<bits/stdc++.h>
using namespace std;
string s;
int main()
{
    // freopen("d.txt","r",stdin);

	ios::sync_with_stdio(false);cin.tie(0);
	set <int>h[30];
	int n;
	cin>>s;
    for(int i=0;i<s.length();i++)
	{
        // 每个元素最后出现的位置
		h[s[i]-'a'].insert(i+1);
	}
	cin>>n;int x,y;char c;
	while(n--)
	{
		int oo;cin>>oo;
		if(oo==1)
		{
			cin>>x>>c;
            // 删除原来存放 字符c 的位置
			h[s[x-1]-'a'].erase(x);
			s[x-1]=c;
			h[s[x-1]-'a'].insert(x);
		}else 
		{
			cin>>x>>y;int ans=0;
			for(int i=0;i<26;i++)
			{
                // 返回一个指向大于或者等于x值的第一个元素的迭代器。
				auto it=h[i].lower_bound(x);
                // 返回指向当前集合中最后一个元素的迭代器。
				if(it!=h[i].end()&&(*it)<=y ) ans++;
			}
			cout<<ans<<endl;
		}
	}
	
}
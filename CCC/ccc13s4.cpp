#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
using vi=vector<int>;
const int MM= 1e6+5;
vi adj[MM]; bool vis[MM];
void dfs(int s) {
    if (vis[s]) return; vis[s]=true;
    for (auto x: adj[s]) dfs(x);
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n,m; cin >> n >> m;
    for (int i = 0;i<m;i++) {
        int x,y;cin>>x>>y;
        //x taller than y
        adj[y].pb(x);
    }

    int a,b; cin>>a>>b;
    //yes a >b, no b > a, unknown
    dfs(a);
    if (vis[b]) {
        cout << "no" << nl;
    }
    else {
        memset(vis,false,sizeof(vis));dfs(b);
        if (vis[a]) cout << "yes" << nl;
        else cout << "unknown"<<nl;
    }
}
#include <bits/stdc++.h>
using namespace std; 
using ll = long long; constexpr char nl= '\n';
using vi = vector<int>;
using pi = pair<int,int>;
const int MM = 1e5+5;
bool subpho[MM];
// int d[MM];
vi adj[MM];
int tot = 0;
int mx = 0, len = 0;
void initdfs(int rt, int pa) {
    for (auto x: adj[rt]) {
        if (x==pa) continue;
        initdfs(x,rt); subpho[rt] |= subpho[x];
    }
    if (subpho[rt]) tot++;
}
void dfs(int rt, int pa, int dis) {
    if (dis > len) {
        len = dis; mx = rt;
    }
    for (auto x: adj[rt]) {
        if (x==pa) continue;
        if (!subpho[x]) continue;
        dfs(x,rt,dis+1);
    }
}
int main() {
    //been about a year since my last java submission... let's see how I'll do now
    ios::sync_with_stdio(0); cin.tie(0);
    // freopen("in.txt","r",stdin); 
    // freopen("out.txt","w",stdout);
    int n,m; cin >> n >> m;
    int st = 0;
    for (int i =0 ; i < m; i++) {
        int x; cin >> x;
        subpho[x] = true;
        st= x;
    }
    for (int i = 0; i < n-1; i++) {
        int a,b; cin >> a >> b;
        adj[a].push_back(b); 
        adj[b].push_back(a);
    }
    initdfs(st,-1);
    len = 0; 
    dfs(st,-1,0); 
    len = 0;
    dfs(mx,-1,0);
    cout << 2 * (tot-1) - len << nl;
}
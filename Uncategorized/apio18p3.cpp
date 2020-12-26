#include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
const int MM = 1e5+5;
int N,M,cnt;
int dfn[MM],low[MM],sz[2*MM], w[2*MM], stk[2*MM],tp=-1, idx;
vector<int> adj[MM], adj2[2*MM];
ll ans;
void tarjan(int u) {
    dfn[u] = low[u] = ++idx;
    stk[++tp] = u;
    for (int v: adj[u]) {
        if (!dfn[v]){
            tarjan(v); 
            low[u] = min(low[u],low[v]);
            //bcc
            if (low[v] == dfn[u]) {
                //tree
                ++cnt; w[cnt]=0;
                for (int x = 0; x != v;) {
                    x = stk[tp--];
                    //dummy node++
                    w[cnt]++;
                    adj2[cnt].push_back(x); adj2[x].push_back(cnt);
                }
                adj2[cnt].push_back(u); adj2[u].push_back(cnt); w[cnt]++;
            }
        }
        else low[u] = min(low[u],dfn[v]);
    }
}
void dfs(int s, int par) {
    sz[s] = (s <= N);
    for (int v: adj2[s]) {
        if (v == par) continue;
        dfs(v,s);
        ans += 2LL * w[s] * sz[v]*sz[s];
        sz[s]+=sz[v];
    }
    ans += 2LL * w[s] * sz[s] * (idx - sz[s]);
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> N >> M;
    cnt = N;
    for (int i = 1; i <= N; i++) w[i] = -1;
    for (int i = 1; i <= M; i++) {
        int u,v; cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for (int i = 1; i <= N; i++) {
        if (!dfn[i]) {
            idx = 0; tp=-1;
            tarjan(i); dfs(i,-1);
        }
    }
    cout << ans << nl;
}

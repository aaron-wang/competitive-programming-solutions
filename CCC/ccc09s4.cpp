#include <bits/stdc++.h>
using namespace std; 
using ll = long long; constexpr char nl= '\n';
const int MM = 5003;
using pi = pair<int,int>;
vector<pi> adj[MM];
int pen[MM], d[MM];
bool vis[MM];
priority_queue<pi> q;
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    // freopen("in.txt","r",stdin); 
    // freopen("out.txt","w",stdout);
    int n; cin >> n;
    int t; cin >> t;
    while(t--) {
        int x,y, cost; 
        cin >> x >> y >> cost;
        adj[x].push_back({y,cost});
        adj[y].push_back({x,cost});
    }
    int k; cin >> k;
    memset(pen,-1,sizeof(pen));
    while(k--) {
        int z,p; cin >> z >> p;
        pen[z] = p;
    }
    memset(d,0x3f,sizeof(d));

    int dest; cin >> dest;
    d[dest] = 0;
    q.push({0,dest});
    while(!q.empty()) {
        int a = q.top().second; 
        if (-q.top().first > d[a]) {
            q.pop();
            continue;
        }
        q.pop();
        // if (vis[a]) continue; vis[a] = true;
        for (auto x: adj[a]) {
            int b = x.first; 
            int w = x.second;
            if (d[a] + w < d[b]) {
                d[b] = d[a] + w;
                q.push({-d[b],b});
            }
        }
    }
    int ans = 2e9;
    for (int i = 1; i <= n; i++) {
        if (d[i] == 0x3f3f3f3f || pen[i] < 0) continue;
        d[i] += pen[i];
        ans = min(ans,d[i]);
    }
    cout << ans << nl;
}
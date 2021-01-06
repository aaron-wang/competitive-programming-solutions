#include <bits/stdc++.h>
using namespace std;using ll = long long; constexpr char nl = '\n';
const int MM =1e6+6;
vector<int> adj[MM];bool vis[MM];
void dfs(int s) {
    if (vis[s]) return;vis[s]= true;
    for (auto x: adj[s]) dfs(x);
}
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int m,n; cin >> m >> n;
    for (int i =1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            int x;
            cin >> x; adj[i*j].push_back(x);
        }
    }
    dfs(1);cout << (vis[n*m] ? "yes" :"no");
}
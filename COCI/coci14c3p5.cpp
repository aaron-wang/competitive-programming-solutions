#include <bits/stdc++.h>
#define pb push_back
#define eb emplace_back
#define f first
#define s second
using namespace std;
using ll =long long; constexpr char nl = '\n';
const int MM = 3e5+5, LOG = 20;
int N, st[MM], anc[LOG][MM], dep[MM];
int lca(int u, int v) {
    if (dep[u] < dep[v]) swap(u,v);
    for (int k = LOG-1; k >= 0;k--) {
        if (anc[k][u] != -1 && dep[anc[k][u]] >= dep[v]) u = anc[k][u];
    }
    if (u == v) return u;
    for (int k = LOG-1; k >=0; k--) {
        if (anc[k][u] != -1 && anc[k][v] != -1 && anc[k][u] != anc[k][v]) {
            u = anc[k][u]; v = anc[k][v];
        }
    }
    return anc[0][u];
}
inline void upd(int i, int p) {
    dep[i]=dep[p]+1; anc[0][i] = p;
    for (int k = 1; k < LOG; k++) 
        if (anc[k-1][i] != -1) anc[k][i] = anc[k-1][anc[k-1][i]];
}
int main() {
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> N;
    memset(anc,-1,sizeof(anc));
    int v; char op;
    for (int i = 1; i <= N; i++) {
        cin >> op;
        cin >> v;
        int p = st[v];
        if (op == 'a') {
            st[i] = i;
            upd(i,p);
        }
        else if (op == 'b') {
            cout << p << nl;
            //par
            st[i] = anc[0][p];
        }
        else {
            int w; cin >> w; st[i] = st[v]; //for next
            int ans = dep[lca(st[v],st[w])];
            cout << ans << nl;
        }
    }
}
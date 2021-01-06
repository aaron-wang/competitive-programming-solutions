 #include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
int n,k,p;
const int MM = 1e9;
unordered_map<int,int> xR,xC, cR,cC;
unordered_map<ll,int> g;
ll ans;
void rook(int r, int c, int v) {
    ans = ans - (n-cC[xR[r]]) - (n-cR[xC[c]]);
    cR[xR[r]]--; cC[xC[c]]--;
    xR[r] ^= v; xC[c] ^=v;
    cR[xR[r]]++; cC[xC[c]]++;
    ans = ans + (n-cC[xR[r]]) + (n-cR[xC[c]]);
}
inline ll f(int a, int b) {return ((ll) a * MM + b);}
int main() {
    cin.sync_with_stdio(0);cin.tie(0);
    cin >> n >> k >> p;
    cR[0]=cC[0]=n;
    for (int i = 0 ; i < k; i++) {
        int r,c,v; cin >> r >> c >> v;
        rook(r,c,v);
        g[f(r,c)] = v;
    }   
    for (int i = 0;i  < p; i++) {
        int r1,c1,r2,c2;
        cin >> r1 >> c1 >> r2 >> c2;
        int y= g[f(r1,c1)];
        rook(r1,c1,y); g[f(r1,c1)] = 0;
        rook(r2,c2,y); g[f(r2,c2)] = y;
        cout << ans << nl;
    }
}
# CP-Solutions
 A collection of my solutions to online judges. *Exemplar solutions below*

Generally, C++ solutions are higher quality than Java solutions. 

- C++ solutions are significantly more recent than Java solutions.
- Java has more solutions to "easy" problems, while C++ has more solutions to harder problems.


If you are trying to copy solutions without time spent for forethought, you will only be hurting yourself in the long run.

Exemplar C++ solutions:

```c++
#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl= '\n';
const int LOG = 16, MM = 5e4+3;
int b[LOG][MM], a[LOG][MM];
int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int n,q; cin >> n >> q;
    for (int i = 0; i < n; i++) {int x;cin>>x;b[0][i] = a[0][i] = x;}
    for (int k = 1; k < LOG; k++) {
        for (int i = 0; i + (1<<k) <= n; i++) {
            a[k][i] = max(a[k-1][i],a[k-1][i+(1<<(k-1))]);b[k][i] = min(b[k-1][i],b[k-1][i+(1<<(k-1))]);
        }
    }
    while(q--) {
        int x,y; cin >> x >> y;
        x--,y--;
        int k = 31-__builtin_clz(y-x+1); 
        cout << max(a[k][x],a[k][y-(1<<k)+1]) -min(b[k][x],b[k][y-(1<<k)+1]) << nl;
    }
}
```

```c++
#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3002;
int tr[MAXN][MAXN];
int org[MAXN][MAXN];
	
void update(int r, int c, int val) {
    for (int i = r; i <= MAXN; i+=(i&-i)) {
        for (int j = c; j <= MAXN; j += (j&-j)) {
//				if (tr[i][j] == 0) continue;
            tr[i][j] = max(tr[i][j],val);
        }
    }
}
	
int mx(int r, int c) {
    int ret = 0;
    for (int i = r; i >0; i-=(i&-i)) {
        for (int j = c; j >0; j -= (j&-j)) {				
            ret = max(ret,tr[i][j]);
        }
    }
    return ret;
}
int main() {
    cin.tie(0);
    cin.sync_with_stdio(false);
    int N, K;
    cin >> N >> K;
    //align
    for (int i = 1; i <= N; i++) {
        for (int j = i; j >= 1; j--) {
            cin >> org[i][N-j+1];
        }
    }
    long ans = 0;
    for (int d = 0; d < N; d++) {
        for (int r = 0; r <= d; r++) {
            int R = N - d+r;
            update(R,N-r,org[R][N-r]);
        }
        for (int i = 0; i<= d-K+1; i++) {
            ans += mx(N-d+K-1+i,N-i);
        }
    }
    cout<< ans << "\n";
}
```

```c++
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
```

```c++
 #include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
const int MM = 1e6+5;
ll tr[MM], a[MM], tmp[MM];
pair<ll,int> rk[MM];
pair<ll,int> qq[MM];

ll query(ll tr[], int x) {
    x++;
    ll ret = 0;
    for (int i = x; i > 0; i-=i&-i) {
        ret += tr[i];
    }
    return ret;
}
void update(ll tr[], int x, ll val) {
    x++;
    for (int i = x; i < MM; i+=i&-i) {
        tr[i] += val;
    }
}

int main() {
    // test "over" negative and P=0
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    int N;
    cin >> N;
    for (int i = 1; i <= N; i++) cin>> a[i];
    int P; cin >> P;
    for (int i =1; i <= N; i++) {
        a[i]-=P; tmp[i] = a[i];
        if (i >= 1) tmp[i] += tmp[i-1];
    }
    //sum at "i"
    for (int i = 1; i <= N; i++) {
        qq[i] = {tmp[i],i};
    }
    //shift all elements right**
    qq[N+1] = {0,0};
    sort(qq+1,qq+1+N+1);
    //for P, how many diff consec subsequences where avg >= P
    //-P, so nonnegative, 0,1...,
    int L = 1;
    ll ans = 0;
    //note from [1,N+1]
    //offset update/query functions
    //all indexes shifted 1 right )
    for (int R = 1; R <= N+1; R++) {
        while (L < R && ((qq[R].first - qq[L].first) >= 0)) {
            update(tr,qq[L].second,1);L++;
        }
        ans+= (query(tr,qq[R].second));
    }
    // ans++;
    cout << ans << nl;



}
```

```c++
#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
const int MM = 2e5+5;
vector<int> g[MM];
int d[MM];
priority_queue<int> q;
ll tr[MM];
inline void upd(int x, int v) {
    for (int i = x; i < MM; i+=i&-i) tr[i] += v;
}
ll query(int x) {
    ll ret = 0;
    for (int i = x; i > 0; i-=i&-i) ret += tr[i];
    return ret;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    for (int i = 1,x; i <= n; i++) {
        cin >> x; g[x].pb(i);
    }
    for (int i = n; i>=1;i--) {
        for (int x: g[i]) q.push(x);
        if (q.empty()) {cout << -1<<nl; return 0;}
        d[i] = q.top(); q.pop();
    }
    ll ans = 0;
    //main
    for (int i = 1; i <= n;i++) {
        ans += i- 1 - query(d[i]);
        upd(d[i],1);
    }
    cout << ans << nl;
}
```


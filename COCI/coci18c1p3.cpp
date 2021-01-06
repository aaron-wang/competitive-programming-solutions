 #include <bits/stdc++.h>
#define pb push_back
using namespace std;
using pi = pair<int,int>; using vi = vector<int>;
using ll = long long; constexpr char nl = '\n';
const int MM = 1e5+5;
int N,M;
vi a,b;
//left and right
bool solve(int val) {
    for (int i = 0,R=-1; i < N; i++) {
        ++R;
        while (R < M) {
            //ugliness
            if (abs(a[i] - b[R]) > val)R++;
            else break;
        } 
        if (R >= M) return false;
    }
    return true;
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    cin >> N >> M;
    for (int i = 1; i <= N; i++) {
        int l; cin >> l; a.pb(l);
    }
    sort(a.begin(),a.end());
    //r
    for (int i = 1; i <= M; i++) {
        int l; cin >> l; b.pb(l);
    }
    sort(b.begin(),b.end());
    //always let right shoe amount be larger, so deal with left shoes
    if (N>M) {
        swap(a,b); swap(N,M);
    }
    int L = 0, R = 1e9;
    //shoe size - try values starting from 1e9
    //check in "right" shoe M (larger shoe amount group)
    while (L < R) {
        int m = (L+R)/2;
        if (solve(m)) R=m;
        else L=m+1;
        // cout << m << nl;
    }
    
    // cout << R << nl;
    cout << L << nl;
}
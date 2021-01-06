#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';
double C,S,P; 
struct crew {
    double c,s,p;
};
double ans = 0;
crew a[25];
void solve(vector<int>& bb) {
    double cc=0,ss=0,pp=0;
    for (int i = 0; i < bb.size();i++) {
        cc+= a[bb[i]].c; 
        ss+=a[bb[i]].s; 
        pp+=a[bb[i]].p;
    }
    double x = min(min(cc/C,ss/S),pp/P);
    x = min(100.0,x*100);
    ans = max(ans,x);
}
int main() {
    // cin.sync_with_stdio(0); cin.tie(0);
    cin >> C >> S >> P;
    //cod, anti-s, and path
    //five members
    //succ = min ratio betw an attribute and sum of all crew attribute.
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        double c,s,p;cin>>c>>s>>p;
        a[i].c = c; a[i].s=s;a[i].p=p;
    }
    if (n < 5) n = 5;
    vector<int> bb;
    for (int m = 0; m < 1 <<n; m++) {    
        if (__builtin_popcount(m) == 5) {
            for (int i = 0; i < n; i++) {
                if (m & (1<<i)) bb.pb(i);
            }
            solve(bb);
            bb.clear();
        }
    }

    cout << fixed <<setprecision(1)<<ans << nl;
}
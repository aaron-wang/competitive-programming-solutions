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
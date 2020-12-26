 #include <bits/stdc++.h>
using namespace std;
typedef long long ll; constexpr char nl = '\n'; 
const int MM = 8;
vector<ll> adj[MM];
bool vis[MM], found;
stack<ll> ans;
ll A,B;
bool isPrime(ll num) {
    if (num <=1) return false;
    for (ll a = 2; a*a <= num; a++) {
        if ((num % a) == 0) {
            return false;
        }
    }
    return true;
}
void dfs(int s) {
    if (vis[s]) return;
    vis[s] = true;
    if (s == 5){
        found = true;
        return;
    }    
    if (found) return;
    for (auto v: adj[s]) {
        if (!found) ans.push(v);
        dfs(v);
        if (!found)ans.pop();
        else return;
    }
}
int main() {
    cin.sync_with_stdio(false);
    cin.tie(0);
    cin>>A>>B;
    //A!=B
    //if one is 2, other is odd
    //else odd,odd1
    //distance between each prime is even
    //except for 2 which is odd
    //array of primes, with abs prime neighbour diff
    //so all differences are 2 (barring the one next to 2)
    //ODD,ODD
    /*
    A A-2 A+2, B-2 B+2 B
    */
    //EVEN, oDD
    /*
    above, including 2
    */
   //0 to 5
   ll a[] = {A,A+2,A-2,B+2,B-2,B,2};
   if (A==2 || B == 2) a[6] = 0;
   for (int i = 0; i < 7; i++) {
       if (!isPrime(a[i])) continue;
       for (int j = i+1; j < 7; j++) {
            // cout << a[i] << " " << a[j] << nl;
            
            ll here = llabs(a[i]-a[j]);
            // cout << here <<nl;
           if (isPrime(here)) {
               adj[i].push_back(j);
               adj[j].push_back(i);
           }
       }
   }
   ans.push(0);
   dfs(0);
//    for (bool b: vis) {
//        cout << b << nl;
//    }
   if (vis[5]) {
       cout << ans.size() << nl;
       stack<ll> last;
       while (!ans.empty()) {
        //    cout << a[ans.top()] << " ";
        //    ans.pop();
        last.push(ans.top()); ans.pop();
       }
       while (!last.empty()) {
           cout << a[last.top()] << " "; last.pop();
           ans.pop();
       }
       cout << nl;
   }
   else {
       cout << -1 << nl;
   }

}
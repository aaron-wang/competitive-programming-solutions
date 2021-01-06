#include <bits/stdc++.h>
#define pb push_back
using namespace std;
using ll=long long; constexpr char nl = '\n';using vi=vector<int>;
const int MM =1e5+5;
const int RR = 10, CC = 9;
int a[112],f[112];
vector<int> adj[112];
bool vis[112], undef[112], def[112];
void eval(int s, int rt) {
    if(def[s]) return;
    for (auto x: adj[s]) {
        eval(x,rt);
    }
    def[s] =true;
    for (auto x: adj[s]) {
        f[s] += f[x];
    }
    
}
void check(int s, int rt) {
    if (vis[s]) return;
    vis[s] = true;
    for (auto x: adj[s]) {
        if (undef[x]) undef[rt] = true;
        check(x,rt);
    }
}
void dfs(int s,int rt) {
    if (vis[s]) return;
    vis[s] = true;
    for (auto x: adj[s]) {
        if (x == rt) undef[rt] = true;
        dfs(x,rt);
    }
}
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    // freopen("in.txt","r",stdin);
    // freopen("out.txt","w",stdout);
    //A-J = row (1-10)
    //1-9 = col
    //A1 A2 A3. ... A9
    //B1 ...
    //...
    //J1.         J9
    //10 row, 9 col
    //'a'-'a'+1
    //'j'-'a'+1 = 10
    for (int i = 1; i <= RR; i++) {
        for (int j = 1; j <= CC;j ++) {
            string str; cin >> str;
            if (isalpha(str[0])) {
                int here= 10*i+j;
                vector<string> temp;
                stringstream ss(str);
                string st;
                while (getline(ss,st,'+')) {
                    temp.pb(st);
                }
                for (auto x: temp) {
                    int curr = 10*(x[0]-'A'+1) + (x[1]-'0');
                    adj[here].pb(curr);
                }
            }
            else {
                a[10*i+j] = stoi(str);
                f[10*i+j]=a[10*i+j];
                def[10*i+j]=true;
            }
        }
    }
    for (int i = 1; i <=RR; i++) {
        for (int j = 1; j <=CC; j++) {
            //dfs, check if the path reaches the root again
            memset(vis,false,sizeof(vis));
            dfs(10*i+j,10*i+j);   
        }
    }
    for (int i =1 ; i <= RR; i++) {
        for (int j = 1; j <= CC;j++) {
            memset(vis,false,sizeof(vis));
            check(10*i+j,10*i+j);
            // cout << (undef[10*i+j] ? "y" :"n")<<" ";
        }
        // cout<<nl;
    }
    for (int i = 1; i <=RR;i ++) {
        for (int j = 1;j<=CC;j++) {
            if (!undef[10*i+j]) {
                // for (auto x: adj[10*i+j]) {
                //     a[10*i+j] += a[x];
                // }
                eval(10*i+j,10*i+j);
                cout << f[10*i+j] << " ";
                def[10*i+j]=true;
            }
            else {
                cout << "* ";
            }
        }cout << nl;
    }
}
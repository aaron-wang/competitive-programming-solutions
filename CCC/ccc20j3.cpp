// #include <bits/stdc++.h>
#include <iostream>
#include <vector>
#define pb push_back
using namespace std;
using ll = long long; constexpr char nl = '\n';
int main() {
    cin.sync_with_stdio(false); cin.tie(0);
    int n; cin >> n;
    int minx,miny;
    minx=miny= 10000;
    int maxx,maxy;
    maxx=maxy=0;
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        int x = s.find(',');
        int X = stoi(s.substr(0,x));
        int Y = stoi(s.substr(x+1,n-x-1));
        maxx = max(maxx,X);
        maxy = max(maxy,Y);
        miny = min(miny,Y);
        minx = min(minx,X);
    }
    cout << --minx << "," << --miny << nl;
    cout << ++maxx << "," << ++maxy << nl;
}
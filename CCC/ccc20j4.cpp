#include <bits/stdc++.h>
using namespace std;
int main() {
    string T,S; cin >> T >> S;
    for (int i = 0; i < S.length(); i++) {
        if (T.find(S) == string::npos) S = S.substr(1) + S.at(0);
        else {
            cout << "yes\n"; 
            return 0;
        }
    }
    cout << "no\n";
}
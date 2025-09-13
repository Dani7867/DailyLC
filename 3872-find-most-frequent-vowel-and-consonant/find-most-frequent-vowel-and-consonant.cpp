class Solution {
public:
    int maxFreqSum(string s) {
        unordered_map<char, int> vowels;
        unordered_map<char, int> c;

        for (auto x : s) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowels[x]++;
            } else {
                c[x]++;
            }
        }

        int v = 0;
        for (auto x : vowels) {
            if (x.second > v) {
                v = x.second;
            }
        }
        int cc = 0;

        for (auto x : c) {
            if (x.second > cc) {
                cc = x.second;
            }
        }

        return cc + v;
    }
};
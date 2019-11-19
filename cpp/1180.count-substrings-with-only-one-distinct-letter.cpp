class Solution {
public:
    int countLetters(string S) {
        char seen = ' ';
        int count = 0;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S[i];
            if (c != seen) {
                ans += allSubstringNum(count);
                seen = c;
                count = 1;
                
            } else{
                count++;
            }
        }
        ans += allSubstringNum(count);
        return ans;
    }
private:
    int allSubstringNum(int n) {
        return n * (n + 1) / 2;
    }
};
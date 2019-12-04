class Solution {
public:
    int shortestWay(string source, string target) {

        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < target.size()) {
            int nextJ = match(source, target, j);
            if (j != nextJ) {
                ans++;
            } else {
                return -1;
            }
            j = nextJ;
            // printf("%d", j);
        }
        return ans;
        
    }
private:
    int match(string source, string target, int startIndex) {
        int j = startIndex;
        for (int i = 0; i < source.size(); i++) {
            if (j == target.size()) {
                return j;
            }
            if (source.at(i) == target.at(j)) {
                j++;
            }
        }
        return j;
    }
};
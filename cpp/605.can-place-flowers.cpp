class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        // plant as left as possible
        int count = 0;
        for (int i = 0; i < flowerbed.size(); i++) {
            int left = max(i - 1, 0);
            int right = min(i + 1, ((int) flowerbed.size() - 1));
            if (flowerbed[i] == 0 && flowerbed[left] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
};
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
    // 1 - 1
    // 2 - 10
    // 4 - 100
}
class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int ans = 0;
        // i <= j
        // B <= A
        for (int i = 1; i <= 120; i++) {
            for (int j = i; j<= 120; j++) {
                if (i <= 0.5 * j + 7) {
                    continue;
                } 
                if (i > 100 && j < 100) {
                    continue;
                }
                int sum = i == j ? count[i] * (count[i] - 1) : count[i] * count[j];
                ans += sum;
            }
        }
        return ans;
    }
}

// age[B] <= 0.5 * age[A] + 7
// age[B] > age[A]
// age[B] > 100 && age[A] < 100
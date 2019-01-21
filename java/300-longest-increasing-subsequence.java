class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        Arrays.fill(tails, Integer.MAX_VALUE);
        // tails[0] = Integer.MIN_VALUE;
        for (int num : nums) {
            int index = findFirstLargerOrEquals(tails, num);
            tails[index] = num;
        }
        int ans = tails.length - 1;
        for (; ans >= 0; ans--) {
            if (tails[ans] != Integer.MAX_VALUE) {
                return ans + 1;
            }
        }
        return 0;
    }
    private int findFirstLargerOrEquals(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
 
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] >= target) {
            return end;
        }
        return end + 1;
    }
}
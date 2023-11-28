use std::cmp;

impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        let len = nums.len();
        let mut dp = vec![i32::MAX; len];
        dp[len - 1] = 0;
        for i in (0..(len - 1)).rev() {
            let step = nums[i];
            let mut min_cost = i16::MAX as i32;
            for j in 1..(step + 1) {
                let index = cmp::min(i + j as usize, len - 1);
                let cost = dp[index] + 1;
                // println!("{}", cost);
                min_cost = cmp::min(min_cost, cost);
            }
            dp[i] = min_cost;
        }
        // println!("{:?}", dp);
        return dp[0];
    }
}

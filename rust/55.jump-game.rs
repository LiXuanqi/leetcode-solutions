use std::cmp;

impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let len = nums.len();
        let mut reachable = vec![false; len];
        reachable[0] = true;
        for i in 0..len {
            if reachable[i] {
                for step in 1..(nums[i] + 1) {
                    let next = cmp::min(i + step as usize, len - 1);
                    reachable[next] = true;
                }
            }
        }
        return reachable[len - 1];
    }
}

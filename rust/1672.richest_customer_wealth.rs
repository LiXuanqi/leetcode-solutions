use std::cmp;

impl Solution {
    pub fn maximum_wealth(accounts: Vec<Vec<i32>>) -> i32 {
        let mut max = 0;
        for account in accounts.iter() {
            let total = account.iter().sum();
            max = cmp::max(max, total);
        }
        max
    }
}

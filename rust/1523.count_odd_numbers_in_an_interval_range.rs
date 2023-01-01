impl Solution {
    pub fn count_odds(low: i32, high: i32) -> i32 {
        if low > high {
            return 0;
        }
        if low % 2 == 0 {
            return Self::count_odds(low + 1, high);
        }
        if high % 2 != 0 {
            return 1 + Self::count_odds(low, high - 1);
        }
        return (high - low + 1) / 2;
    }
}

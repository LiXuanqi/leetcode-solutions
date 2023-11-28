use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for (index, num) in nums.iter().enumerate() {
            let need = target - num;
            match map.get(&need) {
                Some(another_index) => return vec![*another_index, index as i32],
                None => map.insert(num, index as i32),
            };     
        }
        return vec![];
    }
}

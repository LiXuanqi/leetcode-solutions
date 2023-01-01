impl Solution {
    pub fn maximum_units(mut box_types: Vec<Vec<i32>>, mut truck_size: i32) -> i32 {
        box_types.sort_unstable_by_key(|k| std::cmp::Reverse(k[1]));
        let mut ans = 0;
        for box_type in box_types.iter() {
            let num_box = box_type[0];
            let num_unit = box_type[1];
            if truck_size >= num_box {
                truck_size -= num_box;
                ans += (num_unit * num_box);
            } else {
                ans += (truck_size * num_unit);
                return ans;
            }
        }
        return ans;
    }
}

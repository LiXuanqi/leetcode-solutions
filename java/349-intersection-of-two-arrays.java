class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> ans = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(Number::intValue).toArray();
    }
}
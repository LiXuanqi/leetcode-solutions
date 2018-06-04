class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] <= nums2[n - 1]) {
                nums1[total] = nums2[n - 1];
                n--;
            } else {
                nums1[total] = nums1[m - 1];
                m--;
            }
            total--;
        }
        while (m > 0) {
            nums1[total] = nums1[m - 1];
            m--;
            total--;
        }
        while (n > 0) {
            nums1[total] = nums2[n - 1];
            n--;
            total--;
        }
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = n + m;
        if (k % 2 == 0) {
            System.out.println(findKth(nums1, nums2, k / 2));
            System.out.println(findKth(nums1, nums2, k / 2 + 1));
            
            return (findKth(nums1, nums2, k / 2) + findKth(nums1, nums2, k / 2 + 1)) / 2.0;
        }
        
        return findKth(nums1, nums2, k / 2 + 1);
    }
    private int findKth(int[] A, int[] B, int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }
        int low = Math.min(A[0], B[0]);
        int high = Math.max(A[A.length - 1], B[B.length - 1]);
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            System.out.println("A: " + countSmallerOrEqual(A, mid));
            System.out.println("B: " + countSmallerOrEqual(B, mid));
            // why find first mid 
            if (countSmallerOrEqual(A, mid) + countSmallerOrEqual(B, mid) >= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (countSmallerOrEqual(A, low) + countSmallerOrEqual(B, low) >= k) {
            return low;
        }
        return high;
   
    }
    private int countSmallerOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // find first num > target
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] > target) {
            return left;
        }
        if (nums[right] > target) {
            return right;
        }
        return nums.length;
    }
}
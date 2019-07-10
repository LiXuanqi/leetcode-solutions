class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums = set(nums1)
        ans = set()
        for num in nums2:
            if num in nums:
                ans.add(num)
        return list(ans)
        
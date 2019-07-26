class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        nums_map = {}
        for num in arr1:
            nums_map[num] = nums_map.get(num, 0) + 1
        
        ans = []
        for num in arr2:
            if num in nums_map:
                times = nums_map.pop(num)
                ans.extend([num] * times)
        rest_nums = sorted(nums_map.keys())
        for key in rest_nums:
            ans.extend([key] * nums_map[key])
        
        return ans
            
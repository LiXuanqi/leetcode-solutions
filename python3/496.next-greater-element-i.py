class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        next_greaters = {}
        
        stack = []
        
        for index, num in enumerate(nums2):
            while stack and num > nums2[stack[-1]]:
                last_index = stack.pop()
                next_greaters[nums2[last_index]] = num
            
            stack.append(index)
            
            
        ans = []
        for num in nums1:
            ans.append(next_greaters[num] if num in next_greaters else -1)
            
        return ans
        

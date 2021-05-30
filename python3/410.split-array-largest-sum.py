class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        
        prefix_sums = [0]
        curr_sum = 0
        for num in nums:
            curr_sum += num
            prefix_sums.append(curr_sum)
        
        left = 0
        right = sum(nums)
        
        while left + 1 < right:
            mid = (left + right) // 2
            if is_valid(prefix_sums, mid, m):
                right = mid
            else:
                left = mid
        if is_valid(prefix_sums, left, m):
            return left
        return right
    
def is_valid(prefix_sums, max_sum, m):
    curr_index = 0
    group = 0
    # print(prefix_sums, max_sum, m)
    while curr_index < len(prefix_sums) - 1:
        next_sum = prefix_sums[curr_index] + max_sum
        # 0 2 4 6 6 6 
        # print(curr_index)
        curr_index = bisect.bisect_right(prefix_sums, next_sum) - 1
        # print(curr_index)
        
        group += 1
        if group > m:
            return False
       
    return group <= m
    
    
        
        

class Solution:
    def threeSumSmaller(self, nums: 'List[int]', target: 'int') -> 'int':
        if not nums or len(nums) < 3:
            return 0
        nums.sort()
        ans = 0
        for index, num in enumerate(nums):
            ans += twoSum(num, target, index, nums)
        return ans
def twoSum(num, target, start, nums):
    if start >= len(nums) - 2:
        return 0
    # num + wanted < target
    wanted = target - num
    left = start + 1
    right = len(nums) - 1
    count = 0
    while left < right:
        sum = nums[left] + nums[right]
        if sum < wanted:
            count += right - left
            left +=1
        else:
            right -= 1
    return count
        
    
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        tails = []
        for num in nums:
            index = bisect.bisect_left(tails, num)
        
            if index == len(tails):
                tails.append(num)
            else:
                tails[index] = num

            if len(tails) == 3:
                return True
        return False
        

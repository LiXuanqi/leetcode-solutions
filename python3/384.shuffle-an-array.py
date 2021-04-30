class Solution:

    def __init__(self, nums: List[int]):
        self.origin = nums.copy()
        self.data = nums.copy()
        

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        return self.origin
        

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        n = len(self.data)
        for i in range(n - 1, 0, -1):
            j = random.randint(0, i)
            # swap
            temp = self.data[i]
            self.data[i] = self.data[j]
            self.data[j] = temp
        return self.data
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()

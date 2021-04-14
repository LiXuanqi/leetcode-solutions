class Solution:
    def numDifferentIntegers(self, word: str) -> int:
        nums = re.sub("[a-zA-Z]+", " ", word).split()
        return len(set(int(num) for num in nums))
        
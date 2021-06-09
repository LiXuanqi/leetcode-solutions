class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counter = Counter(arr)
        frequencies = counter.values()
        return len(frequencies) == len(set(frequencies))

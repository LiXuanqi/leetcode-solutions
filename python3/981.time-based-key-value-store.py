class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = collections.defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        
        self.data[key].append((timestamp, value))
    
        # print(self.data)

    def get(self, key: str, timestamp: int) -> str:
        candidates = self.data[key]

        if not candidates:
            return ""
        index = self._find_the_first_index_less_or_equal_timestamp(timestamp, candidates)
        # print(index)
        if index is None:
            return ""
        return candidates[index][1]
        
    def _find_the_first_index_less_or_equal_timestamp(self, target_timestamp, candidates):
        left = 0
        right = len(candidates) - 1
        while left + 1 < right:
            mid = (left + right) // 2
            if candidates[mid][0] == target_timestamp:
                return mid
            elif candidates[mid][0] < target_timestamp:
                left = mid
            else: 
                right = mid
        if candidates[right][0] <= target_timestamp:
            return right
        elif candidates[left][0] <= target_timestamp:
            return left
        return None
            
        


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)


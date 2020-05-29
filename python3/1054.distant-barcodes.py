class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        counter = collections.Counter(barcodes)
        index = 0
        ans = [None] * len(barcodes) 
        for k, v in counter.most_common():
            for _ in range(v):
                ans[index] = k
                index += 2
                if index >= len(ans):
                    index = 1
        return ans
            
        
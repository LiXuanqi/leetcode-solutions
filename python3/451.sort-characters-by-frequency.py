class Solution:
    def frequencySort(self, s: str) -> str:
        counter = Counter(s)
        pairs = sorted([(v, k) for k, v in counter.items()], reverse=True)
       
        ans = []
        for frequency, c in pairs:
            ans += [c] * frequency
            
        return ''.join(ans)

class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        dp = {}
  
        for word in sorted(words, key=len):
            # consider remove 1 word.
            curr_max = 0
            for i in range(len(word)):
                word_after_deletion = word[:i] + word[i + 1:]
                curr_max = max(curr_max, dp.get(word_after_deletion, 0) + 1)
            
            dp[word] = curr_max

        return max(dp.values())
        

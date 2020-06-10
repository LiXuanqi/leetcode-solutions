class Solution:
    def arrangeWords(self, text: str) -> str:
        words = text.split(' ')
        words[0] = words[0][0].lower() + words[0][1:]
        words = sorted(words, key=lambda w: len(w))
        ans = ' '.join(words)
        return ans[0].upper() + ans[1:]
        
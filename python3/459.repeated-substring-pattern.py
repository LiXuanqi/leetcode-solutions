class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        for end in range(len(s) - 1):
            pattern = s[:end + 1]
            # - repeat pattern
            if len(s) % len(pattern) == 0:
                time = len(s) // len(pattern)
                if s == pattern * time:
                    return True
        return False
        
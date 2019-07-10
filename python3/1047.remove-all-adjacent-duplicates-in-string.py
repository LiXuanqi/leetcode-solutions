class Solution:
    def removeDuplicates(self, S: str) -> str:
        if not S:
            return ""
        S = list(S)
        slow = 0
        fast = 0
        while fast < len(S):
            character = S[fast]
            if slow > 0 and S[slow - 1] == character:
                slow -= 1
            else:
                S[slow] = character
                slow += 1
            fast += 1
        return "".join(S[:slow])

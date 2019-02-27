class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        m = dict()
        for i in range(len(s) - 9):
            target = s[i: i + 10]
            m[target] = m.get(target, 0) + 1
        return [k for k, v in m.items() if v > 1]
           
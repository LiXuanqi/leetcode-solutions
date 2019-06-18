class Solution:
    def calPoints(self, ops: List[str]) -> int:
        if not ops:
            return 0
        slow = 0
        fast = 0
        while fast < len(ops):
            op = ops[fast]
            if slow > 1 and op == "+":
                ops[slow] = ops[slow - 1] + ops[slow - 2]
                slow += 1
            elif slow > 0 and op == "D":
                ops[slow] = 2 * ops[slow - 1]
                slow += 1
            elif op == "C":
                slow -= 1
            else:
                ops[slow] = int(op)
                slow += 1
            fast += 1
        return sum(ops[:slow])

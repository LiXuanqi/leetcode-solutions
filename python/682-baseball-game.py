class Solution:
    def calPoints(self, ops: List[str]) -> int:
        if not ops:
            return 0
        valids = []
        for op in ops:
            if op == "C" and valids:
                valids.pop() 
            elif op == "D":
                valids.append(valids[-1] * 2)
            elif op == "+" and len(valids) >= 2:
                valids.append(valids[-2] + valids[-1]) 
            else:
                valids.append(int(op))
        return sum(valids)

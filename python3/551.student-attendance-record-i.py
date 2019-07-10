class Solution:
    def checkRecord(self, s: str) -> bool:
        if not s:
            return True
        absent = False
        continuousLate = 0
        for day in s:
            if day == "A":
                continuousLate = 0
                if absent:
                    return False
                else:
                    absent = True
            elif day == "L":
                continuousLate += 1
                if continuousLate > 2:
                    return False
            elif day == "P":
                continuousLate = 0
        return True
            
        
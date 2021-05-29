class Solution:
    def canConvert(self, str1: str, str2: str) -> bool:
        if str1 == str2:
            return True
        mapping = {}
        for i, j in zip(str1, str2):
            if i in mapping and mapping[i] != j:
                return False
            mapping[i] = j
    
        return len(set(str2)) < 26
                
        

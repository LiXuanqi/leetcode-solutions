class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        if not strings:
            return []
        map = {}
      
        
        def moveToOrigin(word):
            diff = ord(word[0]) - ord('a')
            sb = []
            for c in word:
                index = ord(c) - diff
                if index < ord('a'):
                    index += 26
                sb.append(chr(index))
            return "".join(sb)
            
        for word in strings:
            origin = moveToOrigin(word)
            map.setdefault(origin, []).append(word)
            
        return list(map.values())
        
         
        
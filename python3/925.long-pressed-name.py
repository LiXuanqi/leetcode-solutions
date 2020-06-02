class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        index = 0
        for c in typed:
            if index < len(name) and c == name[index]:
                index += 1
            elif index > 0 and c == name[index-1]:
                continue
            else:
                return False
        return index == len(name)
        
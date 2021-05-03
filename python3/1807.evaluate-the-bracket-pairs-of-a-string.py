class Solution:
    def evaluate(self, s: str, knowledge: List[List[str]]) -> str:
        knowledge_map = {k: v for k, v in knowledge}
        ans = ''
        pattern = ''
        is_in_parenthesee = False
        for c in s:
            if c == '(':
                pattern = ''
                is_in_parenthesee = True
            elif c == ')':
                ans += knowledge_map.get(pattern, '?')
                is_in_parenthesee = False
            else:
                pattern += c
                if not is_in_parenthesee:
                    ans += c
        return ans
            
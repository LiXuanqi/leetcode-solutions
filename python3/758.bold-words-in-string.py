class Solution:
    def boldWords(self, words: List[str], S: str) -> str:
        n = len(S)
        need_bold = [False] * n
        
        for word in words:
            mark_bold_word(word, S, need_bold)
        
        return bold_word(S, need_bold)
    
def mark_bold_word(word, S, need_bold):
    width = len(word)
    for i in range(len(S) - width + 1):
        if S[i: i + width] == word:
            need_bold[i: i + width] = [True] * width
            
        
def bold_word(S, need_bold):
    ans = ''
    curr_bold_text = ''
    for index, c in enumerate(S):
        if need_bold[index]:
            curr_bold_text += c
        else:
            if curr_bold_text != '':
                ans += (f'<b>{curr_bold_text}</b>')
            curr_bold_text = ''
            ans += c
            
    if curr_bold_text != '':
        ans += (f'<b>{curr_bold_text}</b>')
    return ans
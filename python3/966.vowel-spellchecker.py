class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        word_set = set(wordlist)
        caplizations = {}
        vowels = {}
        for word in wordlist:
            cap = word.lower()
            devowel = re.sub('[aeiou]', '.', cap)
            if cap not in caplizations:
                caplizations[cap] = word
            if devowel not in vowels:
                vowels[devowel] = word
        ans = []
        for query in queries:
            cap = query.lower()
            devowel = re.sub('[aeiou]', '.', cap)
  
            if query in word_set:
                ans.append(query)
            elif cap in caplizations:
                ans.append(caplizations[cap])
            elif devowel in vowels:
                ans.append(vowels[devowel])
            else:
                ans.append('')
                
        return ans

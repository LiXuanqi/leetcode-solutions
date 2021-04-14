# """
# This is Master's API interface.
# You should not implement it, or speculate about its implementation
# """
# class Master:
#     def guess(self, word: str) -> int:
import random

SECRET_WORD_LENGTH = 6

class Solution:
    def findSecretWord(self, wordlist: List[str], master: 'Master') -> None:
        while wordlist:
            random_word = random.choice(wordlist)
            similarity = master.guess(random_word)
            
            if similarity == SECRET_WORD_LENGTH:
                return
            
            candidate_words = []
            
            for word in wordlist:
                if calculate_similarity(word, random_word) == similarity:
                    candidate_words.append(word)
                    
            wordlist = candidate_words
        
def calculate_similarity(word_1, word_2):
    similarity = 0
    for i in range(len(word_1)):
        if word_1[i] == word_2[i]:
            similarity += 1
    return similarity

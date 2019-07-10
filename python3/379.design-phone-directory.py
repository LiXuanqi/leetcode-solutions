class PhoneDirectory:

    def __init__(self, maxNumbers: int):
        """
        Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory.
        """
        self.availables = collections.deque()
        self.directories = set()
        for i in range(maxNumbers):
            self.availables.append(i)

    def get(self) -> int:
        """
        Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available.
        """
        if not self.availables:
            return -1
        number = self.availables.pop()
        self.directories.add(number)
        return number
        

    def check(self, number: int) -> bool:
        """
        Check if a number is available or not.
        """
        return number not in self.directories
        

    def release(self, number: int) -> None:
        """
        Recycle or release a number.
        """
        if number in self.directories:
            self.directories.remove(number)
            self.availables.append(number)
        


# Your PhoneDirectory object will be instantiated and called as such:
# obj = PhoneDirectory(maxNumbers)
# param_1 = obj.get()
# param_2 = obj.check(number)
# obj.release(number)
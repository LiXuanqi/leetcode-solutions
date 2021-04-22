class ProductOfNumbers:

    def __init__(self):
        self.prefix_product = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.prefix_product = [1]
        else:
            self.prefix_product.append(self.prefix_product[-1] * num)

        

    def getProduct(self, k: int) -> int:
        if k + 1 > len(self.prefix_product):
            return 0
        return self.prefix_product[-1] // self.prefix_product[-1 - k]
        


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)

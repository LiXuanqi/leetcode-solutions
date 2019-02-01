class Solution:
    def constructRectangle(self, area):
        """
        :type area: int
        :rtype: List[int]
        """
        half = math.ceil(math.sqrt(area))
        while area % half != 0:
            half += 1
        return [half, area // half]
BIG = 1
MEDIUM = 2
SMALL = 3

class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.parking_lots = {
            BIG: big,
            MEDIUM: medium,
            SMALL: small
        }

    def addCar(self, carType: int) -> bool:
        can_park = self.parking_lots[carType] > 0
        
        if can_park:
            self.parking_lots[carType] -= 1
        
        return can_park


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)
DIRECTIONS = {
    'U': (-1, 0),
    'D': (1, 0),
    'L': (0, -1),
    'R': (0, 1)
}

class SnakeGame:

    def __init__(self, width: int, height: int, food: List[List[int]]):
        """
        Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
        """
        self.width = width
        self.height = height
        
        self.food = food
        self.curr_food_index = 0
        
        self.snake = collections.deque()
        self.snake.append((0, 0))
        self.snake_set = {(0, 0)}
        self.score = 0
        
        

    def move(self, direction: str) -> int:
        """
        Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body.
        """
        x, y = self.snake[-1]
        diff_x, diff_y = DIRECTIONS[direction]
        next_x = x + diff_x
        next_y = y + diff_y
        next_point = (next_x, next_y)
        
        # move tail
        tail = self.snake.popleft() 
        self.snake_set.remove(tail)
        
        if not self.in_bound(next_x, next_y) or next_point in self.snake_set:
            return -1
        
        curr_food = self.food[self.curr_food_index] if self.curr_food_index < len(self.food) else None
        
        # move head
        self.snake.append(next_point)
        self.snake_set.add(next_point)
        
        if curr_food and next_point == tuple(curr_food):
            self.curr_food_index += 1
            self.score += 1
            self.snake.appendleft(tail)
            self.snake_set.add(tail)
 
       
        return self.score
            
    def in_bound(self, x, y):
        return 0 <= x < self.height and 0 <= y < self.width


# Your SnakeGame object will be instantiated and called as such:
# obj = SnakeGame(width, height, food)
# param_1 = obj.move(direction)

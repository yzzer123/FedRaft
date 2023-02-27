

class Dog:
    
    def __init__(self, name: str) -> None:
        self.name = name
        
    def greet(self):
        print(f"Hello I'm {self.name}")
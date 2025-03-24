# Lab 5.4
# findNumbers.py

def find_numbers(numbers):
    # Validate input is a list
    if not isinstance(numbers, list):
        raise ValueError("Input should be a list of numbers")
    
    result = []
    for num in numbers:
        # Validate each element is a number (int or float)
        if not isinstance(num, (int, float)) or isinstance(num, bool):
            raise ValueError("Each item in the list should be a number")
            
        if num > 0:
            result.append("positive")
        elif num < 0:
            result.append("negative")
        else:
            result.append("zero")
    return result

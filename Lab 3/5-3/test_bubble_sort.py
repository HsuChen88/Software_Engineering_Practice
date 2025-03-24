# test_bubble_sort.py
import pytest
from bubble_sort import bubble_sort

def test_bubble_sort():
    """Test sorting an empty array."""
    assert bubble_sort([]) == []

    """Test sorting an array with a single element."""
    assert bubble_sort([42]) == [42]

    """Test sorting an array with two elements already sorted."""
    assert bubble_sort([1, 2]) == [1, 2]

    """Test sorting an array with two elements that need sorting."""
    assert bubble_sort([2, 1]) == [1, 2]

    """Test sorting an array that is already sorted."""
    assert bubble_sort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]

    """Test sorting an array that is sorted in reverse order."""
    assert bubble_sort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]

    """Test sorting an array with duplicate elements."""
    assert bubble_sort([3, 1, 4, 1, 5, 9, 2, 6, 5]) == [1, 1, 2, 3, 4, 5, 5, 6, 9]

    """Test sorting an array with negative numbers."""
    assert bubble_sort([-3, -1, -4, -1, -5]) == [-5, -4, -3, -1, -1]

    """Test sorting an array with a mix of positive and negative numbers."""
    assert bubble_sort([3, -1, 0, 4, -5, 2]) == [-5, -1, 0, 2, 3, 4]

    """Test sorting a larger array."""
    # Create an array with 100 elements in reverse order
    large_array = list(range(100, 0, -1))
    expected = list(range(1, 101))
    assert bubble_sort(large_array) == expected

    """Test sorting an array that includes zero."""
    assert bubble_sort([5, 0, 3, 0, 1]) == [0, 0, 1, 3, 5]

    """Test sorting an array with floating-point values."""
    assert bubble_sort([3.14, 1.0, 2.71, 0.5]) == [0.5, 1.0, 2.71, 3.14]

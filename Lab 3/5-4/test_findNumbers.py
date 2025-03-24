import pytest
from findNumbers import find_numbers
def test_find_numbers_basic():
    assert find_numbers([1, -1, 0]) == ['positive', 'negative', 'zero']

# Boundary test cases
def test_empty_list():
    assert find_numbers([]) == []

def test_very_large_numbers():
    assert find_numbers([float('inf'), -float('inf')]) == ['positive', 'negative']

def test_very_small_numbers():
    assert find_numbers([1e-10, -1e-10, 0]) == ['positive', 'negative', 'zero']

def test_floating_point_precision():
    # Testing numbers very close to zero
    assert find_numbers([0.0000001, -0.0000001]) == ['positive', 'negative']

# Negative test cases
def test_find_numbers_invalid_input_type():
    with pytest.raises(ValueError) as error:
        find_numbers(123)
    assert str(error.value) == "Input should be a list of numbers"

def test_find_numbers_invalid_input_string():
    with pytest.raises(ValueError) as error:
        find_numbers("not a list")
    assert str(error.value) == "Input should be a list of numbers"

def test_find_numbers_invalid_input_none():
    with pytest.raises(ValueError) as error:
        find_numbers(None)
    assert str(error.value) == "Input should be a list of numbers"

def test_find_numbers_invalid_list_string():
    with pytest.raises(ValueError) as error:
        find_numbers([1, "string", 3])
    assert str(error.value) == "Each item in the list should be a number"

def test_find_numbers_invalid_list_none():
    with pytest.raises(ValueError) as error:
        find_numbers([1, None, 3])
    assert str(error.value) == "Each item in the list should be a number"

def test_find_numbers_invalid_list_empty_list():
    with pytest.raises(ValueError) as error:
        find_numbers([1, [], 3])
    assert str(error.value) == "Each item in the list should be a number"

def test_find_numbers_nested_lists():
    with pytest.raises(ValueError) as error:
        find_numbers([1, [2, 3], 4])
    assert str(error.value) == "Each item in the list should be a number"

def test_find_numbers_complex_numbers():
    with pytest.raises(ValueError) as error:
        find_numbers([1, 2+3j, 4])
    assert str(error.value) == "Each item in the list should be a number"

def test_find_numbers_boolean_values():
    with pytest.raises(ValueError) as error:
        find_numbers([True, False, 1])
    assert str(error.value) == "Each item in the list should be a number"

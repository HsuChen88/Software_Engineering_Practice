# Lab 4.1
# test_calculateDiscounts.py
from calculateDiscounts import calculate_discounts
import pytest

def test_calculate_discounts():
    prices = [120, 80, 70, 30, 50]
    membership_levels = ['Gold', 'Gold', 'Silver', 'Silver', 'Bronze']
    expected_discounted_prices = ['96.00', '72.00', '59.50', '28.50', '50.00']

    result = calculate_discounts(prices, membership_levels)

    assert result == expected_discounted_prices

def test_calculate_discounts_empty_input():
    with pytest.raises(Exception) as error:
        a=[]
        b=[]
        result = calculate_discounts(a,b)
    assert str(error.value) == "Prices and membership levels must be provided as non-empty lists."
    

def test_calculate_discounts_different_length():
    with pytest.raises(Exception) as error:
        a=[10, 20]
        b=['Gold']
        result = calculate_discounts(a,b)
    assert str(error.value) == "Prices and membership levels lists must have the same length."
    
def test_calculate_discounts_discounted_price_above_ten():
    prices = [15]  # A small price that will result in discounted price >= 10
    membership_levels = ['Silver']  # Silver membership with price < 50 gets 5% discount
    expected_discounted_prices = ['14.25']  # 15 - (15 * 0.05) = 14.25

    result = calculate_discounts(prices, membership_levels)
    assert result == expected_discounted_prices

def test_calculate_discounts_discounted_price_below_ten():
    prices = [9]  # A small price that will result in discounted price < 10
    membership_levels = ['Bronze']  # Bronze membership with price < 50 gets 0% discount
    expected_discounted_prices = ['9.00']  # 9 - (9 * 0) = 9

    result = calculate_discounts(prices, membership_levels)
    assert result == expected_discounted_prices



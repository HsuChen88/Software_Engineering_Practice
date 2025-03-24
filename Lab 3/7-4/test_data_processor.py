from data_processor import process_and_store_data
from unittest import mock

@mock.patch('data_processor.Database')
def test_process_and_store_data(MockDataBase):
    # Get the mock database instance
    mock_db_instance = MockDataBase.return_value
    
    # Configure mock to return [1,2,3] when get_all_data is called
    mock_db_instance.get_all_data.return_value = [1,2,3]

    # Call the function under test with input value 4
    result = process_and_store_data(4)

    # Verify insert_data was called once with value 4
    mock_db_instance.insert_data.assert_called_once_with(4)

    # Verify get_all_data was called once
    mock_db_instance.get_all_data.assert_called_once()

    # Verify the result is the sum of the mock data (1+2+3=6)
    assert result == 6

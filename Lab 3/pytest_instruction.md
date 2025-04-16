# Pytest 使用說明

## 1. 基本目錄與命名規則

為了讓 `pytest` 自動識別測試：

- 測試檔案需以 `test_*.py` 或 `*_test.py` 命名
- 測試函數需以 `test_` 開頭
- 類別名稱建議以 `Test` 開頭，且不加 `__init__`

範例目錄：
```
project/
├── mycode.py
├──tests (不加也可以)
|   └── test_mycode.py
```

---

## 2. 基本範例

**原始程式 (mycode.py)：**
```python
def add(a, b):
    return a + b
```

**測試程式 (test_mycode.py)：**
```python
from mycode import add

def test_add():
    assert add(2, 3) == 5
```

**執行測試：**
```bash
pytest
```

---

## 3.`assert` 語法

`pytest` 會自動解析 `assert` 失敗的原因，並顯示對比內容：

```python
def test_string():
    s = "hello"
    assert s.upper() == "HELLO"
    assert s.isupper() == False
```

---

## 4. 進階功能介紹

### 1. **Fixture（測試前置/後置）**
可以設定初始化資料、清理資源等。

```python
import pytest

@pytest.fixture
def sample_data():
    return {"a": 1, "b": 2}

def test_use_fixture(sample_data):
    assert sample_data["a"] == 1
```

---

### 2. **參數化（Parameterized Testing）**

```python
import pytest

@pytest.mark.parametrize("a,b,expected", [
    (1, 2, 3),
    (3, 4, 7),
    (5, 5, 10),
])
def test_add(a, b, expected):
    assert a + b == expected
```

---

### 3. **例外測試**

```python
import pytest

def div(a, b):
    return a / b

def test_div_zero():
    with pytest.raises(ZeroDivisionError):
        div(1, 0)
```

---

### 4. **測試類別**

```python
class TestMath:

    def test_add(self):
        assert 1 + 1 == 2

    def test_sub(self):
        assert 5 - 3 == 2
```

---

## 5. 常用指令

| 指令 | 說明 |
|------|------|
| `pytest` | 執行所有測試 |
| `pytest test_file.py` | 執行指定檔案 |
| `pytest -k "substring"` | 執行包含特定名稱的測試 |
| `pytest -m "tag"` | 執行標記為某 tag 的測試 |
| `pytest -x` | 執行到第一個錯誤就停止 |
| `pytest --maxfail=2` | 錯誤達到 2 次就停止 |
| `pytest -v` | 顯示詳細資訊 |
| `pytest --tb=short` | 顯示簡短的 traceback |
| `pytest --disable-warnings` | 關閉警告 |

---

## 6. 標記（Markers）

自訂標記可以分類測試用例。

```python
import pytest

@pytest.mark.slow
def test_big_data():
    ...
```

**使用指定標記執行：**
```bash
pytest -m slow
```

**註冊自訂標記（pytest.ini）：**
```ini
[pytest]
markers =
    slow: mark test as slow
```

---

## 7. 輸出報告

### 1. **產生 JUnit XML 報告**
```bash
pytest --junitxml=report.xml
```

### 2. **與 `pytest-html` 搭配產生 HTML 報告**
```bash
pip install pytest-html
pytest --html=report.html
```

---

## 8. 常用插件
`pip install <插件名稱>`

| 插件 | 說明 | 使用說明 |
|------|------|------|
| `pytest-cov` | 顯示程式碼覆蓋率 |  |
| `pytest-mock` | 整合 mock 功能 |  |
| `pytest-django` | 專為 Django 的測試套件 |  |
| `pytest-asyncio` | 支援 async 測試 |  |
| `pytest-xdist` | 平行測試，提高效能 |  |

---

## 9. 整合 Coverage (程式碼覆蓋率)

```bash
pip install pytest-cov
pytest --cov
```

也可以產生報告：
```bash
pytest --cov --cov-report=html
```

---

## 10. 偵錯工具

搭配 `pdb` 使用：

```python
def test_debug():
    import pdb; pdb.set_trace()
    assert 1 == 2
```

---

## 11. 測試前後執行的 hook

```python
def setup_module(module):
    print("setup before all tests in module")

def teardown_module(module):
    print("teardown after all tests in module")
```

---

## 12. 與 CI/CD 整合（例如 GitHub Actions）

```yaml
# .github/workflows/python-tests.yml
name: Python Tests

on: [push]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-python@v4
        with:
          python-version: '3.10'
      - run: pip install -r requirements.txt
      - run: pytest --cov=your_module
```

---

## 13. Pytest 和 Unittest 哪個更好?

Unittest 是 python 內定設置的測試框架。\
在 Unittest 中,我們創建一個從 unittest.TestCase 模組產生的類別,然後在類別中定義測試函數。

而使用 Pytest，我們只需定義函數並 assert 其中的條件。

> 雖然這兩個框架都非常適合在 Python 中執行測試，但 Pytest 與 Unittest 相比，需要更少的程式碼，更容易使用。

## Homework 4
> 110303527 鄭旭辰

## 如何編譯

若只存在`*.c`，沒有可執行檔的話，先編譯。
```
gcc -o p1 p1.c sem.c
gcc -o p2 p2.c sem.c
gcc -o p3 p3.c sem.c
```
## 如何執行
### 檢查 Semaphore
在執行之前可以先檢查是否存在任何 semaphore。(為了不要混淆程式執行結果)
```
ipcs
```

若已有 semaphore 存在，可以使用 `ipcrm` 刪除。
```
ipcrm sem <semid>
```

### 測試執行
```
./p1 &
./p2 &
./p3 &
```


## Hint
可以用輸入 `jobs` 來顯示你目前有多少背景程式在執行。
用 `kill %<id>` 來刪除背景程式。
 

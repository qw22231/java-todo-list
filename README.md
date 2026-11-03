# Java Todo List

以 Java 製作的命令列待辦清單練習專案。

## 目前進度

- 提供互動式選單及離開功能。
- 查看與新增任務目前為提示訊息，尚待實作。
- `src/Task.java` 為空白檔案，預留作為任務資料模型。

## 執行方式

需先安裝 JDK（已使用 JDK 21 編譯驗證）。在專案根目錄執行：

```sh
javac -encoding UTF-8 -d out src/Main.java src/Task.java
java -cp out Main
```

輸入 `1` 查看任務提示、`2` 查看新增提示，或 `3` 離開。

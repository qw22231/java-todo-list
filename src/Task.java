
public class Task {

    // 1. Fields（欄位）
    private int id;
    private String title;
    private boolean completed;

    // 2. Constructor（建構子）
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    // 3. Getter：取得 ID
    public int getId() {
        return id;
    }

    // 4. Getter：取得任務名稱
    public String getTitle() {
        return title;
    }

    // 5. Getter：取得完成狀態
    public boolean isCompleted() {
        return completed;
    }

    // 6. Setter：修改任務名稱
    public void setTitle(String title) {
        this.title = title;
    }

    // 7. Setter：修改完成狀態
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

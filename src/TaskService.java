
import java.util.ArrayList;

public class TaskService {

    // 儲存所有 Task 物件
    private final ArrayList<Task> tasks;

    // 下一個任務 ID
    private int nextTaskId;

    // Constructor：初始化 Service
    public TaskService() {
        this.tasks = new ArrayList<>();
        this.nextTaskId = 1;
    }

    // Read：取得全部任務
    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    private String validateTitle(
            String title,
            String errorMessage) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }

        return title.strip();
    }

    private void validateId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID 必須大於 0！");
        }
    }

    // Create：新增任務
    public Task addTask(String title) {

        String cleanTitle = validateTitle(
                title,
                "任務名稱不能為空！");

        Task newTask = new Task(nextTaskId, cleanTitle);

        tasks.add(newTask);

        nextTaskId++;

        return newTask;
    }

    // Find：根據 ID 尋找任務
    public Task findTaskById(int id) {

        validateId(id);

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    // Update：修改任務名稱
    public boolean updateTaskTitle(int id, String newTitle) {

        Task task = findTaskById(id);

        if (task == null) {
            return false;
        }

        String cleanTitle = validateTitle(
                newTitle,
                "新名稱不能為空！");

        task.setTitle(cleanTitle);

        return true;
    }

    // Update：切換完成狀態
    public Task toggleTaskCompleted(int id) {

        Task task = findTaskById(id);

        if (task == null) {
            return null;
        }

        task.setCompleted(!task.isCompleted());

        return task;
    }

    // Delete：刪除任務
    public Task deleteTask(int id) {

        Task task = findTaskById(id);

        if (task == null) {
            return null;
        }

        tasks.remove(task);

        return task;
    }
}

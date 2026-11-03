
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        boolean running = true;

        try {

            while (running) {

                System.out.println("\n===== Java Todo List =====");
                System.out.println("1. 查看所有任務");
                System.out.println("2. 新增任務");
                System.out.println("3. 修改任務名稱");
                System.out.println("4. 切換任務完成狀態");
                System.out.println("5. 刪除任務");
                System.out.println("6. 離開");

                System.out.print("請輸入選項 (1-6)：");

                String choice = scanner.nextLine().trim();

                try {

                    switch (choice) {

                        case "1": {

                            ArrayList<Task> tasks = taskService.getAllTasks();

                            if (tasks.isEmpty()) {
                                System.out.println("目前還沒有任務！");
                            } else {

                                System.out.println("\n===== 所有任務 =====");

                                for (Task task : tasks) {

                                    String status = task.isCompleted() ? "已完成" : "未完成";

                                    System.out.println(
                                            "ID: " + task.getId() +
                                                    " | 名稱: " + task.getTitle() +
                                                    " | [" + status + "]");
                                }
                            }
                            break;
                        }

                        case "2": {

                            System.out.print("請輸入任務名稱：");
                            String title = scanner.nextLine().trim();

                            if (title.isEmpty()) {
                                System.out.println("任務名稱不能為空！");
                                break;
                            }

                            Task added = taskService.addTask(title);

                            System.out.println(
                                    "任務新增成功！ID: " + added.getId());

                            break;
                        }

                        case "3": {

                            Integer id = readTaskId(scanner, "請輸入要修改的任務 ID：");

                            if (id == null) {
                                break;
                            }

                            Task target = taskService.findTaskById(id);

                            if (target == null) {
                                System.out.println("找不到 ID：" + id);
                                break;
                            }

                            System.out.println(
                                    "目前任務名稱：" + target.getTitle());

                            System.out.print("請輸入新名稱：");
                            String newTitle = scanner.nextLine().trim();

                            if (newTitle.isEmpty()) {
                                System.out.println("新名稱不能為空！");
                                break;
                            }

                            boolean updated = taskService.updateTaskTitle(id, newTitle);

                            if (updated) {
                                System.out.println("任務名稱修改成功！");
                            }

                            break;
                        }

                        case "4": {

                            Integer id = readTaskId(scanner, "請輸入要切換的任務 ID：");

                            if (id == null) {
                                break;
                            }

                            Task changed = taskService.toggleTaskCompleted(id);

                            if (changed == null) {
                                System.out.println("找不到 ID：" + id);
                                break;
                            }

                            if (changed.isCompleted()) {
                                System.out.println("任務已標記為完成！");
                            } else {
                                System.out.println("任務已標記為未完成！");
                            }

                            break;
                        }

                        case "5": {

                            Integer id = readTaskId(scanner, "請輸入要刪除的任務 ID：");

                            if (id == null) {
                                break;
                            }

                            Task deleted = taskService.deleteTask(id);

                            if (deleted == null) {
                                System.out.println("找不到 ID：" + id);
                                break;
                            }

                            System.out.println(
                                    "已刪除任務：" + deleted.getTitle());

                            break;
                        }

                        case "6": {
                            running = false;
                            System.out.println("感謝使用！");
                            break;
                        }

                        default: {
                            System.out.println("無效選項，請輸入 1、2 或 3。");
                            break;
                        }
                    }
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());

                }
            }

        } finally {

            scanner.close();

        }
    }

    private static Integer readTaskId(
            Scanner scanner,
            String prompt) {

        System.out.print(prompt);

        String text = scanner.nextLine().trim();

        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("ID 必須是整數！");
            return null;
        }
    }
}


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== Java Todo List =====");
            System.out.println("1. 查看所有任務");
            System.out.println("2. 新增任務");
            System.out.println("3. 離開");

            System.out.print("請輸入選項 (1-3)：");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("目前還沒有任務（之後實作）");
                    break;

                case "2":
                    System.out.println("新增任務功能將在下一步完成");
                    break;

                case "3":
                    running = false;
                    System.out.println("感謝使用！");
                    break;

                default:
                    System.out.println("無效選項，請輸入 1、2 或 3。");
            }
        }

        scanner.close();
    }
}

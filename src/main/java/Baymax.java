import java.util.Scanner;

public class Baymax {
    private static final String HORIZONTAL = "__________________________________";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskCount = 0;
        final Task[] list = new Task[100];

        System.out.printf("%s\nHello! I'm Baymax\nWhat can I do for you?\n%s\n",
                HORIZONTAL, HORIZONTAL);

        while (true) {
            String input = scanner.nextLine();
            int result = handleCommand(input, list, taskCount);
            if (result == -1) break; // bye command detected break out
            taskCount = result;
        }
    }

    // Helper function to handle user commands
    private static int handleCommand(String input, Task[] list, int taskCount) {
        String[] parts = input.split(" ");

        switch (parts[0]) {
            case "bye" -> {
                System.out.printf("%s\nBye. Hope to see you again soon!", HORIZONTAL);
                return -1; // Signals end of program
            }
            case "list" -> {
                System.out.printf("%s\nHere are the tasks in your list:\n", HORIZONTAL);
                for (int i = 0; i < taskCount; i++) {
                    System.out.printf((i + 1) + ".%s\n", list[i]);
                }
                System.out.println(HORIZONTAL);
            }
            case "mark", "unmark" -> {
                if (parts.length == 2) {
                    try {
                        int x = Integer.parseInt(parts[1]);
                        if (x >= 1 && x <= taskCount) {
                            if (parts[0].equals("mark")) {
                                list[x - 1].markAsDone();
                                System.out.printf(HORIZONTAL + "\nNice! I've marked this task as done:\n"
                                        + list[x - 1] + "\n" + HORIZONTAL + "\n");
                            } else {
                                list[x - 1].markAsUndone();
                                System.out.printf(HORIZONTAL + "\nOK, I've marked this task as not done yet:\n"
                                        + list[x - 1] + "\n" + HORIZONTAL + "\n");
                            }
                        }
                    } catch (NumberFormatException e) {
                        // ignore invalid number
                    }
                }
            }
            case "todo" -> {}
            case "deadline" -> {}
            case "event" -> {}
            default -> {
                list[taskCount] = new Task(input);
                taskCount++;
                System.out.printf("%s\nadded: %s\n%s\n", HORIZONTAL, input, HORIZONTAL);
            }
        }
        return taskCount;
    }
}

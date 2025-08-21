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
            case "todo" -> {
                System.out.println("Got it. I've added this task:");
                list[taskCount] = new Todo(input);
                taskCount++;
                System.out.println(list[taskCount - 1]);
                System.out.printf("Now you have %d tasks in the list.\n", taskCount);
                System.out.println(HORIZONTAL);
            }
            case "deadline" -> {
                System.out.println(HORIZONTAL);
                System.out.println("Got it. I've added this task:");
                int byIndex = -1;

                // Looks for /by string
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("/by")) {
                        byIndex = i;
                        break;
                    }
                }

                if (byIndex != -1) {
                    // Combines words before /by as taskName
                    StringBuilder taskName = new StringBuilder();
                    for (int i = 1; i < byIndex; i++) {
                        taskName.append(parts[i]).append(" ");
                    }

                    // Combines words after /by as by
                    StringBuilder by = new StringBuilder();
                    for (int i = byIndex + 1; i < parts.length; i++) {
                        by.append(parts[i]).append(" ");
                    }

                    list[taskCount] = new Deadline(taskName.toString().trim(),
                            by.toString().trim());
                    taskCount++;
                    System.out.println(list[taskCount - 1]);
                    System.out.printf("Now you have %d tasks in the list.\n", taskCount);
                    System.out.println(HORIZONTAL);
                }
            }
            case "event" -> {
                System.out.println(HORIZONTAL);
                System.out.println("Got it. I've added this task:");

                int fromIndex = -1;
                int toIndex = -1;

                // Looks for /from and /to string
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("/from")) fromIndex = i;
                    if (parts[i].equals("/to")) toIndex = i;
                }

                if (fromIndex != -1 && toIndex != -1) {
                    // Combines words before /from as taskName
                    StringBuilder taskName = new StringBuilder();
                    for (int i = 1; i < fromIndex; i++) {
                        taskName.append(parts[i]).append(" ");
                    }

                    // Combines words between /from and /to as from
                    StringBuilder from = new StringBuilder();
                    for (int i = fromIndex + 1; i < toIndex; i++) {
                        from.append(parts[i]).append(" ");
                    }

                    // Combines words after /to as to
                    StringBuilder to = new StringBuilder();
                    for (int i = toIndex + 1; i < parts.length; i++) {
                        to.append(parts[i]).append(" ");
                    }

                    list[taskCount] = new Event(taskName.toString().trim(),
                            from.toString().trim(),
                            to.toString().trim());
                    taskCount++;
                    System.out.println(list[taskCount - 1]);
                    System.out.printf("Now you have %d tasks in the list.\n", taskCount);
                    System.out.println(HORIZONTAL);
                }
            }
        }
        return taskCount;
    }
}

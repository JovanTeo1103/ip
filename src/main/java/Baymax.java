import java.util.Scanner;

public class Baymax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        final Task[] list = new Task[100];
        final String HORIZONTAL = "__________________________________";

        System.out.printf("%s\nHello! I'm Baymax\nWhat can I do for you?\n%s\n"
                , HORIZONTAL, HORIZONTAL);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (input.equals("bye")) {
                System.out.printf("%s\nBye. Hope to see you again soon!", HORIZONTAL);
                break;
            } else if (input.equals("list")) {
                System.out.printf("%s\nHere are the tasks in your list:\n", HORIZONTAL);
                for (int i = 0; i < j; i++) {
                    System.out.printf((i + 1) + ".%s\n", list[i]);
                }
                System.out.println(HORIZONTAL);
            } else if (parts.length == 2 && (parts[0].equals("mark") || parts[0].equals("unmark"))) {
                try {
                    int x = Integer.parseInt(parts[1]);
                    if (x >= 1 && x <= j) {
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
            } else {
                list[j] = new Task(input);
                j++;
                System.out.printf("%s\nadded: %s\n%s\n", HORIZONTAL, input, HORIZONTAL);
            }
        }
    }
}


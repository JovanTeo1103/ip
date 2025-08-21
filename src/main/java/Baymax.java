import java.util.Scanner;

public class Baymax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int j = 0;
        final String[] list = new String[100];
        final String HORIZONTAL = "__________________________________";

        System.out.printf("%s\nHello! I'm Baymax\nWhat can I do for you?\n%s\n"
                , HORIZONTAL, HORIZONTAL);

        while (true) {
            String input = scanner.nextLine();

            list[j] = input;
            j++;

            if (input.equals("bye")) {
                System.out.printf("%s\nBye. Hope to see you again soon!", HORIZONTAL);
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < j - 1; i++) {
                    System.out.printf((i + 1) + ". %s\n", list[i]);
                }
                System.out.println(HORIZONTAL);
            } else {

            System.out.printf("%s\nadded: %s\n%s\n", HORIZONTAL, input, HORIZONTAL);
        }
    }
}
}

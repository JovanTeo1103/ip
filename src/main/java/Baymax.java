import java.util.Scanner;
public class Baymax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String HORIZONTAL = "__________________________________";
        System.out.printf("%s\nHello! I'm Baymax\nWhat can I do for you?\n%s\n"
                ,HORIZONTAL, HORIZONTAL);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.printf("%s\nBye. Hope to see you again soon!", HORIZONTAL);
                break;
            } else {
                System.out.printf("%s\n%s\n%s\n", HORIZONTAL, input, HORIZONTAL);
            }
        }
    }
}

package baymax;

public class Ui {
    private static final String HORIZONTAL = "__________________________________";

    public void showWelcome() {
        System.out.printf("%s\nHello! I'm baymax.Baymax\nWhat can I do for you?\n%s\n",
                HORIZONTAL, HORIZONTAL);
    }

    public void showLine() {
        System.out.println(HORIZONTAL);
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showTaskAdded(Task t, int taskCount) {
        showLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(t);
        System.out.printf("Now you have %d tasks in the list.\n%s\n", taskCount, HORIZONTAL);
    }

    public void showTaskRemoved(Task t, int taskCount) {
        showLine();
        System.out.println("Noted. I've removed this task:");
        System.out.println(t);
        System.out.printf("Now you have %d tasks in the list.\n%s\n", taskCount, HORIZONTAL);
    }

    public void showTaskMarked(Task t) {
        showLine();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(t);
        showLine();
    }

    public void showTaskUnmarked(Task t) {
        showLine();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(t);
        showLine();
    }

    public void showList(TaskList tasks) {
        showLine();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d.%s\n", i + 1, tasks.get(i));
        }
        showLine();
    }

    public void showBye() {
        System.out.printf("%s\nBye. Hope to see you again soon!\n", HORIZONTAL);
    }

    public void showError(String msg) {
        showLine();
        System.out.println(msg);
        showLine();
    }
}

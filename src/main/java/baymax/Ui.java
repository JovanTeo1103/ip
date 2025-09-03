package baymax;

import java.util.ArrayList;

public class Ui {
    private static final String HORIZONTAL = "__________________________________";

    public String showWelcome() {
        return HORIZONTAL + "\n"
                + "Hello! I'm Baymax\n"
                + "What can I do for you?\n"
                + HORIZONTAL;
    }

    public String showLine() {
        return HORIZONTAL;
    }

    public String showTaskAdded(Task t, int taskCount) {
        return HORIZONTAL + "\n"
                + "Got it. I've added this task:\n"
                + t + "\n"
                + "Now you have " + taskCount + " tasks in the list.\n"
                + HORIZONTAL;
    }

    public String showTaskRemoved(Task t, int taskCount) {
        return HORIZONTAL + "\n"
                + "Noted. I've removed this task:\n"
                + t + "\n"
                + "Now you have " + taskCount + " tasks in the list.\n"
                + HORIZONTAL;
    }

    public String showTaskMarked(Task t) {
        return HORIZONTAL + "\n"
                + "Nice! I've marked this task as done:\n"
                + t + "\n"
                + HORIZONTAL;
    }

    public String showTaskUnmarked(Task t) {
        return HORIZONTAL + "\n"
                + "OK, I've marked this task as not done yet:\n"
                + t + "\n"
                + HORIZONTAL;
    }

    public String showList(TaskList tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append(HORIZONTAL).append("\n");
        sb.append("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1).append(".").append(tasks.get(i)).append("\n");
        }
        sb.append(HORIZONTAL);
        return sb.toString();
    }

    public String showBye() {
        return HORIZONTAL + "\n"
                + "Bye. Hope to see you again soon!\n";
    }

    public String showError(String msg) {
        return HORIZONTAL + "\n"
                + msg + "\n"
                + HORIZONTAL;
    }

    public String showFoundTasks(ArrayList<Task> matches) {
        StringBuilder sb = new StringBuilder();
        sb.append(HORIZONTAL).append("\n");
        sb.append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < matches.size(); i++) {
            sb.append(i + 1).append(".").append(matches.get(i)).append("\n");
        }
        sb.append(HORIZONTAL);
        return sb.toString();
    }
}

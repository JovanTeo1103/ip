package ui;

import java.util.ArrayList;

import task.Task;
import task.TaskList;

public class Ui {
    private static final String HORIZONTAL = "___________________________________________________";

    private String formatMessage(String header, Task t, String footer) {
        StringBuilder sb = new StringBuilder();
        sb.append(HORIZONTAL).append("\n");
        sb.append(header).append("\n");
        sb.append(t).append("\n");

        if (footer != null) {
            sb.append(footer).append("\n");
        }

        sb.append(HORIZONTAL);
        return sb.toString();
    }

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
        assert t != null : "Task should never be null";
        return formatMessage("Got it. I've added this task:", t,
                "Now you have " + taskCount + " tasks in the list.");
    }

    public String showTaskRemoved(Task t, int taskCount) {
        assert t != null : "Task should never be null";
        return formatMessage("Noted. I've removed this task:", t,
                "Now you have " + taskCount + " tasks in the list.");
    }

    public String showTaskMarked(Task t) {
        assert t != null : "Task should never be null";
        return formatMessage("Nice! I've marked this task as done:", t, null);
    }

    public String showTaskUnmarked(Task t) {
        assert t != null : "Task should never be null";
        return formatMessage("OK, I've marked this task as not done yet:", t, null);
    }

    public String showTaskRemoved(Task t, int taskCount) {
        assert t != null : "Task should never be null";

        return HORIZONTAL + "\n"
                + "Noted. I've removed this task:\n"
                + t + "\n"
                + "Now you have " + taskCount + " tasks in the list.\n"
                + HORIZONTAL;
    }

    public String showTaskMarked(Task t) {
        assert t != null : "Task should never be null";

        return HORIZONTAL + "\n"
                + "Nice! I've marked this task as done:\n"
                + t + "\n"
                + HORIZONTAL;
    }

    public String showTaskUnmarked(Task t) {
        assert t != null : "Task should never be null";

        return HORIZONTAL + "\n"
                + "OK, I've marked this task as not done yet:\n"
                + t + "\n"
                + HORIZONTAL;
    }

    public String showList(TaskList tasks) {
        assert tasks != null : "TaskList should never be null";

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
        assert matches != null : "Matches list should never be null";
        StringBuilder sb = new StringBuilder();
        sb.append(HORIZONTAL).append("\n");
        sb.append("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1).append(".").append(tasks.get(i)).append("\n");
        }
        sb.append(HORIZONTAL);
        return sb.toString();
    }
}

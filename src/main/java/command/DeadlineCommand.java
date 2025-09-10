package command;

import exception.BaymaxException;
import storage.Storage;
import task.Deadline;
import task.TaskList;
import task.TaskType;
import ui.Ui;

// Add a deadline
public class DeadlineCommand extends Command {
    private final String desc;
    private final String by;

    public DeadlineCommand(String desc, String by) {
        this.desc = desc;
        this.by = by;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Deadline t = new Deadline(desc, TaskType.DEADLINE, by);
            tasks.add(t);
            storage.save(tasks.getAll());
            return ui.showTaskAdded(t, tasks.size());
        } catch (BaymaxException e) {
            return ui.showError(e.getMessage());
        }
    }
}

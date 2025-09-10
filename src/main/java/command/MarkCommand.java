package command;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.get(index);
        t.markAsDone();
        storage.save(tasks.getAll());
        return ui.showTaskMarked(t);
    }
}

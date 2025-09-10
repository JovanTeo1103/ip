package command;


import exception.BaymaxException;
import storage.Storage;
import task.TaskList;
import task.TaskType;
import task.Todo;
import ui.Ui;

public class TodoCommand extends Command {
    private final String desc;

    public TodoCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Todo t = new Todo(desc, TaskType.TODO);
            tasks.add(t);
            storage.save(tasks.getAll());
            return ui.showTaskAdded(t, tasks.size());
        } catch (BaymaxException e) {
            return ui.showError(e.getMessage());
        }
    }
}

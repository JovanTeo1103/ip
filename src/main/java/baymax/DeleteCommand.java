package baymax;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.remove(index);
        storage.save(tasks.getAll());
        return ui.showTaskRemoved(t, tasks.size());
    }
}

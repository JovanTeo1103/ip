package baymax;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.get(index);
        t.markAsUndone();
        storage.save(tasks.getAll());
        ui.showTaskUnmarked(t);
    }
}


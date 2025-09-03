package baymax;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task t = tasks.get(index);
        t.markAsDone();
        storage.save(tasks.getAll());
        ui.showTaskMarked(t);
    }
}

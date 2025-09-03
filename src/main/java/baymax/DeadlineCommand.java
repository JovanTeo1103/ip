package baymax;

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
        Deadline t = new Deadline(desc, TaskType.DEADLINE, by);
        tasks.add(t);
        storage.save(tasks.getAll());
        return ui.showTaskAdded(t, tasks.size());
    }
}

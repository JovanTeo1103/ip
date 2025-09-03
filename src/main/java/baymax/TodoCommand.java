package baymax;


public class TodoCommand extends Command {
    private final String desc;

    public TodoCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo t = new Todo(desc, TaskType.TODO);
        tasks.add(t);
        storage.save(tasks.getAll());
        ui.showTaskAdded(t, tasks.size());
    }
}

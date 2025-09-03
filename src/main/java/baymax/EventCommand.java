package baymax;

public class EventCommand extends Command {
    private final String desc;
    private final String from;
    private final String to;

    public EventCommand(String desc, String from, String to) {
        this.desc = desc;
        this.from = from;
        this.to = to;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        Event t = new Event(desc, TaskType.EVENT, from, to);
        tasks.add(t);
        storage.save(tasks.getAll());
        return ui.showTaskAdded(t, tasks.size());
    }
}

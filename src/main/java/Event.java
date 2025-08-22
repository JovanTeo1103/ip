public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String taskName, TaskType taskType, String from, String to) {
        super(taskName, taskType);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}

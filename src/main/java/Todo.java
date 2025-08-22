public class Todo extends Task {
    public Todo(String taskName, TaskType taskType) {
        super(taskName, taskType);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}


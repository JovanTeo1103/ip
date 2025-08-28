package baymax;

public class Todo extends Task {
    public Todo(String taskName, TaskType taskType) {
        super(taskName, taskType);
    }

    public Todo(String taskName, TaskType taskType, boolean isDone) {
        super(taskName, taskType, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}


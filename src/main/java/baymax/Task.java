package baymax;

public class Task {
    protected String taskDescripion;
    protected boolean isDone;
    protected TaskType taskType;

    public Task(String taskName, TaskType taskType) {
        this.taskDescripion = taskName;
        this.isDone = false;
        this.taskType = taskType;
    }

    // Overload Constructor that takes in boolean isDone for file reading
    public Task(String taskName, TaskType taskType, boolean isDone) {
        this.taskDescripion = taskName;
        this.taskType = taskType;
        this.isDone = isDone;
    }


    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return isDone
                ? "[X] " + taskDescripion
                : "[ ] " + taskDescripion;
    }

    public String getDescription() {
        return this.taskDescripion;
    }

    public boolean getStatus() {
        return this.isDone;
    }
}

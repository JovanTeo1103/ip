public class Task {
    protected String taskName;
    protected boolean isDone;
    protected TaskType taskType;

    public Task(String taskName, TaskType taskType) {
        this.taskName = taskName;
        this.isDone = false;
        this.taskType = taskType;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString(){
        return isDone
                ? "[X] " + taskName
                : "[ ] " + taskName;
    }
}

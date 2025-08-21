public class Task {
    protected String taskName;
    protected boolean isDone;
    protected int taskId;
    private static int id = 0;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
        id++;
        this.taskId = id;
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

import java.util.Scanner;

public class Baymax {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Baymax() {
        ui = new Ui();
        storage = new Storage();
        TaskList loadedTasks;
        try {
            loadedTasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showError("Failed to load tasks!");
            loadedTasks = new TaskList();
        }
        tasks = loadedTasks;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        ui.showWelcome();

        while (true) {
            String input = scanner.nextLine();
            try {
                String command = Parser.getCommand(input);
                String args = Parser.getArgs(input);

                switch (command) {
                    case "bye" -> {
                        ui.showBye();
                        return;
                    }
                    case "list" -> ui.showList(tasks);
                    case "mark" -> {
                        int idx = Parser.parseIndex(args);
                        tasks.get(idx).markAsDone();
                        ui.showTaskMarked(tasks.get(idx));
                        storage.save(tasks.getAll());
                    }
                    case "unmark" -> {
                        int idx = Parser.parseIndex(args);
                        tasks.get(idx).markAsUndone();
                        ui.showTaskUnmarked(tasks.get(idx));
                        storage.save(tasks.getAll());
                    }
                    case "delete" -> {
                        int idx = Parser.parseIndex(args);
                        Task removed = tasks.remove(idx);
                        ui.showTaskRemoved(removed, tasks.size());
                        storage.save(tasks.getAll());
                    }
                    case "todo" -> {
                        String desc = Parser.parseTodo(args);
                        Task t = new Todo(desc, TaskType.TODO);
                        tasks.add(t);
                        ui.showTaskAdded(t, tasks.size());
                        storage.save(tasks.getAll());
                    }
                    case "deadline" -> {
                        String[] parts = Parser.parseDeadline(args);
                        Task t = new Deadline(parts[0], TaskType.DEADLINE, parts[1]);
                        tasks.add(t);
                        ui.showTaskAdded(t, tasks.size());
                        storage.save(tasks.getAll());
                    }
                    case "event" -> {
                        String[] parts = Parser.parseEvent(args);
                        Task t = new Event(parts[0], TaskType.EVENT, parts[1], parts[2]);
                        tasks.add(t);
                        ui.showTaskAdded(t, tasks.size());
                        storage.save(tasks.getAll());
                    }
                    default -> ui.showError("OHNO!!! I'm sorry, but that's not a valid command T.T");
                }
            } catch (InvalidCommandException | InvalidDescriptionException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Baymax().run();
    }
}

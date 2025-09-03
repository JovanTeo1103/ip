package baymax;

import java.util.ArrayList;
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
                Command cmd = Parser.parse(input);
                cmd.execute(tasks, ui, storage);
                if (cmd.isExit()) break;
            } catch (InvalidCommandException | InvalidDescriptionException e) {
                ui.showError(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        new Baymax().run();
    }
}

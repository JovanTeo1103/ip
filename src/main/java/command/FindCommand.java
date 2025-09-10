package command;

import java.util.ArrayList;

import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

public class FindCommand extends Command {
    private final String KEYWORD;

    public FindCommand(String keyword) {
        this.KEYWORD = keyword;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> matches = tasks.findTasks(KEYWORD);
        return ui.showFoundTasks(matches);
    }
}

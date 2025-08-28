import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Storage class handles reading and writing Task objects to a file.
 * Tasks are persisted in a text file so that they can be loaded on
 * program start and saved when modified.
 */
public class Storage {
    private final Path filePath;


    /**
     * Constructs a Storage object using the default file path.
     * The default file path is "./data/baymax.txt".
     */
    public Storage() {
        this.filePath = Paths.get("data", "baymax.txt");
    }

    /**
     * Loads tasks from the storage file.
     * If the file or its parent directories do not exist, they are created
     * and an empty list is returned.
     *
     * @return an ArrayList containing all tasks read from the file
     */
    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            if (Files.notExists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
                return tasks;
            }

            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                try {
                    tasks.add(parse(line));
                } catch (Exception e) {
                    System.err.println("Skipping corrupted line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not load tasks: " + e.getMessage());
        }
        return tasks;
    }

    //Saves all tasks to baymax.txt
    public void save(List<Task> tasks) {
        try {
            Files.createDirectories(filePath.getParent());
            List<String> lines = new ArrayList<>();
            for (Task t : tasks) {
                lines.add(format(t));
            }
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.err.println("Could not save tasks: " + e.getMessage());
        }
    }


    /**
     * Parses a line from the storage file and converts it into a Task object.
     *
     * @param line a single line from the file representing a task
     * @return a Task object corresponding to the line
     * @throws IllegalArgumentException if the task type is unknown
     */
    private Task parse(String line) {
        String[] parts = line.split("\\s*\\|\\s*");
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String desc = parts[2];

        return switch (type) {
            case "T" -> new Todo(desc, TaskType.TODO, isDone);
            case "D" -> new Deadline(desc, TaskType.DEADLINE, parts[3], isDone);
            case "E" -> new Event(desc, TaskType.EVENT, parts[3], parts[4], isDone);
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }


    /**
     * Converts a Task object into a string that can be saved in the storage file.
     *
     * @param t the task to format
     * @return a string representation of the task for file storage
     */
    private String format(Task t) {
        String done = t.getStatus() ? "1" : "0";
        return switch (t) {
            case Todo td -> String.format("T | %s | %s", done, td.getDescription());
            case Deadline d -> String.format("D | %s | %s | %s", done, d.getDescription(), d.getBy().toString());
            case Event e ->
                    String.format("E | %s | %s | %s | %s", done, e.getDescription(), e.getFrom().toString(), e.getTo().toString());

            default -> throw new IllegalStateException("Unknown task subclass");
        };
    }
}

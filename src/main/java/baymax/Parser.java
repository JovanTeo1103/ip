package baymax;

public class Parser {

    public static Command parse(String input) throws InvalidCommandException, InvalidDescriptionException {
        String command = getCommand(input);
        String args = getArgs(input);

        return switch (command) {
            case "bye" -> new ByeCommand();
            case "list" -> new ListCommand();
            case "mark" -> new MarkCommand(parseIndex(args));
            case "unmark" -> new UnmarkCommand(parseIndex(args));
            case "delete" -> new DeleteCommand(parseIndex(args));
            case "todo" -> new TodoCommand(parseTodo(args));
            case "deadline" -> {
                String[] parts = parseDeadline(args);
                yield new DeadlineCommand(parts[0], parts[1]);
            }
            case "event" -> {
                String[] parts = parseEvent(args);
                yield new EventCommand(parts[0], parts[1], parts[2]);
            }
            case "find" -> new FindCommand(args.trim());
            default -> throw new InvalidCommandException("Unknown command: " + command);
        };
    }

    /** Extracts the command keyword from the raw input */
    public static String getCommand(String input) {
        String[] parts = input.trim().split(" ", 2);
        return parts[0];
    }

    /** Extracts everything after the command as arguments */
    public static String getArgs(String input) {
        String[] parts = input.trim().split(" ", 2);
        return parts.length > 1 ? parts[1] : "";
    }

    /** Parses a todo command */
    public static String parseTodo(String args) throws InvalidDescriptionException {
        if (args.isEmpty()) {
            throw new InvalidDescriptionException("OHNO!!! The description of a todo cannot be empty T.T");
        }
        return args;
    }

    /** Parses a deadline command into description and by date */
    public static String[] parseDeadline(String args) throws InvalidDescriptionException {
        int byIndex = args.indexOf("/by");
        if (byIndex == -1) throw new InvalidDescriptionException("OHNO!!! baymax.Deadline must have /by");

        String desc = args.substring(0, byIndex).trim();
        String by = args.substring(byIndex + 3).trim();

        if (desc.isEmpty() || by.isEmpty())
            throw new InvalidDescriptionException("OHNO!!! The description of the deadline is invalid T.T");

        return new String[]{desc, by};
    }

    /** Parses an event command into description, from, and to */
    public static String[] parseEvent(String args) throws InvalidDescriptionException {
        int fromIndex = args.indexOf("/from");
        int toIndex = args.indexOf("/to");

        if (fromIndex == -1 || toIndex == -1 || fromIndex >= toIndex)
            throw new InvalidDescriptionException("OHNO!!! The description of the event is invalid T.T");

        String desc = args.substring(0, fromIndex).trim();
        String from = args.substring(fromIndex + 5, toIndex).trim();
        String to = args.substring(toIndex + 3).trim();

        if (desc.isEmpty() || from.isEmpty() || to.isEmpty())
            throw new InvalidDescriptionException("OHNO!!! The description of the event is invalid T.T");

        return new String[]{desc, from, to};
    }

    /** Parses index from mark/unmark/delete commands */
    public static int parseIndex(String arg) throws InvalidCommandException {
        try {
            return Integer.parseInt(arg.trim()) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid number format");
        }
    }
}

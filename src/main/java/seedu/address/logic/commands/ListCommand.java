package seedu.address.logic.commands;


/**
 * Lists all tasks in the task book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all tasks";

    public ListCommand() {}

    @Override
    public CommandResult execute() {
        model.setFilter(null);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

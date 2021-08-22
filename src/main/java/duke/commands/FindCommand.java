package duke.commands;

import duke.data.TaskList;
import duke.data.exception.DukeException;
import duke.data.exception.EmptyDescriptionException;
import duke.data.task.Task;
import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Encapsulates Find command's operation
 */
public class FindCommand extends Command {
    private String filter;

    /**
     * Constructor for FindCommand
     * @param rest the user input after the command
     * @throws EmptyDescriptionException if input is empty
     */
    public FindCommand(String rest) throws EmptyDescriptionException {
        if (rest.isEmpty()) throw new EmptyDescriptionException();
        this.filter = rest;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        TaskList filtered = tasks.filter(task -> task.getDescription().contains(filter));
        ui.print(String.format(
                "Here are the matching tasks in your list:%s",
                filtered.printList()));
    }
}

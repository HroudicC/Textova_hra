package game.commands;

/**
 * Represents an abstract class of all commands.
 */
public abstract class Command {

    public abstract String execute();
    public abstract boolean exit();

}

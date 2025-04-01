package game.commands;

import game.Console;

/**
 * Represents the command that shows a list of available commands to the player.
 */
public class Help extends Command {

    Console console;

    /**
     *   Colors were made by chatGPT for better clarity.
     */
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";

    public Help(Console console) {
        this.console = console;
    }

    @Override
    public String execute() {
       return helpMessage();
    }

    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Display a help message with all off the commands.
     * Colors were made by chatGPT for better clarity.
     * @return Message with commands.
     */
    private String helpMessage() {
        StringBuilder helpMessage = new StringBuilder("Příkazy k použití: ");

        for (String command : console.getPrikazy().keySet()) {
            helpMessage.append(YELLOW).append(command).append(", ").append(RESET);
        }

        return helpMessage.toString();
    }

}

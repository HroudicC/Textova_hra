package game.commands;

import game.Console;

public class Help extends Command {

    Console console;

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

    private String helpMessage() {
        StringBuilder helpMessage = new StringBuilder("Příkazy k použití: ");

        for (String command : console.getPrikazy().keySet()) {
            helpMessage.append(YELLOW).append(command).append(", ").append(RESET);
        }

        return helpMessage.toString();
    }

}

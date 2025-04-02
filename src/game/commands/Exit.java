package game.commands;

public class Exit extends Command {

    /**
     * Executes the exit command.
     * @return A message describing the ending.
     */
    @Override
    public String execute() {
        return "Rozhodl ses nechat všechno být a nezkusit se dostat ven. Čas plynul a dny se změnily v týdny, týdny v měsíce. \n" +
                "Po několika letech tě nakonec vyhlídli a zmlátili tak, že už ses z toho nikdy neprobudil. (ending 4)";    }

    @Override
    public boolean exit() {
        return true;
    }
}

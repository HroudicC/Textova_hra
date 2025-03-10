package game.commands;

public class Exit extends Command {

    @Override
    public String execute() {
        return "Konec hry";
    }

    @Override
    public boolean exit() {
        return true;
    }
}

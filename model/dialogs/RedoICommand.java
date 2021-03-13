package model.dialogs;

public class RedoICommand implements ICommand {
    @Override
    public void execute() {

        CommandHistory.redo();
    }
}
